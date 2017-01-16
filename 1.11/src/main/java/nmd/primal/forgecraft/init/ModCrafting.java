package nmd.primal.forgecraft.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

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

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.pistonbellows),  "X X", "X X", " X ", 'X', Items.STICK);
    }
}
