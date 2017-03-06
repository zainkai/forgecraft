package nmd.primal.forgecraft.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

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

    private static Integer [] pickaxeHead = {
            0,0,0,0,0,
            0,1,1,1,0,
            1,0,0,0,1,
            0,0,0,0,0,
            0,0,0,0,0
    };

    public static ItemStack getSlots(Integer x) {
        return slots[x];
    }

    public static ItemStack[] getSlots() {
        return slots;
    }

    private ItemStack output;

    public AnvilCrafting(Integer input, ItemStack slot0, ItemStack slot1, ItemStack slot2, ItemStack slot3, ItemStack slot4, ItemStack slot5, ItemStack slot6, ItemStack slot7, ItemStack slot8, ItemStack slot9, ItemStack slot10, ItemStack slot11, ItemStack slot12, ItemStack slot13, ItemStack slot14, ItemStack slot15, ItemStack slot16, ItemStack slot17, ItemStack slot18, ItemStack slot19, ItemStack slot20, ItemStack slot21, ItemStack slot22, ItemStack slot23, ItemStack slot24, ItemStack output){

        this.input = input;
        this.slot0 = slot0;
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.slot3 = slot3;
        this.slot4 = slot4;
        this.slot5 = slot5;
        this.slot6 = slot6;
        this.slot7 = slot7;
        this.slot8 = slot8;
        this.slot9 = slot9;
        this.slot10 = slot10;
        this.slot11 = slot11;
        this.slot12 = slot12;
        this.slot13 = slot13;
        this.slot14 = slot14;
        this.slot15 = slot15;
        this.slot16 = slot16;
        this.slot17 = slot17;
        this.slot18 = slot18;
        this.slot19 = slot19;
        this.slot20 = slot20;
        this.slot21 = slot21;
        this.slot22 = slot22;
        this.slot23 = slot23;
        this.slot24 = slot24;
        this.output = output;

    }

    // ***************************************************************************** //
    //  Recipe Methods
    // ***************************************************************************** //

    public static void addRecipe(Integer input, ItemStack slot0, ItemStack slot1, ItemStack slot2, ItemStack slot3, ItemStack slot4, ItemStack slot5, ItemStack slot6, ItemStack slot7, ItemStack slot8, ItemStack slot9, ItemStack slot10, ItemStack slot11, ItemStack slot12, ItemStack slot13, ItemStack slot14, ItemStack slot15, ItemStack slot16, ItemStack slot17, ItemStack slot18, ItemStack slot19, ItemStack slot20, ItemStack slot21, ItemStack slot22, ItemStack slot23, ItemStack slot24, ItemStack output)
    {
        anvilRecipes.add(new AnvilCrafting(input, slot0, slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9, slot10, slot11, slot12, slot13, slot14, slot15, slot16, slot17, slot18, slot19, slot20, slot21, slot22, slot23, slot24, output));
    }

    public static boolean isRecipeItem(ItemStack stack)
    {
        for(AnvilCrafting recipe : anvilRecipes) {
            for(int i=0; i<25; i++){
                if (AnvilCrafting.getSlots(i).equals(stack))
                    return true;
            }

        }
        return false;
    }

    public static AnvilCrafting getRecipe(ItemStack stack)
    {
        for(AnvilCrafting recipe : anvilRecipes) {
            if (stack.equals(recipe.output))
                return recipe;
        }
        return null;
    }


}
