package nmd.primal.forgecraft.proxy;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.renders.blocks.TileAnvilRender;
import nmd.primal.forgecraft.renders.blocks.TileBloomeryRender;
import nmd.primal.forgecraft.renders.blocks.TileForgeRender;
import nmd.primal.forgecraft.renders.blocks.TilePistonBellowsRender;
import nmd.primal.forgecraft.tiles.TileAnvil;
import nmd.primal.forgecraft.tiles.TileBloomery;
import nmd.primal.forgecraft.tiles.TileForge;
import nmd.primal.forgecraft.tiles.TilePistonBellows;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ClientProxy implements CommonProxy {

    @Override
    public void preInit(){
        ModItems.registerCustomRenders();
    }

    @Override
    public void init() {
        //OBJLoader.INSTANCE.addDomain(ModInfo.MOD_ID);
        //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ModItems.stonetongs, 0, new ModelResourceLocation("stonetongs", "inventory"));
        ModItems.registerRenders();
        ModBlocks.registerRenders();
        //this.registerModelBakeryStuff();
        this.registerTileRendering();
    }

    //@Override
    public void registerTileRendering()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(TileForge.class, new TileForgeRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TilePistonBellows.class, new TilePistonBellowsRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileBloomery.class, new TileBloomeryRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileAnvil.class, new TileAnvilRender());
    }

    @Override
    public void registerModelBakeryVariants(){
        //ModelBakery.registerItemVariants(ModItems.stonetongs, new ResourceLocation(ModInfo.MOD_ID, "stonetongs_default"),
        //        new ResourceLocation(ModInfo.MOD_ID, "stonetongs_emptyhot"));
    }

}
