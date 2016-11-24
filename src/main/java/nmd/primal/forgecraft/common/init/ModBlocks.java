package nmd.primal.forgecraft.common.init;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import nmd.primal.core.common.PrimalCore;
import nmd.primal.core.common.blocks.lighting.IgnisFatuus;
import nmd.primal.core.common.blocks.lighting.JackOLanern;
import nmd.primal.core.common.blocks.lighting.Lantern;
import nmd.primal.core.common.blocks.lighting.Torch;
import nmd.primal.core.common.blocks.parts.*;
import nmd.primal.core.common.blocks.plants.*;
import nmd.primal.core.common.blocks.soil.*;
import nmd.primal.core.common.blocks.stone.*;
import nmd.primal.core.common.blocks.storage.*;
import nmd.primal.core.common.items.block.ItemAshBlock;
import nmd.primal.core.common.items.block.ItemTorchBlock;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import static nmd.primal.core.api.PrimalBlocks.*;

public class ModBlocks
{
    public static final Set<Block> BLOCKS = new HashSet<>();

    /*******************************************************************************
     * Blocks
     */
    public static void registerBlocks()
    {
        // ***************************************************************************** //
        //  Thatch and Basic Building Materials
        ///
        THATCH_WET              = registerBlock("thatch_wet", new ThatchWet());
        THATCH                  = registerBlock("thatch", new Thatch());

        NETHER_WOOL             = registerBlock("nether_wool", new NetherWool());
        GRATED_GRAVEL           = registerBlock("grated_gravel", new GratedGravel());

        ASH_BLOCK               = registerBlock("ash_block", new AshBlock(), "blockAsh");
        ASH_LAYER               = registerBlock("ash_layer", new AshLayer(), ItemAshBlock::new);
        ASH_STABILIZED          = registerBlock("ash_stabilized", new AshStabilized(), "blockAsh");
        EARTHWAX_BLOCK          = registerBlock("earthwax_block", new EarthWax().setHardness(1.2F).setResistance(0.8F), "blockFuel");
        TERRACLAY_BLOCK         = registerBlock("terraclay_block", new TerraClay().setHardness(2.2F).setResistance(1.5F), "blockTerra");
        CINISCLAY_BLOCK         = registerBlock("cinisclay_block", new TerraClay().setHardness(2.2F).setResistance(1.5F), "blockTerra");

        DIRT_BRICK              = registerBlock("dirt_brick", new Solum().setHardness(0.9F).setResistance(0.5F));
        MUD_BRICK_DRY           = registerBlock("mud_brick_dry", new Saxum().setHardness(1.6F).setResistance(1.6F));
        MUD_BLOCK_DRY           = registerBlock("mud_block_dry", new Saxum().setHardness(1.2F).setResistance(1.2F));
        MUD_BRICK_WET           = registerBlock("mud_brick_wet", new MudWet().setHardness(1.0F).setResistance(1.0F));
        MUD_BLOCK_WET           = registerBlock("mud_block_wet", new MudWet().setHardness(1.0F).setResistance(1.0F));

        CINISCOTTA_BRICK        = registerBlock("ciniscotta_brick", new Saxum().setHardness(1.2F).setResistance(2.0F), "blockCotta");
        TERRACOTTA_BRICK        = registerBlock("terracotta_brick", new Saxum().setHardness(1.2F).setResistance(2.0F), "blockCotta");

        CARBONATE_STONE         = registerBlock("carbonate_stone", new CarbonateStone().setHardness(1.5F).setResistance(10.0F), "blockLimestone");
        CARBONATE_FLAG          = registerBlock("carbonate_flag", new Saxum().setHardness(2.0F).setResistance(10.0F), "blockLimestone");
        CARBONATE_BRICK         = registerBlock("carbonate_brick", new Saxum().setHardness(2.0F).setResistance(10.0F), "blockLimestone");

        FERRO_STONE             = registerBlock("ferro_stone", new CarbonateStone().setHardness(1.5F).setResistance(10.0F), "blockLimestone");
        FERRO_FLAG              = registerBlock("ferro_flag", new Saxum().setHardness(2.0F).setResistance(10.0F), "blockLimestone");
        FERRO_BRICK             = registerBlock("ferro_brick", new Saxum().setHardness(2.0F).setResistance(10.0F), "blockLimestone");

        NETHERPALM_LOG          = registerBlock("netherpalm_log", new NetherPalm().setHardness(5.0F).setResistance(10.0F));
        NETHERPALM_PLANK        = registerBlock("netherpalm_plank", new WoodPlank().setHardness(5.0F).setResistance(10.0F));
        IRONWOOD_LEAVES         = registerBlock("ironwood_leaves", new TreeLeaves());
        IRONWOOD_LOG            = registerBlock("ironwood_log", new WoodLog().setHardness(5.0F).setResistance(10.0F));
        IRONWOOD_PLANK          = registerBlock("ironwood_plank", new WoodPlank().setHardness(5.0F).setResistance(10.0F));
        NETHERSTONE             = registerBlock("netherstone", new Saxum().setHardness(2.2F).setResistance(1.5F));

        SOULSTONE_NORMAL        = registerBlock("soulstone_normal", new SoulStone(), "blockSoulstone");
        SOULSTONE_SMOOTH        = registerBlock("soulstone_smooth", new SoulStone(), "blockSoulstone");
        SOULSTONE_CHISELED      = registerBlock("soulstone_chiseled", new SoulStone(), "blockSoulstone");
        SOULSTONE_FLAGSTONE     = registerBlock("soulstone_flagstone", new SoulStone(), "blockSoulstone");

        CLEAN_OAK               = registerBlock("clean_oak", new CleanOak(), "blockCleanOak");
        CLEAN_BIRCH             = registerBlock("clean_birch", new CleanBirch(), "blockCleanBirch");
        CLEAN_SPRUCE            = registerBlock("clean_spruce", new CleanSpruce(), "blockCleanSpruce");
        CLEAN_JUNGLE            = registerBlock("clean_jungle", new CleanJungle(), "blockCleanJungle");
        CLEAN_BIG_OAK           = registerBlock("clean_big_oak", new CleanBigOak(), "blockCleanBigOak");
        CLEAN_ACACIA            = registerBlock("clean_acacia", new CleanAcacia(), "blockCleanAcacia");
        CLEAN_IRONWOOD          = registerBlock("clean_ironwood", new CleanIronwood(), "blockCleanIronwood");
    }

