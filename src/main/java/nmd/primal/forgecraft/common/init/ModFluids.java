package nmd.primal.forgecraft.common.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;
import nmd.primal.core.common.PrimalCore;
import nmd.primal.core.common.fluids.Smoke;
import nmd.primal.core.common.fluids.Steam;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class ModFluids
{
    /**
     * The fluid blocks from this mod only. Doesn't include blocks for fluids that were already registered by another mod.
     */
    public static final Set<IFluidBlock> FLUID_BLOCKS = new HashSet<>();
    public static final Set<Fluid> FLUIDS = new HashSet<>();

    public static Fluid SMOKE;
    public static Fluid STEAM;
    public static Fluid WATER_CONDENSATION;
    public static Fluid TANNIN;

    public static ResourceLocation getStill(String fluid) {
        return new ResourceLocation(ModInfo.MOD_ID, "blocks/fluids/" + fluid + "_still");
    }

    public static ResourceLocation getFlowing(String fluid) {
        return new ResourceLocation(ModInfo.MOD_ID, "blocks/fluids/" + fluid + "_flow");
    }

    public static void registerFluids()
    {
        /**
        STATIC = createFluid("static", false,
                fluid -> fluid.setLuminosity(10).setDensity(800).setViscosity(1500),
                fluid -> new BlockFluidNoFlow(fluid, new MaterialLiquid(MapColor.BROWN)));

        STATIC_GAS = createFluid("staticGas", false,
                fluid -> fluid.setLuminosity(10).setDensity(-800).setViscosity(1500).setGaseous(true),
                fluid -> new BlockFluidNoFlow(fluid, new MaterialLiquid(MapColor.BROWN)));

        NORMAL = createFluid("normal", true,
                fluid -> fluid.setLuminosity(10).setDensity(1600).setViscosity(100),
                fluid -> new BlockFluidClassic(fluid, new MaterialLiquid(MapColor.ADOBE)));

        NORMAL_GAS = createFluid("normalGas", true,
                fluid -> fluid.setLuminosity(10).setDensity(-1600).setViscosity(100).setGaseous(true),
                fluid -> new BlockFluidClassic(fluid, new MaterialLiquid(MapColor.ADOBE)));

        FINITE = createFluid("finite", false,
                fluid -> fluid.setLuminosity(10).setDensity(800).setViscosity(1500),
                fluid -> new BlockFluidFinite(fluid, new MaterialLiquid(MapColor.BLACK)));
        **/

        SMOKE = createFluid("smoke", false,
                fluid -> fluid.setLuminosity(0).setDensity(-1600).setViscosity(2000).setTemperature(600).setGaseous(true),
                fluid -> new Smoke(fluid));

        STEAM = createFluid("steam", false,
                fluid -> fluid.setLuminosity(0).setDensity(-1600).setViscosity(2000).setTemperature(1600).setGaseous(true),
                fluid -> new Steam(fluid));

        WATER_CONDENSATION = createFluid("water_condensation", false,
                fluid -> fluid.setLuminosity(0).setDensity(1600).setViscosity(100).setGaseous(false),
                fluid -> new BlockFluidFinite(fluid, Material.WATER));

        //TANNIN = createFluid("tannin", true,
        //        fluid -> fluid.setLuminosity(0).setDensity(1600).setViscosity(100).setGaseous(false),
        //        fluid -> new BlockFluidClassic(fluid, new MaterialLiquid(MapColor.BROWN)));

    }

    /**
    @SideOnly(Side.CLIENT)
    public void registerRenderers() {
        MinecraftForge.EVENT_BUS.register(this);
        registerFluidBlockRendering(fluidNutrientDistillation, NUTRIENT_DISTILLATION_NAME);
        registerFluidBlockRendering(fluidHootch, HOOTCH_NAME);
        registerFluidBlockRendering(fluidFireWater, FIRE_WATER_NAME);
        registerFluidBlockRendering(fluidRocketFuel, ROCKET_FUEL_NAME);
        registerFluidBlockRendering(fluidLiquidSunshine, LIQUID_SUNSHINE_NAME);
        registerFluidBlockRendering(fluidCloudSeed, CLOUD_SEED_NAME);
        registerFluidBlockRendering(fluidCloudSeedConcentrated, CLOUD_SEED_CONCENTRATED_NAME);
    }

    @SideOnly(Side.CLIENT)
    public void registerFluidBlockRendering(Fluid fluid, String name) {

        FluidStateMapper mapper = new FluidStateMapper(fluid);
        Block block = fluid.getBlock();
        Item item = Item.getItemFromBlock(block);

        // item-model
        if (item != null) {
            ModelLoader.registerItemVariants(item);
            ModelLoader.setCustomMeshDefinition(item, mapper);
        }
        // block-model
        if (block != null) {
            ModelLoader.setCustomStateMapper(block, mapper);
        }
    }
    **/

    /*******************************************************************************
     * Registration Methods
     * https://github.com/Choonster/TestMod3/blob/1.10.2/src/main/java/choonster/testmod3/init/ModFluids.java
     */
    /**
     * Create a {@link Fluid} and its {@link IFluidBlock}, or use the existing ones if a fluid has already been registered with the same name.
     *
     * @param name                 The name of the fluid
     * @param hasFlowIcon          Does the fluid have a flow icon?
     * @param fluidPropertyApplier A function that sets the properties of the {@link Fluid}
     * @param blockFactory         A function that creates the {@link IFluidBlock}
     * @return The fluid and block
     *
     * PrimalCore.proxy.registerFluidRendering(fluidBlock, name);
     */
    private static <T extends Block & IFluidBlock> Fluid createFluid(String name, boolean hasFlowIcon, Consumer<Fluid> fluidPropertyApplier, Function<Fluid, T> blockFactory)
    {
        final String texturePrefix = ModInfo.MOD_PREFIX + "blocks/fluids/";
        final ResourceLocation still = new ResourceLocation(texturePrefix + name + "_still");
        final ResourceLocation flowing = hasFlowIcon ? new ResourceLocation(texturePrefix + name + "_flow") : still;

        //final ResourceLocation still = new ResourceLocation(ModInfo.MOD_PREFIX + "blocks/fluids/" + name + "_still");
        ///final ResourceLocation flowing = hasFlowIcon ? new ResourceLocation(ModInfo.MOD_PREFIX + "blocks/fluids/" + name + "_flow") : still;

        Fluid fluid = new Fluid(name, still, flowing);
        final boolean useOwnFluid = FluidRegistry.registerFluid(fluid);

        if (useOwnFluid) {
            fluidPropertyApplier.accept(fluid);
            registerFluidBlock(blockFactory.apply(fluid), name);
        } else {
            fluid = FluidRegistry.getFluid(name);
        }


        FLUIDS.add(fluid);

        return fluid;
    }

    private static <T extends Block & IFluidBlock> T registerFluidBlock(T block, String name)
    {
        //block.setRegistryName("fluid." + block.getFluid().getName());
        //block.setRegistryName(block.getFluid().getName());
        block.setUnlocalizedName(ModInfo.MOD_PREFIX + block.getFluid().getUnlocalizedName());

        //block.setCreativeTab(ModInfo.TAB_PRIMAL);

        ModBlocks.registerBlock("fluid." + name, block, true);
        //PrimalCore.proxy.registerFluidModel(block, block.getFluid().getName());

        //PrimalCore.proxy.registerFluidModel(block);
        PrimalCore.proxy.registerFluidBlockRendering(block, name);
        FLUID_BLOCKS.add(block);

        return block;
    }

    /**
    private static void registerBucket(Fluid fluid) {
        FluidRegistry.addBucketForFluid(fluid);
    }

    private static void registerTank(Fluid fluid) {
        final FluidStack fluidStack = new FluidStack(fluid, TileEntityFluidTank.CAPACITY);
        ((ItemFluidTank) Item.getItemFromBlock(ModBlocks.FLUID_TANK)).addFluid(fluidStack);
    } **/
}