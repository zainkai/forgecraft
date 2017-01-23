package nmd.primal.forgecraft.tiles;

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
import nmd.primal.forgecraft.blocks.Bloomery;
import nmd.primal.forgecraft.blocks.Firebox;

import static nmd.primal.forgecraft.CommonUtils.getVanillaItemBurnTime;

/**
 * Created by mminaie on 1/22/17.
 */
public class TileBloomery extends TileBaseSlot implements ITickable {

    private NonNullList<ItemStack> slotList = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
    private int iteration = 0;
    private int heat;

    @Override
    public void update () {
        if(!world.isRemote){
            World world = this.getWorld();
            this.iteration ++;
            if(this.iteration == 300 ) {
                this.iteration = 0;
                IBlockState state = world.getBlockState(this.pos);
                BlockPos abovePos = new BlockPos(this.getPos().getX(), this.getPos().getY()+1, this.getPos().getZ());
                if (world.getBlockState(this.getPos()).getValue(Bloomery.ACTIVE)) {
                    if (this.getSlotStack(0) == ItemStack.EMPTY) {
                        world.setBlockState(this.getPos(), state.withProperty(Firebox.ACTIVE, false), 2);
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
                    }
                }
                this.heatManager(this.getHeat(), state, this.getSlotStack(0));
            }
        }
    }

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

    private void heatManager(Integer h, IBlockState state, ItemStack stack){
        if(state.getValue(Bloomery.ACTIVE) == true){
            if(!stack.isEmpty()) {
                if(h > 400) {
                    this.setHeat(h - 25);
                }
                if(h < 400){
                    this.setHeat(400);
                }
            }
            if(stack.isEmpty()){
                if(h > 50){
                    this.setHeat(h - 25);
                    if(this.getHeat() < 50){
                        this.setHeat(50);
                    }
                }
            }
        }
        if(state.getValue(Bloomery.ACTIVE) == false){
            if(h > 50){
                this.setHeat(h - 50);
                if(this.getHeat() < 50){
                    this.setHeat(50);
                }
            }
        }
        this.updateBlock();
        this.markDirty();
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