    public static void registerSubBlocks()
    {
        ///
        //  Thin PrimalFacing
        ///

        ///
        //  Slats
        ///
        SLAT_ACACIA             = registerBlock("slat_acacia", new Slats(Blocks.PLANKS.getDefaultState()));
        SLAT_BIGOAK             = registerBlock("slat_bigoak", new Slats(Blocks.PLANKS.getDefaultState()));
        SLAT_BIRCH              = registerBlock("slat_birch", new Slats(Blocks.PLANKS.getDefaultState()));
        SLAT_JUNGLE             = registerBlock("slat_jungle", new Slats(Blocks.PLANKS.getDefaultState()));
        SLAT_OAK                = registerBlock("slat_oak", new Slats(Blocks.PLANKS.getDefaultState()));
        SLAT_SPRUCE             = registerBlock("slat_spruce", new Slats(Blocks.PLANKS.getDefaultState()));
        SLAT_IRON               = registerBlock("slat_iron", new Slats(Blocks.IRON_BLOCK.getDefaultState()));
        SLAT_NETHERPALM         = registerBlock("slat_netherpalm", new Slats(NETHERPALM_PLANK.getDefaultState()));
        SLAT_IRONWOOD           = registerBlock("slat_ironwood", new Slats(IRONWOOD_PLANK.getDefaultState()));

        ///
        //  Stairs
        ///
        STAIRS_DIRT                 = registerBlock("stairs_dirt", new Stairs(Blocks.DIRT.getDefaultState(), true));
        STAIRS_GRASS                = registerBlock("stairs_grass", new Stairs(Blocks.GRASS.getDefaultState(), true), true);
        STAIRS_NETHERRACK           = registerBlock("stairs_netherrack", new Stairs(Blocks.NETHERRACK.getDefaultState(), true), true);
        STAIRS_MUD                  = registerBlock("stairs_mud", new Stairs(MUD_BLOCK_DRY.getDefaultState(), true));
        STAIRS_NETHERPALM           = registerBlock("stairs_nether_palm", new Stairs(NETHERPALM_PLANK.getDefaultState(), true), true);
        STAIRS_IRONWOOD             = registerBlock("stairs_ironwood", new Stairs(IRONWOOD_PLANK.getDefaultState(), true), true);
        STAIRS_CARBONATE_FLAG       = registerBlock("stairs_carbonate_flag", new Stairs(CARBONATE_FLAG.getDefaultState()), "blockStair");
        STAIRS_CARBONATE_BRICK      = registerBlock("stairs_carbonate_brick", new Stairs(CARBONATE_BRICK.getDefaultState()).setHardness(2.0F).setResistance(10.0F), "blockStair");
        STAIRS_FERRO_FLAG           = registerBlock("stairs_ferro_flag", new Stairs(FERRO_FLAG.getDefaultState()), "blockStair");
        STAIRS_FERRO_BRICK          = registerBlock("stairs_ferro_brick", new Stairs(FERRO_BRICK.getDefaultState()).setHardness(2.0F).setResistance(10.0F), "blockStair");
        STAIRS_COBBLESTONE_MOSSY    = registerBlock("stairs_cobblestone_mossy", new Stairs(Blocks.COBBLESTONE.getDefaultState()).setHardness(2.0F).setResistance(10.0F), "blockStair");
        STAIRS_STONEBRICK_MOSSY     = registerBlock("stairs_stonebrick_mossy", new Stairs(Blocks.STONEBRICK.getDefaultState()).setHardness(2.0F).setResistance(10.0F), "blockStair");

        ///
        //  Wall
        ///
        WALL_NETHERRACK         = registerBlock("wall_netherrack", new Wall(Blocks.NETHERRACK.getDefaultState()), "blockWall");
        WALL_NETHERSTONE        = registerBlock("wall_netherstone", new Wall(NETHERSTONE.getDefaultState()), "blockWall");
        WALL_CARBONATE_FLAG     = registerBlock("wall_carbonate_flag", new Wall(CARBONATE_FLAG.getDefaultState()), "blockWall");
        WALL_CARBONATE_BRICK    = registerBlock("wall_carbonate_brick", new Wall(CARBONATE_BRICK.getDefaultState()), "blockWall");
        WALL_FERRO_FLAG         = registerBlock("wall_ferro_flag", new Wall(CARBONATE_FLAG.getDefaultState()), "blockWall");
        WALL_FERRO_BRICK        = registerBlock("wall_ferro_brick", new Wall(CARBONATE_BRICK.getDefaultState()), "blockWall");

        ///
        //  Fence
        ///
        FENCE_IRONWOOD          = registerBlock("fence_ironwood", new Fence(IRONWOOD_PLANK.getDefaultState()));
        FENCE_NETHERPALM        = registerBlock("fence_netherpalm", new Fence(NETHERPALM_PLANK.getDefaultState()));
        //GATE_IRONWOOD           = registerBlock(new Gates("gate_ironwood", IRONWOOD_PLANK.getDefaultState()));
        //GATE_NETHERPALM         = registerBlock(new Gates("gate_netherpalm", NETHERPALM_PLANK.getDefaultState()));

        ///
        //  Pressure Plates
        ///
        PRESSPLATE_DIRT         = registerBlock("pressplate_dirt", new PressurePlate(Blocks.DIRT.getDefaultState(), BlockPressurePlate.Sensitivity.EVERYTHING)).setHardness(0.5F).setResistance(0.0F);
        PRESSPLATE_GRASS        = registerBlock("pressplate_grass", new PressurePlate(Blocks.GRASS.getDefaultState(), BlockPressurePlate.Sensitivity.EVERYTHING)).setHardness(0.6F).setResistance(0.0F);
        PRESSPLATE_GLASS        = registerBlock("pressplate_glass", new PressurePlate(Blocks.GLASS.getDefaultState(), BlockPressurePlate.Sensitivity.EVERYTHING)).setHardness(0.3F).setResistance(0.0F);
        PRESSPLATE_NETHERRACK   = registerBlock("pressplate_netherrack", new PressurePlate(Blocks.NETHERRACK.getDefaultState(), BlockPressurePlate.Sensitivity.EVERYTHING)).setHardness(2.0F).setResistance(10.0F);
        PRESSPLATE_NETHERPALM   = registerBlock("pressplate_netherpalm", new PressurePlate(NETHERPALM_PLANK.getDefaultState(), BlockPressurePlate.Sensitivity.EVERYTHING)).setHardness(2.0F).setResistance(5.0F);
        PRESSPLATE_IRONWOOD     = registerBlock("pressplate_ironwood", new PressurePlate(IRONWOOD_PLANK.getDefaultState(), BlockPressurePlate.Sensitivity.EVERYTHING)).setHardness(2.0F).setResistance(5.0F);
        PRESSPLATE_THATCH       = registerBlock("pressplate_thatch", new PressurePlateFacing(THATCH.getDefaultState(), BlockPressurePlate.Sensitivity.EVERYTHING)).setHardness(2.0F).setResistance(5.0F);

        ///
        //  Lever, Misc
        ///
        LEVER_WOOD              = registerBlock("lever_wood", new Lever(), "blockLever");
        LEVER_NETHER            = registerBlock("lever_nether", new Lever(), "blockLever");
    }

