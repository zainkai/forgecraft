package nmd.primal.forgecraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import nmd.primal.forgecraft.Item.ModItems;
import nmd.primal.forgecraft.proxy.CommonProxy;
//import nmd.primal.forgecraft.common.init.*;

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
    public static ForgeCraft INSTANCE = new ForgeCraft();

    @SidedProxy(clientSide = "nmd.primal.forgecraft.proxy.ClientProxy", serverSide = "nmd.primal.forgecraft.proxy.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        this.proxy.preInit(event);

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        this.proxy.init(event);

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        this.proxy.postInit(event);

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