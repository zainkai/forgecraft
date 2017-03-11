package nmd.primal.forgecraft.crafting;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import static javax.swing.UIManager.put;

/**
 * Created by mminaie on 3/5/17.
 */
public class AnvilCrafting {

    // ***************************************************************************** //
    //  Recipe Handler AnvilCrafting
    // ***************************************************************************** //

    private static ArrayList<AnvilCrafting> anvilRecipes = new ArrayList<>();

    //private Integer[] input = new Integer[25];

    private String[] input = new String[25];

    //private ItemStack inputItem;

    //private static Item slot0, slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9, slot10, slot11, slot12, slot13, slot14, slot15, slot16, slot17, slot18, slot19, slot20, slot21, slot22, slot23, slot24;

    //private static Item[] input = {slot0, slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9, slot10, slot11, slot12, slot13, slot14, slot15, slot16, slot17, slot18, slot19, slot20, slot21, slot22, slot23, slot24};

    private ItemStack output;

    public AnvilCrafting(String[] input, ItemStack output){

        this.input = input;
        this.output = output;

    }

    // ***************************************************************************** //
    //  Recipe Methods
    // ***************************************************************************** //

    public static void addRecipe(String[] input, ItemStack output)
    {
        anvilRecipes.add(new AnvilCrafting(input, output));
    }

    public static boolean isRecipe(String[] array)
    {
        for(AnvilCrafting recipe : anvilRecipes) {
            if (Arrays.equals(array, recipe.input))

                return true;
        }
        return false;
    }

    public static AnvilCrafting getRecipe(String[] array)
    {
        for(AnvilCrafting recipe : anvilRecipes) {
            if (Arrays.equals(array, recipe.input))
                return recipe;
        }
        return null;
    }

    public String[] getInput() {return this.input;}

    public ItemStack getOutput() {return this.output;}

}