    public static void registerPlants()
    {
        ///
        //  Solum Blocks
        ///
        LOAM_BLOCK              = registerBlock("loam_block", new Loam().setHardness(1.2F).setResistance(1.2F));

        ///
        //  Plants
        ///
        RUSHES                  = registerBlock("rush", new Rushes());
        CORN_STALK              = registerBlock("corn_stalk", new CornStalk());
        STRANGLE_WEED           = registerBlock("strangle_weed", new StrangleWeed());
        //NETHER_GRASS            = registerBlock(new NetherGrass("nether_grass"));
        //NETHER_GRASS_GROWING    = registerBlock(new NetherGrassGrowing("nether_grass_growing"));
        //SEARING_LACE            = registerBlock(new SearingLace("searing_lace"));
        //SEARING_LACE_GROWING    = registerBlock(new SearingLaceGrowing("searing_lace_growing"));
    }

    public static void registerOres()
    {
        ///
        //  ..
        ///
        ORE_IRON            = registerBlock("ore_iron", new OreDensity().setHardness(4.0F).setResistance(15.0F));

        ///
        //  Ferrum Storage Blocks
        ///
        BRASS_BLOCK         = registerBlock("brass_block", new Ferrum().setHardness(4.0F).setResistance(15.0F), "blockBrass");
        BRONZE_BLOCK        = registerBlock("bronze_block", new Ferrum().setHardness(4.0F).setResistance(15.0F), "blockBronze");
        COPPER_BLOCK        = registerBlock("copper_block", new Ferrum().setHardness(3.0F).setResistance(10.0F), "blockCopper");
        LEAD_BLOCK          = registerBlock("lead_block", new Ferrum().setHardness(2.0F).setResistance(18.0F), "blockLead");
        PIGIRON_BLOCK       = registerBlock("pigiron_block", new Ferrum().setHardness(5.0F).setResistance(10.0F), "blockPigiron");
        SILVER_BLOCK        = registerBlock("silver_block", new Ferrum().setHardness(5.0F).setResistance(12.0F), "blockSilver");
        TIN_BLOCK           = registerBlock("tin_block", new Ferrum().setHardness(2.0F).setResistance(10.0F), "blockTin");
        VANADIUM_BLOCK      = registerBlock("vanadium_block", new Ferrum().setHardness(10.0F).setResistance(20.0F), "blockVanadium");
        WOOTZ_BLOCK         = registerBlock("wootz_block", new Ferrum().setHardness(8.0F).setResistance(16.0F), "blockWootz");
        ZINC_BLOCK          = registerBlock("zinc_block", new Ferrum().setHardness(2.5F).setResistance(10.0F), "blockZinc");

        ///
        //  Salt Ores
        ///
        SALT_HALITE_BLOCK   = registerBlock("salt_halite_block", new SaltFlat(), "blockSalt");
        SALT_NETJRY_BLOCK   = registerBlock("salt_netjry_block", new SaltFlat(), "blockSalt");
        SALT_FIRE_BLOCK     = registerBlock("salt_fire_block", new SaltFlat(), "blockSalt");
        SALT_VOID_BLOCK     = registerBlock("salt_void_block", new SaltFlat(), "blockSalt");
    }

