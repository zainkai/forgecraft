package nmd.primal.forgecraft.items;

import nmd.primal.forgecraft.items.BaseItem;

/**
 * Created by mminaie on 2/19/17.
 */
public abstract class BaseMultiItem extends BaseItem {

    public BaseMultiItem( String registryName) {
        setUnlocalizedName(registryName);
        setRegistryName(registryName);
    }

}
