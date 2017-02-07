package nmd.primal.forgecraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by mminaie on 2/6/17.
 */
public class IngotBall extends BlockCustomBase {

    protected static final AxisAlignedBB boundBox = new AxisAlignedBB(7/16D, 0.0D, 7/16D, 9/16D, 2/16D, 9/16D);

    public IngotBall(Material material, String registryName, Float hardness){
        super(material, registryName, hardness);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return boundBox;
    }

}