    public static void registerTablesShelves()
    {
        ///
        //  Worktables + Shelves
        ///
        WORKTABLE_SANDSTONE     = registerBlock("worktable_sandstone", new WorkTableShelf(Blocks.SANDSTONE.getDefaultState()));
        WORKTABLE_NETHERSTONE   = registerBlock("worktable_netherstone", new WorkTableShelf(NETHERSTONE.getDefaultState()));
        WORKTABLE_END           = registerBlock("worktable_endstone", new WorkTableShelf(Blocks.END_STONE.getDefaultState()));
        WORKTABLE_MUD           = registerBlock("worktable_mud", new WorkTableShelf(MUD_BLOCK_DRY.getDefaultState()));
        WORKTABLE_ACACIA_LOG    = registerBlock("worktable_acacia_log", new WorkTableShelf(Blocks.LOG.getDefaultState()));
        WORKTABLE_BIGOAK_LOG    = registerBlock("worktable_bigoak_log", new WorkTableShelf(Blocks.LOG.getDefaultState()));
        WORKTABLE_BIRCH_LOG     = registerBlock("worktable_birch_log", new WorkTableShelf(Blocks.LOG.getDefaultState()));
        WORKTABLE_JUNGLE_LOG    = registerBlock("worktable_jungle_log", new WorkTableShelf(Blocks.LOG.getDefaultState()));
        WORKTABLE_OAK_LOG       = registerBlock("worktable_oak_log", new WorkTableShelf(Blocks.LOG.getDefaultState()));
        WORKTABLE_SPRUCE_LOG    = registerBlock("worktable_spruce_log", new WorkTableShelf(Blocks.LOG.getDefaultState()));
        WORKTABLE_IRONWOOD_LOG  = registerBlock("worktable_ironwood_log", new WorkTableShelf(IRONWOOD_LOG.getDefaultState()));

        ///
        //  Worktable PrimalFacing
        ///
        WORKTABLE_MUD_SLAB      = registerBlock("worktable_mud_slab", new WorkTableSlab(MUD_BLOCK_DRY.getDefaultState()));
        WORKTABLE_ACACIA        = registerBlock("worktable_acacia", new WorkTableSlab(Blocks.PLANKS.getDefaultState()));
        WORKTABLE_BIGOAK        = registerBlock("worktable_bigoak", new WorkTableSlab(Blocks.PLANKS.getDefaultState()));
        WORKTABLE_BIRCH         = registerBlock("worktable_birch", new WorkTableSlab(Blocks.PLANKS.getDefaultState()));
        WORKTABLE_JUNGLE        = registerBlock("worktable_jungle", new WorkTableSlab(Blocks.PLANKS.getDefaultState()));
        WORKTABLE_OAK           = registerBlock("worktable_oak", new WorkTableSlab(Blocks.PLANKS.getDefaultState()));
        WORKTABLE_SPRUCE        = registerBlock("worktable_spruce", new WorkTableSlab(Blocks.PLANKS.getDefaultState()));
        WORKTABLE_NETHERPALM    = registerBlock("worktable_netherpalm", new WorkTableSlab(NETHERPALM_PLANK.getDefaultState()));
        WORKTABLE_IRONWOOD      = registerBlock("worktable_ironwood", new WorkTableSlab(IRONWOOD_PLANK.getDefaultState()));

        ///
        //  Shelves
        ///
        SHELF_FULL_ACACIA       = registerBlock("shelf_full_acacia", new ShelfBasic(Blocks.PLANKS.getDefaultState()));
        SHELF_FULL_BIGOAK       = registerBlock("shelf_full_bigoak", new ShelfBasic(Blocks.PLANKS.getDefaultState()));
        SHELF_FULL_BIRCH        = registerBlock("shelf_full_birch", new ShelfBasic(Blocks.PLANKS.getDefaultState()));
        SHELF_FULL_END          = registerBlock("shelf_full_end", new ShelfBasic(Blocks.END_STONE.getDefaultState()));
        SHELF_FULL_IRONWOOD     = registerBlock("shelf_full_ironwood", new ShelfBasic(IRONWOOD_PLANK.getDefaultState()));
        SHELF_FULL_JUNGLE       = registerBlock("shelf_full_jungle", new ShelfBasic(Blocks.PLANKS.getDefaultState()));
        SHELF_FULL_OAK          = registerBlock("shelf_full_oak", new ShelfBasic(Blocks.PLANKS.getDefaultState()));
        SHELF_FULL_MUD          = registerBlock("shelf_full_mud", new ShelfBasic(MUD_BLOCK_DRY.getDefaultState()));
        SHELF_FULL_NETHERPALM   = registerBlock("shelf_full_netherpalm", new ShelfBasic(NETHERPALM_PLANK.getDefaultState()));
        SHELF_FULL_NETHERRACK   = registerBlock("shelf_full_netherrack", new ShelfBasic(Blocks.NETHERRACK.getDefaultState()));
        SHELF_FULL_NETHERSTONE  = registerBlock("shelf_full_netherstone", new ShelfBasic(NETHERSTONE.getDefaultState()));
        SHELF_FULL_SANDSTONE    = registerBlock("shelf_full_sandstone", new ShelfBasic(Blocks.SANDSTONE.getDefaultState()));
        SHELF_FULL_SPRUCE       = registerBlock("shelf_full_spruce", new ShelfBasic(Blocks.PLANKS.getDefaultState()));

        SHELF_HALF_ACACIA       = registerBlock("shelf_half_acacia", new ShelfHalf(Blocks.PLANKS.getDefaultState()));
        SHELF_HALF_BIGOAK       = registerBlock("shelf_half_bigoak", new ShelfHalf(Blocks.PLANKS.getDefaultState()));
        SHELF_HALF_BIRCH        = registerBlock("shelf_half_birch", new ShelfHalf(Blocks.PLANKS.getDefaultState()));
        SHELF_HALF_END          = registerBlock("shelf_half_end", new ShelfHalf(Blocks.END_STONE.getDefaultState()));
        SHELF_HALF_IRONWOOD     = registerBlock("shelf_half_ironwood", new ShelfHalf(IRONWOOD_PLANK.getDefaultState()));
        SHELF_HALF_JUNGLE       = registerBlock("shelf_half_jungle", new ShelfHalf(Blocks.PLANKS.getDefaultState()));
        SHELF_HALF_OAK          = registerBlock("shelf_half_oak", new ShelfHalf(Blocks.PLANKS.getDefaultState()));
        SHELF_HALF_MUD          = registerBlock("shelf_half_mud", new ShelfHalf(MUD_BLOCK_DRY.getDefaultState()));
        SHELF_HALF_NETHERPALM   = registerBlock("shelf_half_netherpalm", new ShelfHalf(NETHERPALM_PLANK.getDefaultState()));
        SHELF_HALF_NETHERRACK   = registerBlock("shelf_half_netherrack", new ShelfHalf(Blocks.NETHERRACK.getDefaultState()));
        SHELF_HALF_NETHERSTONE  = registerBlock("shelf_half_netherstone", new ShelfHalf(NETHERSTONE.getDefaultState()));
        SHELF_HALF_SANDSTONE    = registerBlock("shelf_half_sandstone", new ShelfHalf(Blocks.SANDSTONE.getDefaultState()));
        SHELF_HALF_SPRUCE       = registerBlock("shelf_half_spruce", new ShelfHalf(Blocks.PLANKS.getDefaultState()));

        ///
        //  Drying Racks
        ///
        DRYING_RACK_ACACIA      = registerBlock("drying_rack_acacia", new DryingRack(Blocks.PLANKS.getDefaultState()));
        DRYING_RACK_BIGOAK      = registerBlock("drying_rack_bigoak", new DryingRack(Blocks.PLANKS.getDefaultState()));
        DRYING_RACK_BIRCH       = registerBlock("drying_rack_birch", new DryingRack(Blocks.PLANKS.getDefaultState()));
        DRYING_RACK_IRONWOOD    = registerBlock("drying_rack_ironwood", new DryingRack(IRONWOOD_PLANK.getDefaultState()));
        DRYING_RACK_JUNGLE      = registerBlock("drying_rack_jungle", new DryingRack(Blocks.PLANKS.getDefaultState()));
        DRYING_RACK_OAK         = registerBlock("drying_rack_oak", new DryingRack(Blocks.PLANKS.getDefaultState()));
        DRYING_RACK_NETHERPALM  = registerBlock("drying_rack_netherpalm", new DryingRack(NETHERPALM_PLANK.getDefaultState()));
        DRYING_RACK_SPRUCE      = registerBlock("drying_rack_spruce", new DryingRack(Blocks.PLANKS.getDefaultState()));

        FISH_TRAP_ACACIA      = registerBlock("fish_trap_acacia", new FishTrap());
        FISH_TRAP_BIGOAK      = registerBlock("fish_trap_bigoak", new FishTrap());
        FISH_TRAP_BIRCH       = registerBlock("fish_trap_birch", new FishTrap());
        FISH_TRAP_IRONWOOD    = registerBlock("fish_trap_ironwood", new FishTrap());
        FISH_TRAP_JUNGLE      = registerBlock("fish_trap_jungle", new FishTrap());
        FISH_TRAP_OAK         = registerBlock("fish_trap_oak", new FishTrap());
        FISH_TRAP_NETHERPALM  = registerBlock("fish_trap_netherpalm", new FishTrap(Material.LAVA));
        FISH_TRAP_SPRUCE      = registerBlock("fish_trap_spruce", new FishTrap());

        ///
        //  Slabs
        ///
        SLAB_CARBONATE_BRICK   = registerBlock("slab_carbonate_brick", new SlabFull(CARBONATE_BRICK.getDefaultState()));
        SLAB_CARBONATE_FLAG    = registerBlock("slab_carbonate_flag", new SlabFull(CARBONATE_FLAG.getDefaultState()));
        SLAB_ENDBRICK          = registerBlock("slab_endbrick", new SlabFull(Blocks.END_BRICKS.getDefaultState()));
        SLAB_ENDSTONE          = registerBlock("slab_endstone", new SlabFull(Blocks.END_STONE.getDefaultState()));
        SLAB_FERRO_BRICK       = registerBlock("slab_ferro_brick", new SlabFull(FERRO_BRICK.getDefaultState()));
        SLAB_FERRO_FLAG        = registerBlock("slab_ferro_flag", new SlabFull(FERRO_FLAG.getDefaultState()));
        SLAB_GLASS             = registerBlock("slab_glass", new SlabFull(Blocks.GLASS.getDefaultState()));
        SLAB_IRONWOOD          = registerBlock("slab_ironwood", new SlabFull(IRONWOOD_PLANK.getDefaultState()));
        SLAB_MUD               = registerBlock("slab_mud", new SlabFull(MUD_BLOCK_DRY.getDefaultState()));
        //SLAB_NETHERBRICK       = registerBlock("slab_netherbrick", new SlabFull(Blocks.NETHER_BRICK.getDefaultState()));
        SLAB_NETHERPALM        = registerBlock("slab_netherpalm", new SlabFull(NETHERPALM_PLANK.getDefaultState()));
        SLAB_NETHERRACK        = registerBlock("slab_netherrack", new SlabFull(Blocks.NETHERRACK.getDefaultState()));
        SLAB_NETHERSTONE       = registerBlock("slab_netherstone", new SlabFull(NETHERSTONE.getDefaultState()));
        //SLAB_SANDSTONE         = registerBlock("slab_sandstone", new SlabFull(Blocks.SANDSTONE.getDefaultState()));
        SLAB_SOULSTONE          = registerBlock("slab_soulstone", new SlabFull(SOULSTONE_SMOOTH.getDefaultState()));
        SLAB_STONEBRICK_MOSSY   = registerBlock("slab_stonebrick_mossy", new SlabFull(Blocks.STONEBRICK.getDefaultState()));

        ///
        //  Thin Slabs
        ///
        THIN_SLAB_ACACIA            = registerBlock("thin_slab_acacia", new ThinSlab(Blocks.PLANKS.getDefaultState()));
        THIN_SLAB_BIGOAK            = registerBlock("thin_slab_bigoak", new ThinSlab(Blocks.PLANKS.getDefaultState()));
        THIN_SLAB_BIRCH             = registerBlock("thin_slab_birch", new ThinSlab(Blocks.PLANKS.getDefaultState()));
        THIN_SLAB_CARBONATE_BRICK   = registerBlock("thin_slab_carbonate_brick", new ThinSlab(CARBONATE_BRICK.getDefaultState()));
        THIN_SLAB_CARBONATE_FLAG    = registerBlock("thin_slab_carbonate_flag", new ThinSlab(CARBONATE_FLAG.getDefaultState()));
        THIN_SLAB_ENDBRICK          = registerBlock("thin_slab_endbrick", new ThinSlab(Blocks.END_BRICKS.getDefaultState()));
        THIN_SLAB_ENDSTONE          = registerBlock("thin_slab_endstone", new ThinSlab(Blocks.END_STONE.getDefaultState()));
        THIN_SLAB_FERRO_BRICK       = registerBlock("thin_slab_ferro_brick", new ThinSlab(FERRO_BRICK.getDefaultState()));
        THIN_SLAB_FERRO_FLAG        = registerBlock("thin_slab_ferro_flag", new ThinSlab(FERRO_FLAG.getDefaultState()));
        THIN_SLAB_GLASS             = registerBlock("thin_slab_glass", new ThinSlab(Blocks.GLASS.getDefaultState()));
        THIN_SLAB_IRONWOOD          = registerBlock("thin_slab_ironwood", new ThinSlab(IRONWOOD_PLANK.getDefaultState()));
        THIN_SLAB_JUNGLE            = registerBlock("thin_slab_jungle", new ThinSlab(Blocks.PLANKS.getDefaultState()));
        THIN_SLAB_MUD               = registerBlock("thin_slab_mud", new ThinSlab(MUD_BLOCK_DRY.getDefaultState()));
        THIN_SLAB_NETHERBRICK       = registerBlock("thin_slab_netherbrick", new ThinSlab(Blocks.NETHER_BRICK.getDefaultState()));
        THIN_SLAB_NETHERPALM        = registerBlock("thin_slab_netherpalm", new ThinSlab(NETHERPALM_PLANK.getDefaultState()));
        THIN_SLAB_NETHERRACK        = registerBlock("thin_slab_netherrack", new ThinSlab(Blocks.NETHERRACK.getDefaultState()));
        THIN_SLAB_NETHERSTONE       = registerBlock("thin_slab_netherstone", new ThinSlab(NETHERSTONE.getDefaultState()));
        THIN_SLAB_OAK               = registerBlock("thin_slab_oak", new ThinSlab(Blocks.PLANKS.getDefaultState()));
        THIN_SLAB_SANDSTONE         = registerBlock("thin_slab_sandstone", new ThinSlab(Blocks.SANDSTONE.getDefaultState()));
        THIN_SLAB_SOULSTONE         = registerBlock("thin_slab_soulstone", new ThinSlab(SOULSTONE_SMOOTH.getDefaultState()));
        THIN_SLAB_SPRUCE            = registerBlock("thin_slab_spruce", new ThinSlab(Blocks.PLANKS.getDefaultState()));
        THIN_SLAB_STONEBRICK        = registerBlock("thin_slab_stonebrick", new ThinSlab(Blocks.STONEBRICK.getDefaultState()));
        THIN_SLAB_STONEBRICK_MOSSY  = registerBlock("thin_slab_stonebrick_mossy", new ThinSlab(Blocks.STONEBRICK.getDefaultState()));
        THIN_SLAB_THATCH            = registerBlock("thin_slab_thatch", new ThinSlab(THATCH.getDefaultState(), true));

        ///
        //  Smoke Grates
        ///
        GRATE_ACACIA                = registerBlock("grate_acacia", new SmokeGrate(Blocks.PLANKS.getDefaultState()));
        GRATE_BIGOAK                = registerBlock("grate_bigoak", new SmokeGrate(Blocks.PLANKS.getDefaultState()));
        GRATE_BIRCH                 = registerBlock("grate_birch", new SmokeGrate(Blocks.PLANKS.getDefaultState()));
        GRATE_CARBONATE_BRICK       = registerBlock("grate_carbonate_brick", new SmokeGrate(CARBONATE_BRICK.getDefaultState()));
        GRATE_CARBONATE_FLAG        = registerBlock("grate_carbonate_flag", new SmokeGrate(CARBONATE_FLAG.getDefaultState()));
        GRATE_ENDBRICK              = registerBlock("grate_endbrick", new SmokeGrate(Blocks.END_BRICKS.getDefaultState()));
        GRATE_ENDSTONE              = registerBlock("grate_endstone", new SmokeGrate(Blocks.END_STONE.getDefaultState()));
        GRATE_FERRO_BRICK           = registerBlock("grate_ferro_brick", new SmokeGrate(FERRO_BRICK.getDefaultState()));
        GRATE_FERRO_FLAG            = registerBlock("grate_ferro_flag", new SmokeGrate(FERRO_FLAG.getDefaultState()));
        GRATE_IRONWOOD              = registerBlock("grate_ironwood", new SmokeGrate(IRONWOOD_PLANK.getDefaultState()));
        GRATE_JUNGLE                = registerBlock("grate_jungle", new SmokeGrate(Blocks.PLANKS.getDefaultState()));
        GRATE_MUD                   = registerBlock("grate_mud", new SmokeGrate(MUD_BLOCK_DRY.getDefaultState()));
        GRATE_NETHERBRICK           = registerBlock("grate_netherbrick", new SmokeGrate(Blocks.NETHER_BRICK.getDefaultState()));
        GRATE_NETHERPALM            = registerBlock("grate_netherpalm", new SmokeGrate(NETHERPALM_PLANK.getDefaultState()));
        GRATE_NETHERRACK            = registerBlock("grate_netherrack", new SmokeGrate(Blocks.NETHERRACK.getDefaultState()));
        GRATE_NETHERSTONE           = registerBlock("grate_netherstone", new SmokeGrate(NETHERSTONE.getDefaultState()));
        GRATE_OAK                   = registerBlock("grate_oak", new SmokeGrate(Blocks.PLANKS.getDefaultState()));
        GRATE_SANDSTONE             = registerBlock("grate_sandstone", new SmokeGrate(Blocks.SANDSTONE.getDefaultState()));
        GRATE_SOULSTONE             = registerBlock("grate_soulstone", new SmokeGrate(SOULSTONE_SMOOTH.getDefaultState()));
        GRATE_SPRUCE                = registerBlock("grate_spruce", new SmokeGrate(Blocks.PLANKS.getDefaultState()));
        GRATE_STONEBRICK            = registerBlock("grate_stonebrick", new SmokeGrate(Blocks.STONEBRICK.getDefaultState()));
        GRATE_STONEBRICK_MOSSY      = registerBlock("grate_stonebrick_mossy", new SmokeGrate(Blocks.STONEBRICK.getDefaultState()));
        GRATE_THATCH                = registerBlock("grate_thatch", new SmokeGrate(THATCH.getDefaultState(), true));

        DRAIN_CARBONATE_BRICK       = registerBlock("drain_carbonate_brick", new Drain(CARBONATE_BRICK.getDefaultState()));
        DRAIN_CARBONATE_FLAG        = registerBlock("drain_carbonate_flag", new Drain(CARBONATE_FLAG.getDefaultState()));
        DRAIN_ENDBRICK              = registerBlock("drain_endbrick", new Drain(Blocks.END_BRICKS.getDefaultState()));
        DRAIN_ENDSTONE              = registerBlock("drain_endstone", new Drain(Blocks.END_STONE.getDefaultState()));
        DRAIN_FERRO_BRICK           = registerBlock("drain_ferro_brick", new Drain(FERRO_BRICK.getDefaultState()));
        DRAIN_FERRO_FLAG            = registerBlock("drain_ferro_flag", new Drain(FERRO_FLAG.getDefaultState()));
        DRAIN_MUD                   = registerBlock("drain_mud", new Drain(MUD_BLOCK_DRY.getDefaultState()));
        DRAIN_NETHERBRICK           = registerBlock("drain_netherbrick", new Drain(Blocks.NETHER_BRICK.getDefaultState()));
        DRAIN_NETHERRACK            = registerBlock("drain_netherrack", new Drain(Blocks.NETHERRACK.getDefaultState()));
        DRAIN_NETHERSTONE           = registerBlock("drain_netherstone", new Drain(NETHERSTONE.getDefaultState()));
        DRAIN_STONE                 = registerBlock("drain_stone", new Drain(Blocks.STONE.getDefaultState()));
        DRAIN_STONEBRICK            = registerBlock("drain_stonebrick", new Drain(Blocks.STONEBRICK.getDefaultState()));
        DRAIN_STONEBRICK_MOSSY      = registerBlock("drain_stonebrick_mossy", new Drain(Blocks.STONEBRICK.getDefaultState()));
        DRAIN_THATCH                = registerBlock("drain_thatch", new Drain(THATCH.getDefaultState()));
    }

