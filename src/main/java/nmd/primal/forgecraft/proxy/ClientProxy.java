package nmd.primal.forgecraft.proxy;

import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;

import static nmd.primal.forgecraft.init.ModItems.*;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ClientProxy implements CommonProxy {

    @Override
    public void init() {

        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }


}
