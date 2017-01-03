package nmd.primal.forgecraft.blocks;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.tiles.TileFirebox;

import javax.annotation.Nullable;

/**
 * Created by mminaie on 1/1/17.
 */
public class PistonBellows extends CustomFacing {

    //public static final PropertyBool ACTIVE =  PropertyBool.create("active");
    //protected static final AxisAlignedBB collideBox = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.99D, 1.0D);
    protected static final AxisAlignedBB boundBox = new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 1.0D, 12 / 16D, 1.0D);

    public PistonBellows(Material material) {
        super(material);

        setUnlocalizedName(ModInfo.ForgecraftBlocks.PISTONBELLOWS.getUnlocalizedName());
        setRegistryName(ModInfo.ForgecraftBlocks.PISTONBELLOWS.getRegistryName());
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setHardness(3.0f);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!world.isRemote){
            System.out.println(facing);
            if(facing == EnumFacing.NORTH){
                BlockPos tempPos = new BlockPos(pos.getX()-1, pos.getY(), pos.getZ());
                TileFirebox tile = (TileFirebox) world.getTileEntity(tempPos);
                if(tile != null){
                    tile.setHeat(tile.getHeat() + 25);
                }
                System.out.println(world.getBlockState(tempPos).getBlock());
            }
            if(facing == EnumFacing.SOUTH){
                BlockPos tempPos = new BlockPos(pos.getX()+1, pos.getY(), pos.getZ());
                System.out.println(world.getBlockState(tempPos).getBlock());
            }
        }
        return true;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing()), 2);
    }

    //@Override
    //public TileEntity createNewTileEntity(World worldIn, int meta)
    //{
    //return new TilePistonBellows();
    //}

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return boundBox;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        /*if (!world.isRemote && world.getGameRules().getBoolean("doTileDrops"))
        {
            TilePistonBellows tile = (TilePistonBellows) world.getTileEntity(pos);
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
        }*/

        super.breakBlock(world, pos, state);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if( (state.getValue(FACING) == EnumFacing.EAST)){
            i = 0;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.WEST)){
            i = 1;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.SOUTH)){
            i = 2;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.NORTH)){
            i = 3;
            return i;
        }

        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing;

        switch (meta & 7)
        {
            case 0:
                enumfacing = EnumFacing.EAST;
                break;
            case 1:
                enumfacing = EnumFacing.WEST;
                break;
            case 2:
                enumfacing = EnumFacing.SOUTH;
                break;
            case 3:
                enumfacing = EnumFacing.NORTH;
                break;
            default:
                enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
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