    public static void registerLighting()
    {
        ///
        //  Lanterns, Torch, etc
        ///
        LANTERN_EMPTY           = registerBlock("lantern_empty", new Lantern());
        LANTERN_TORCH           = registerBlock("lantern_torch", new Lantern(true, true, 0.8375F), false);
        LANTERN_NETHER          = registerBlock("lantern_nether", new Lantern(true, false, 0.7375F), false);
        LANTERN_REDSTONE        = registerBlock("lantern_redstone", new Lantern(true, false, 0.5F), false);
        LANTERN_IGNIS           = registerBlock("lantern_ignis", new Lantern(true, false, 0.8375F), false);

        TORCH_WOOD              = registerBlock("torch_wood", new Torch(0.9375F, ModConfig.LIGHTING_TORCH_BURN_CHANCE, true), ItemTorchBlock::new, "torchUnlit");
        TORCH_NETHER            = registerBlock("torch_nether", new Torch(0.8375F, 60, false), ItemTorchBlock::new, "torchUnlit");
        //TORCH_SMOKER          = registerBlock(new Torch("torch_smoker", 0.6375F, 500, true));
        IGNIS_FATUUS            = registerBlock("ignis_fatuus", new IgnisFatuus(), "torch");
        JACK_O_LANTERN          = registerBlock("jackolantern", new JackOLanern());
    }

