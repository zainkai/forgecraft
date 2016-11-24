package nmd.primal.forgecraft.common.init;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
//import nmd.primal.forgecraft.common.world.ForgeCraftWorldGenerator;


public class ModWorldGen
{
    public static void registerMapGen()
    {
        //MapGenStructureIO.registerStructure(MapGenScatteredFeatureModBiomes.Start.class, "testmod3:MapGenScatteredFeatureModBiomes");
        //MinecraftForge.TERRAIN_GEN_BUS.register(new MapGenHandler());
    }

    public static void registerWorldGenerators()
    {
        if (ModConfig.WORLDGEN_ENABLE)
        {
            //GameRegistry.registerWorldGenerator(new PrimalWorldGenerator(), 0);
        }

    }


    /**
    if (ModConfig.) {

    }

    if (ModConfig.FEA) {
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
    }
     **/
}
