package nmd.primal.forgecraft.api;

import com.google.common.collect.Lists;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import org.apache.commons.lang3.tuple.Triple;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class ForgeCraftRegistries
{
    /*******************************************************************************
     *
     */


    /*******************************************************************************
     *  Parent Block Registry, this will kick off crafting for slabs, stairs, etc..
     */
    public static List<ItemStack> PARENT_BLOCK_REGISTRY = new ArrayList<>();

    public static void addParentBlock(ItemStack stack)
    {
        ForgeCraftRegistries.PARENT_BLOCK_REGISTRY.add(stack);
    }

    /*******************************************************************************
     * Fuel Registry
     */
    public static Hashtable<ItemStack, Integer> FUEL_REGISTRY = new Hashtable<>();

    public static void addFuel(ItemStack stack, int value)
    {
        ForgeCraftRegistries.FUEL_REGISTRY.put(stack, value);
    }


    /*******************************************************************************
     * Torch Registry
     */
    public static List<ItemStack> TORCH_REGISTRY = new ArrayList<>();

    public static void addTorch(ItemStack stack)
    {
        ForgeCraftRegistries.TORCH_REGISTRY.add(stack);
    }

    public static boolean isTorch(ItemStack stack)
    {
        for (ItemStack list : ForgeCraftRegistries.TORCH_REGISTRY) {
            if (list.isItemEqual(stack))
                return true;
        }

        return false;
    }

    /*******************************************************************************
     *  Crafting Registries
     *
     *    EXAMPLE:
     *      ForgeCraftRegistries.addBladeRecipe(new ItemStack(ModItems.CORN_COB), new ItemStack(ModItems.CORN_SEEDS, 1));
     *      ForgeCraftRegistries.addBladeRecipe("bone", new ItemStack(ModItems.SHARP_BONE, 1));
     *
     */
    ///
    // crafting matrix items
    ///
    public static Hashtable<Item, SoundEvent> CRAFTING_MATRIX_ITEM_REGISTRY = new Hashtable<>();

    public static void addCraftingItem(Item item, @Nullable SoundEvent sound)
    {
        ForgeCraftRegistries.CRAFTING_MATRIX_ITEM_REGISTRY.put(item, sound);
    }

    ///
    // in-world knapping recipes
    ///
    public static final List<Triple<ItemStack, ItemStack, Float>> KNAPPING_RECIPE_REGISTRY = Lists.newArrayList();

    public static Hashtable<Item, ItemStack> CRAFTING_KNAPPING_OUTPUT_REGISTRY = new Hashtable<>();
    public static Hashtable<Item, Float> CRAFTING_KNAPPING_HARDNESS_REGISTRY = new Hashtable<>();

    public static void addKnappingRecipe(Item item, ItemStack output, float hardness)
    {
        ForgeCraftRegistries.CRAFTING_KNAPPING_OUTPUT_REGISTRY.put(item, output);
        ForgeCraftRegistries.CRAFTING_KNAPPING_HARDNESS_REGISTRY.put(item, hardness);
    }

    ///
    // Stone Basin Recipes
    ///
    public static Hashtable<Object, ItemStack> BASIC_KERN_CRAFTING_REGISTRY = new Hashtable<>();

    public static void addBasicKernRecipe(String in, ItemStack out)
    {
        ForgeCraftRegistries.BASIC_KERN_CRAFTING_REGISTRY.put(in, out);
    }

    public static void addBasicKernRecipe(ItemStack in, ItemStack out)
    {
        ForgeCraftRegistries.BASIC_KERN_CRAFTING_REGISTRY.put(in, out);
    }

    ///
    //  Axe Recipes
    ///
    public static final List<Triple<Object, ItemStack, String[]>> AXE_RECIPES = Lists.newArrayList();

    public static Hashtable<Object, ItemStack> AXE_CRAFTING_REGISTRY = new Hashtable<>();
    public static Hashtable<Object, ItemStack> AXE_SIDE_CRAFTING_REGISTRY = new Hashtable<>();
    public static Hashtable<Item, Integer> AXE_REGISTRY = new Hashtable<>();

    public static void addAxe(Item item, Integer level)
    {
        ForgeCraftRegistries.AXE_REGISTRY.put(item, level);
    }

    public static void addAxeRecipe(String in, ItemStack out)
    {
        ForgeCraftRegistries.AXE_CRAFTING_REGISTRY.put(in, out);
    }

    public static void addAxeRecipe(ItemStack in, ItemStack out)
    {
        ForgeCraftRegistries.AXE_CRAFTING_REGISTRY.put(in, out);
    }


    public static void addAxeSideRecipe(String in, ItemStack out)
    {
        ForgeCraftRegistries.AXE_SIDE_CRAFTING_REGISTRY.put(in, out);
    }

    public static void addAxeSideRecipe(ItemStack in, ItemStack out)
    {
        ForgeCraftRegistries.AXE_SIDE_CRAFTING_REGISTRY.put(in, out);
    }

    ///
    //  HandClipper Recipes
    ///
    public static Hashtable<Object, ItemStack> BASIC_CLIPPER_CRAFTING_REGISTRY = new Hashtable<>();
    public static Hashtable<Item, Integer> CLIPPER_REGISTRY = new Hashtable<>();

    public static void addClipper(Item item, Integer level)
    {
        ForgeCraftRegistries.CLIPPER_REGISTRY.put(item, level);
    }

    public static void addBasicClipperRecipe(String in, ItemStack out)
    {
        ForgeCraftRegistries.BASIC_CLIPPER_CRAFTING_REGISTRY.put(in, out);
    }

    public static void addBasicClipperRecipe(ItemStack in, ItemStack out)
    {
        ForgeCraftRegistries.BASIC_CLIPPER_CRAFTING_REGISTRY.put(in, out);
    }

    ///
    // WorkBlade Recipes
    ///
    public static Hashtable<Object, ItemStack> WORKBLADE_CRAFTING_REGISTRY = new Hashtable<>();
    public static Hashtable<Item, Integer> WORKBLADE_REGISTRY = new Hashtable<>();

    public static void addBlade(Item item, Integer level)
    {
        ForgeCraftRegistries.WORKBLADE_REGISTRY.put(item, level);
    }

    public static void addBladeRecipe(String in, ItemStack out)
    {
        ForgeCraftRegistries.WORKBLADE_CRAFTING_REGISTRY.put(in, out);
    }

    public static void addBladeRecipe(ItemStack in, ItemStack out)
    {
        ForgeCraftRegistries.WORKBLADE_CRAFTING_REGISTRY.put(in, out);
    }

    ///
    // Gallagher Recipes
    ///
    public static Hashtable<Object, ItemStack> GALLAGHER_CRAFTING_REGISTRY = new Hashtable<>();
    public static Hashtable<Item, Integer> GALLAGHER_REGISTRY = new Hashtable<>();

    public static void addGallagher(Item item, Integer level)
    {
        ForgeCraftRegistries.GALLAGHER_REGISTRY.put(item, level);
    }

    public static void addGallagherRecipe(String in, ItemStack out)
    {
        ForgeCraftRegistries.GALLAGHER_CRAFTING_REGISTRY.put(in, out);
    }

    public static void addGallagherRecipe(ItemStack in, ItemStack out)
    {
        ForgeCraftRegistries.GALLAGHER_CRAFTING_REGISTRY.put(in, out);
    }


    ///
    //  Drying Rack
    ///
    //public static final List<Triple<ItemStack, ItemStack, Integer>> DRYING_RACK_CRAFTING_REGISTRY = Lists.newArrayList();
    //public static HashMap<ItemStack, ItemStack> DRYING_RACK_CRAFTING_REGISTRY = new HashMap<>();
    public static HashMap<Item, Item> DRYING_RACK_CRAFTING_REGISTRY = new HashMap<>();

    public static void addDryingRackRecipe(Item in, Item out)
    {
        ForgeCraftRegistries.DRYING_RACK_CRAFTING_REGISTRY.put(in, out);
    }

    /*******************************************************************************
     * Tool & Armor Registries
     */
    ///
    // Tool Repair Materials
    ///
    public static Hashtable<ItemStack, Item.ToolMaterial> TOOL_REPAIR_MATERIALS = new Hashtable<>();

    public static void addToolRepairItem(Item.ToolMaterial toolMaterial, ItemStack repairStack)
    {
        ForgeCraftRegistries.TOOL_REPAIR_MATERIALS.put(repairStack, toolMaterial);
    }

    ///
    // Tool Break by-Products
    ///
    public static Hashtable<Item, ItemStack[]> TOOL_BREAK_ITEMS = new Hashtable<>();

    public static void addToolBreakItem(Item tool, ItemStack[] stacks)
    {
        ForgeCraftRegistries.TOOL_BREAK_ITEMS.put(tool, stacks);
    }

    /*******************************************************************************
     * Entity Registries
     */
    ///
    // Entity Drops
    ///
    //public static Hashtable<EntityLivingBase, ItemStack[]> ENTITY_CUSTOM_DROP_REGISTRY = new Hashtable<>();
    //public static void addEntityDrop(EntityLivingBase entity, ItemStack[] stacks)
    //{
    //    ForgeCraftRegistries.ENTITY_CUSTOM_DROP_REGISTRY.put(entity, stacks);
    //}

    /*******************************************************************************
     * ..
     */
}