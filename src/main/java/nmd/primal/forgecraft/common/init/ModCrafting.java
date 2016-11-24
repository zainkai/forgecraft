package nmd.primal.forgecraft.common.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
//import nmd.primal.core.api.ForgeCraftBlocks;
//import nmd.primal.core.api.ForgeCraftItems;
//import nmd.primal.core.api.ForgeCraftRegistries;
//import nmd.primal.core.common.crafting.*;

import java.util.Map;

public class ModCrafting
{
    /*******************************************************************************
     * Register Recipes and Related Handlers
     */
    public static void registerRecipes()
    {
        ///
        //  Start by removing vanilla recipes
        ///
        //ModCrafting.registerRecipeRemover();

        ///
        //
        ///
        /*ClipperRecipe.registerHandlerRecipe();
        ClipperRecipe.registerStaticRecipes();

        WorkBladeRecipe.registerHandlerRecipe();
        WorkBladeRecipe.registerStaticRecipes();

        WorkMalletRecipe.registerHandlerRecipe();
        WorkMalletRecipe.registerStaticRecipes();

        ModCrafting.registerAxeRecipes();
        ModCrafting.registerSawRecipes();

        ModCrafting.registerStaticRecipes();
        ModCrafting.registerToolArmorCrafting();

        // new-style recipe handlers
        ModCrafting.addDryingRackRecipes();
        ModCrafting.addKnappingRecipes();*/
    }



