package nmd.primal.forgecraft.items.weapons;

import net.minecraft.item.Item;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.items.BaseItem;

/**
 * Created by Lyle on 4/2/2017.
 */
public class Musket extends BaseItem{

    public Musket(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        this.setMaxStackSize(1);
        this.setNoRepair();
    }
}
