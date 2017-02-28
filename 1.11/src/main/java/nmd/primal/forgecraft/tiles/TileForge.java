package nmd.primal.forgecraft.tiles;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.forgecraft.blocks.Forge;
import nmd.primal.forgecraft.blocks.IngotBall;
import nmd.primal.forgecraft.crafting.ForgeCrafting;
import org.omg.PortableInterceptor.ACTIVE;

import static nmd.primal.forgecraft.CommonUtils.getVanillaItemBurnTime;

/**
 * Created by mminaie on 11/30/16.
 */
public class TileForge extends TileBaseSlot implements ITickable {

    private NonNullList<ItemStack> slotList = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
    //private ItemStack[] inventory = new ItemStack [0];
    //private String customName;
    private int iteration = 0;
    private int heat;
    private int cookCounter;

    @Override
    public void update () {
        if(!world.isRemote){
            World world = this.getWorld();
            this.iteration ++;
            IBlockState state = world.getBlockState(this.pos);
            BlockPos abovePos = new BlockPos(this.getPos().getX(), this.getPos().getY()+1, this.getPos().getZ());
            IBlockState aboveState = world.getBlockState(abovePos);
            Block block = world.getBlockState(abovePos).getBlock();
            if(this.iteration == 300 ) {
                this.iteration = 0;


                if (world.getBlockState(this.getPos()).getValue(Forge.ACTIVE)) {
                    if (this.getSlotStack(0) == ItemStack.EMPTY) {
                        world.setBlockState(this.getPos(), state.withProperty(Forge.ACTIVE, false), 2);
                        this.markDirty();
                        world.notifyBlockUpdate(pos, state, state, 2);
                    }
                    if(this.getSlotStack(0) != ItemStack.EMPTY) {
                        Integer decrInt = (int) Math.floor(getVanillaItemBurnTime(this.getSlotStack(0)) / 20);
                        if(decrInt == 0) {
                            decrInt = 1;
                        }
                        if (world.rand.nextInt(decrInt) == 0) {
                            this.decrStackSize(0, 1);
                            this.markDirty();
                            this.updateBlock();
                        }
                        this.furnaceManager(abovePos);
                    }
                }
                this.heatManager(this.getHeat(), state, this.getSlotStack(0), world, pos);
            }
            craftingManager(block, world, abovePos, aboveState);
        }
    }

    private void furnaceManager(BlockPos abovePos){
        if(world.getBlockState(abovePos).getBlock() instanceof BlockFurnace){
            TileEntityFurnace tileFurnace = (TileEntityFurnace) world.getTileEntity(abovePos);
            if(world.getBlockState(abovePos).getBlock() == Blocks.LIT_FURNACE){
                tileFurnace.setField(0,1000);
            }
            if(world.getBlockState(abovePos).getBlock() == Blocks.FURNACE){
                BlockFurnace.setState(true, world, abovePos);
                tileFurnace.setField(0,1000);
            }
        }
    }

    private void heatManager(Integer h, IBlockState state, ItemStack stack, World world, BlockPos pos){
        if(state.getValue(Forge.ACTIVE) == true){
            if(!stack.isEmpty()) {
                if(h > 0) {
                    this.setHeat(h - 25);
                }
                if(h < 10 ){
                    world.setBlockState(pos, state.withProperty(Forge.ACTIVE, false), 2);
                }
            }
            if(stack.isEmpty()){
                world.setBlockState(pos, state.withProperty(Forge.ACTIVE, false), 2);
            }
        }
        if(state.getValue(Forge.ACTIVE) == false){
            if(h > 50){
                this.setHeat(h - 50);
            }
            if(h < 0){
                this.setHeat(0);
            }
        }
        this.updateBlock();
        this.markDirty();
    }


    private void craftingManager(Block block, World world, BlockPos pos, IBlockState state){
        ForgeCrafting recipe = ForgeCrafting.getRecipe(block);
        if(recipe != null){
            if(this.getHeat() >= recipe.getHeatThreshold() && recipe.getStartState().equals(state) ){
                cookCounter++;
            }
            if(this.getHeat() < recipe.getHeatThreshold() && cookCounter > 0){
                cookCounter--;
            }
            if(cookCounter >= recipe.getIdealTime() ){
                world.setBlockState(pos, recipe.getOutput(), 3);
                cookCounter = 0;
            }
            /*
            System.out.println(state.getValue(IngotBall.ACTIVE) + " : " + recipe.getStartState());
            System.out.println(cookCounter + " : " + recipe.getIdealTime());
            System.out.println(this.heat + " : " + recipe.getHeatThreshold());
            System.out.println("========");
             */
        }
    }


    /*
       private void slotOneManager(){
        BloomeryCrafting recipe = BloomeryCrafting.getRecipe(this.getSlotStack(1));
        if(recipe != null){
            //System.out.println(recipe.getIdealTime() + " : " + recipe.getHeatThreshold());
            //System.out.println(this.cookCounter + " : " + this.getHeat());
            //System.out.println("====================");
            if(this.getHeat() >= recipe.getHeatThreshold()){
                cookCounter++;
            }
            if(cookCounter >= recipe.getIdealTime() ){
                if(this.getSlotStack(1).getItem() == recipe.getInput().getItem()) {
                    this.setSlotStack(1, recipe.getOutput());
                    this.cookCounter = 0;
                    //System.out.print(" :Success: " + this.getSlotStack(1));
                    this.updateBlock();
                    this.markDirty();
                }
            }
            if(cookCounter > recipe.getIdealTime() + (recipe.getIdealTime() * recipe.getTimeVariance())){
                if(this.getSlotStack(1).getItem() == recipe.getInput().getItem()) {
                    this.setSlotStack(1, recipe.getOutputFailed());
                    this.cookCounter = 0;
                    //System.out.print(" :Failure Time: " + this.getSlotStack(1));
                    this.updateBlock();
                    this.markDirty();
                }
            }
            if(this.getHeat() > recipe.getHeatThreshold() + (recipe.getHeatThreshold() * recipe.getHeatVariance())){
                if(this.getSlotStack(1).getItem() == recipe.getInput().getItem()) {
                    this.setSlotStack(1, recipe.getOutputFailed());
                    this.cookCounter = 0;
                    //System.out.print(" :Failure Heat: " + this.getSlotStack(1));
                    this.updateBlock();
                    this.markDirty();
                }
            }
            if (this.getSlotStack(1).isEmpty()){
                this.cookCounter=0;
            }
        }
    }
     */


    public int getHeat(){
        return this.heat;
    }

    public void setHeat(int newHeat){
        this.heat = newHeat;
    }
    @Override
    public int getSlotLimit() {
        return 1;
    }

    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = this.getSlotStack(index);
        this.setSlotStack(index, ItemStack.EMPTY);
        return stack;
    }

    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if(index == 0){
            if(stack.getItem() == Items.COAL){
                if(stack.getMetadata() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // ***************************************************************************** //
    //  NBT
    // ***************************************************************************** //
    @Override
    public NBTTagCompound readNBT(NBTTagCompound nbt)
    {
        super.readNBT(nbt);
        this.heat = nbt.getInteger("heat");
        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        nbt.setInteger("heat", this.heat);
        super.writeNBT(nbt);
        return nbt;
    }

}
