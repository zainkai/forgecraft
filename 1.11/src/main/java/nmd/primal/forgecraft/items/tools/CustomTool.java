package nmd.primal.forgecraft.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by mminaie on 3/9/17.
 */
public abstract class CustomTool extends Item {

    public CustomTool(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        this.setMaxStackSize(1);
        this.setNoRepair();



    }

    @Override
    public boolean isRepairable()
    {
        return false;
    }

    public int getItemEnchantability(ItemStack stack)
    {
        return 0;
    }

}
