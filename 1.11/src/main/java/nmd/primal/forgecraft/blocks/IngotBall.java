package nmd.primal.forgecraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by mminaie on 2/6/17.
 */
public class IngotBall extends BlockCustomBase {

    protected static final AxisAlignedBB boundBox = new AxisAlignedBB(7/16D, 0.0D, 7/16D, 9/16D, 2/16D, 9/16D);
    public static final PropertyBool ACTIVE =  PropertyBool.create("active");

    public IngotBall(Material material, String registryName, Float hardness){
        super(material, registryName, hardness);

    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return boundBox;
    }


    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        //System.out.println(stack.getItemDamage());
        worldIn.setBlockState(pos, state.withProperty(ACTIVE, Boolean.valueOf(false)), 2);
        //System.out.println(state.getValue(ACTIVE));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if(  state.getValue(ACTIVE) == false) {
            i = 0;
            return i;
        }
        if(  state.getValue(ACTIVE) == true) {
            i = 1;
            return i;
        }
        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        if (meta == 0){
            iblockstate = iblockstate.withProperty(ACTIVE, Boolean.valueOf(false));
        }
        if (meta == 1) {
            iblockstate = iblockstate.withProperty(ACTIVE, Boolean.valueOf(true));
        }
        return iblockstate;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {ACTIVE});
    }

}
