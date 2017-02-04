package nmd.primal.forgecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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
import nmd.primal.forgecraft.CommonUtils;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.tiles.TileBaseCrucible;
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

        if (!world.isRemote) {
            ItemStack pItem = player.inventory.getCurrentItem();
            if(pItem.isEmpty()){
                CommonUtils.spawnItemEntity(world, player, new ItemStack(this, 1));
                world.setBlockToAir(pos);
                return true;
            }
            if(Block.getBlockFromItem(pItem.getItem()) == this){
                CommonUtils.spawnItemEntity(world, player, new ItemStack(this, 1));
                world.setBlockToAir(pos);
                return true;
            }
        }

        return false;
    }

    /*@Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileBaseCrucible();
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
