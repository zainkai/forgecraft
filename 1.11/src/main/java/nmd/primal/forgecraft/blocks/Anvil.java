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
import nmd.primal.forgecraft.CommonUtils;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.tiles.TileAnvil;
import nmd.primal.forgecraft.tiles.TileForge;

/**
 * Created by mminaie on 3/4/17.
 */
public class Anvil extends CustomContainerFacing {

    public Anvil(Material material, String registryName, Float hardness) {
        super(material);
        setUnlocalizedName(ModInfo.ForgecraftBlocks.BLOOMERY.getUnlocalizedName());
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
                if(pItem.getItem().equals(ModItems.stonetongs)){
                    if(pItem.getTagCompound().getInteger("type") == 6){


                        if(state.getValue(FACING) == EnumFacing.NORTH){
                            for(int i = 1; i < 15; i+=3){
                                if(hitx >= (double)i/16.0) {
                                    if(hitx <= (double)(i+3)/16.0){
                                        for(int a = 1; a < 15; a+=3) {
                                            if(hitz >= (double)a/16.0) {
                                                if(hitz <= (double)(a+3)/16.0) {
                                                    int row = (int)(((i-1.0)/3.0));
                                                    int column = (int)(((a-1.0)/3.0)*5);
                                                    //System.out.println(row+column);
                                                    tile.setSlotStack((row+column), new ItemStack(ModItems.ironingotballhot, 1));
                                                    pItem.getTagCompound().setInteger("type", 0);
                                                    System.out.println(tile.getSlotStack(row+column));
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(state.getValue(FACING) == EnumFacing.SOUTH){
                            for(int i = 1; i < 15; i+=3){
                                if(hitx >= (double)i/16.0) {
                                    if(hitx <= (double)(i+3)/16.0){
                                        for(int a = 1; a < 15; a+=3) {
                                            if(hitz >= (double)a/16.0) {
                                                if(hitz <= (double)(a+3)/16.0) {
                                                    int row = (int)(((i-1.0)/3.0));
                                                    int column = (int)(((a-1.0)/3.0)*5);
                                                    System.out.println((int)Math.abs(24-(row+column)));
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(state.getValue(FACING) == EnumFacing.WEST){
                            for(int i = 1; i < 15; i+=3){
                                if(hitz >= (double)i/16.0) {
                                    if(hitz <= (double)(i+3)/16.0){
                                        for(int a = 1; a < 15; a+=3) {
                                            if(hitx >= (double)a/16.0) {
                                                if(hitx <= (double)(a+3)/16.0) {
                                                    int row = (int)Math.abs(((i-1.0)/3.0)-4);
                                                    int column = (int)(((a-1.0)/3.0)*5);
                                                    System.out.println("Row: " + row + " | Column: " + column);
                                                    System.out.println(row+column);
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(state.getValue(FACING) == EnumFacing.EAST){
                            for(int i = 1; i < 15; i+=3){
                                if(hitz >= (double)i/16.0) {
                                    if(hitz <= (double)(i+3)/16.0){
                                        for(int a = 1; a < 15; a+=3) {
                                            if(hitx >= (double)a/16.0) {
                                                if(hitx <= (double)(a+3)/16.0) {
                                                    int row = (int)(((i-1.0)/3.0));
                                                    int column = (int)(Math.abs(((a-1.0)/3.0)-4)*5);
                                                    System.out.println("Row: " + row + " | Column: " + column);
                                                    System.out.println(row+column);
                                                    return true;
                                                }
                                            }
                                        }
                                    }
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
