package nmd.primal.forgecraft.api;

import net.minecraft.item.Item;

///
//  import static nmd.primal.core.api.ForgeCraftItems.*;
///

public class ForgeCraftItems
{
    ///
    // Ores
    ///
    public static Item TEST;
    /*public static Item EARTHWAX_CLUMP;
    public static Item CINISCLAY_CLUMP;
    public static Item CINISCLAY;
    public static Item CINISCOTTA;
    public static Item TERRACLAY_CLUMP;
    public static Item TERRACLAY;
    public static Item TERRACOTTA;
    public static Item MUDBRICK_SOFT;
    public static Item MUDBRICK_DRY;
    public static Item CARBONATE_SLACK;
    public static Item CARBONATE_FERRO_SLACK;

    public static Item BRASS_DUST;
    public static Item BRASS_INGOT;
    public static Item BRASS_NUGGET;

    public static Item BRONZE_DUST;
    public static Item BRONZE_INGOT;
    public static Item BRONZE_NUGGET;

    public static Item COPPER_DUST;
    public static Item COPPER_INGOT;
    public static Item COPPER_NUGGET;

    public static Item LEAD_DUST;
    public static Item LEAD_INGOT;
    public static Item LEAD_NUGGET;

    public static Item PIGIRON_DUST;
    public static Item PIGIRON_INGOT;
    public static Item PIGIRON_NUGGET;

    public static Item SILVER_DUST;
    public static Item SILVER_INGOT;
    public static Item SILVER_NUGGET;

    public static Item TIN_DUST;
    public static Item TIN_INGOT;
    public static Item TIN_NUGGET;

    public static Item VANADIUM_DUST;
    public static Item VANADIUM_INGOT;
    public static Item VANADIUM_NUGGET;

    public static Item WOOTZ_DUST;
    public static Item WOOTZ_INGOT;
    public static Item WOOTZ_NUGGET;

    public static Item ZINC_DUST;
    public static Item ZINC_INGOT;
    public static Item ZINC_NUGGET;

    public static Item SALT_HALITE_DUST;
    public static Item SALT_NETJRY_DUST;
    public static Item SALT_FIRE_DUST;
    public static Item SALT_VOID_DUST;

    ///
    // Parts
    ///
    public static Item MUCK;
    public static Item ROCK;
    public static Item MORTAR;
    public static Item MUD_CLUMP;
    public static Item FLINT_KNAPP;
    public static Item FLINT_POINT;
    public static Item OBSIDIAN_SHARD;
    public static Item OBSIDIAN_KNAPP;
    public static Item OBSIDIAN_POINT;
    public static Item OBSIDIAN_LENS;
    public static Item OPAL_KNAPP;
    public static Item OPAL_POINT;
    public static Item DIAMOND_KNAPP;
    public static Item DIAMOND_POINT;
    public static Item EMERALD_KNAPP;
    public static Item EMERALD_POINT;
    public static Item PLANT_FIBER;
    public static Item PLANT_CORDAGE;
    public static Item PLANT_CLOTH;
    public static Item PLANT_TINDER;
    public static Item LEATHER_STRIP;
    public static Item LEATHER_CORDAGE;
    public static Item SILK_CORDAGE;
    public static Item SILK_CORDAGE_COILED;
    public static Item STONE_BASIN;
    public static Item IRON_STRANDS;
    public static Item IRON_PIN;
    public static Item IRON_RING;
    public static Item IRON_MESH;
    public static Item IRON_PLATE;
    public static Item IRON_SHEET;
    public static Item WOOD_PIN;
    public static Item THATCHING_WET;
    public static Item THATCHING_DRY;
    public static Item RUSH_STEMS;
    public static Item RUSH_TIPS;
    public static Item RUSH_TIPS_BLOOM;
    //public static Item CORN_STALK;

    public static Item BARK_ACACIA;
    public static Item BARK_BIGOAK;
    public static Item BARK_BIRCH;
    public static Item BARK_IRONWOOD;
    public static Item BARK_JUNGLE;
    public static Item BARK_OAK;
    public static Item BARK_NETHERPALM;
    public static Item BARK_SPRUCE;

    public static Item LEAF_ACACIA;
    public static Item LEAF_BIGOAK;
    public static Item LEAF_BIRCH;
    public static Item LEAF_IRONWOOD;
    public static Item LEAF_JUNGLE;
    public static Item LEAF_NETHERPALM;
    public static Item LEAF_SPRUCE;

    ///
    // Foodstuff Items
    ///
    public static Item SUET;
    public static Item LARD;
    public static Item SALO;
    public static Item FISH_LAVAWORM_RAW;
    public static Item FISH_LAVAWORM_SALTED;
    public static Item FISH_LAVAWORM_DRIED;
    public static Item FISH_LAVAWORM_CURED;
    public static Item FISH_LAVAWORM_ROTTEN;
    public static Item FISH_COD_ROTTEN;
    public static Item FISH_COD_DRIED;
    public static Item FISH_COD_SALTED;
    public static Item FISH_COD_CURED;
    public static Item FISH_SALMON_ROTTEN;
    public static Item FISH_SALMON_DRIED;
    public static Item FISH_SALMON_SALTED;
    public static Item FISH_SALMON_CURED;
    public static Item FISH_CLOWN_ROTTEN;
    public static Item FISH_CLOWN_DRIED;
    public static Item FISH_CLOWN_SALTED;
    public static Item FISH_CLOWN_CURED;
    public static Item FISH_PUFFER_ROTTEN;
    public static Item FISH_PUFFER_DRIED;
    public static Item FISH_PUFFER_SALTED;
    public static Item FISH_PUFFER_CURED;
    public static Item HORSE_MEAT_RAW;
    public static Item HORSE_MEAT_COOKED;
    public static Item CHEESE_WHITE;
    public static Item CORN_COB;
    public static Item CORN_BREAD;
    public static Item CORN_GROUND;
    public static Item WHEAT_GROUND;

    ///
    // Seeds
    ///
    public static Item CORN_SEEDS;
    public static Item RUSH_SEEDS;

    ///
    // Tools
    ///
    public static Item GOLDEN_STICK;
    public static Item FIRE_BOW;
    public static Item SHARP_BONE;
    public static Item STONE_GALLAGHER;
    public static Item FLINT_WORKBLADE;
    public static Item FLINT_SHEARS;
    public static Item FLINT_HATCHET;
    public static Item FLINT_AXE;
    public static Item FLINT_PICKAXE;
    public static Item FLINT_SHOVEL;
    public static Item FLINT_HOE;
    public static Item FLINT_SAW;
    public static Item IRON_SAW;
    public static Item IRON_CLIPPERS;
    public static Item NETHER_FISHING_ROD;

    ///
    //  Nether
    ///
    public static Item QUARTZ_KNAPP;
    public static Item QUARTZ_POINT;
    public static Item NETHER_FIBER;
    public static Item NETHER_CORDAGE;
    public static Item NETHER_CLOTH;
    public static Item NETHER_TINDER;

    public static Item NETHER_GALLAGHER;
    public static Item QUARTZ_GALLAGHER;
    public static Item QUARTZ_WORKBLADE;
    public static Item QUARTZ_SHEARS;
    public static Item QUARTZ_HATCHET;
    public static Item QUARTZ_AXE;
    public static Item QUARTZ_PICKAXE;
    public static Item QUARTZ_SHOVEL;
    public static Item QUARTZ_HOE;
    public static Item QUARTZ_SAW;
    public static Item QUARTZ_CLIPPERS;

    public static Item TORCH_NETHER_LIT;
    public static Item TORCH_WOOD_LIT;
    public static Item IRONWOOD_STICK;
    public static Item NETHERPALM_STICK;
    public static Item NETHERPALM_PIN;

    public static Item PALM_SEED;
    public static Item VALUS_SEEDS;

    ///
    //  Projectiles
    ///
    public static Item ARROW_QUARTZ;
    public static Item ARROW_TORCH_WOOD;
    public static Item ARROW_TORCH_NETHER;
    public static Item ARROW_WATER;
    public static Item ARROW_SILVER;
    public static Item ARROW_GOLD;
*/
}
