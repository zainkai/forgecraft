package nmd.primal.forgecraft.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.common.init.ModInfo;
import nmd.primal.forgecraft.common.tiles.TileFirebox;

/**
 * Created by kitsu on 11/24/2016.
 */
public class FireBox extends Block{

    public FireBox(Material material, MapColor mapColor, String blockName) {
        super(material, mapColor);
        setBlockName(this, blockName);
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
    }

    public FireBox(Material materialIn, String blockName) {
        this(materialIn, materialIn.getMaterialMapColor(), blockName);
    }

    public static void setBlockName(Block block, String blockName) {
        block.setRegistryName(ModInfo.MOD_ID, blockName);
        block.setUnlocalizedName(block.getRegistryName().toString());
    }

    // ***************************************************************************** //
    //  Rendering
    // ***************************************************************************** //
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

    // ***************************************************************************** //
    //  Placement
    // ***************************************************************************** //
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        ((TileFirebox) world.getTileEntity(pos)).rotation = (byte) (((MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 1) % 4);
    }


}
