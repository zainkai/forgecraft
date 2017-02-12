package nmd.primal.forgecraft.init;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.forgecraft.tiles.TileBaseCrucible;
import nmd.primal.forgecraft.tiles.TileBloomery;
import nmd.primal.forgecraft.tiles.TileForge;
import nmd.primal.forgecraft.tiles.TilePistonBellows;

/**
 * Created by kitsu on 12/2/2016.
 */
public class ModTiles {

    public static void registerTileEntities () {
        registerTileEntity(TileForge.class, "firebox");
        registerTileEntity(TilePistonBellows.class, "pistonbellows");
        registerTileEntity(TileBloomery.class, "bloomery");
        registerTileEntity(TileBaseCrucible.class, "basecrucible");
    }

    private static void registerTileEntity(Class<? extends TileEntity> tile_class, String baseName) {
        GameRegistry.registerTileEntity(tile_class, "tile.forgecraft." + baseName);
    }
}
