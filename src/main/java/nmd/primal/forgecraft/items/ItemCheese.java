package nmd.primal.forgecraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ItemCheese extends Item {

    public ItemCheese() {
        super();
        setUnlocalizedName(ModInfo.ForgecraftItems.CHEESE.getUnlocalizedName());
        setRegistryName(ModInfo.ForgecraftItems.CHEESE.getRegistryName());
        setCreativeTab(CreativeTabs.MATERIALS);
    }
}
