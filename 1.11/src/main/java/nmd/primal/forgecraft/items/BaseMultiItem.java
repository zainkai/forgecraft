package nmd.primal.forgecraft.items;

import net.minecraft.item.Item;
import nmd.primal.forgecraft.items.BaseItem;

/**
 * Created by mminaie on 2/19/17.
 */
public class BaseMultiItem extends BaseItem {

    private Item.ToolMaterial mat;

    public BaseMultiItem( String registryName, Item.ToolMaterial material) {
        setUnlocalizedName(registryName);
        setRegistryName(registryName);
        mat = material;
    }

    public Item.ToolMaterial getMaterial(Item item){
        return mat;
    }

}
