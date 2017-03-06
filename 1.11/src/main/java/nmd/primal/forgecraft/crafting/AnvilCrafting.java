package nmd.primal.forgecraft.crafting;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
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

    private static int input;

    private static ItemStack slot0, slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9, slot10, slot11, slot12, slot13, slot14, slot15, slot16, slot17, slot18, slot19, slot20, slot21, slot22, slot23, slot24;

    private static ItemStack [] slots = {slot0, slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9, slot10, slot11, slot12, slot13, slot14, slot15, slot16, slot17, slot18, slot19, slot20, slot21, slot22, slot23, slot24};

    private static int[] craftingIDs = {6781014};

    public static int getCraftingIDs(Integer x) {
        return craftingIDs[x];
    }

    public static int[] getCraftingIDArray() {
        return craftingIDs;
    }

    private static ItemStack[] craftable = {new ItemStack(Blocks.OBSIDIAN, 1)};

    public static ItemStack getCraftable(Integer x) {
        return craftable[x];
    }


    /*public static Hashtable<Integer, ItemStack> anvilReference = new Hashtable<Integer, ItemStack>(){{

        put(6781014, new ItemStack(Blocks.OBSIDIAN, 1));

        //put(3, ModItems.battleAxe);

    }};*/

    public static ItemStack getSlots(Integer x) {
        return slots[x];
    }

    public static ItemStack[] getSlots() {
        return slots;
    }

    private ItemStack output;

    public AnvilCrafting(Integer input, ItemStack output){

        this.input = input;
        this.output = output;

    }

    // ***************************************************************************** //
    //  Recipe Methods
    // ***************************************************************************** //

    public static void addRecipe(Integer input, ItemStack output)
    {
        anvilRecipes.add(new AnvilCrafting(input, output));
    }

    public static boolean isRecipeItem(Integer craftingID)
    {
        for(AnvilCrafting recipe : anvilRecipes) {
            for(int i=0; i < AnvilCrafting.craftingIDs.length ; i++){
                if (craftingID.equals(getCraftingIDs(i)))
                    return true;
            }
        }
        return false;
    }

    public static AnvilCrafting getRecipe(Integer id)
    {
        for(AnvilCrafting recipe : anvilRecipes) {
            for (int i = 0; i < AnvilCrafting.craftingIDs.length; i++) {
                if (id.equals(getCraftingIDs(i)))
                    return recipe;
            }
        }
        return null;
    }

    public ItemStack getOutput() {return this.output;}

}
