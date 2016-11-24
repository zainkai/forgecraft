package nmd.primal.forgecraft.common.init;

import net.minecraftforge.common.MinecraftForge;
//import nmd.primal.forgecraft.common.CommonEvents;
import nmd.primal.forgecraft.common.ForgeCraft;
//import nmd.primal.forgecraft.common.crafting.CraftingEvents;
//import nmd.primal.forgecraft.common.world.WorldEvents;
import nmd.primal.forgecraft.common.ForgeCraft;

public class ModEvents
{
    public static void registerCommonEvents()
    {
        ForgeCraft.LOGGER.info("Register Events");

        ///
        //  Common Events
        ///
        //MinecraftForge.EVENT_BUS.register(new CommonEvents());
        //MinecraftForge.EVENT_BUS.register(new CraftingEvents());

        ///
        //  OreGen Bus
        ///
        if (ModConfig.WORLDGEN_DISABLE_VANILLA_ORE_IRON)
            //MinecraftForge.ORE_GEN_BUS.register(new WorldEvents());

        ///
        //  Client Events
        ///
        ForgeCraft.proxy.registerClientEvents();
        //if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
        //    registerClientEvents();
        //}
    }

    //@SideOnly(Side.CLIENT)
    //private static void registerClientEvents() {
    //    MinecraftForge.EVENT_BUS.register(new GuiEventHandler());
    //}
}