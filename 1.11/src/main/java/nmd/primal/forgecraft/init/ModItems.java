package nmd.primal.forgecraft.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.forgecraft.items.ItemBellowsHandle;
import nmd.primal.forgecraft.items.ItemTest;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ModItems {

    public static Item pistonbellows;
    public static Item test;

    public static void init() {
        pistonbellows = new ItemBellowsHandle();
        //test = new ItemTest();
    }

    public static void register() {
        GameRegistry.register(pistonbellows);
        //GameRegistry.register(test);
    }

    public static void registerRenders() {
        registerRender(pistonbellows);
        //registerRender(test);
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
