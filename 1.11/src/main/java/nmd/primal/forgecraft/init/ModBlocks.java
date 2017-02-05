package nmd.primal.forgecraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.forgecraft.blocks.*;

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
    public static Block emptycruciblehot;
    public static Block emptycruciblecracked;
    public static Block emptycruciblecrackedhot;

    public static Block rawironcrucible;
    public static Block hotironcrucible;
    public static Block hotcookedironcrucible;
    public static Block coolironcrucible;
    public static Block failedironcrucible;
    public static Block failedironcruciblehot;

    public static void init() {

        firebox = new Firebox(Material.ROCK);

        bloomery = new Bloomery(Material.ROCK, "bloomery");

        pistonbellowsoak = new PistonBellows(Material.WOOD, "pistonbellowsoak");
        pistonbellowsjungle = new PistonBellows(Material.WOOD, "pistonbellowsjungle");
        pistonbellowsbirch = new PistonBellows(Material.WOOD, "pistonbellowsbirch");
        pistonbellowsspruce = new PistonBellows(Material.WOOD, "pistonbellowsspruce");
        pistonbellowsdarkoak = new PistonBellows(Material.WOOD, "pistonbellowsdarkoak");
        pistonbellowsacacia = new PistonBellows(Material.WOOD, "pistonbellowsacacia");

        emptycrucible = new Crucible(Material.ROCK, "emptycrucible");
        emptycruciblehot = new CrucibleHot(Material.ROCK, "emptycruciblehot");
        emptycruciblecracked = new Crucible(Material.ROCK, "emptycruciblecracked");
        emptycruciblecrackedhot = new CrucibleHot(Material.ROCK, "emptycruciblecrackedhot");

        rawironcrucible = new Crucible(Material.ROCK, "rawironcrucible");
        hotironcrucible = new CrucibleHot(Material.ROCK, "hotironcrucible");
        hotcookedironcrucible = new CrucibleHot(Material.ROCK, "hotcookedironcrucible");
        coolironcrucible = new Crucible(Material.ROCK, "coolironcrucible");
        failedironcrucible = new Crucible(Material.ROCK, "failedironcrucible");
        failedironcruciblehot = new Crucible(Material.ROCK, "failedironcruciblehot");

    }

    public static void register() {
        registerBlock(firebox);
        registerBlock(bloomery);

        registerBlock(pistonbellowsoak);
        registerBlock(pistonbellowsjungle);
        registerBlock(pistonbellowsbirch);
        registerBlock(pistonbellowsspruce);
        registerBlock(pistonbellowsdarkoak);
        registerBlock(pistonbellowsacacia);

        registerBlock(emptycrucible);
        registerBlock(emptycruciblehot);
        registerBlock(emptycruciblecracked);
        registerBlock(emptycruciblecrackedhot);

        registerBlock(rawironcrucible);
        registerBlock(hotironcrucible);
        registerBlock(hotcookedironcrucible);
        registerBlock(coolironcrucible);
        registerBlock(failedironcrucible);
        registerBlock(failedironcruciblehot);

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
        registerRender(emptycruciblehot);
        registerRender(emptycruciblecracked);
        registerRender(emptycruciblecrackedhot);

        registerRender(rawironcrucible);
        registerRender(hotironcrucible);
        registerRender(hotcookedironcrucible);
        registerRender(coolironcrucible);
        registerRender(failedironcrucible);
        registerRender(failedironcruciblehot);

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
