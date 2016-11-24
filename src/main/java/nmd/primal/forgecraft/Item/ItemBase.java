package nmd.primal.forgecraft.Item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nmd.primal.forgecraft.ForgeCraft;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by kitsu on 11/24/2016.
 */
public class ItemBase extends Item implements ItemModelProvider{

    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel(Item item) {
        ForgeCraft.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
