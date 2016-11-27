package nmd.primal.forgecraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.forgecraft.blocks.TestBlock;
import nmd.primal.forgecraft.items.ItemTest;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ModBlocks {

    public static Block testBlock;

    public static void init() {

        testBlock = new TestBlock(Material.CACTUS);
    }

    public static void register() {
        registerBlock(testBlock);

    }

    private static void registerBlock(Block block) {
        GameRegistry.register(testBlock);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        GameRegistry.register(item);
    }

    public static void registerRenders() {
        registerRender(testBlock);
    }

    private static void registerRender(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
}
