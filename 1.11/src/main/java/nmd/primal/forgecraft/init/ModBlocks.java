package nmd.primal.forgecraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.forgecraft.blocks.Firebox;
import nmd.primal.forgecraft.blocks.PistonBellows;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ModBlocks {

    public static Block firebox;
    public static Block pistonbellows;
    public static Block pistonbellowsjungle;

    public static void init() {

        firebox = new Firebox(Material.ROCK);
        pistonbellows = new PistonBellows(Material.WOOD);
        pistonbellowsjungle = new PistonBellows(Material.WOOD);
    }

    public static void register() {
        registerBlock(firebox);
        registerBlock(pistonbellows);
        registerBlock(pistonbellowsjungle);
    }

    public static void registerRenders() {
        registerRender(firebox);
        registerRender(pistonbellows);
        registerRender(pistonbellowsjungle);
    }

    private static void registerBlock(Block block) {
        GameRegistry.register(block);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        GameRegistry.register(item);
    }

    private static void registerRender(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
}
