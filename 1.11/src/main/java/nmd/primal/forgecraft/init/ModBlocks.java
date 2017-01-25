package nmd.primal.forgecraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.forgecraft.blocks.Bloomery;
import nmd.primal.forgecraft.blocks.EmptyCrucible;
import nmd.primal.forgecraft.blocks.Firebox;
import nmd.primal.forgecraft.blocks.PistonBellows;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ModBlocks {

    public static Block firebox;
    public static Block bloomery;
    public static Block pistonbellowsoak;
    public static Block pistonbellowsjungle;
    public static Block pistonbellowsbirch;
    public static Block pistonbellowsspruce;
    public static Block pistonbellowsdarkoak;
    public static Block pistonbellowsacacia;
    public static Block emptycrucible;


    public static void init() {

        firebox = new Firebox(Material.ROCK);
        pistonbellowsoak = new PistonBellows(Material.WOOD, "pistonbellowsoak");
        pistonbellowsjungle = new PistonBellows(Material.WOOD, "pistonbellowsjungle");
        pistonbellowsbirch = new PistonBellows(Material.WOOD, "pistonbellowsbirch");
        pistonbellowsspruce = new PistonBellows(Material.WOOD, "pistonbellowsspruce");
        pistonbellowsdarkoak = new PistonBellows(Material.WOOD, "pistonbellowsdarkoak");
        pistonbellowsacacia = new PistonBellows(Material.WOOD, "pistonbellowsacacia");
        bloomery = new Bloomery(Material.ROCK, "bloomery");
        emptycrucible = new EmptyCrucible(Material.ROCK, "emptycrucible");
    }

    public static void register() {
        registerBlock(firebox);
        registerBlock(pistonbellowsoak);
        registerBlock(pistonbellowsjungle);
        registerBlock(pistonbellowsbirch);
        registerBlock(pistonbellowsspruce);
        registerBlock(pistonbellowsdarkoak);
        registerBlock(pistonbellowsacacia);
        registerBlock(bloomery);
        registerBlock(emptycrucible);
    }

    public static void registerRenders() {
        registerRender(firebox);
        registerRender(pistonbellowsoak);
        registerRender(pistonbellowsjungle);
        registerRender(pistonbellowsbirch);
        registerRender(pistonbellowsspruce);
        registerRender(pistonbellowsdarkoak);
        registerRender(pistonbellowsacacia);
        registerRender(bloomery);
        registerRender(emptycrucible);
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