    /*******************************************************************************
     * Block Registration Methods
     * https://github.com/Choonster/TestMod3/blob/1e3b9be1448a93ff1c6e3ef2e16fb4388eefc1a4/src/main/java/com/choonster/testmod3/init/ModBlocks.java#L94-L124
     */
    public static <BLOCK extends Block> BLOCK registerBlock(String name, BLOCK block, @Nullable Function<BLOCK, ItemBlock> itemFactory, @Nullable String dictionary_names, boolean hidden)
    {
        block.setRegistryName(name);
        block.setUnlocalizedName(block.getRegistryName().toString());

        ForgeRegistries.BLOCKS.register(block);
        //PrimalCore.proxy.renderBlock(block);
        BLOCKS.add(block);

        if (itemFactory != null)
        {
            //CommonUtils.debugLogger(2, "item register", "name: " + block.getRegistryName().toString().substring(7));
            ItemBlock item = itemFactory.apply(block);
            item.setRegistryName(block.getRegistryName().toString().substring(7));
            ForgeRegistries.ITEMS.register(item);
            PrimalCore.proxy.registerItemSided(item);
        } else {
            PrimalCore.proxy.registerItemSided(Item.getItemFromBlock(block));
        }

        if (dictionary_names != null)
        {
            String [] dictionary_name_array = dictionary_names.replaceAll("\\s+","").split(",");
            //List<String> name_list = Arrays.asList(names);
            for (String dictionary_name : dictionary_name_array) {
                OreDictionary.registerOre(dictionary_name, block);
            }
        }

        if (!hidden) {
            block.setCreativeTab(ModInfo.TAB_PRIMAL);
        }

        return block;
    }

