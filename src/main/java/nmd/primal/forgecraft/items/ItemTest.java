package nmd.primal.forgecraft.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ItemTest extends Item {

    public ItemTest() {
        setUnlocalizedName(ModInfo.ForgecraftItems.TEST.getUnlocalizedName());
        setRegistryName(ModInfo.ForgecraftItems.TEST.getRegistryName());
    }

}