    /*******************************************************************************
     *  Knapping Recipes
     */
    /*private static void addKnappingRecipes()
    {
        KnapRecipe.addRecipe(new ItemStack(Items.FLINT), new ItemStack(ForgeCraftItems.FLINT_KNAPP, 1), 1.5F, (float)ModConfig.CRAFTING_KNAPPING_DIFFICULTY_FLINT);
        KnapRecipe.addRecipe(new ItemStack(Items.QUARTZ), new ItemStack(ForgeCraftItems.QUARTZ_KNAPP, 1), 2.0F, (float)ModConfig.CRAFTING_KNAPPING_DIFFICULTY_QUARTZ);
        KnapRecipe.addRecipe(new ItemStack(ForgeCraftItems.OBSIDIAN_SHARD), new ItemStack(ForgeCraftItems.OBSIDIAN_KNAPP, 1), 2.0F, (float)ModConfig.CRAFTING_KNAPPING_DIFFICULTY_OBSIDIAN);
    }

    ///
    // Stone Basin Recipes
    ///
    public static void addBasicKernRecipes(Item tool)
    {
        ItemStack STONE_BASIN = new ItemStack(tool, 1, net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE);

        ///
        //  recipes
        ///
        ForgeCraftRegistries.addBasicKernRecipe(new ItemStack(Items.WHEAT), new ItemStack(ForgeCraftItems.WHEAT_GROUND));
        ForgeCraftRegistries.addBasicKernRecipe(new ItemStack(ForgeCraftItems.CORN_SEEDS, 2), new ItemStack(ForgeCraftItems.CORN_GROUND));
        ForgeCraftRegistries.addBasicKernRecipe("bone", new ItemStack(Items.DYE, 3, 15));

        ///
        //  register
        ///
        for (Map.Entry<Object, ItemStack> entry : ForgeCraftRegistries.BASIC_KERN_CRAFTING_REGISTRY.entrySet())
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(entry.getValue(), true, new Object[]{"S", "I", "C",
                    ('S'), "rock",
                    ('I'), entry.getKey(),
                    ('C'), STONE_BASIN
            }));
        }
    }

    ///
    //  Axe Recipes
    ///
    public static void registerAxeRecipes()
    {
        ///
        //  vanilla axes
        ///
        //ForgeCraftRegistries.addCraftingItem(Items.GOLDEN_AXE, SoundEvents.ITEM_HOE_TILL);
        //ForgeCraftRegistries.addCraftingItem(Items.STONE_AXE, SoundEvents.ITEM_HOE_TILL);
        //ForgeCraftRegistries.addCraftingItem(Items.IRON_AXE, SoundEvents.ITEM_HOE_TILL);
        //ForgeCraftRegistries.addCraftingItem(Items.DIAMOND_AXE, SoundEvents.ITEM_HOE_TILL);

        //ForgeCraftRegistries.addAxe(Items.GOLDEN_AXE, Item.ToolMaterial.GOLD.getHarvestLevel());
        //ForgeCraftRegistries.addAxe(Items.STONE_AXE, Item.ToolMaterial.STONE.getHarvestLevel());
        //ForgeCraftRegistries.addAxe(Items.IRON_AXE, Item.ToolMaterial.IRON.getHarvestLevel());
        //ForgeCraftRegistries.addAxe(Items.DIAMOND_AXE, Item.ToolMaterial.DIAMOND.getHarvestLevel());

        ///
        //  recipes
        ///
        ForgeCraftRegistries.addAxeRecipe("logWood", new ItemStack(Items.STICK, 8));
        ForgeCraftRegistries.addAxeRecipe("plankWood", new ItemStack(Items.STICK, 4));
        ForgeCraftRegistries.addAxeRecipe("slabWood", new ItemStack(Items.STICK, 2));
        ForgeCraftRegistries.addAxeRecipe(new ItemStack(ForgeCraftBlocks.NETHERPALM_LOG), new ItemStack(ForgeCraftItems.NETHERPALM_STICK, 8));
        ForgeCraftRegistries.addAxeRecipe(new ItemStack(ForgeCraftBlocks.NETHERPALM_PLANK), new ItemStack(ForgeCraftItems.NETHERPALM_STICK, 4));
        ForgeCraftRegistries.addAxeRecipe(new ItemStack(ForgeCraftBlocks.SLAB_NETHERPALM), new ItemStack(ForgeCraftItems.NETHERPALM_STICK, 2));
        ForgeCraftRegistries.addAxeRecipe(new ItemStack(ForgeCraftBlocks.MUD_BLOCK_DRY), new ItemStack(ForgeCraftBlocks.SLAB_MUD, 2));

        ForgeCraftRegistries.addAxeSideRecipe(new ItemStack(Blocks.LOG, 1, 0), new ItemStack(ForgeCraftBlocks.WORKTABLE_OAK_LOG));
        ForgeCraftRegistries.addAxeSideRecipe(new ItemStack(Blocks.LOG, 1, 1), new ItemStack(ForgeCraftBlocks.WORKTABLE_SPRUCE_LOG));
        ForgeCraftRegistries.addAxeSideRecipe(new ItemStack(Blocks.LOG, 1, 2), new ItemStack(ForgeCraftBlocks.WORKTABLE_BIRCH_LOG));
        ForgeCraftRegistries.addAxeSideRecipe(new ItemStack(Blocks.LOG, 1, 3), new ItemStack(ForgeCraftBlocks.WORKTABLE_JUNGLE_LOG));
        ForgeCraftRegistries.addAxeSideRecipe(new ItemStack(Blocks.LOG2, 1, 0), new ItemStack(ForgeCraftBlocks.WORKTABLE_ACACIA_LOG));
        ForgeCraftRegistries.addAxeSideRecipe(new ItemStack(Blocks.LOG2, 1, 1), new ItemStack(ForgeCraftBlocks.WORKTABLE_BIGOAK_LOG));


        ///
        //  ..
        ///
        for (Map.Entry<Item, Integer> tool : ForgeCraftRegistries.AXE_REGISTRY.entrySet())
        {
            ///
            //  tool
            ///
            ItemStack TOOL = new ItemStack(tool.getKey(), 1, net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE);

            ///
            //  register
            ///
            for (Map.Entry<Object, ItemStack> entry : ForgeCraftRegistries.AXE_CRAFTING_REGISTRY.entrySet())
            {
                GameRegistry.addRecipe(new ShapedOreRecipe(entry.getValue(), true, new Object[]{"C", "I",
                        ('I'), entry.getKey(),
                        ('C'), TOOL
                }));
            }

            for (Map.Entry<Object, ItemStack> entry : ForgeCraftRegistries.AXE_SIDE_CRAFTING_REGISTRY.entrySet())
            {
                GameRegistry.addRecipe(new ShapedOreRecipe(entry.getValue(), true, new Object[]{"IC",
                        ('I'), entry.getKey(),
                        ('C'), TOOL
                }));
            }
        }
    }

    ///
    //  Hand Saws
    ///
    public static void registerSawRecipes()
    {
        ///
        //  recipes
        ///
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.LOG, 1, 0), new ItemStack(Blocks.PLANKS, 4, 0));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.LOG, 1, 1), new ItemStack(Blocks.PLANKS, 4, 1));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.LOG, 1, 2), new ItemStack(Blocks.PLANKS, 4, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.LOG, 1, 3), new ItemStack(Blocks.PLANKS, 4, 3));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.LOG2, 1, 0), new ItemStack(Blocks.PLANKS, 4, 4));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.LOG2, 1, 1), new ItemStack(Blocks.PLANKS, 4, 5));

        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.MUD_BLOCK_DRY, 1), new ItemStack(ForgeCraftBlocks.SLAB_MUD, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.NETHERPALM_LOG, 1), new ItemStack(ForgeCraftBlocks.NETHERPALM_PLANK, 2));

        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.PLANKS, 1, 0), new ItemStack(Blocks.WOODEN_SLAB, 2, 0));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.PLANKS, 1, 1), new ItemStack(Blocks.WOODEN_SLAB, 2, 1));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.PLANKS, 1, 2), new ItemStack(Blocks.WOODEN_SLAB, 2, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.PLANKS, 1, 3), new ItemStack(Blocks.WOODEN_SLAB, 2, 3));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.PLANKS, 1, 4), new ItemStack(Blocks.WOODEN_SLAB, 2, 4));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.PLANKS, 1, 5), new ItemStack(Blocks.WOODEN_SLAB, 2, 5));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.IRONWOOD_PLANK, 1), new ItemStack(ForgeCraftBlocks.SLAB_IRONWOOD, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.NETHERPALM_PLANK, 1), new ItemStack(ForgeCraftBlocks.SLAB_NETHERPALM, 2));

        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.WOODEN_SLAB, 1, 4), new ItemStack(ForgeCraftBlocks.THIN_SLAB_ACACIA, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.WOODEN_SLAB, 1, 5), new ItemStack(ForgeCraftBlocks.THIN_SLAB_BIGOAK, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.WOODEN_SLAB, 1, 2), new ItemStack(ForgeCraftBlocks.THIN_SLAB_BIRCH, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.WOODEN_SLAB, 1, 3), new ItemStack(ForgeCraftBlocks.THIN_SLAB_JUNGLE, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.WOODEN_SLAB, 1, 0), new ItemStack(ForgeCraftBlocks.THIN_SLAB_OAK, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.WOODEN_SLAB, 1, 1), new ItemStack(ForgeCraftBlocks.THIN_SLAB_SPRUCE, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.SLAB_IRONWOOD), new ItemStack(ForgeCraftBlocks.THIN_SLAB_IRONWOOD, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.SLAB_NETHERPALM), new ItemStack(ForgeCraftBlocks.THIN_SLAB_NETHERPALM, 2));

        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.THIN_SLAB_ACACIA), new ItemStack(ForgeCraftBlocks.SLAT_ACACIA, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.THIN_SLAB_BIGOAK), new ItemStack(ForgeCraftBlocks.SLAT_BIGOAK, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.THIN_SLAB_BIRCH), new ItemStack(ForgeCraftBlocks.SLAT_BIRCH, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.THIN_SLAB_JUNGLE), new ItemStack(ForgeCraftBlocks.SLAT_JUNGLE, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.THIN_SLAB_OAK), new ItemStack(ForgeCraftBlocks.SLAT_OAK, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.THIN_SLAB_SPRUCE), new ItemStack(ForgeCraftBlocks.SLAT_SPRUCE, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.THIN_SLAB_IRONWOOD), new ItemStack(ForgeCraftBlocks.SLAT_IRONWOOD, 2));
        ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(ForgeCraftBlocks.THIN_SLAB_NETHERPALM), new ItemStack(ForgeCraftBlocks.SLAT_NETHERPALM, 2));

        ///
        //  ..
        ///
        for (Map.Entry<Item, Integer> tool : ForgeCraftRegistries.SAW_REGISTRY.entrySet())
        {
            ///
            //  tool
            ///
            ItemStack TOOL = new ItemStack(tool.getKey(), 1, net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE);

            ///
            //  register
            ///
            for (Map.Entry<Object, ItemStack> entry : ForgeCraftRegistries.SAW_CRAFTING_REGISTRY.entrySet())
            {
                GameRegistry.addRecipe(new ShapedOreRecipe(entry.getValue(), true, new Object[]{"C", "I",
                        ('I'), entry.getKey(),
                        ('C'), TOOL
                }));
            }
        }
    }

    ///
    //  Hand Clipper
    ///
    public static void addBasicClipperRecipes(Item tool)
    {
        ///
        //  recipes
        ///
        ForgeCraftRegistries.addBasicClipperRecipe(new ItemStack(ForgeCraftItems.IRON_SHEET, 1, 0), new ItemStack(ForgeCraftItems.IRON_STRANDS, 4, 0));
    }

    ///
    // WorkBlade Recipes
    ///
    public static void addCommonBladeRecipes(Item tool)
    {
        ///
        // basic
        ///
        //ForgeCraftRegistries.addBladeRecipe(new ItemStack(Items.ARROW), new ItemStack(ForgeCraftItems.FLINT_KNAPP, 1));
        ForgeCraftRegistries.addBladeRecipe("stickWood", new ItemStack(ForgeCraftItems.WOOD_PINS, 1));
        ForgeCraftRegistries.addBladeRecipe(new ItemStack(ForgeCraftItems.NETHERPALM_STICK), new ItemStack(ForgeCraftItems.NETHERPALM_PINS, 1));
        ForgeCraftRegistries.addBladeRecipe(new ItemStack(Blocks.LADDER), new ItemStack(Items.STICK, 4));
        ForgeCraftRegistries.addBladeRecipe(new ItemStack(Blocks.CHEST), new ItemStack(Blocks.PLANKS, 5));
        ForgeCraftRegistries.addBladeRecipe(new ItemStack(Blocks.TRAPDOOR), new ItemStack(Blocks.PLANKS, 4));
        ForgeCraftRegistries.addBladeRecipe(new ItemStack(Items.BOAT), new ItemStack(Blocks.PLANKS, 2));
        ForgeCraftRegistries.addBladeRecipe(new ItemStack(Items.LEATHER), new ItemStack(ForgeCraftItems.LEATHER_STRIP, 9));
        ForgeCraftRegistries.addBladeRecipe(new ItemStack(Items.WHEAT), new ItemStack(Items.WHEAT_SEEDS, 1));
        ForgeCraftRegistries.addBladeRecipe(new ItemStack(ForgeCraftItems.CORN_COB), new ItemStack(ForgeCraftItems.CORN_SEEDS, 1));
        ForgeCraftRegistries.addBladeRecipe(new ItemStack(ForgeCraftItems.RUSH_TIPS_BLOOM), new ItemStack(ForgeCraftItems.RUSH_SEEDS, 1));
        ForgeCraftRegistries.addBladeRecipe(new ItemStack(ForgeCraftItems.RUSH_TIPS), new ItemStack(ForgeCraftItems.PLANT_FIBER, 2));
        ForgeCraftRegistries.addBladeRecipe(new ItemStack(ForgeCraftItems.RUSH_STEMS), new ItemStack(ForgeCraftItems.PLANT_FIBER, 4));
        ForgeCraftRegistries.addBladeRecipe(new ItemStack(ForgeCraftBlocks.MUD_BLOCK_DRY), new ItemStack(ForgeCraftBlocks.SLAB_MUD, 2));
        ForgeCraftRegistries.addBladeRecipe("bone", new ItemStack(ForgeCraftItems.SHARP_BONE, 1));

       //if (!ModConfig.CRAFTING_BARK_REMOVAL_ENABLE) {
            ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.LOG, 1, 0), new ItemStack(ForgeCraftItems.BARK_OAK, 4));
            ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.LOG, 1, 1), new ItemStack(ForgeCraftItems.BARK_SPRUCE, 4));
            ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.LOG, 1, 2), new ItemStack(ForgeCraftItems.BARK_BIRCH, 4));
            ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.LOG, 1, 3), new ItemStack(ForgeCraftItems.BARK_JUNGLE, 4));
            ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.LOG2, 1, 0), new ItemStack(ForgeCraftItems.BARK_ACACIA, 4));
            ForgeCraftRegistries.addBasicSawRecipe(new ItemStack(Blocks.LOG2, 1, 1), new ItemStack(ForgeCraftItems.BARK_BIGOAK, 4));
        //}

        if (ModConfig.CRAFTING_REPLACE_CHISELED_RECIPE) {
            ItemStack removeItems[] = { new ItemStack(Blocks.STONEBRICK, 1, 3), new ItemStack(Blocks.SANDSTONE, 1, 1), new ItemStack(Blocks.RED_SANDSTONE, 1, 1), new ItemStack(Blocks.QUARTZ_BLOCK, 1, 1) };
            RecipeRemover.removeRecipeByStack(removeItems);

            ForgeCraftRegistries.addBladeRecipe(new ItemStack(Blocks.STONEBRICK), new ItemStack(Blocks.STONEBRICK, 1, 3));
            ForgeCraftRegistries.addBladeRecipe(new ItemStack(Blocks.SANDSTONE), new ItemStack(Blocks.SANDSTONE, 1, 1));
            ForgeCraftRegistries.addBladeRecipe(new ItemStack(Blocks.RED_SANDSTONE), new ItemStack(Blocks.RED_SANDSTONE, 1, 1));
            ForgeCraftRegistries.addBladeRecipe(new ItemStack(Blocks.QUARTZ_BLOCK), new ItemStack(Blocks.QUARTZ_BLOCK, 1, 1));
            ForgeCraftRegistries.addBladeRecipe(new ItemStack(ForgeCraftBlocks.SOULSTONE_SMOOTH), new ItemStack(ForgeCraftBlocks.SOULSTONE_CHISELED));

        } else {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.SOULSTONE_CHISELED, 1), true, new Object[]{"S", "S",
                    ('S'), ForgeCraftBlocks.SLAB_SOULSTONE
            }));
        }

        ///
        // doors
        ///
        //ForgeCraftRegistries.addBladeRecipe(new ItemStack(Blocks.OAK_DOOR), new ItemStack(Blocks.PLANKS, 4, 0));
        //ForgeCraftRegistries.addBladeRecipe(new ItemStack(Blocks.SPRUCE_DOOR), new ItemStack(Blocks.PLANKS, 4, 1));
        //ForgeCraftRegistries.addBladeRecipe(new ItemStack(Blocks.BIRCH_DOOR), new ItemStack(Blocks.PLANKS, 4, 2));
        //ForgeCraftRegistries.addBladeRecipe(new ItemStack(Blocks.JUNGLE_DOOR), new ItemStack(Blocks.PLANKS, 4, 3));
        //ForgeCraftRegistries.addBladeRecipe(new ItemStack(Blocks.ACACIA_DOOR), new ItemStack(Blocks.PLANKS, 4, 4));
        //ForgeCraftRegistries.addBladeRecipe(new ItemStack(Blocks.DARK_OAK_DOOR), new ItemStack(Blocks.PLANKS, 4, 5));
    }

    ///
    // Gallagher Recipes
    ///
    public static void addGallagherRecipes(Item tool)
    {
        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(Blocks.STONE), new ItemStack(ForgeCraftItems.ROCK, 9));
        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(Blocks.COBBLESTONE), new ItemStack(ForgeCraftItems.ROCK, 5));
        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(Blocks.MOSSY_COBBLESTONE), new ItemStack(ForgeCraftItems.ROCK, 5));
        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(Blocks.STONE_SLAB), new ItemStack(ForgeCraftItems.ROCK, 2));
        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(Blocks.STONE_SLAB, 1, 1), new ItemStack(ForgeCraftItems.ROCK, 2));
        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(Blocks.COBBLESTONE_WALL), new ItemStack(Blocks.COBBLESTONE, 1));
        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(Blocks.COBBLESTONE_WALL, 1, 1), new ItemStack(Blocks.COBBLESTONE, 1));
        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(Blocks.IRON_BARS, 1, 1), new ItemStack(ForgeCraftBlocks.SLAT_IRON, 1));

        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(ForgeCraftBlocks.WALL_CARBONATE_BRICK), new ItemStack(ForgeCraftBlocks.CARBONATE_BRICK, 1));
        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(ForgeCraftBlocks.WALL_CARBONATE_FLAG, 1, 1), new ItemStack(ForgeCraftBlocks.CARBONATE_FLAG, 1));

        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(ForgeCraftBlocks.WALL_FERRO_BRICK), new ItemStack(ForgeCraftBlocks.FERRO_BRICK, 1));
        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(ForgeCraftBlocks.WALL_FERRO_FLAG, 1, 1), new ItemStack(ForgeCraftBlocks.FERRO_FLAG, 1));

        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(ForgeCraftBlocks.WALL_NETHERSTONE), new ItemStack(ForgeCraftBlocks.NETHERSTONE, 1));
        ForgeCraftRegistries.addGallagherRecipe(new ItemStack(ForgeCraftBlocks.WALL_NETHERRACK, 1, 1), new ItemStack(Blocks.NETHERRACK, 1));


        //ForgeCraftRegistries.addGallagherRecipe("nuggetIron", new ItemStack(ForgeCraftItems.IRON_STRANDS));
        //ForgeCraftRegistries.addGallagherRecipe("nuggetPigiron", new ItemStack(ForgeCraftItems.IRON_STRANDS));
        ForgeCraftRegistries.addGallagherRecipe("ingotIron", new ItemStack(ForgeCraftItems.IRON_SHEET, 2));
        ForgeCraftRegistries.addGallagherRecipe("plateIron", new ItemStack(ForgeCraftItems.IRON_RING, 8));
        ForgeCraftRegistries.addGallagherRecipe("sheetIron", new ItemStack(ForgeCraftItems.IRON_RING, 4));
        //ForgeCraftRegistries.addGallagherRecipe("ingotPigiron", new ItemStack(ForgeCraftItems.IRON_RING, 9));
        ForgeCraftRegistries.addGallagherRecipe("strandIron", new ItemStack(ForgeCraftItems.IRON_PINS, 1));

        ///
        // double stack items
        ///
        //CraftingHelper.addLargeToolRecipe(tool, new ItemStack(ForgeCraftItems.IRON_STRANDS), new ItemStack(ForgeCraftItems.IRON_MESH, 2));
    }

    private static void addDryingRackRecipes()
    {
        DryingRecipe.addRecipe(new ItemStack(Items.FISH, 1, 0), new ItemStack(ForgeCraftItems.FISH_COD_DRIED), new ItemStack(ForgeCraftItems.FISH_COD_ROTTEN), 2600, 10);
        DryingRecipe.addRecipe(new ItemStack(ForgeCraftItems.FISH_COD_SALTED), new ItemStack(ForgeCraftItems.FISH_COD_CURED), new ItemStack(ForgeCraftItems.FISH_COD_ROTTEN), 1600, 25);

        DryingRecipe.addRecipe(new ItemStack(Items.FISH, 1, 1), new ItemStack(ForgeCraftItems.FISH_SALMON_DRIED), new ItemStack(ForgeCraftItems.FISH_COD_ROTTEN), 2600, 10);
        DryingRecipe.addRecipe(new ItemStack(ForgeCraftItems.FISH_SALMON_SALTED), new ItemStack(ForgeCraftItems.FISH_SALMON_CURED), new ItemStack(ForgeCraftItems.FISH_COD_ROTTEN), 1600, 25);

        DryingRecipe.addRecipe(new ItemStack(Items.FISH, 1, 2), new ItemStack(ForgeCraftItems.FISH_CLOWN_DRIED), new ItemStack(ForgeCraftItems.FISH_COD_ROTTEN), 2600, 10);
        DryingRecipe.addRecipe(new ItemStack(ForgeCraftItems.FISH_CLOWN_SALTED), new ItemStack(ForgeCraftItems.FISH_CLOWN_CURED), new ItemStack(ForgeCraftItems.FISH_COD_ROTTEN), 1600, 25);

        DryingRecipe.addRecipe(new ItemStack(Items.FISH, 1, 3), new ItemStack(ForgeCraftItems.FISH_PUFFER_DRIED), new ItemStack(ForgeCraftItems.FISH_COD_ROTTEN), 2600, 10);
        DryingRecipe.addRecipe(new ItemStack(ForgeCraftItems.FISH_PUFFER_SALTED), new ItemStack(ForgeCraftItems.FISH_PUFFER_CURED), new ItemStack(ForgeCraftItems.FISH_COD_ROTTEN), 1600, 25);

        DryingRecipe.addRecipe(new ItemStack(ForgeCraftItems.FISH_LAVAWORM_RAW, 1), new ItemStack(ForgeCraftItems.FISH_LAVAWORM_DRIED), new ItemStack(ForgeCraftItems.FISH_LAVAWORM_ROTTEN), 2600, 6);
        DryingRecipe.addRecipe(new ItemStack(ForgeCraftItems.FISH_LAVAWORM_SALTED), new ItemStack(ForgeCraftItems.FISH_LAVAWORM_CURED), new ItemStack(ForgeCraftItems.FISH_LAVAWORM_ROTTEN), 1600, 3);

    }
/*

    /*******************************************************************************
     * Static Recipes
     */
    public static void registerToolArmorCrafting()
    {
        /*if (ModConfig.CRAFTING_PRIMAL_TOOLS)
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.STONE_BASIN), true, new Object[]{"I I", " I ", ('I'), Blocks.STONE}));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.FIRE_BOW), "  S", " SC", "S C",
                    ('S'), "stickWood",
                    ('C'), "cordageGeneral"));

            //GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ForgeCraftItems.SHARP_BONE, 1), "bone", new ItemStack(Items.FLINT, 1)));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ForgeCraftItems.SHARP_BONE, 1), Items.BONE, "knappedFlint"));

            ///
            //  Arrows
            ///
            if (ModConfig.CRAFTING_REPLACE_ARROW_RECIPE) {
                ItemStack removeItems[] = { new ItemStack(Items.ARROW) };
                RecipeRemover.removeRecipeByStack(removeItems);

                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.ARROW, 4), "T", "S", "F",
                        ('T'), "knappedFlint",
                        ('S'), "stickWood",
                        ('F'), "feather"));
            }

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.ARROW_QUARTZ, 4), "T", "S", "F",
                    ('T'), "knappedQuartz",
                    ('S'), ForgeCraftItems.NETHERPALM_STICK,
                    ('F'), ForgeCraftItems.NETHER_CORDAGE));


            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.ARROW_TORCH_WOOD, 1), "T", "F",
                    ('T'), ForgeCraftItems.TORCH_WOOD_LIT,
                    ('F'), "feather"));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.ARROW_TORCH_WOOD, 1), "T", "F",
                    ('T'), Blocks.TORCH,
                    ('F'), "feather"));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.ARROW_TORCH_NETHER, 1), "T", "F",
                    ('T'), ForgeCraftItems.TORCH_NETHER_LIT,
                    ('F'), ForgeCraftItems.NETHER_CORDAGE));

            ///
            //  Hand Saw
            ///
            GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.IRON_SAW, "I  ", " IP", " SS",
                    ('I'), "sheetIron",
                    ('S'), "stickWood",
                    ('P'), "pinBasic"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.QUARTZ_SAW, "I  ", " IP", " SS",
                    ('I'), "knappedQuartz",
                    ('S'), ForgeCraftItems.NETHERPALM_STICK,
                    ('P'), "pinBasic"));

            ///
            //  Hand Clippers
            ///
            GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.IRON_CLIPPERS, " I ", "IPS", " S ",
                    ('I'), "sheetIron",
                    ('S'), "stickWood",
                    ('P'), "pinBasic"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.QUARTZ_CLIPPERS, " I ", "IPS", " S ",
                    ('I'), "knappedQuartz",
                    ('S'), ForgeCraftItems.NETHERPALM_STICK,
                    ('P'), "pinBasic"));


            ///
            //  Work Blades
            ///
            GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.FLINT_WORKBLADE, " FB", "FCF", "SF ",
                    ('B'), Items.FLINT,
                    ('F'), "knappedFlint",
                    ('S'), "stickWood",
                    ('C'), "cordageGeneral"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.QUARTZ_WORKBLADE, " FB", "FCF", "SF ",
                    ('B'), Items.QUARTZ,
                    ('F'), "knappedQuartz",
                    ('S'), ForgeCraftItems.NETHERPALM_STICK,
                    ('C'), "cordageNether"));

            ///
            //  Mallets
            ///
            GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.STONE_GALLAGHER, "ICI", "ISI", " S ",
                    ('I'), Blocks.STONE,
                    ('S'), "stickWood",
                    ('C'), "cordageGeneral"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.NETHER_GALLAGHER, "ICI", "ISI", " S ",
                    ('I'), ForgeCraftBlocks.NETHERSTONE,
                    ('S'), ForgeCraftItems.NETHERPALM_STICK,
                    ('C'), "cordageNether"));


            GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.QUARTZ_GALLAGHER, "ICI", "ISI", " S ",
                    ('I'), Blocks.QUARTZ_BLOCK,
                    ('S'), ForgeCraftItems.NETHERPALM_STICK,
                    ('C'), "cordageNether"));

            ///
            //  Flint Tools
            ///
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.FLINT_HATCHET), "KC", " S",
                    ('K'), "knappedFlint",
                    ('S'), "stickWood",
                    ('C'), "cordageGeneral"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.FLINT_PICKAXE), "KCK", "KSK", " S ",
                    ('K'), "knappedFlint",
                    ('S'), "stickWood",
                    ('C'), "cordageGeneral"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.FLINT_AXE), "KCK", "KS ", " S ",
                    //('F'), Items.FLINT,
                    ('K'), "knappedFlint",
                    ('S'), "stickWood",
                    ('C'), "cordageGeneral"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.FLINT_SHOVEL), " F ", " C ", " S ",
                    ('F'), Items.FLINT,
                    ('S'), "stickWood",
                    ('C'), "cordageGeneral"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.FLINT_HOE), "KKC", " S ", "S  ",
                    ('K'), "knappedFlint",
                    ('S'), "stickWood",
                    ('C'), "cordageGeneral"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.FLINT_SHEARS), " F", "FC",
                    ('F'), "knappedFlint",
                    ('C'), "cordageGeneral"));

            ///
            //  Quartz Tools
            ///
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.QUARTZ_HATCHET), "KC", " S",
                    ('K'), "knappedQuartz",
                    ('S'), ForgeCraftItems.NETHERPALM_STICK,
                    ('C'), "cordageNether"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.QUARTZ_PICKAXE), "KCK", "KSK", " S ",
                    ('K'), "knappedQuartz",
                    ('S'), ForgeCraftItems.NETHERPALM_STICK,
                    ('C'), "cordageNether"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.QUARTZ_AXE), "KCK", "KS ", " S ",
                    ('K'), "knappedQuartz",
                    ('S'), ForgeCraftItems.NETHERPALM_STICK,
                    ('C'), "cordageNether"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.QUARTZ_SHOVEL), " F ", " C ", " S ",
                    ('F'), Items.QUARTZ,
                    ('S'), ForgeCraftItems.NETHERPALM_STICK,
                    ('C'), "cordageNether"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.QUARTZ_HOE), "KKC", " S ", "S  ",
                    ('K'), "knappedQuartz",
                    ('S'), ForgeCraftItems.NETHERPALM_STICK,
                    ('C'), "cordageNether"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.QUARTZ_SHEARS), " F", "FC",
                    ('F'), "knappedQuartz",
                    ('C'), "cordageNether"));

        }*/
    }


