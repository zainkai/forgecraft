package nmd.primal.forgecraft.Item;

import net.minecraft.client.Minecraft;
//import net.minecraft.client.resources.model.ModelResourceLocation;
//import net.minecraft.client.resources.
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by kitsu on 11/24/2016.
 */
public class ItemRenderRegister {

    public static String modid = ModInfo.MOD_ID;

    public static void registerItemRenderer() {
        reg(ModItems.test);
    }

    public static void reg(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}