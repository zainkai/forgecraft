package nmd.primal.forgecraft.common.init;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
//import nmd.primal.forgecraft.common.tiles.*;

public class ModTileEntities
{
    /*******************************************************************************
     * Tile Entities
     */
    public static void registerTileEntities() // init
    {
        //registerTileEntity(TileWorkTableBasic.class, "WORKTABLE_BASIC");
        //registerTileEntity(TileWorkTableShelf.class, "WORKTABLE_SHELVES");
        //registerTileEntity(TileShelf.class, "shelf");
        //registerTileEntity(TileDryingRack.class, "rack");
        //registerTileEntity(TileFishTrap.class, "fishtrap");
    }

    /*******************************************************************************
     * registration Methods
     */
    private static void registerTileEntity(Class<? extends TileEntity> tile_class, String baseName)
    {
        GameRegistry.registerTileEntity(tile_class, "tile.forgecraft." + baseName);
    }
}