    public static void registerStaticRecipes()
    {
        /*
        ///
        // Cordage
        ///
        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.PLANT_CORDAGE, true, new Object[]{" I", "II", ('I'), ForgeCraftItems.PLANT_FIBER}));
        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.NETHER_CORDAGE, true, new Object[]{" I", "II", ('I'), ForgeCraftItems.NETHER_FIBER}));
        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.LEATHER_CORDAGE, true, new Object[]{" I", "II", ('I'), ForgeCraftItems.LEATHER_STRIP}));
        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.SILK_CORDAGE, true, new Object[]{" I", "II", ('I'), Items.STRING}));
        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.SILK_CORDAGE_COILED, true, new Object[]{" I", "II", ('I'), ForgeCraftItems.SILK_CORDAGE}));

        ///
        //  Oak Slats
        //      pre-iron recipe
        ///
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.SLAT_OAK, 1), true, new Object[]{"SSS", "SSS",
                ('S'), "stickWood"
        }));


        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.LANTERN_EMPTY, 1), true, new Object[]{"SIS", "W P", "SIS",
                ('I'), ForgeCraftItems.IRON_SHEET,
                ('P'), ForgeCraftItems.IRON_PINS,
                ('S'), ForgeCraftItems.IRON_STRANDS,
                ('W'), "stickWood"
        }));

        //GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.LANTERN_TORCH, 1), true, new Object[]{"L", "T",
        //        ('L'), ForgeCraftBlocks.LANTERN_EMPTY,
        //        ('T'), Blocks.TORCH
        //}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.LANTERN_TORCH, 1), true, new Object[]{"L", "T",
                ('L'), ForgeCraftBlocks.LANTERN_EMPTY,
                ('T'), ForgeCraftBlocks.TORCH_WOOD
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.LANTERN_NETHER, 1), true, new Object[]{"L", "T",
                ('L'), ForgeCraftBlocks.LANTERN_EMPTY,
                ('T'), ForgeCraftBlocks.TORCH_NETHER
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.LANTERN_REDSTONE, 1), true, new Object[]{"L", "T",
                ('L'), ForgeCraftBlocks.LANTERN_EMPTY,
                ('T'), Blocks.REDSTONE_TORCH
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.LANTERN_IGNIS, 1), true, new Object[]{"L", "T",
                ('L'), ForgeCraftBlocks.LANTERN_EMPTY,
                ('T'), ForgeCraftBlocks.IGNIS_FATUUS
        }));

        ///
        // ..
        ///
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftItems.PLANT_FIBER), new ItemStack(ForgeCraftItems.PLANT_TINDER, 1));
        CraftingHelper.add3x3Crafting(new ItemStack(ForgeCraftItems.PLANT_CORDAGE), new ItemStack(ForgeCraftItems.PLANT_CLOTH, 2));
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftItems.NETHER_FIBER), new ItemStack(ForgeCraftItems.NETHER_TINDER, 1));
        CraftingHelper.add3x3Crafting(new ItemStack(ForgeCraftItems.NETHER_CORDAGE), new ItemStack(ForgeCraftItems.NETHER_CLOTH, 2));

        ///
        // Cobble Stone
        ///
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.MORTAR, 16), true, new Object[]{"SCS", "CSC", "SCS",
                ('C'), "clayball",
                ('S'), Blocks.SAND
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.MORTAR, 16), true, new Object[]{"SCS", "CSC", "SCS",
                ('C'), "slimeball",
                ('S'), Blocks.SAND
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.COBBLESTONE, 1), true, new Object[]{"SCS", "CSC", "SCS",
                ('C'), ForgeCraftItems.MORTAR,
                ('S'), ForgeCraftItems.ROCK
        }));


        /// LOAM

        //GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.LOAM_BLOCK, 8), true, new Object[]{"DSD", "SCS", "DSD",
        //        ('C'), "clayball",
        //        ('S'), Blocks.SAND,
        //        ('D'), Blocks.DIRT
        //}));

        ///
        //  Mossy
        ///


        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.STAIRS_COBBLESTONE_MOSSY, 4), true, new Object[]{"S  ", "SS ", "SSS",
                ('S'), new ItemStack(Blocks.MOSSY_COBBLESTONE, 1, 1)
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.STAIRS_STONEBRICK_MOSSY, 4), true, new Object[]{"S  ", "SS ", "SSS",
                ('S'), new ItemStack(Blocks.STONEBRICK, 1, 1)
        }));

        ///
        //  Nether
        ///
        CraftingHelper.add2x2Crafting(new ItemStack(Blocks.NETHERRACK), new ItemStack(ForgeCraftBlocks.NETHERSTONE, 1));
        //CraftingHelper.add2x2Crafting(new ItemStack(Blocks.SOUL_SAND), new ItemStack(ForgeCraftBlocks.SOULSTONE, 1));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.WALL_NETHERRACK, 6), true, new Object[]{"SSS", "SSS",
                ('S'), Blocks.NETHERRACK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.WALL_NETHERSTONE, 6), true, new Object[]{"SSS", "SSS",
                ('S'), ForgeCraftBlocks.NETHERSTONE
        }));


        ///
        //  Carbonate
        ///
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftItems.CARBONATE_SLACK), new ItemStack(ForgeCraftBlocks.CARBONATE_STONE, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftBlocks.CARBONATE_STONE), new ItemStack(ForgeCraftBlocks.CARBONATE_FLAG, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftBlocks.CARBONATE_FLAG), new ItemStack(ForgeCraftBlocks.CARBONATE_BRICK, 4));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.STAIRS_CARBONATE_FLAG, 4), true, new Object[]{"S  ", "SS ", "SSS",
                ('S'), ForgeCraftBlocks.CARBONATE_FLAG
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.STAIRS_CARBONATE_BRICK, 4), true, new Object[]{"S  ", "SS ", "SSS",
                ('S'), ForgeCraftBlocks.CARBONATE_BRICK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.WALL_CARBONATE_BRICK, 6), true, new Object[]{"SSS", "SSS",
                ('S'), ForgeCraftBlocks.CARBONATE_BRICK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.WALL_CARBONATE_FLAG, 6), true, new Object[]{"SSS", "SSS",
                ('S'), ForgeCraftBlocks.CARBONATE_FLAG
        }));

        /// FERRO ///
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftItems.CARBONATE_FERRO_SLACK), new ItemStack(ForgeCraftBlocks.FERRO_STONE, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftBlocks.FERRO_STONE), new ItemStack(ForgeCraftBlocks.FERRO_FLAG, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftBlocks.FERRO_FLAG), new ItemStack(ForgeCraftBlocks.FERRO_BRICK, 4));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.STAIRS_FERRO_FLAG, 4), true, new Object[]{"S  ", "SS ", "SSS",
                ('S'), ForgeCraftBlocks.FERRO_FLAG
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.STAIRS_FERRO_BRICK, 4), true, new Object[]{"S  ", "SS ", "SSS",
                ('S'), ForgeCraftBlocks.FERRO_BRICK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.WALL_FERRO_BRICK, 6), true, new Object[]{"SSS", "SSS",
                ('S'), ForgeCraftBlocks.FERRO_BRICK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.WALL_FERRO_FLAG, 6), true, new Object[]{"SSS", "SSS",
                ('S'), ForgeCraftBlocks.FERRO_FLAG
        }));


        ///
        //  IronWood, Netherpalm
        ///
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.FENCE_IRONWOOD, 6), true, new Object[]{"BSB", "BSB",
                ('B'), ForgeCraftBlocks.IRONWOOD_PLANK,
                ('S'), ForgeCraftItems.IRONWOOD_STICK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.STAIRS_IRONWOOD, 4), true, new Object[]{"S  ", "SS ", "SSS",
                ('S'), ForgeCraftBlocks.IRONWOOD_PLANK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.FENCE_NETHERPALM, 6), true, new Object[]{"BSB", "BSB",
                ('B'), ForgeCraftBlocks.NETHERPALM_PLANK,
                ('S'), ForgeCraftItems.NETHERPALM_STICK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.STAIRS_NETHERPALM, 4), true, new Object[]{"S  ", "SS ", "SSS",
                ('S'), ForgeCraftBlocks.NETHERPALM_PLANK
        }));


        ///
        //  STAIRS, PRESSURE PLATES, ETC
        ///
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.PRESSPLATE_DIRT, 1), true, new Object[]{"SS",
                ('S'), Blocks.DIRT
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.PRESSPLATE_GRASS, 1), true, new Object[]{"SS",
                ('S'), Blocks.GRASS
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.PRESSPLATE_GLASS, 1), true, new Object[]{"SS",
                ('S'), Blocks.GLASS
        }));


        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.STAIRS_NETHERRACK, 4), true, new Object[]{"S  ", "SS ", "SSS",
                ('S'), Blocks.NETHERRACK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.PRESSPLATE_NETHERRACK, 1), true, new Object[]{"SS",
                ('S'), Blocks.NETHERRACK
        }));


        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.STAIRS_NETHERPALM, 4), true, new Object[]{"S  ", "SS ", "SSS",
                ('S'), ForgeCraftBlocks.NETHERPALM_PLANK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.PRESSPLATE_NETHERPALM, 1), true, new Object[]{"SS",
                ('S'), ForgeCraftBlocks.NETHERPALM_PLANK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.PRESSPLATE_THATCH, 1), true, new Object[]{"SS",
                ('S'), ForgeCraftBlocks.THATCH
        }));

        ///
        //  Grates
        ///
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_ACACIA, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_ACACIA
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_BIGOAK, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_BIGOAK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_BIRCH, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_BIRCH
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_CARBONATE_BRICK, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_CARBONATE_BRICK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_CARBONATE_FLAG, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_CARBONATE_FLAG
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_ENDBRICK, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_ENDBRICK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_ENDSTONE, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_ENDSTONE
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_FERRO_BRICK, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_FERRO_BRICK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_FERRO_FLAG, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_FERRO_FLAG
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_IRONWOOD, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_IRONWOOD
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_JUNGLE, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_JUNGLE
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_MUD, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_OAK,
                ('S'), ForgeCraftBlocks.THIN_SLAB_MUD
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_NETHERBRICK, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_NETHERBRICK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_NETHERPALM, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_NETHERPALM
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_NETHERRACK, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.NETHERPALM_STICK,
                ('S'), ForgeCraftBlocks.THIN_SLAB_NETHERRACK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_NETHERSTONE, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_NETHERSTONE
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_OAK, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_OAK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_SANDSTONE, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_SANDSTONE
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_SOULSTONE, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_SOULSTONE
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_SPRUCE, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_SPRUCE
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_STONEBRICK, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_STONEBRICK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_STONEBRICK_MOSSY, 1), true, new Object[]{"I", "S",
                ('I'), ForgeCraftItems.IRON_MESH,
                ('S'), ForgeCraftBlocks.THIN_SLAB_STONEBRICK_MOSSY
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.GRATE_THATCH, 1), true, new Object[]{"I", "S",
                ('I'), Items.STICK,
                ('S'), ForgeCraftBlocks.THIN_SLAB_THATCH
        }));

        ///
        //  Drains
        ///
        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.DRAIN_CARBONATE_BRICK, true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_IRON,
                ('S'), ForgeCraftBlocks.THIN_SLAB_THATCH
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.DRAIN_CARBONATE_FLAG, true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_IRON,
                ('S'), ForgeCraftBlocks.THIN_SLAB_THATCH
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.DRAIN_ENDBRICK, true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_IRON,
                ('S'), ForgeCraftBlocks.THIN_SLAB_THATCH
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.DRAIN_ENDSTONE, true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_IRON,
                ('S'), ForgeCraftBlocks.THIN_SLAB_THATCH
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.DRAIN_FERRO_BRICK, true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_IRON,
                ('S'), ForgeCraftBlocks.SLAB_FERRO_BRICK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.DRAIN_FERRO_FLAG, true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_IRON,
                ('S'), ForgeCraftBlocks.THATCH
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.DRAIN_MUD, true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_OAK,
                ('S'), ForgeCraftBlocks.SLAB_MUD
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.DRAIN_NETHERBRICK, true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_IRON,
                ('S'), new ItemStack(Blocks.STONE_SLAB2, 1)
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.DRAIN_NETHERRACK, true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_NETHERPALM,
                ('S'), ForgeCraftBlocks.SLAB_NETHERRACK
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.DRAIN_NETHERSTONE, true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_IRON,
                ('S'), ForgeCraftBlocks.SLAB_NETHERSTONE
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.DRAIN_STONE, true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_IRON,
                ('S'), new ItemStack(Blocks.STONE_SLAB, 1)
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.DRAIN_STONEBRICK, true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_IRON,
                ('S'), new ItemStack(Blocks.STONE_SLAB, 2)
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.DRAIN_STONEBRICK_MOSSY, true, new Object[]{"I", "S",
                ('I'), ForgeCraftBlocks.SLAT_IRON,
                ('S'), ForgeCraftBlocks.SLAB_STONEBRICK_MOSSY
        }));

        ///
        //  TERRACOTTA
        ///
        GameRegistry.addSmelting(ForgeCraftItems.CINISCLAY_CLUMP, new ItemStack(ForgeCraftItems.CINISCOTTA, 1, 0), 0.35f);
        GameRegistry.addSmelting(ForgeCraftItems.TERRACLAY_CLUMP, new ItemStack(ForgeCraftItems.TERRACOTTA, 1, 0), 0.35f);

        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftItems.CINISCLAY_CLUMP), new ItemStack(ForgeCraftBlocks.CINISCLAY_BLOCK, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftItems.TERRACLAY_CLUMP), new ItemStack(ForgeCraftBlocks.TERRACLAY_BLOCK, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftItems.CINISCOTTA), new ItemStack(ForgeCraftBlocks.CINISCOTTA_BRICK, 4));
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftItems.TERRACOTTA), new ItemStack(ForgeCraftBlocks.TERRACOTTA_BRICK, 4));

        /// LOAM AND MUD
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftItems.MUD_CLUMP), new ItemStack(ForgeCraftBlocks.MUD_BLOCK_WET, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftBlocks.MUD_BLOCK_WET), new ItemStack(ForgeCraftBlocks.MUD_BRICK_WET, 4));

        CraftingHelper.add2x2Crafting(new ItemStack(Blocks.DIRT), new ItemStack(ForgeCraftBlocks.DIRT_BRICK, 1));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.STAIRS_DIRT, 4), true, new Object[]{"S  ", "SS ", "SSS",
                ('S'), Blocks.DIRT
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.STAIRS_MUD, 4), true, new Object[]{"S  ", "SS ", "SSS",
                ('S'), ForgeCraftBlocks.MUD_BLOCK_DRY
        }));

        /// Thatch
        CraftingHelper.add3x3Crafting(new ItemStack(Blocks.TALLGRASS, 1, 1), new ItemStack(ForgeCraftItems.THATCHING_WET, 1));
        CraftingHelper.add3x3Crafting(new ItemStack(ForgeCraftItems.RUSH_TIPS, 1), new ItemStack(ForgeCraftItems.THATCHING_WET, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftItems.RUSH_STEMS, 1), new ItemStack(ForgeCraftItems.THATCHING_WET, 1));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.THATCH_WET, 1), true, new Object[]{"TTT", "TCT", "TTT",
                ('T'), "thatchingWet",
                ('C'), "cordagePlant"
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.THATCH, 2), true, new Object[]{"TTT", "TCT", "TTT",
                ('T'), "thatchingDry",
                ('C'), "cordagePlant"
        }));

        ///
        //  WORKTABLES
        ///
        CraftingHelper.add2x2Crafting(new ItemStack(Blocks.WOODEN_SLAB, 1, 4), new ItemStack(ForgeCraftBlocks.WORKTABLE_ACACIA, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(Blocks.WOODEN_SLAB, 1, 5), new ItemStack(ForgeCraftBlocks.WORKTABLE_BIGOAK, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(Blocks.WOODEN_SLAB, 1, 2), new ItemStack(ForgeCraftBlocks.WORKTABLE_BIRCH, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(Blocks.WOODEN_SLAB, 1, 3), new ItemStack(ForgeCraftBlocks.WORKTABLE_JUNGLE, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(Blocks.WOODEN_SLAB, 1, 0), new ItemStack(ForgeCraftBlocks.WORKTABLE_OAK, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(Blocks.WOODEN_SLAB, 1, 1), new ItemStack(ForgeCraftBlocks.WORKTABLE_SPRUCE, 1));

        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftBlocks.SLAB_MUD, 1), new ItemStack(ForgeCraftBlocks.WORKTABLE_MUD_SLAB, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftBlocks.SLAB_NETHERPALM, 1), new ItemStack(ForgeCraftBlocks.WORKTABLE_NETHERPALM, 1));

        CraftingHelper.add2x2Crafting(new ItemStack(Blocks.SANDSTONE, 1, 2), new ItemStack(ForgeCraftBlocks.WORKTABLE_SANDSTONE, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(Blocks.END_BRICKS, 1), new ItemStack(ForgeCraftBlocks.WORKTABLE_END, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftBlocks.MUD_BLOCK_DRY, 1), new ItemStack(ForgeCraftBlocks.WORKTABLE_MUD, 1));
        CraftingHelper.add2x2Crafting(new ItemStack(ForgeCraftBlocks.NETHERSTONE, 1), new ItemStack(ForgeCraftBlocks.WORKTABLE_NETHERSTONE, 1));

        ///
        // Torch
        ///
        if (ModConfig.LIGHTING_TORCHES_REPLACE_VANILLA)
        {
            ItemStack removeItems[] = { new ItemStack(Blocks.TORCH) };
            RecipeRemover.removeRecipeByStack(removeItems);

            String removeNames[] = { "tconstruct:stone_torch" };
            RecipeRemover.removeRecipeByString(removeNames);

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.TORCH_WOOD, ModConfig.LIGHTING_TORCH_RECIPE_OUTPUT), "F", "C", "S",
                    ('F'), "clumpFuel",
                    ('C'), "cordageGeneral",
                    ('S'), "stickWood"));
        }

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftBlocks.TORCH_NETHER, "S", "S",
                ('S'), Blocks.NETHERRACK));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.LEVER_NETHER, 2), "T", "S",
                ('T'), ForgeCraftBlocks.TORCH_NETHER,
                ('S'), Blocks.NETHERRACK));

        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.LIT_PUMPKIN, "P", "T",
            ('P'), Blocks.PUMPKIN,
            ('T'), ForgeCraftItems.TORCH_WOOD_LIT));

        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.LIT_PUMPKIN, "P", "T",
                ('P'), Blocks.PUMPKIN,
                ('T'), ForgeCraftItems.TORCH_NETHER_LIT));

        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.LIT_PUMPKIN, "P", "T",
                ('P'), Blocks.PUMPKIN,
                ('T'), ForgeCraftBlocks.IGNIS_FATUUS));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.JACK_O_LANTERN), "P", "T",
                ('P'), Blocks.PUMPKIN,
                ('T'), "torchUnlit"));

        CraftingHelper.addBasicToolRecipe(Items.FLINT_AND_STEEL, new ItemStack(ForgeCraftBlocks.JACK_O_LANTERN), new ItemStack(Blocks.LIT_PUMPKIN));
        CraftingHelper.addBasicToolRecipe(Items.FLINT_AND_STEEL, new ItemStack(ForgeCraftBlocks.TORCH_WOOD), new ItemStack(Blocks.TORCH));
        CraftingHelper.addBasicToolRecipe(Items.FLINT_AND_STEEL, new ItemStack(ForgeCraftBlocks.TORCH_NETHER), new ItemStack(ForgeCraftItems.TORCH_NETHER_LIT));


        ///
        //  fish
        ///
        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.FISH_COD_SALTED, true, new Object[]{"S", "F",
                ('S'), "foodSalt",
                ('F'), new ItemStack(Items.FISH, 1, 0)
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.FISH_SALMON_SALTED, true, new Object[]{"S", "F",
                ('S'), "foodSalt",
                ('F'), new ItemStack(Items.FISH, 1, 1)
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.FISH_CLOWN_SALTED, true, new Object[]{"S", "F",
                ('S'), "foodSalt",
                ('F'), new ItemStack(Items.FISH, 1, 2)
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.FISH_PUFFER_SALTED, true, new Object[]{"S", "F",
                ('S'), "foodSalt",
                ('F'), new ItemStack(Items.FISH, 1, 3)
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ForgeCraftItems.FISH_LAVAWORM_SALTED, true, new Object[]{"S", "F",
                ('S'), "foodSalt",
                ('F'), new ItemStack(ForgeCraftItems.FISH_LAVAWORM_RAW, 1)
        }));


        ///
        // ash
        ///
        CraftingHelper.add3x3Crafting(new ItemStack(ForgeCraftItems.ASH), new ItemStack(ForgeCraftBlocks.ASH_BLOCK, 1));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.ASH_STABILIZED, 8), true, new Object[]{"III", "ICI", "III",
                ('I'), ForgeCraftBlocks.ASH_BLOCK,
                ('C'), "slimeball"
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.ASH_STABILIZED, 8), true, new Object[]{"III", "ICI", "III",
                ('I'), ForgeCraftBlocks.ASH_BLOCK,
                ('C'), "clumpClay"
        }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftBlocks.ASH_STABILIZED, 8), true, new Object[]{"III", "ICI", "III",
                ('I'), ForgeCraftBlocks.ASH_BLOCK,
                ('C'), "mortar"
        }));

        ///
        //  Foods
        ///
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.SALO, 1), true, new Object[]{"S", "F",
                ('F'), "foodFat",
                ('S'), "foodSalt"
        }));

        ///
        // Crafting Config Hooks
        ///
        if (ModConfig.CRAFTING_SURVIVAL_FLINTNSTEEL)
        {
            GameRegistry.addShapelessRecipe(new ItemStack(Items.FLINT_AND_STEEL), new ItemStack(ForgeCraftItems.IRON_RING), new ItemStack(ForgeCraftItems.FLINT_KNAPP, 1));
        }

        if (ModConfig.CRAFTING_ENABLE_SADDLE)
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.SADDLE), true, new Object[]{"CSC", "CWC", "I I",
                    ('S'), "leather",
                    ('W'), Blocks.WOOL,
                    ('I'), ForgeCraftItems.IRON_RING,
                    ('C'), "cordageLeather"
            }));
        }

        if (!ModConfig.CRAFTING_KNAPPING_ENABLE) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ForgeCraftItems.SALO, 1), true, new Object[]{"S", "F",
                    ('F'), Items.FLINT,
                    ('S'), "rock"
            }));
        }

        ///
        // vanilla smelting recipes
        ///
        GameRegistry.addSmelting(ForgeCraftItems.CORN_GROUND, new ItemStack(ForgeCraftItems.CORN_BREAD, 1, 0), 0.35f);
        GameRegistry.addSmelting(ForgeCraftItems.WHEAT_GROUND, new ItemStack(Items.BREAD, 1, 0), 0.35f);
        GameRegistry.addSmelting(ForgeCraftItems.HORSE_MEAT_RAW, new ItemStack(ForgeCraftItems.HORSE_MEAT_COOKED, 1, 0), 0.35f);
        //
        //GameRegistry.addSmelting(ForgeCraftItems.obsidianCrushed,      new ItemStack(ForgeCraftItems.obsidianPlate, 1, 0), 0.1f);
        //GameRegistry.addSmelting(ForgeCraftItems.valusMash,           new ItemStack(ForgeCraftItems.valusBread, 1, 0), 0.06f);
        //GameRegistry.addSmelting(ForgeCraftItems.netherMuttonRaw,      new ItemStack(ForgeCraftItems.netherMuttonCooked, 1, 0), 0.05f);
        //GameRegistry.addSmelting(ForgeCraftItems.overworldMuttonRaw,   new ItemStack(ForgeCraftItems.overworldMuttonCooked, 1, 0), 0.05f);
        //GameRegistry.addSmelting(ForgeCraftItems.wolfMeatRaw,          new ItemStack(ForgeCraftItems.wolfMeatCooked, 1, 0), 0.05f);
        //GameRegistry.addSmelting(ForgeCraftItems.vanadiumBar,          new ItemStack(ForgeCraftItems.vanadiumBarHot, 1, 0), 0.06f);
        //GameRegistry.addSmelting(ForgeCraftItems.netherClayBrick,      new ItemStack(ForgeCraftItems.netherClayClump, 1, 0), 0.01f);
        //GameRegistry.addSmelting(ForgeCraftBlocks.silverOreOverworld,  new ItemStack(ForgeCraftItems.silverIngot, 1, 0), 0.05f);
        //GameRegistry.addSmelting(Blocks.soul_sand,              new ItemStack(ForgeCraftBlocks.soulGlass, 1, 0), 0.05f);
        //GameRegistry.addSmelting(ModFluids.clayBucket_raw,      new ItemStack(ModFluids.clayBucket_empty, 1, 0), 0.05f);
        //GameRegistry.addSmelting(ModFluids.netherBucket_raw,    new ItemStack(ModFluids.netherBucket_empty, 1, 0), 0.05f);
        //GameRegistry.addSmelting(ForgeCraftItems.pittedBrickRaw,       new ItemStack(ForgeCraftItems.pittedBrick, 1, 0), 0.05f);
        //GameRegistry.addSmelting(ForgeCraftItems.netherClayBrickRaw,   new ItemStack(ForgeCraftItems.netherClayBrick, 1, 0), 0.05f);
        //GameRegistry.addSmelting(ForgeCraftItems.sinuousMash,          new ItemStack(ForgeCraftItems.sinuousResin, 1, 0), 0.05f);
        //GameRegistry.addSmelting(ForgeCraftBlocks.soulGlass,           new ItemStack(Blocks.glass, 1, 0), 0.05f);
        */
    }


