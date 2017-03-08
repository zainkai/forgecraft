package nmd.primal.forgecraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalBlocks;
import nmd.primal.core.api.PrimalItems;
import nmd.primal.forgecraft.CommonUtils;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.crafting.AnvilCrafting;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.tiles.TileAnvil;
import nmd.primal.forgecraft.tiles.TileForge;

/**
 * Created by mminaie on 3/4/17.
 */
public class Anvil extends CustomContainerFacing {


    double[] normalMin = {0.0625,0.25,0.4375,0.625,0.8125};

    public double getNormalMin(Integer x) {
        return normalMin[x];
    }

    double[] normalMax = {0.1875,0.375,0.5625,0.75,0.9375};

    public double getNormalMax(Integer x) {
        return normalMax[x];
    }

    double[] reverseMin = {0.8125,0.625,0.4375,0.25,0.0625};

    public double getReverseMin(Integer x) {
        return reverseMin[x];
    }

    double[] reverseMax = {0.9375,0.75,0.5625,0.375,0.1875};

    public double getReverseMax(Integer x) {
        return reverseMax[x];
    }

    public Anvil(Material material, String registryName, Float hardness) {
        super(material);
        setUnlocalizedName(registryName);
        setRegistryName(registryName);
        //setRegistryName(ModInfo.ForgecraftBlocks.FIREBOX.getRegistryName());
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setHardness(hardness);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz)
    {
        if (!world.isRemote) {
            TileAnvil tile = (TileAnvil) world.getTileEntity(pos);
            if (tile != null) {
                ItemStack pItem = player.inventory.getCurrentItem();

                // ***************************************************************************** //
                //  Crafting Anvil Recipes
                // ***************************************************************************** //
                if((pItem.getItem().equals(PrimalItems.STONE_GALLAGHER)) || (pItem.getItem() == ModItems.forgehammer)){
                    Integer[] tempArray = new Integer[25];
                    for(int i=0; i < 25 ; i++){
                        if(!tile.getSlotStack(i).isEmpty()){
                            tempArray[i] = 1;
                        } else tempArray[i] = 0;
                    }
                    AnvilCrafting recipe = AnvilCrafting.getRecipe(tempArray);
                    if(recipe != null) {
                        if(pItem.getItem().equals(PrimalItems.STONE_GALLAGHER)) {
                            pItem.damageItem(15, player);
                        }
                        if(pItem.getItem().equals(ModItems.forgehammer)) {
                            pItem.damageItem(1, player);
                        }
                        CommonUtils.spawnItemEntityFromWorld(world, pos, recipe.getOutput());
                        world.playEvent(1031, pos, 0);
                        for (int i = 0; i < tile.getSlotListSize(); i++) {
                            if (!tile.getSlotStack(i).isEmpty()) {
                                tile.setSlotStack(i, ItemStack.EMPTY);
                            }
                        }
                        return true;
                    }
                }


                // ***************************************************************************** //
                //  Adding and Removing Inventory
                // ***************************************************************************** //

                if(pItem.getItem().equals(ModItems.stonetongs)){
                    if( (pItem.getTagCompound().getInteger("type") == 6) || (pItem.getTagCompound().getInteger("type") == 7) || (pItem.getTagCompound().getInteger("type") == 0) ) {


                        if(state.getValue(FACING) == EnumFacing.NORTH) {
                            int counter = 0;
                            for(int z=0; z<5; z++){
                                for(int x=0; x<5; x++){
                                    if(hitx >= this.getNormalMin(x) && hitx <= this.getNormalMax(x)){
                                        if(hitz >= this.getNormalMin(z) && hitz <= this.getNormalMax(z)) {
                                            if(!tile.getSlotStack(counter).isEmpty()) {
                                                if (pItem.getTagCompound().getInteger("type") == 0) {
                                                    if(tile.getSlotStack(counter).getItem().equals(ModItems.ironingotballhot)){
                                                        pItem.getTagCompound().setInteger("type", 6);
                                                        tile.setSlotStack(counter, ItemStack.EMPTY);
                                                        return true;
                                                    }
                                                    if(tile.getSlotStack(counter).getItem().equals(ModItems.ironchunkhot)){
                                                        pItem.getTagCompound().setInteger("type", 7);
                                                        tile.setSlotStack(counter, ItemStack.EMPTY);
                                                        System.out.println(counter);
                                                        return true;
                                                    }
                                                }
                                            }

                                            if(tile.getSlotStack(counter).isEmpty()) {
                                                if (pItem.getTagCompound().getInteger("type") == 6) {
                                                    tile.setSlotStack((counter), new ItemStack(ModItems.ironingotballhot, 1));
                                                    pItem.getTagCompound().setInteger("type", 0);
                                                    return true;
                                                }
                                                if (pItem.getTagCompound().getInteger("type") == 7) {
                                                    tile.setSlotStack((counter), new ItemStack(ModItems.ironchunkhot, 1));
                                                    pItem.getTagCompound().setInteger("type", 0);
                                                    System.out.println(counter);
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                    counter++;
                                }
                            }
                        }
                        if(state.getValue(FACING) == EnumFacing.SOUTH) {
                            int counter = 0;
                            for(int z=0; z<5; z++){
                                for(int x=0; x<5; x++){
                                    if(hitx >= this.getReverseMin(x) && hitx <= this.getReverseMax(x)){
                                        if(hitz >= this.getReverseMin(z) && hitz <= this.getReverseMax(z)) {
                                            if(!tile.getSlotStack(counter).isEmpty()) {
                                                if (pItem.getTagCompound().getInteger("type") == 0) {
                                                    if(tile.getSlotStack(counter).getItem().equals(ModItems.ironingotballhot)){
                                                        pItem.getTagCompound().setInteger("type", 6);
                                                        tile.setSlotStack(counter, ItemStack.EMPTY);
                                                        return true;
                                                    }
                                                    if(tile.getSlotStack(counter).getItem().equals(ModItems.ironchunkhot)){
                                                        pItem.getTagCompound().setInteger("type", 7);
                                                        tile.setSlotStack(counter, ItemStack.EMPTY);
                                                        System.out.println(counter);
                                                        return true;
                                                    }
                                                }
                                            }

                                            if(tile.getSlotStack(counter).isEmpty()) {
                                                if (pItem.getTagCompound().getInteger("type") == 6) {
                                                    tile.setSlotStack((counter), new ItemStack(ModItems.ironingotballhot, 1));
                                                    pItem.getTagCompound().setInteger("type", 0);
                                                    return true;
                                                }
                                                if (pItem.getTagCompound().getInteger("type") == 7) {
                                                    tile.setSlotStack((counter), new ItemStack(ModItems.ironchunkhot, 1));
                                                    pItem.getTagCompound().setInteger("type", 0);
                                                    System.out.println(counter);
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                    counter++;
                                }
                            }
                        }
                        if(state.getValue(FACING) == EnumFacing.WEST) {
                            int counter = 0;
                            for(int x=0; x<5; x++){
                                for(int z=0; z<5; z++){
                                    if(hitx >= this.getNormalMin(x) && hitx <= this.getNormalMax(x)){
                                        if(hitz >= this.getReverseMin(z) && hitz <= this.getReverseMax(z)) {
                                            if(!tile.getSlotStack(counter).isEmpty()) {
                                                if (pItem.getTagCompound().getInteger("type") == 0) {
                                                    if(tile.getSlotStack(counter).getItem().equals(ModItems.ironingotballhot)){
                                                        pItem.getTagCompound().setInteger("type", 6);
                                                        tile.setSlotStack(counter, ItemStack.EMPTY);
                                                        return true;
                                                    }
                                                    if(tile.getSlotStack(counter).getItem().equals(ModItems.ironchunkhot)){
                                                        pItem.getTagCompound().setInteger("type", 7);
                                                        tile.setSlotStack(counter, ItemStack.EMPTY);
                                                        System.out.println(counter);
                                                        return true;
                                                    }
                                                }
                                            }

                                            if(tile.getSlotStack(counter).isEmpty()) {
                                                if (pItem.getTagCompound().getInteger("type") == 6) {
                                                    tile.setSlotStack((counter), new ItemStack(ModItems.ironingotballhot, 1));
                                                    pItem.getTagCompound().setInteger("type", 0);
                                                    return true;
                                                }
                                                if (pItem.getTagCompound().getInteger("type") == 7) {
                                                    tile.setSlotStack((counter), new ItemStack(ModItems.ironchunkhot, 1));
                                                    pItem.getTagCompound().setInteger("type", 0);
                                                    System.out.println(counter);
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                    counter++;
                                }
                            }
                        }
                        if(state.getValue(FACING) == EnumFacing.EAST) {
                            int counter = 0;
                            for(int x=0; x<5; x++){
                                for(int z=0; z<5; z++){
                                    if(hitx >= this.getReverseMin(x) && hitx <= this.getReverseMax(x)){
                                        if(hitz >= this.getNormalMin(z) && hitz <= this.getNormalMax(z)) {
                                            if(!tile.getSlotStack(counter).isEmpty()) {
                                                if (pItem.getTagCompound().getInteger("type") == 0) {
                                                    if(tile.getSlotStack(counter).getItem().equals(ModItems.ironingotballhot)){
                                                        pItem.getTagCompound().setInteger("type", 6);
                                                        tile.setSlotStack(counter, ItemStack.EMPTY);
                                                        return true;
                                                    }
                                                    if(tile.getSlotStack(counter).getItem().equals(ModItems.ironchunkhot)){
                                                        pItem.getTagCompound().setInteger("type", 7);
                                                        tile.setSlotStack(counter, ItemStack.EMPTY);
                                                        System.out.println(counter);
                                                        return true;
                                                    }
                                                }
                                            }

                                            if(tile.getSlotStack(counter).isEmpty()) {
                                                if (pItem.getTagCompound().getInteger("type") == 6) {
                                                    tile.setSlotStack((counter), new ItemStack(ModItems.ironingotballhot, 1));
                                                    pItem.getTagCompound().setInteger("type", 0);
                                                    return true;
                                                }
                                                if (pItem.getTagCompound().getInteger("type") == 7) {
                                                    tile.setSlotStack((counter), new ItemStack(ModItems.ironchunkhot, 1));
                                                    pItem.getTagCompound().setInteger("type", 0);
                                                    System.out.println(counter);
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                    counter++;
                                }
                            }
                        }
                    }
                }


                return false;
            }
        }
        return false;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        if (!world.isRemote && world.getGameRules().getBoolean("doTileDrops"))
        {
            TileAnvil tile = (TileAnvil) world.getTileEntity(pos);
            if (tile !=null)
            {
                for (ItemStack stack : tile.getSlotList())
                {
                    if (stack != null) {
                        float offset = 0.7F;
                        double offsetX = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        double offsetY = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        double offsetZ = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        EntityItem item = new EntityItem(world, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ, stack);
                        item.setDefaultPickupDelay();
                        world.spawnEntity(item);
                    }
                }
            }
        }

        super.breakBlock(world, pos, state);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileAnvil();
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing()),2);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if( state.getValue(FACING) == EnumFacing.EAST) {
            i = 0;
            return i;
        }
        if( state.getValue(FACING) == EnumFacing.WEST) {
            i = 1;
            return i;
        }
        if( state.getValue(FACING) == EnumFacing.SOUTH){
            i = 2;
            return i;
        }
        if( state.getValue(FACING) == EnumFacing.NORTH){
            i = 3;
            return i;
        }
        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        if (meta == 0){
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
        }
        if (meta == 1) {
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
        }
        if (meta == 2) {
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
        }
        if (meta == 3) {
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
        }
        return iblockstate;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullyOpaque(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

}
