package nmd.primal.forgecraft.init;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.core.api.PrimalItems;
import nmd.primal.core.common.crafting.ToolRecipe;
import nmd.primal.core.common.items.tools.PrimalTool;
import nmd.primal.forgecraft.blocks.Bloomery;
import nmd.primal.forgecraft.blocks.IngotBall;
import nmd.primal.forgecraft.crafting.AnvilCrafting;
import nmd.primal.forgecraft.crafting.BloomeryCrafting;
import nmd.primal.forgecraft.crafting.ForgeCrafting;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by kitsu on 11/30/2016.
 */
public class ModCrafting {

    public static void register() {

        Random rand = new Random();

        /***Forge***/
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.firebox),
                "X X", "XYX", "X X", 'X', Items.BRICK, 'Y', Blocks.FURNACE);

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
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.pistonbellows),
                "X X", "X X", " X ", 'X', Items.STICK);

        /***Tongs***/
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.stonetongs, 1),
                "X X", "YSY", 'X', Blocks.STONE, 'S', Items.STRING, 'Y', Items.STICK);

        /***Iron Crucible***/

        ItemStack iron0 = new ItemStack(ModBlocks.rawironcrucible, 1);
        //iron0.getTagCompound().setBoolean("mod", false);
        ///iron0.getTagCompound().setInteger("speed", 0);
        //iron0.getTagCompound().setInteger("fortune", 0);
        //iron0.getTagCompound().setInteger("durability", 0);
        //iron0.getTagCompound().setBoolean("silk", false);

        //Regular Iron Ore
        GameRegistry.addShapedRecipe(iron0,
                " X ", " Y ", 'X', Blocks.IRON_ORE, 'Y', ModBlocks.emptycrucible);

        //Iron Ore speed +1

        /***Pickaxe Crafting***/
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.ironpickaxe, 1),
                " X ", " Y ", 'X', ModItems.pickaxehead, 'Y', Items.STICK);

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

//Makes the Finished Hot Iron Crucible
        BloomeryCrafting.addRecipe(
                new ItemStack(ModBlocks.hotcookedironcrucible, 1),
                new ItemStack(ModBlocks.failedironcruciblehot, 1),
                new ItemStack(ModBlocks.failedironcruciblehot, 1),
                new ItemStack(ModBlocks.failedironcrucible, 1),
                1550,
                1200,
                800,
                0.33f,
                0.5f
        );

        /******************************************************************************
          FORGING
         ******************************************************************************/

//Makes a Hot Iron Ingot
        ForgeCrafting.addRecipe(
                Item.getItemFromBlock(ModBlocks.ironball),
                new ItemStack(ModItems.ironingotballhot, 1),
                800,
                200,
                500,
                1.0f,
                1.0f
        );

//Makes a Hot Iron Chunk
        ForgeCrafting.addRecipe(
                Item.getItemFromBlock(ModBlocks.ironchunk),
                new ItemStack(ModItems.ironchunkhot,1),
                800,
                160,
                400,
                1.0f,
                1.0f
        );

