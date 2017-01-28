package nmd.primal.forgecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.CommonUtils;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.tiles.TileFirebox;

/**
 * Created by mminaie on 1/24/17.
 */
public class EmptyCrucible extends Block {

    protected static final AxisAlignedBB boundBox = new AxisAlignedBB(4/16D, 0.0D, 4/16D, 12/16D, 7/16D, 12/16D);

    //public static final PropertyInteger SIZE =  PropertyInteger.create("size", 0, 3);

    public EmptyCrucible(Material material, String registryName) {
        super(material);
        setUnlocalizedName(ModInfo.ForgecraftBlocks.EMPTYCRUCIBLE.getUnlocalizedName());
        //setUnlocalizedName("emptycrucible");
        setRegistryName(registryName);
        //setRegistryName(ModInfo.ForgecraftBlocks.FIREBOX.getRegistryName());
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
        setHardness(3.0f);
        //this.blockState.getBaseState().withProperty(SIZE, Integer.valueOf(0));
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        /*if (!world.isRemote) {
            System.out.println(state.getValue(SIZE));
            //TileFirebox tile = (TileFirebox) world.getTileEntity(pos);
            //if (tile != null) {
                ItemStack pItem = player.inventory.getCurrentItem();
                if(pItem.isEmpty()) {
                    if (player.isSneaking()) {
                        CommonUtils.spawnItemEntity(world, player, new ItemStack(this, 1, this.getMetaFromState(state)));
                    }
                }

            if(state.getValue(SIZE) == 3){
                world.setBlockState(pos, state.withProperty(SIZE, 0), 2);
                return true;
            } else
            world.setBlockState(pos, state.withProperty(SIZE, state.getValue(SIZE) + 1), 2);
            return true;
        }
        if(player.isSneaking()){

        }*/
        return false;
    }

    // ***************************************************************************** //
    //  BlockState
    // ***************************************************************************** //
    /*@Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(SIZE, 0), 2);
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getStateFromMeta(meta).withProperty(SIZE, 0);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {SIZE});
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        if (meta == 0){
            iblockstate = iblockstate.withProperty(SIZE, 0);
        } else if (meta == 1){
            iblockstate = iblockstate.withProperty(SIZE, 1);
        } else if (meta == 2){
            iblockstate = iblockstate.withProperty(SIZE, 2);
        } else if (meta == 3){
            iblockstate = iblockstate.withProperty(SIZE, 3);
        }

        return iblockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        //switch state.getValue(LOG_AXIS);
        if(state.getValue(SIZE) == 0) {
            i = 0;
            return i;
        } else if(state.getValue(SIZE) == 1){
            i = 1;
            return i;
        } else if(state.getValue(SIZE) == 2){
            i = 2;
            return i;
        }else if(state.getValue(SIZE) == 3){
            i = 3;
            return i;
        }
        return i;
    }*/

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return boundBox;
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
