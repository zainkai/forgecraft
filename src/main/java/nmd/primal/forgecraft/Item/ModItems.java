package nmd.primal.forgecraft.Item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by kitsu on 11/24/2016.
 */
public class ModItems {

    public static Item test;

    public static void init(){

           test = register(new ItemBase("test").setCreativeTab(ModInfo.TAB_FORGECRAFT));
    }


    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemModelProvider) {
            ((ItemModelProvider)item).registerItemModel(item);
        }
        if (item instanceof ItemOreDict) {
            ((ItemOreDict)item).initOreDict();
        }

        return item;
    }

}
