package nmd.primal.forgecraft.tiles;

import com.google.common.collect.ImmutableMap;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.animation.TimeValues;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.model.animation.CapabilityAnimation;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 1/5/17.
 */
public class TilePistonBellows extends BaseTile {

    private static final String TAG_ACTIVE = "active";

    public float innerRingPos;
    public boolean active = false;
    public boolean hasCart = false;
    public boolean hasCartOnTop = false;
    public float moving = 0F;

    public int comparator;
    public boolean hasRedstone = false;
    private int lastComparator = 0;

    private final TimeValues.VariableValue move;
    private final IAnimationStateMachine asm;

    public TilePistonBellows() {
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            move = new TimeValues.VariableValue(0);
            asm = ModelLoaderRegistry.loadASM(new ResourceLocation("botania", "asms/block/pump.json"), ImmutableMap.of("move", move));
        } else {
            move = null;
            asm = null;
        }
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> cap, @Nonnull EnumFacing side) {
        return cap == CapabilityAnimation.ANIMATION_CAPABILITY || super.hasCapability(cap, side);
    }

    @Nonnull
    @Override
    public <T> T getCapability(@Nonnull Capability<T> cap, @Nonnull EnumFacing side) {
        if (cap == CapabilityAnimation.ANIMATION_CAPABILITY) {
            return CapabilityAnimation.ANIMATION_CAPABILITY.cast(asm);
        }
        return super.getCapability(cap, side);
    }

}
