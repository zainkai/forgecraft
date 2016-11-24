package nmd.primal.forgecraft.Item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nmd.primal.forgecraft.ForgeCraft;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by kitsu on 11/24/2016.
 */
public class ItemBase extends Item {

    protected String name;

    public ItemBase(String name) {
        super();
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
    }
}
