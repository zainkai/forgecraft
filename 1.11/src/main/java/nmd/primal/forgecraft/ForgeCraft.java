package nmd.primal.forgecraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import nmd.primal.forgecraft.compat.ModDictionary;
import nmd.primal.forgecraft.gui.GuiHandler;
import nmd.primal.forgecraft.init.*;
import nmd.primal.forgecraft.proxy.CommonProxy;

//import nmd.primal.forgecraft.common.init.*;

@Mod(   modid = ModInfo.MOD_ID,
        name = ModInfo.MOD_NAME,
        version = ModInfo.MOD_VERSION,
        acceptedMinecraftVersions = ModInfo.MC_VERSIONS,
        dependencies = ModInfo.DEPENDENCIES
        //guiFactory = ModInfo.GUI_FACTORY,
        //updateJSON = ModInfo.UPDATE_JSON
)
public class ForgeCraft
{
    @Instance
    public static ForgeCraft instance;
    public static SimpleNetworkWrapper NETWORK;
    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.SERVER_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MOD_CHANNEL);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());


        ModBlocks.init();
        ModBlocks.register();
        ModItems.init();
        ModItems.register();

        ModTiles.registerTileEntities();
        ModSounds.registerSounds();
        ModEvents.registerCommonEvents();
        //ModEvents.registerClientEvents();
//        ModItems.registerRenders();
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        //this.proxy.init(event);
        proxy.init();
        ModDictionary.registerDictionaryNames();
        ModCrafting.register();

        //proxy.registerModelBakeryVariants();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        //this.proxy.postInit(event);
    }

    /*@EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        //event.registerServerCommand(new PrimalCommand());
    }

    //public File getConfigDirectory()
    //{
    //    return CONFIG_DIRECTORY;
    //}
    */
}