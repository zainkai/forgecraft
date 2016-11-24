package nmd.primal.forgecraft.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import nmd.primal.forgecraft.Item.ModItems;

/**
 * Created by kitsu on 11/24/2016.
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        //ModBlocks.createBlocks();
        ModItems.init();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
