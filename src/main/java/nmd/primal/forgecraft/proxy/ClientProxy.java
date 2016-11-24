package nmd.primal.forgecraft.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by kitsu on 11/24/2016.
 */
public class ClientProxy extends CommonProxy {

    public static Minecraft minecraft = Minecraft.getMinecraft();

    @Override
    public void renderItem(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ModInfo.MOD_ID + ":" + id, "inventory"));
        //minecraft.getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
