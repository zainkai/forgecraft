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
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.tiles.TileFirebox;
import nmd.primal.forgecraft.tiles.TilePistonBellows;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Created by mminaie on 1/1/17.
 */
public class PistonBellows extends CustomContainerFacing {

    public static final PropertyBool ACTIVE =  PropertyBool.create("active");
    //protected static final AxisAlignedBB collideBox = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.99D, 1.0D);
    protected static final AxisAlignedBB boundBox = new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 1.0D, 12 / 16D, 1.0D);

    public PistonBellows(Material material) {
        super(material);

        setUnlocalizedName(ModInfo.ForgecraftBlocks.PISTONBELLOWS.getUnlocalizedName());
        setRegistryName(ModInfo.ForgecraftBlocks.PISTONBELLOWS.getRegistryName());
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, Boolean.valueOf(false)));
        setHardness(3.0f);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TilePistonBellows();
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {

        TilePistonBellows tile = (TilePistonBellows) worldIn.getTileEntity(pos);
        if (tile != null) {
            worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing()).withProperty(ACTIVE, Boolean.valueOf(false)), 2);
        }

    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!world.isRemote){
            System.out.println(state.getValue(PistonBellows.FACING));
            if(state.getValue(this.ACTIVE) == false) {
                world.setBlockState(pos, state.withProperty(ACTIVE, true), 2);
                if (state.getValue(PistonBellows.FACING) == EnumFacing.NORTH) {
                    BlockPos tempPos = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
                    if (world.getBlockState(tempPos).getBlock() == ModBlocks.firebox) {
                        TileFirebox tile = (TileFirebox) world.getTileEntity(tempPos);
                        if ((world.getBlockState(tempPos).getValue(Firebox.ACTIVE) == true) && (world.getBlockState(tempPos).getValue(Firebox.FACING) == EnumFacing.EAST)) {
                            if (tile != null) {
                                //System.out.println(world.getBlockState(tempPos).getValue(Firebox.FACING));
                                tile.setHeat(tile.getHeat() + 25);
                                tile.updateBlock();
                                tile.markDirty();
                                return true;
                            }
                        }
                    }
                }
                if (state.getValue(PistonBellows.FACING) == EnumFacing.SOUTH) {
                    BlockPos tempPos = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
                    if (world.getBlockState(tempPos).getBlock() == ModBlocks.firebox) {
                        TileFirebox tile = (TileFirebox) world.getTileEntity(tempPos);
                        if ((world.getBlockState(tempPos).getValue(Firebox.ACTIVE) == true) && (world.getBlockState(tempPos).getValue(Firebox.FACING) == EnumFacing.WEST)) {
                            if (tile != null) {
                                //System.out.println(world.getBlockState(tempPos).getValue(Firebox.FACING));
                                tile.setHeat(tile.getHeat() + 25);
                                tile.updateBlock();
                                tile.markDirty();
                                return true;
                            }
                        }
                    }
                }
                if (state.getValue(PistonBellows.FACING) == EnumFacing.EAST) {
                    BlockPos tempPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
                    if (world.getBlockState(tempPos).getBlock() == ModBlocks.firebox) {
                        TileFirebox tile = (TileFirebox) world.getTileEntity(tempPos);
                        if ((world.getBlockState(tempPos).getValue(Firebox.ACTIVE) == true) && (world.getBlockState(tempPos).getValue(Firebox.FACING) == EnumFacing.SOUTH)) {
                            if (tile != null) {
                                //System.out.println(world.getBlockState(tempPos).getValue(Firebox.FACING));
                                tile.setHeat(tile.getHeat() + 25);
                                tile.updateBlock();
                                tile.markDirty();
                                return true;
                            }
                        }
                    }
                }
                if (state.getValue(PistonBellows.FACING) == EnumFacing.WEST) {
                    BlockPos tempPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
                    if (world.getBlockState(tempPos).getBlock() == ModBlocks.firebox) {
                        TileFirebox tile = (TileFirebox) world.getTileEntity(tempPos);
                        if ((world.getBlockState(tempPos).getValue(Firebox.ACTIVE) == true) && (world.getBlockState(tempPos).getValue(Firebox.FACING) == EnumFacing.NORTH)) {
                            if (tile != null) {
                                //System.out.println(world.getBlockState(tempPos).getValue(Firebox.FACING));
                                tile.setHeat(tile.getHeat() + 25);
                                tile.updateBlock();
                                tile.markDirty();
                                return true;
                            }
                        }
                    }
                }
            }
        }
        /*if(world.isRemote){
            if(state.getValue(PistonBellows.FACING) == EnumFacing.NORTH) {
                BlockPos tempPos = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
                if(world.getBlockState(tempPos).getBlock() == ModBlocks.firebox){
                    TileFirebox tile = (TileFirebox) world.getTileEntity(tempPos);
                    if((world.getBlockState(tempPos).getValue(Firebox.ACTIVE) == true) && (world.getBlockState(tempPos).getValue(Firebox.FACING) == EnumFacing.EAST)){
                        makeEmbers(world, tempPos, world.rand);
                    }
                }

            }
            if(state.getValue(PistonBellows.FACING) == EnumFacing.SOUTH) {
                BlockPos tempPos = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
                if(world.getBlockState(tempPos).getBlock() == ModBlocks.firebox){
                    TileFirebox tile = (TileFirebox) world.getTileEntity(tempPos);
                    if((world.getBlockState(tempPos).getValue(Firebox.ACTIVE) == true) && (world.getBlockState(tempPos).getValue(Firebox.FACING) == EnumFacing.WEST)){
                        makeEmbers(world, tempPos, world.rand);
                    }
                }

            }
            if(state.getValue(PistonBellows.FACING) == EnumFacing.EAST) {
                BlockPos tempPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
                if(world.getBlockState(tempPos).getBlock() == ModBlocks.firebox){
                    TileFirebox tile = (TileFirebox) world.getTileEntity(tempPos);
                    if((world.getBlockState(tempPos).getValue(Firebox.ACTIVE) == true) && (world.getBlockState(tempPos).getValue(Firebox.FACING) == EnumFacing.SOUTH)){
                        makeEmbers(world, tempPos, world.rand);
                    }
                }

            }
            if(state.getValue(PistonBellows.FACING) == EnumFacing.WEST) {
                BlockPos tempPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
                if(world.getBlockState(tempPos).getBlock() == ModBlocks.firebox){
                    TileFirebox tile = (TileFirebox) world.getTileEntity(tempPos);
                    if((world.getBlockState(tempPos).getValue(Firebox.ACTIVE) == true) && (world.getBlockState(tempPos).getValue(Firebox.FACING) == EnumFacing.NORTH)){
                        makeEmbers(world, tempPos, world.rand);
                    }
                }

            }
        }*/
        return true;
    }




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

        if( (state.getValue(FACING) == EnumFacing.EAST) && state.getValue(ACTIVE) == false){
            i = 0;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.WEST) && state.getValue(ACTIVE) == false){
            i = 1;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.SOUTH) && state.getValue(ACTIVE) == false){
            i = 2;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.NORTH) && state.getValue(ACTIVE) == false){
            i = 3;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.EAST) && state.getValue(ACTIVE) == true){
            i = 4;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.WEST) && state.getValue(ACTIVE) == true){
            i = 5;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.SOUTH) && state.getValue(ACTIVE) == true){
            i = 6;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.NORTH) && state.getValue(ACTIVE) == true){
            i = 7;
            return i;
        }

        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing;
        Boolean active;



        switch (meta & 7)
        {
            case 0:
                enumfacing = EnumFacing.EAST;
                active = false;
                break;
            case 1:
                enumfacing = EnumFacing.WEST;
                active = false;
                break;
            case 2:
                enumfacing = EnumFacing.SOUTH;
                active = false;
                break;
            case 3:
                enumfacing = EnumFacing.NORTH;
                active = false;
                break;
            case 4:
                enumfacing = EnumFacing.EAST;
                active = true;
                break;
            case 5:
                enumfacing = EnumFacing.WEST;
                active = true;
                break;
            case 6:
                enumfacing = EnumFacing.SOUTH;
                active = true;
                break;
            case 7:
                enumfacing = EnumFacing.NORTH;
                active = true;
                break;
            default:
                enumfacing = EnumFacing.NORTH;
                active = false;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(ACTIVE, Boolean.valueOf(active));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING, ACTIVE});
    }

    //return new ExtendedBlockState(this, new IProperty[] { BotaniaStateProps.CARDINALS, Properties.StaticProperty }, new IUnlistedProperty[] { Properties.AnimationProperty });

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

    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
    {
        if(state.getValue(PistonBellows.ACTIVE) == Boolean.TRUE) {
            if (state.getValue(PistonBellows.FACING) == EnumFacing.NORTH) {
                BlockPos tempPos = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
                if (world.getBlockState(tempPos).getBlock() == ModBlocks.firebox) {
                    TileFirebox tile = (TileFirebox) world.getTileEntity(tempPos);
                    if ((world.getBlockState(tempPos).getValue(Firebox.ACTIVE) == true) && (world.getBlockState(tempPos).getValue(Firebox.FACING) == EnumFacing.EAST)) {
                        makeEmbers(world, tempPos, world.rand);
                    }
                }

            }
            if (state.getValue(PistonBellows.FACING) == EnumFacing.SOUTH) {
                BlockPos tempPos = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
                if (world.getBlockState(tempPos).getBlock() == ModBlocks.firebox) {
                    TileFirebox tile = (TileFirebox) world.getTileEntity(tempPos);
                    if ((world.getBlockState(tempPos).getValue(Firebox.ACTIVE) == true) && (world.getBlockState(tempPos).getValue(Firebox.FACING) == EnumFacing.WEST)) {
                        makeEmbers(world, tempPos, world.rand);
                    }
                }

            }
            if (state.getValue(PistonBellows.FACING) == EnumFacing.EAST) {
                BlockPos tempPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
                if (world.getBlockState(tempPos).getBlock() == ModBlocks.firebox) {
                    TileFirebox tile = (TileFirebox) world.getTileEntity(tempPos);
                    if ((world.getBlockState(tempPos).getValue(Firebox.ACTIVE) == true) && (world.getBlockState(tempPos).getValue(Firebox.FACING) == EnumFacing.SOUTH)) {
                        makeEmbers(world, tempPos, world.rand);
                    }
                }

            }
            if (state.getValue(PistonBellows.FACING) == EnumFacing.WEST) {
                BlockPos tempPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
                if (world.getBlockState(tempPos).getBlock() == ModBlocks.firebox) {
                    TileFirebox tile = (TileFirebox) world.getTileEntity(tempPos);
                    if ((world.getBlockState(tempPos).getValue(Firebox.ACTIVE) == true) && (world.getBlockState(tempPos).getValue(Firebox.FACING) == EnumFacing.NORTH)) {
                        makeEmbers(world, tempPos, world.rand);
                    }
                }
            }
        }
    }
    private void makeEmbers(World world, BlockPos pos, Random rand){
        double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + 0.65D;
        double d2 = (double)pos.getZ() + 0.5D;
        double d3 = 0.52D;
        double d4 = rand.nextDouble() * 0.6D - 0.3D;

        if(rand.nextInt(3) == 0){
            world.spawnParticle(EnumParticleTypes.FLAME, d0+d4, d1, d2+d4, 0.0D, 0.1D, 0.0D, new int[0]);
            world.spawnParticle(EnumParticleTypes.FLAME, d0+d4, d1, d2+d4, 0.0D, 0.1D, 0.0D, new int[0]);
        }
        if(rand.nextInt(3) == 1){
            world.spawnParticle(EnumParticleTypes.FLAME, d0+d4, d1, d2-d4, 0.0D, 0.1D, 0.0D, new int[0]);
            world.spawnParticle(EnumParticleTypes.FLAME, d0+d4, d1, d2+d4, 0.0D, 0.1D, 0.0D, new int[0]);
        }
        if(rand.nextInt(3) == 2){
            world.spawnParticle(EnumParticleTypes.FLAME, d0-d4, d1, d2+d4, 0.0D, 0.1D, 0.0D, new int[0]);
            world.spawnParticle(EnumParticleTypes.FLAME, d0+d4, d1, d2+d4, 0.0D, 0.1D, 0.0D, new int[0]);
        }
        if(rand.nextInt(3) == 3){
            world.spawnParticle(EnumParticleTypes.FLAME, d0-d4, d1, d2-d4, 0.0D, 0.1D, 0.0D, new int[0]);
            world.spawnParticle(EnumParticleTypes.FLAME, d0+d4, d1, d2+d4, 0.0D, 0.1D, 0.0D, new int[0]);
        }
    }


}