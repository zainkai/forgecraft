package nmd.primal.forgecraft.common.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
//import nmd.primal.core.api.ForgeCraftBlocks;
//import nmd.primal.core.api.ForgeCraftItems;
//import nmd.primal.core.api.ForgeCraftMaterials;
//import nmd.primal.core.api.ForgeCraftRegistries;
import nmd.primal.forgecraft.common.compat.FuelHandler;

public class ModRegistries
{
    //public static final IForgeRegistry<Block> HEATSOURCES ;
    //public static final IForgeRegistry<ItemStack> KNAPPING;

    /*******************************************************************************
     *  Parent Block Registry
     */
    public static void registerVanillaParentBlocks()
    {
        //ForgeCraftRegistries.addParentBlock(new ItemStack(Blocks.DIRT));
        //ForgeCraftRegistries.addParentBlock(new ItemStack(Blocks.GRASS));
        //ForgeCraftRegistries.addParentBlock(new ItemStack(Blocks.GLASS));
        //ForgeCraftRegistries.addParentBlock(new ItemStack(Blocks.NETHERRACK));
    }


    /*******************************************************************************
     * Fuel Registry
     */
    //public static Hashtable<ItemStack, Integer> FUEL_REGISTRY = new Hashtable<>();

    //public static void addFuel(ItemStack stack, int value)
    //{
    //    ModRegistries.FUEL_REGISTRY.put(stack, value);
    //}

    public static void registerFuels()
    {
        if (ModConfig.FEATURE_ENABLE_FUELS)
        {
            GameRegistry.registerFuelHandler(new FuelHandler());

            //ForgeCraftRegistries.addFuel(new ItemStack(Items.PAPER), 48);
            //ForgeCraftRegistries.addFuel(new ItemStack(Items.BOOK), 178);
            //ForgeCraftRegistries.addFuel(new ItemStack(ForgeCraftItems.PLANT_FIBER), 16);
            //ForgeCraftRegistries.addFuel(new ItemStack(ForgeCraftItems.PLANT_CORDAGE), 48);
            //ForgeCraftRegistries.addFuel(new ItemStack(ForgeCraftItems.PLANT_TINDER), 64);
            //ForgeCraftRegistries.addFuel(new ItemStack(ModItems.PLANT_PAPYRUS, 72);
            //ForgeCraftRegistries.addFuel(new ItemStack(ForgeCraftItems.PLANT_CLOTH), 144);

            /**
             * new ItemStack(ModItems.netherPearl)) )      { return 6600
             * new ItemStack(ModBlocks.earthWax)) )        { return 3600
             * new ItemStack(ModItems.earthwaxClump)) )    { return 900
             * new ItemStack(ModItems.clarifiedWax)) )     { return 900
             * new ItemStack(ModItems.paraffinWax)) )      { return 900
             * new ItemStack(ModBlocks.netherGrowth)) )     { return 625
             * new ItemStack(ModBlocks.netherReed)) )       { return 127
             * new ItemStack(ModItems.daucusMurnFronds)) )  { return 192
             * new ItemStack(ModItems.daucusMurnStem)) )    { return 288
             */
        }
    }

    public static void registerVanillaTorches()
    {
        //ForgeCraftRegistries.addTorch(new ItemStack(Blocks.TORCH));
        //ForgeCraftRegistries.addTorch(new ItemStack(Blocks.MAGMA));
        //ForgeCraftRegistries.addTorch(new ItemStack(Items.LAVA_BUCKET));
        //ForgeCraftRegistries.addTorch(new ItemStack(ForgeCraftBlocks.IGNIS_FATUUS));
    }

    /*******************************************************************************
     * Repair Registry
     */
    public static void registerRepairItems()
    {
        /*
        ForgeCraftRegistries.addToolRepairItem(ForgeCraftMaterials.TOOL_BONE, new ItemStack(Items.BONE));
        ForgeCraftRegistries.addToolRepairItem(ForgeCraftMaterials.TOOL_FLINT, new ItemStack(Items.FLINT));
        ForgeCraftRegistries.addToolRepairItem(ForgeCraftMaterials.TOOL_FLINT, new ItemStack(ForgeCraftItems.FLINT_KNAPP));
        ForgeCraftRegistries.addToolRepairItem(ForgeCraftMaterials.TOOL_EMERALD, new ItemStack(Items.EMERALD));
        ForgeCraftRegistries.addToolRepairItem(ForgeCraftMaterials.TOOL_OBSIDIAN, new ItemStack(Blocks.OBSIDIAN));
        ForgeCraftRegistries.addToolRepairItem(ForgeCraftMaterials.TOOL_QUARTZ, new ItemStack(Items.QUARTZ));
        ForgeCraftRegistries.addToolRepairItem(ForgeCraftMaterials.TOOL_QUARTZ, new ItemStack(Blocks.QUARTZ_BLOCK));
        */
    }

    public static void registerToolBreakItems()
    {
        /*
        ForgeCraftRegistries.addToolBreakItem(ForgeCraftItems.SHARP_BONE, new ItemStack[] { new ItemStack(Items.DYE, 1)});
        ForgeCraftRegistries.addToolBreakItem(ForgeCraftItems.FLINT_HATCHET, new ItemStack[] { new ItemStack(ForgeCraftItems.FLINT_KNAPP, 1)});
        ForgeCraftRegistries.addToolBreakItem(ForgeCraftItems.FLINT_AXE, new ItemStack[] { new ItemStack(ForgeCraftItems.FLINT_KNAPP, 2), new ItemStack(Items.STICK, 1) });
        ForgeCraftRegistries.addToolBreakItem(ForgeCraftItems.FLINT_PICKAXE, new ItemStack[] { new ItemStack(ForgeCraftItems.FLINT_KNAPP, 2), new ItemStack(Items.STICK, 1) });
        ForgeCraftRegistries.addToolBreakItem(ForgeCraftItems.FLINT_SHOVEL, new ItemStack[] { new ItemStack(ForgeCraftItems.FLINT_KNAPP, 1), new ItemStack(Items.STICK, 1) });
        ForgeCraftRegistries.addToolBreakItem(ForgeCraftItems.FLINT_HOE, new ItemStack[] { new ItemStack(ForgeCraftItems.FLINT_KNAPP, 1), new ItemStack(Items.STICK, 1) });
        */
    }


    /*******************************************************************************
     * Repair Registry
     */
    public static void registerAdditionalCraftingItems()
    {
        //ForgeCraftRegistries.addCraftingItem(Items.FLINT_AND_STEEL, SoundEvents.ITEM_FLINTANDSTEEL_USE);
    }

    ///
    // end
    ///
}