    public static <BLOCK extends Block> BLOCK registerBlock(String name, BLOCK block) {
        return registerBlock(name, block, ItemBlock::new, null, false);
    }

    public static <BLOCK extends Block> BLOCK registerBlock(String name, BLOCK block, @Nullable String dictionary_names) {
        return registerBlock(name, block, ItemBlock::new, dictionary_names, false);
    }

    public static <BLOCK extends Block> BLOCK registerBlock(String name, BLOCK block, @Nullable Function<BLOCK, ItemBlock> itemFactory) {
        return registerBlock(name, block, itemFactory, null, false);
    }

    public static <BLOCK extends Block> BLOCK registerBlock(String name, BLOCK block, @Nullable Function<BLOCK, ItemBlock> itemFactory, @Nullable String dictionary_names) {
        return registerBlock(name, block, itemFactory, dictionary_names, false);
    }

    public static <BLOCK extends Block> BLOCK registerBlock(String name, BLOCK block, boolean hidden) {
        return registerBlock(name, block, ItemBlock::new, null, hidden);
    }

    public static <BLOCK extends Block> BLOCK registerBlock(String name, BLOCK block, @Nullable String dictionary_names, boolean hidden) {
        return registerBlock(name, block, ItemBlock::new, dictionary_names, hidden);
    }

    public static <BLOCK extends Block> BLOCK registerBlock(String name, BLOCK block, @Nullable Function<BLOCK, ItemBlock> itemFactory, boolean hidden) {
        return registerBlock(name, block, itemFactory, null, hidden);
    }
}