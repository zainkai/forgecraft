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

        /***Bloomery Crafting***/
        //DryingRecipe.addRecipe(new ItemStack(Items.FISH, 1, 0), new ItemStack(PrimalItems.FISH_COD_DRIED), new ItemStack(PrimalItems.FISH_COD_ROTTEN), 25, 0.006F);
        BloomeryCrafting.addRecipe(
                new ItemStack(ModItems.softcrucible, 1),
                new ItemStack(ModBlocks.emptycrucible, 1),
                new ItemStack(Items.STICK, 1),
                2100,
                2400,
                0.25f,
                0.25f);

        BloomeryCrafting.addRecipe(
                new ItemStack(ModBlocks.emptycrucible, 1),
                new ItemStack(Items.STICK, 1),
                new ItemStack(Items.STICK, 1),
                2700,
                9000,
                0.0f,
                0.0f);
    }
}