//Makes a Hot PickaxeHead
        ForgeCrafting.addRecipe(
                ModItems.pickaxehead,
                new ItemStack(ModItems.pickaxehead, 1 ),
                800,
                160,
                400,
                1.0f,
                1.0f
        );

        //Makes a Hot AxeHead
        ForgeCrafting.addRecipe(
                ModItems.ironaxehead,
                new ItemStack(ModItems.ironaxehead, 1 ),
                800,
                160,
                400,
                1.0f,
                1.0f
        );


        /******************************************************************************
               ANVILING
         ******************************************************************************/

        String empty = ItemStack.EMPTY.getItem().getRegistryName().toString();
        String hotChunk = ModItems.ironchunkhot.getRegistryName().toString();
        String diamond = Items.DIAMOND.getRegistryName().toString();
        String emerald = Items.EMERALD.getRegistryName().toString();

        String emeraldShard = PrimalItems.EMERALD_KNAPP.getRegistryName().toString();
        String diamondShard = PrimalItems.DIAMOND_KNAPP.getRegistryName().toString();
        String redstone = Items.REDSTONE.getRegistryName().toString();
        String lapis = Items.DYE.getRegistryName().toString();

        String pickaxehead = ModItems.pickaxehead.getRegistryName().toString();
        String ironaxehead = ModItems.ironaxehead.getRegistryName().toString();

        /*
        Empty = 0
        hotChunk = 1
        diamond = 2
         */

        /*** ForgeHammer ***/
        AnvilCrafting.addRecipe(
                new String [] {
                        empty,hotChunk,hotChunk,hotChunk,empty,
                        empty,hotChunk,hotChunk,empty,empty,
                        empty,empty,hotChunk,empty,empty,
                        empty,empty,hotChunk,empty,empty,
                        empty,empty,hotChunk,empty,empty },
                new ItemStack(ModItems.forgehammer, 1),
                "null"
        );

        /*** Flaked diamond ***/
        AnvilCrafting.addRecipe(
                new String[] {
                        empty,empty,empty,empty,empty,
                        empty,empty,empty,empty,empty,
                        empty,empty,diamond,empty,empty,
                        empty,empty,empty,empty,empty,
                        empty,empty,empty,empty,empty },
                new ItemStack(PrimalItems.DIAMOND_KNAPP, 1),
                "null"
        );

        /*** Flaked emerald ***/
        AnvilCrafting.addRecipe(
                new String[] {
                        empty,empty,empty,empty,empty,
                        empty,empty,empty,empty,empty,
                        empty,empty,emerald,empty,empty,
                        empty,empty,empty,empty,empty,
                        empty,empty,empty,empty,empty },
                new ItemStack(PrimalItems.EMERALD_KNAPP, 1),
                "null"
        );

        /***Pickaxe Head***/
        AnvilCrafting.addRecipe(
                new String[] {
                        empty,empty,empty,empty,empty,
                        empty,hotChunk,hotChunk,hotChunk,empty,
                        hotChunk,empty,empty,empty,hotChunk,
                        empty,empty,empty,empty,empty,
                        empty,empty,empty,empty,empty },
                new ItemStack(ModItems.pickaxehead, 1),
                "null"
        );

        /*** Emerald Upgrade to Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new String[] {
                        empty,empty,empty,empty,empty,
                        empty,empty,emeraldShard,empty,empty,
                        empty,empty,pickaxehead,empty,empty,
                        empty,empty,empty,empty,empty,
                        empty,empty,empty,empty,empty },
                new ItemStack(ModItems.pickaxehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new String[] {
                        empty,empty,empty,empty,empty,
                        empty,empty,diamondShard,empty,empty,
                        empty,empty,pickaxehead,empty,empty,
                        empty,empty,empty,empty,empty,
                        empty,empty,empty,empty,empty },
                new ItemStack(ModItems.pickaxehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new String[] {
                        empty,empty,empty,empty,empty,
                        empty,empty,redstone,empty,empty,
                        empty,empty,pickaxehead,empty,empty,
                        empty,empty,empty,empty,empty,
                        empty,empty,empty,empty,empty },
                new ItemStack(ModItems.pickaxehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new String[] {
                        empty,empty,empty,empty,empty,
                        empty,empty,lapis,empty,empty,
                        empty,empty,pickaxehead,empty,empty,
                        empty,empty,empty,empty,empty,
                        empty,empty,empty,empty,empty },
                new ItemStack(ModItems.pickaxehead, 1),
                "lapis"
        );

        /*** Axe Head ***/
        AnvilCrafting.addRecipe(
                new String[] {
                        empty,hotChunk,hotChunk,empty,empty,
                        empty,hotChunk,hotChunk,hotChunk,empty,
                        empty,hotChunk,hotChunk,hotChunk,empty,
                        empty,hotChunk,empty,empty,empty,
                        empty,empty,empty,empty,empty },
                new ItemStack(ModItems.ironaxehead, 1),
                "null"
        );

        /*** Emerald Upgrade to Axe Head ***/
        AnvilCrafting.addRecipe(
                new String[] {
                        empty,empty,empty,empty,empty,
                        empty,empty,emeraldShard,empty,empty,
                        empty,empty,ironaxehead,empty,empty,
                        empty,empty,empty,empty,empty,
                        empty,empty,empty,empty,empty },
                new ItemStack(ModItems.ironaxehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Axe Head ***/
        AnvilCrafting.addRecipe(
                new String[] {
                        empty,empty,empty,empty,empty,
                        empty,empty,diamondShard,empty,empty,
                        empty,empty,ironaxehead,empty,empty,
                        empty,empty,empty,empty,empty,
                        empty,empty,empty,empty,empty },
                new ItemStack(ModItems.ironaxehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Axe Head ***/
        AnvilCrafting.addRecipe(
                new String[] {
                        empty,empty,empty,empty,empty,
                        empty,empty,redstone,empty,empty,
                        empty,empty,ironaxehead,empty,empty,
                        empty,empty,empty,empty,empty,
                        empty,empty,empty,empty,empty },
                new ItemStack(ModItems.ironaxehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Axe Head ***/
        AnvilCrafting.addRecipe(
                new String[] {
                        empty,empty,empty,empty,empty,
                        empty,empty,lapis,empty,empty,
                        empty,empty,ironaxehead,empty,empty,
                        empty,empty,empty,empty,empty,
                        empty,empty,empty,empty,empty },
                new ItemStack(ModItems.ironaxehead, 1),
                "lapis"
        );

    }
}
