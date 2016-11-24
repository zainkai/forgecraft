package nmd.primal.forgecraft.common;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import nmd.primal.forgecraft.common.init.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

@Mod(   modid = ModInfo.MOD_ID,
        name = ModInfo.MOD_ID,
        version = ModInfo.MOD_VERSION,
        acceptedMinecraftVersions = ModInfo.MC_VERSIONS,
        dependencies = ModInfo.DEPENDENCIES,
        guiFactory = ModInfo.GUI_FACTORY,
        updateJSON = ModInfo.UPDATE_JSON
)
public class ForgeCraft
{
    @Mod.Instance(ModInfo.MOD_ID)
    public static ForgeCraft INSTANCE;

    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.COMMON_PROXY)
    public static CommonProxy proxy;

    public static Logger LOGGER = LogManager.getLogger(ModInfo.MOD_ID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOGGER.info("Pre-Init");
        Locale.setDefault(Locale.ENGLISH);

        /*Configuration File*/

        //CONFIG_DIRECTORY = new File(event.getModConfigurationDirectory(), "primal");
        //ModConfig.init(event.getSuggestedConfigurationFile());
        //LOGGER.info("Debug Level: " + ModConfig.DEBUG_LEVEL);

        /*Networking*/
        //NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MOD_CHANNEL);
        //NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        /*
        Load Main Content
        In Order of:
            Sounds, Entities, Tiles, Blocks, Fluids, Items
        */
        //ModTileEntities.registerTileEntities();

        //ModBlocks.registerBlocks();
        //ModBlocks.registerSubBlocks();
        //ModBlocks.registerOres();
        //ModBlocks.registerPlants();
        //ModBlocks.registerLighting();
        //ModBlocks.registerTablesShelves();

        //ModFluids.registerFluids();

        //ModItems.registerItems();

        //ModSounds.registerSounds();
        //ModEntities.registerEntities();

        /*Events*/
        //ModEvents.registerCommonEvents();

        /*Sounds*/
        //ModSoundHandler.init();

        /*Proxy Power*/
        //proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        //LOGGER.info("Init");
       // proxy.init();

        /*World-Gen*/

        //ModWorldGen.registerWorldGenerators();
        //ModWorldGen.registerDimensionProviders();

        /*Register More Stuff*/
        //ModRegistries.registerFuels();
        //ModRegistries.registerVanillaTorches();
        //ModRegistries.registerRepairItems();
        //ModRegistries.registerToolBreakItems();
        //ModRegistries.registerAdditionalCraftingItems();
        //DispenserBehavoir.registerDispenserItems();
        //ModDictionary.registerDictionaryNames();

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        //LOGGER.info("Post-Init");
        //proxy.postInit();

        /*Crafting, Remove Vanilla Recipes*/
        //ModCrafting.registerRecipeRemover();
        //ModCrafting.registerRecipes();

    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        //event.registerServerCommand(new PrimalCommand());
    }

    //public File getConfigDirectory()
    //{
    //    return CONFIG_DIRECTORY;
    //}
}