package nmd.primal.forgecraft.tiles;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.animation.TimeValues;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.model.animation.CapabilityAnimation;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import nmd.primal.forgecraft.blocks.Firebox;
import nmd.primal.forgecraft.blocks.PistonBellows;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 1/5/17.
 */


public class TilePistonBellows extends BaseTile implements ITickable{

    private int iteration = 0;
    private int animateIteration = 0;

    @Override
    public void update () {
        if (!world.isRemote) {
            World world = this.getWorld();
            IBlockState state = world.getBlockState(this.pos);
            if (world.getBlockState(this.getPos()).getValue(PistonBellows.ACTIVE)) {
                iteration++;
                if(iteration <= 35){
                    animateIteration++;
                    //
                }
                if(iteration > 35){
                    animateIteration = 35 - (iteration - 35);
                    if(animateIteration < 0){
                        animateIteration = 0;
                    }
                    //
                }
                if(iteration > 71){
                    iteration = 0;
                    animateIteration = 0;
                    world.setBlockState(this.getPos(), state.withProperty(PistonBellows.ACTIVE, false), 3);
                }

                //System.out.println("Iterating");

                this.updateBlock();
                this.markDirty();
            }
        }
    }

    public int getIteration(){
        return this.iteration;
    }
    public int getAnimation(){
        return this.animateIteration;
    }


    public NBTTagCompound readNBT(NBTTagCompound nbt)
    {
        super.readNBT(nbt);
        this.iteration = nbt.getInteger("iteration");
        this.animateIteration = nbt.getInteger("animate");
        return nbt;
    }

    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        nbt.setInteger("iteration", this.iteration);
        nbt.setInteger("animate", this.animateIteration);
        return nbt;
    }

}