    /*******************************************************************************
     * Recipes Overrides
     */
    public static void registerRecipeRemover()
    {

    /*
        //if (ModConfig.torchReplaceVanilla) {
        //    //ItemStack removeTorches[] = { new ItemStack(Item.getItemFromBlock(Blocks.torch)), new ItemStack(Blocks.torch) };
        //    ItemStack removeTorches[] = { new ItemStack(Blocks.torch) };
        //    RecipeRemover.removeRecipeByStack(removeTorches);
        //}

        if (ModConfig.CRAFTING_DISABLE_ENDEREYE) {
            ItemStack removeItems[] = { new ItemStack(Items.ENDER_EYE) };
            RecipeRemover.removeRecipeByStack(removeItems);
        }

        if (ModConfig.CRAFTING_DISABLE_TOOLS_WOOD) {
            ItemStack removeItems[] = { new ItemStack(Items.WOODEN_PICKAXE), new ItemStack(Items.WOODEN_AXE), new ItemStack(Items.WOODEN_SHOVEL), new ItemStack(Items.WOODEN_HOE), new ItemStack(Items.WOODEN_SWORD) };
            RecipeRemover.removeRecipeByStack(removeItems);
        }

        if (ModConfig.CRAFTING_DISABLE_TOOLS_STONE) {
            ItemStack removeItems[] = { new ItemStack(Items.STONE_PICKAXE), new ItemStack(Items.STONE_AXE), new ItemStack(Items.STONE_SHOVEL), new ItemStack(Items.STONE_HOE), new ItemStack(Items.STONE_SWORD) };
            RecipeRemover.removeRecipeByStack(removeItems);
        }

        if (ModConfig.CRAFTING_DISABLE_TOOLS_IRON) {
            ItemStack removeItems[] = { new ItemStack(Items.IRON_PICKAXE), new ItemStack(Items.IRON_AXE), new ItemStack(Items.IRON_SHOVEL), new ItemStack(Items.IRON_HOE), new ItemStack(Items.IRON_SWORD) };
            RecipeRemover.removeRecipeByStack(removeItems);
        }

        if (ModConfig.CRAFTING_DISABLE_TOOLS_GOLD) {
            ItemStack removeItems[] = { new ItemStack(Items.GOLDEN_PICKAXE), new ItemStack(Items.GOLDEN_AXE), new ItemStack(Items.GOLDEN_SHOVEL), new ItemStack(Items.GOLDEN_HOE), new ItemStack(Items.GOLDEN_SWORD) };
            RecipeRemover.removeRecipeByStack(removeItems);
        }

        if (ModConfig.CRAFTING_DISABLE_TOOLS_DIAMOND) {
            ItemStack removeItems[] = { new ItemStack(Items.DIAMOND_PICKAXE), new ItemStack(Items.DIAMOND_AXE), new ItemStack(Items.DIAMOND_SHOVEL), new ItemStack(Items.DIAMOND_HOE), new ItemStack(Items.DIAMOND_SWORD) };
            RecipeRemover.removeRecipeByStack(removeItems);
        }

        if (ModConfig.SURVIVAL_BETTER_THAN_PLANKS) {
            ItemStack removeItems[] = {
                    new ItemStack(Blocks.PLANKS, 1, 0),
                    new ItemStack(Blocks.PLANKS, 1, 1),
                    new ItemStack(Blocks.PLANKS, 1, 2),
                    new ItemStack(Blocks.PLANKS, 1, 3),
                    new ItemStack(Blocks.PLANKS, 1, 4),
                    new ItemStack(Blocks.PLANKS, 1, 5),

                    new ItemStack(Blocks.WOODEN_SLAB, 1, 0),
                    new ItemStack(Blocks.WOODEN_SLAB, 1, 1),
                    new ItemStack(Blocks.WOODEN_SLAB, 1, 2),
                    new ItemStack(Blocks.WOODEN_SLAB, 1, 3),
                    new ItemStack(Blocks.WOODEN_SLAB, 1, 4),
                    new ItemStack(Blocks.WOODEN_SLAB, 1, 5),

                    new ItemStack(Items.STICK)
            };
            RecipeRemover.removeRecipeByStack(removeItems);
            //RecipeRemover.removeRecipeByItemName(removeItems);
        }

        if (ModConfig.CRAFTING_REMOVE_NAMES.length > 0) {
            RecipeRemover.removeRecipeByString(ModConfig.CRAFTING_REMOVE_NAMES);
        }

        /**
        if (ModConfig.removeRecipeDisplayNames.length > 0) {
            RecipeRemover.removeRecipeByDisplayName(ModConfig.removeRecipeDisplayNames);
        } **/
    }
}