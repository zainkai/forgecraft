package nmd.primal.forgecraft.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.renders.TileBloomeryRender;
import nmd.primal.forgecraft.renders.TileFireboxRender;
import nmd.primal.forgecraft.renders.TilePistonBellowsRender;
import nmd.primal.forgecraft.tiles.TileBloomery;
import nmd.primal.forgecraft.tiles.TileFirebox;
import nmd.primal.forgecraft.tiles.TilePistonBellows;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ClientProxy implements CommonProxy {

    @Override
    public void init() {
        //OBJLoader.INSTANCE.addDomain(ModInfo.MOD_ID);
        //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ModItems.stonetongs, 0, new ModelResourceLocation("stonetongs", "inventory"));
        ModItems.registerRenders();
        ModBlocks.registerRenders();
        this.registerTileRendering();
    }

    //@Override
    public void registerTileRendering()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(TileFirebox.class, new TileFireboxRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TilePistonBellows.class, new TilePistonBellowsRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileBloomery.class, new TileBloomeryRender());
    }


}
