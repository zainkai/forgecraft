package nmd.primal.forgecraft.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.forgecraft.blocks.Bloomery;
import nmd.primal.forgecraft.crafting.BloomeryCrafting;

/**
 * Created by kitsu on 11/30/2016.
 */
public class ModCrafting {

    public static void register() {
        /***Firebox***/
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.firebox),  "X X", "XYX", "X X", 'X', Items.BRICK, 'Y', Blocks.FURNACE);

        /***Wooden PistonBellows***/
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.pistonbellowsoak),  "XXX", "X Y", "XXX",
                'X', new ItemStack(Blocks.PLANKS, 1, 0), 'Y', ModItems.pistonbellows);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.pistonbellowsspruce),  "XXX", "X Y", "XXX",
                'X', new ItemStack(Blocks.PLANKS, 1, 1), 'Y', ModItems.pistonbellows);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.pistonbellowsbirch),  "XXX", "X Y", "XXX",
                'X', new ItemStack(Blocks.PLANKS, 1, 2), 'Y', ModItems.pistonbellows);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.pistonbellowsjungle),  "XXX", "X Y", "XXX",
                'X', new ItemStack(Blocks.PLANKS, 1, 3), 'Y', ModItems.pistonbellows);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.pistonbellowsacacia),  "XXX", "X Y", "XXX",
                'X', new ItemStack(Blocks.PLANKS, 1, 4), 'Y', ModItems.pistonbellows);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.pistonbellowsdarkoak),  "XXX", "X Y", "XXX",
                'X', new ItemStack(Blocks.PLANKS, 1, 5), 'Y', ModItems.pistonbellows);

        /***Bellows Handle***/
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.pistonbellows),  "X X", "X X", " X ", 'X', Items.STICK);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.stonetongs, 1), "X X", "YSY", 'X', Blocks.STONE, 'S', Items.STRING, 'Y', Items.STICK);

        /***Bloomery Crafting***/

//Makes the Empty Crucible
        BloomeryCrafting.addRecipe(
                new ItemStack(ModItems.softcrucible, 1),
                new ItemStack(ModBlocks.emptycruciblehot, 1),
                new ItemStack(ModBlocks.emptycruciblecrackedhot, 1),
                new ItemStack(ModBlocks.emptycrucible, 1),
                2100,
                1600,
                600,
                0.25f,
                0.25f);

//Makes the Cracked Crucible
        BloomeryCrafting.addRecipe(
                new ItemStack(ModBlocks.emptycruciblehot, 1),
                new ItemStack(ModBlocks.emptycruciblecrackedhot, 1),
                new ItemStack(ModBlocks.emptycruciblecrackedhot, 1),
                new ItemStack(ModBlocks.emptycruciblecracked, 1),
                2700,
                9000,
                600,
                0.0f,
                0.0f);

//Makes the Hot Iron Crucible
        BloomeryCrafting.addRecipe(
                new ItemStack(ModBlocks.rawironcrucible, 1),
                new ItemStack(ModBlocks.hotironcrucible, 1),
                new ItemStack(ModBlocks.hotironcrucible, 1),
                new ItemStack(ModBlocks.rawironcrucible, 1),
                800,
                20,
                500,
                0.5f,
                0.0f
                );

//Makes the Finished Hot Iron Crucible
        BloomeryCrafting.addRecipe(
                new ItemStack(ModBlocks.hotironcrucible, 1),
                new ItemStack(ModBlocks.hotcookedironcrucible, 1),
                new ItemStack(ModBlocks.failedironcruciblehot, 1),
                new ItemStack(ModBlocks.coolironcrucible, 1),
                1550,
                1200,
                800,
                0.33f,
                0.5f
        );

//Remakes the Burnt Hot Iron Crucible
        BloomeryCrafting.addRecipe(
                new ItemStack(ModBlocks.failedironcruciblehot, 1),
                new ItemStack(ModBlocks.failedironcruciblehot, 1),
                new ItemStack(ModBlocks.failedironcruciblehot, 1),
                new ItemStack(ModBlocks.failedironcrucible, 1),
                5000,
                5000,
                800,
                0.0f,
                0.0f
        );

    }
}
