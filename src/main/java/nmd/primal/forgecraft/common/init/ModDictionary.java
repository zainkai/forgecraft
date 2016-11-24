package nmd.primal.forgecraft.common.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModDictionary
{
    /*******************************************************************************
     *  Register Only Vanilla OreDictionary Entries Here
     *    Mod Items/Blocks have their names added through the respective
     *    registration methods as a list of comma delineated strings.
     *
     *    EXAMPLE:
     *      LEATHER_CORDAGE = registerItem(new PrimalItem("leather_cordage"), "cordageGeneral, cordageLeather");
     *
     */
    public static void registerDictionaryNames()
    {
        ///
        // slimeball
        ///
        //OreDictionary.registerOre("slimeball", new ItemStack(Items.SLIME_BALL));
        //OreDictionary.registerOre("slimeball", new ItemStack(Items.MAGMA_CREAM));

        ///
        // paper
        ///
        OreDictionary.registerOre("paper", new ItemStack(Items.PAPER, 1, 0));

        ///
        // clay
        ///
        OreDictionary.registerOre("clayball", new ItemStack(Items.CLAY_BALL, 1, 0));

        ///
        // bone
        ///
        OreDictionary.registerOre("bone", new ItemStack(Items.BONE, 1, 0));

        ///
        // torch fuel
        ///
        OreDictionary.registerOre("clumpFuel", new ItemStack(Items.COAL, 1, 0));
        OreDictionary.registerOre("clumpFuel", new ItemStack(Items.COAL, 1, 1));

        ///
        // Foodstuff
        ///
        OreDictionary.registerOre("foodBread", new ItemStack(Items.BREAD, 1, 0));

        ///
        //  Thatching
        ///
        //OreDictionary.registerOre("thatchingMaterial", new ItemStack(Blocks.TALLGRASS, 1, 0));
    }
}