package nmd.primal.forgecraft.common.init;

import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class ModConfig
{
    /// ************************************************************************ ///
    // features
    ///
    public static boolean FEATURE_ENABLE_FUELS;
    public static boolean FEATURE_REPLACE_LEVERS;
    public static boolean FEATURE_DISABLE_NETHER_PORTAL;
    public static boolean FEATURE_DISABLE_BED_SLEEP;
    public static boolean FEATURE_DISABLE_BED_SPAWN;
    public static boolean FEATURE_AUTO_PLANT_SAPLINGS;

    /// ************************************************************************ ///
    // survival
    ///

    public static int SURVIVAL_MUD_DRY_TIME;
    public static int SURVIVAL_THATCH_DRY_TIME;
    public static int SURVIVAL_THATCH_SUPPORT_RANGE;
    public static int SURVIVAL_ROCK_STACKSIZE;
    public static int SURVIVAL_FIREBOW_DIFFICULTY;
    public static int SURVIVAL_EXTRA_ROCK_DROPS;
    public static int SURVIVAL_EXTRA_FLINT_DROPS;
    public static double SURVIVAL_ROCK_DAMAGE;
    public static boolean SURVIVAL_PLANT_FIBER_DROP;
    public static boolean SURVIVAL_LEAF_STICK_DROP;
    public static boolean SURVIVAL_LEAF_BREAK_FALL;
    public static boolean SURVIVAL_NETHER_EARLYGAME;
    public static boolean SURVIVAL_WOOD_HARVESTING_TOOLS;
    public static boolean SURVIVAL_STONE_HARVESTING_ROCKS;
    public static boolean SURVIVAL_BETTER_THAN_PLANKS;
    public static boolean SURVIVAL_SHELVES_ACCEPT_FULL_STACK;


    /// ************************************************************************ ///
    //  lighting
    ///
    public static int LIGHTING_TORCH_LIFESPAN;
    public static int LIGHTING_TORCH_RECIPE_OUTPUT;
    public static int LIGHTING_TORCH_LIT_STACKSIZE;
    public static int LIGHTING_TORCH_BURN_CHANCE;
    public static int LIGHTING_JACKOLANTERN_LIFESPAN;

    public static int LIGHTING_SMOKE_TORCH_CHANCE;
    public static int LIGHTING_SMOKE_TORCH_ARROW_CHANCE;
    public static int LIGHTING_SMOKE_LANTERN_CHANCE;

    public static double LIGHTING_JACKOLANTERN_LIGHT_LEVEL;

    public static boolean LIGHTING_JACKOLANTERN_REPLACE_VANILLA;
    public static boolean LIGHTING_JACKOLANTERN_CAN_EXPIRE;
    public static boolean LIGHTING_TORCHES_REPLACE_VANILLA;
    public static boolean LIGHTING_TORCHES_DIE;


    /// ************************************************************************ ///
    //  worldgen primal
    ///
    public static boolean WORLDGEN_ENABLE;
    public static boolean WORLDGEN_IN_MOD_DIMENSIONS;
    public static boolean WORLDGEN_OVERRIDE_NETHER;

    public static boolean WORLDGEN_LIMESTONE;
    public static boolean WORLDGEN_BASALT;
    public static boolean WORLDGEN_EARTHWAX;
    public static boolean WORLDGEN_TERRACOTTA;
    public static boolean WORLDGEN_CINISCOTTA;
    public static boolean WORLDGEN_MUD;
    public static boolean WORLDGEN_RUSH;
    public static boolean WORLDGEN_CORN;
    public static boolean WORLDGEN_NETHER_GRASS;
    public static boolean WORLDGEN_NETHER_PALM;
    public static boolean WORLDGEN_END_GRASS;
    public static boolean WORLDGEN_END_WOOD;
    public static boolean WORLDGEN_IRONWOOD;
    public static boolean WORLDGEN_SALT_FLATS;
    public static boolean WORLDGEN_SALT_ROCK;
    public static boolean WORLDGEN_SALT_NETHER;
    public static boolean WORLDGEN_SALT_END;
    public static boolean WORLDGEN_PRIMAL_ORE_IRON;
    public static boolean WORLDGEN_PRIMAL_ORE_GOLD;

    ///
    //  worldgen vanilla
    ///
    public static boolean WORLDGEN_DISABLE_VANILLA_ORE_IRON;
    public static boolean WORLDGEN_DISABLE_VANILLA_ORE_GOLD;
    public static boolean WORLDGEN_DISABLE_VANILLA_ORE_COAL;
    public static boolean WORLDGEN_DISABLE_VANILLA_ORE_REDSTONE;
    public static boolean WORLDGEN_DISABLE_VANILLA_ORE_LAPIS;
    public static boolean WORLDGEN_DISABLE_VANILLA_ORE_DIAMOND;
    public static boolean WORLDGEN_DISABLE_VANILLA_ORE_EMERALD;
    public static boolean WORLDGEN_DISABLE_VANILLA_ORE_QUARTZ;


    /// ************************************************************************ ///
    // crafting overrides
    ///
    public static boolean CRAFTING_PRIMAL_TOOLS;
    public static boolean CRAFTING_ENABLE_SADDLE;
    public static boolean CRAFTING_ENABLE_HORSE_ARMOR;
    public static boolean CRAFTING_DISABLE_ENDEREYE;
    public static boolean CRAFTING_DISABLE_TOOLS_WOOD;
    public static boolean CRAFTING_DISABLE_TOOLS_STONE;
    public static boolean CRAFTING_DISABLE_TOOLS_IRON;
    public static boolean CRAFTING_DISABLE_TOOLS_DIAMOND;
    public static boolean CRAFTING_DISABLE_TOOLS_GOLD;
    public static boolean CRAFTING_REPLACE_CHISELED_RECIPE;
    public static boolean CRAFTING_REPLACE_ARROW_RECIPE;
    public static boolean CRAFTING_SURVIVAL_FLINTNSTEEL;
    public static boolean CRAFTING_FARMLAND;

    public static boolean CRAFTING_BARK_REMOVAL_ENABLE;
    public static boolean CRAFTING_KNAPPING_ENABLE;

    public static double CRAFTING_KNAPPING_DIFFICULTY_FLINT;
    public static double CRAFTING_KNAPPING_DIFFICULTY_QUARTZ;
    public static double CRAFTING_KNAPPING_DIFFICULTY_OBSIDIAN;

    public static int CRAFTING_DRYING_RACK_BASE_TIME;
    //public static int CRAFTING_KNAPPING_DIFFICULTY;

    /// ************************************************************************ ///
    // development
    ///
    public static int DEBUG_LEVEL;


    /// ************************************************************************ ///
    // lists
    ///
    public static String[] SURVIVAL_WOOD_HARVESTING_ADDITIONS = { };
    public static String[] CRAFTING_REMOVE_NAMES = { };
    public static String[] removeRecipeDisplayNames = { };
    public static String[] FEATURE_CUSTOM_SAPLINGS = { };


    /// ************************************************************************ ///
    //  init config defaults
    ///
    public static void init(File configFile)
    {
        // you will be able to find the config file in .minecraft/config/ and it will be named "modname".cfg
        // here our Configuration has been instantiated, and saved under the name "config"
        Configuration config = new Configuration(configFile);

        // loading the configuration from its file
        config.load();


        /// ************************************************************************ ///
        // features
        //
        String features_title = "feature hooks";
        ConfigCategory featuresCategory = config.getCategory(features_title);
        featuresCategory.setComment("Hooks for controlling various aspects of the mod");
        //
        /// ************************************************************************ ///

        Property feature_enable_fuels = config.get(features_title, "FEATURE_ENABLE_FUELS", true);
        feature_enable_fuels.setComment("Registration of various fuel items");
        FEATURE_ENABLE_FUELS = feature_enable_fuels.getBoolean(true);

        Property feature_replace_levers = config.get(features_title, "FEATURE_REPLACE_LEVERS", true);
        feature_replace_levers.setComment("Replace vanilla levers during block placement");
        FEATURE_REPLACE_LEVERS = feature_replace_levers.getBoolean(true);

        Property feature_disable_nether_portal = config.get(features_title, "FEATURE_DISABLE_NETHER_PORTAL", false);
        feature_disable_nether_portal.setComment("Disable Nether Portal Creation");
        FEATURE_DISABLE_NETHER_PORTAL = feature_disable_nether_portal.getBoolean(false);

        Property feature_disable_bed_sleep = config.get(features_title, "FEATURE_DISABLE_BED_SLEEP", false);
        feature_disable_bed_sleep.setComment("Disable sleeping in a bed, hackish method of preventing night skipping, if you have a better way plz let me know");
        FEATURE_DISABLE_BED_SLEEP = feature_disable_bed_sleep.getBoolean(false);

        Property feature_disable_bed_spawn = config.get(features_title, "FEATURE_DISABLE_BED_SPAWN", false);
        feature_disable_bed_spawn.setComment("Disable setting of spawn via beds or bed-like blocks");
        FEATURE_DISABLE_BED_SPAWN = feature_disable_bed_spawn.getBoolean(false);

        Property feature_auto_plant_saplings = config.get(features_title, "FEATURE_AUTO_PLANT_SAPLINGS", true);
        feature_auto_plant_saplings.setComment("Saplings will plant themselves when left in the world");
        FEATURE_AUTO_PLANT_SAPLINGS = feature_auto_plant_saplings.getBoolean(true);

        /// ************************************************************************ ///
        // survival
        //
        String survival_title = "survival settings";
        ConfigCategory survivalCategory = config.getCategory(survival_title);
        survivalCategory.setComment("Options balanced toward a harder survival style game");
        //
        /// ************************************************************************ ///

        Property survival_mud_dry_time = config.get(survival_title, "SURVIVAL_MUD_DRY_TIME", 40);
        survival_mud_dry_time.setComment("Modifier for how long it takes wet mud to dry. Lack of air, rain, or near by water will slow or prevent mud from drying");
        SURVIVAL_MUD_DRY_TIME = survival_mud_dry_time.getInt(40);

        Property survival_thatch_dry_time = config.get(survival_title, "SURVIVAL_THATCH_DRY_TIME", 120);
        survival_thatch_dry_time.setComment("Modifier for how long it takes wet thatch to dry, this values is reduced by half when thatch is exposed to the sun, however rain will pose a problem.");
        SURVIVAL_THATCH_DRY_TIME = survival_thatch_dry_time.getInt(120);

        Property survival_thatch_support_range = config.get(survival_title, "SURVIVAL_THATCH_SUPPORT_RANGE", 2);
        survival_thatch_support_range.setComment("Modifier for how far away wooden slats can be from thatch and still provide support.");
        SURVIVAL_THATCH_SUPPORT_RANGE = survival_thatch_support_range.getInt(2);

        Property survival_rock_stacksize = config.get(survival_title, "SURVIVAL_ROCK_STACKSIZE", 16);
        survival_rock_stacksize.setComment("How many rocks can a rock stacker stack?");
        SURVIVAL_ROCK_STACKSIZE = survival_rock_stacksize.getInt(16);

        Property survival_rock_damage = config.get(survival_title, "SURVIVAL_ROCK_DAMAGE", 1.5D);
        survival_rock_damage.setComment("Amount of damage from a thrown rock");
        SURVIVAL_ROCK_DAMAGE = survival_rock_damage.getDouble(1.5D);

        Property survival_firebow_difficulty = config.get(survival_title, "SURVIVAL_FIREBOW_DIFFICULTY", 8);
        survival_firebow_difficulty.setComment("Chance of success with the fire bow, higher is less likely.");
        SURVIVAL_FIREBOW_DIFFICULTY = survival_firebow_difficulty.getInt(8);

        Property survival_extra_rock_drops = config.get(survival_title, "SURVIVAL_EXTRA_ROCK_DROPS", 50);
        survival_extra_rock_drops.setComment("Harvesting Ground or Sand materials has a chance of dropping rocks, 0 will disable drop while higher values are less and less likely");
        SURVIVAL_EXTRA_ROCK_DROPS = survival_extra_rock_drops.getInt(50);

        Property survival_extra_flint_drops = config.get(survival_title, "SURVIVAL_EXTRA_FLINT_DROPS", 50);
        survival_extra_flint_drops.setComment("Harvesting Ground or Sand materials has a chance of dropping flint, 0 will disable drop while higher values are less and less likely");
        SURVIVAL_EXTRA_FLINT_DROPS = survival_extra_flint_drops.getInt(50);

        Property survival_plant_fiber_drop = config.get(survival_title, "SURVIVAL_PLANT_FIBER_DROP", true);
        survival_plant_fiber_drop.setComment("Breaking GrassBlocks, TallGrass, and Vines drops plant fibers");
        SURVIVAL_PLANT_FIBER_DROP = survival_plant_fiber_drop.getBoolean(true);

        Property survival_leaf_stick_drop = config.get(survival_title, "SURVIVAL_LEAF_STICK_DROP", true);
        survival_leaf_stick_drop.setComment("Breaking leaf blocks will sometimes drop sticks");
        SURVIVAL_LEAF_STICK_DROP = survival_leaf_stick_drop.getBoolean(true);

        Property survival_leaf_break_fall = config.get(survival_title, "SURVIVAL_LEAF_BREAK_FALL", true);
        survival_leaf_break_fall.setComment("Falling or jumping onto leaf blocks absorbs some damage and breaks the associated blocks");
        SURVIVAL_LEAF_BREAK_FALL = survival_leaf_break_fall.getBoolean(true);

        Property survival_Nether_earlygame = config.get(survival_title, "SURVIVAL_NETHER_EARLYGAME", true);
        survival_Nether_earlygame.setComment("Settings to smooth early gameplay in the Nether, such as harvesting Netherrack without a tool");
        SURVIVAL_NETHER_EARLYGAME = survival_Nether_earlygame.getBoolean(true);

        Property stone_harvesting_rocks = config.get(survival_title, "SURVIVAL_STONE_HARVESTING_ROCKS", false);
        stone_harvesting_rocks.setComment("Harvesting smooth stone with a pick drops a number of rocks based on tool level, cobble stone must be crafted");
        SURVIVAL_STONE_HARVESTING_ROCKS = stone_harvesting_rocks.getBoolean(false);

        Property survival_better_than_planks = config.get(survival_title, "SURVIVAL_BETTER_THAN_PLANKS", true);
        survival_better_than_planks.setComment("Crafting planks and sticks require the use of a saw and workblade respectively");
        SURVIVAL_BETTER_THAN_PLANKS = survival_better_than_planks.getBoolean(true);

        //Property survival_shelves_accept_full_stack = config.get(survival_title, "SURVIVAL_SHELVES_ACCEPT_FULL_STACK", false);
        //survival_shelves_accept_full_stack.setComment("Shelves with load/unload full stacks as opposed to one item at a time.");
        //SURVIVAL_SHELVES_ACCEPT_FULL_STACK = survival_shelves_accept_full_stack.getBoolean(false);

        Property survival_wood_harvesting_tools = config.get(survival_title, "SURVIVAL_WOOD_HARVESTING_TOOLS", true);
        survival_wood_harvesting_tools.setComment("Harvesting log blocks requires the use of appropriate tools");
        SURVIVAL_WOOD_HARVESTING_TOOLS = survival_wood_harvesting_tools.getBoolean(true);

        Property survival_wood_harvesting_additions = config.get(survival_title, "SURVIVAL_WOOD_HARVESTING_ADDITIONS", SURVIVAL_WOOD_HARVESTING_ADDITIONS);
        survival_wood_harvesting_additions.setComment("List of Blocks to treat as wood logs, this is used by the SURVIVAL_WOOD_HARVESTING_TOOLS option.");
        SURVIVAL_WOOD_HARVESTING_ADDITIONS = survival_wood_harvesting_additions.getStringList();


        /// ************************************************************************ ///
        //  lighting
        //
        String lighting_title = "lighting";
        ConfigCategory lightingCategory = config.getCategory(lighting_title);
        lightingCategory.setComment("Torch, Lanterns, and other things");
        //
        /// ************************************************************************ ///

        Property lighting_torch_lifespan = config.get(lighting_title, "LIGHTING_TORCH_LIFESPAN", 16);
        lighting_torch_lifespan.setComment("How long will torches stay lit? higher is a longer life time, while 0 will disable the feature.");
        LIGHTING_TORCH_LIFESPAN = lighting_torch_lifespan.getInt(16);

        Property lighting_torch_burn_chance = config.get(lighting_title, "LIGHTING_TORCH_BURN_CHANCE", 500);
        lighting_torch_burn_chance.setComment("How likely are Overworld torches to set entities touching them on fire. Higher is less likely, think in large numbers as the check runs continually on block collision.");
        LIGHTING_TORCH_BURN_CHANCE = lighting_torch_burn_chance.getInt(500);

        Property lighting_smoke_torch_chance = config.get(lighting_title, "LIGHTING_SMOKE_TORCH_CHANCE", 60);
        lighting_smoke_torch_chance.setComment("How likely are torches to produce smoke when exposed to rain or snow. Higher is less likely.");
        LIGHTING_SMOKE_TORCH_CHANCE = lighting_smoke_torch_chance.getInt(60);

        Property lighting_smoke_torch_arrow_chance = config.get(lighting_title, "LIGHTING_SMOKE_TORCH_ARROW_CHANCE", 36);
        lighting_smoke_torch_arrow_chance.setComment("How likely are torch arrows to produce smoke on impact with a block.");
        LIGHTING_SMOKE_TORCH_ARROW_CHANCE = lighting_smoke_torch_arrow_chance.getInt(36);

        Property lighting_smoke_lantern_chance = config.get(lighting_title, "LIGHTING_SMOKE_LANTERN_CHANCE", 40);
        lighting_smoke_lantern_chance.setComment("How likely are lanterns to produce smoke when exposed to rain or snow. Higher is less likely.");
        LIGHTING_SMOKE_LANTERN_CHANCE = lighting_smoke_lantern_chance.getInt(40);

        //Property lighting_smoke_in_doors = config.get(lighting_title, "LIGHTING_SMOKE_IN_DOORS", false);
        //lighting_smoke_in_doors.setComment("");
        //LIGHTING_SMOKE_IN_DOORS = lighting_smoke_in_doors.getBoolean(false);

        Property lighting_jackolantern_light_level = config.get(lighting_title, "LIGHTING_JACKOLANTERN_LIGHT_LEVEL", 0.5D);
        lighting_jackolantern_light_level.setComment("Amount of light produced by Jack o'Lanterns. Redstone torches 0.5D, Torch 0.9375D.");
        LIGHTING_JACKOLANTERN_LIGHT_LEVEL = lighting_jackolantern_light_level.getDouble(0.5D);

        Property lighting_torch_recipe_output = config.get(lighting_title, "LIGHTING_TORCH_RECIPE_OUTPUT", 4);
        lighting_torch_recipe_output.setComment("How many torches are produced from crafting. Currently you must also be overriding vanilla torches for this to work.");
        LIGHTING_TORCH_RECIPE_OUTPUT = lighting_torch_recipe_output.getInt(4);

        Property lighting_jackolantern_replace_vanilla = config.get(lighting_title, "LIGHTING_JACKOLANTERN_REPLACE_VANILLA", true);
        lighting_jackolantern_replace_vanilla.setComment("Replace vanilla jack-o-lanterns during block placement");
        LIGHTING_JACKOLANTERN_REPLACE_VANILLA = lighting_jackolantern_replace_vanilla.getBoolean(true);

        Property lighting_jackolantern_can_expire = config.get(lighting_title, "LIGHTING_JACKOLANTERN_CAN_EXPIRE", true);
        lighting_jackolantern_can_expire.setComment("Jack-o-lanterns can get put out, and or will naturally go out according to how torches are configured");
        LIGHTING_JACKOLANTERN_CAN_EXPIRE = lighting_jackolantern_can_expire.getBoolean(true);

        Property lighting_torches_replace_vanilla = config.get(lighting_title, "LIGHTING_TORCHES_REPLACE_VANILLA", true);
        lighting_torches_replace_vanilla.setComment("Replace vanilla torches during block placement, Use an updated recipe and configurable output amount.");
        LIGHTING_TORCHES_REPLACE_VANILLA = lighting_torches_replace_vanilla.getBoolean(true);

        Property lighting_torches_die = config.get(lighting_title, "LIGHTING_TORCHES_DIE", false);
        lighting_torches_die.setComment("Set this option for torches that will eventually go out even when not exposed to weather. This will also cause torches to create smoke regardless of weather. Separately weather sensitivity can be disabled by setting the lifespan to 0");
        LIGHTING_TORCHES_DIE = lighting_torches_die.getBoolean(false);


        /// ************************************************************************ ///
        //  crafting
        //
        String crafting_title = "crafting control";
        ConfigCategory craftingCategory = config.getCategory(crafting_title);
        craftingCategory.setComment("Control over Crafting");
        //
        /// ************************************************************************ ///

        Property crafting_primal_tools = config.get(crafting_title, "CRAFTING_PRIMAL_TOOLS", true);
        crafting_primal_tools.setComment("Enable crafting recipes for primal tools, currently: flint, quartz");
        CRAFTING_PRIMAL_TOOLS = crafting_primal_tools.getBoolean(true);

        Property crafting_enable_saddle = config.get(crafting_title, "CRAFTING_ENABLE_SADDLE", true);
        crafting_enable_saddle.setComment("Enable Crafting recipe for the vanilla saddle");
        CRAFTING_ENABLE_SADDLE = crafting_enable_saddle.getBoolean(true);

        Property crafting_enable_horse_armor = config.get(crafting_title, "CRAFTING_ENABLE_HORSE_ARMOR", true);
        crafting_enable_horse_armor.setComment("Enable Crafting recipe for the vanilla horse armor");
        CRAFTING_ENABLE_HORSE_ARMOR = crafting_enable_horse_armor.getBoolean(true);

        Property crafting_disable_endereye = config.get(crafting_title, "CRAFTING_DISABLE_ENDEREYE", false);
        crafting_disable_endereye.setComment("Disable crafting recipe for ender eyes");
        CRAFTING_DISABLE_ENDEREYE = crafting_disable_endereye.getBoolean(false);

        Property crafting_disable_tools_wood = config.get(crafting_title, "CRAFTING_DISABLE_TOOLS_WOOD", true);
        crafting_disable_tools_wood.setComment("Disable crafting recipes for vanilla wood tools, by default flint tools are meant to replace wood.");
        CRAFTING_DISABLE_TOOLS_WOOD = crafting_disable_tools_wood.getBoolean(true);

        Property crafting_disable_tools_stone = config.get(crafting_title, "CRAFTING_DISABLE_TOOLS_STONE", false);
        crafting_disable_tools_stone.setComment("Disable crafting recipes for vanilla stone tools");
        CRAFTING_DISABLE_TOOLS_STONE = crafting_disable_tools_stone.getBoolean(false);

        Property crafting_disable_tools_iron = config.get(crafting_title, "CRAFTING_DISABLE_TOOLS_IRON", false);
        crafting_disable_tools_iron.setComment("Disable crafting recipes for vanilla iron tools");
        CRAFTING_DISABLE_TOOLS_IRON = crafting_disable_tools_iron.getBoolean(false);

        Property crafting_disable_tools_gold = config.get(crafting_title, "CRAFTING_DISABLE_TOOLS_GOLD", false);
        crafting_disable_tools_gold.setComment("Disable crafting recipes for vanilla gold tools");
        CRAFTING_DISABLE_TOOLS_GOLD = crafting_disable_tools_gold.getBoolean(false);

        Property crafting_disable_tools_diamond = config.get(crafting_title, "CRAFTING_DISABLE_TOOLS_DIAMOND", false);
        crafting_disable_tools_diamond.setComment("Disable crafting recipes for vanilla diamond tools");
        CRAFTING_DISABLE_TOOLS_DIAMOND = crafting_disable_tools_diamond.getBoolean(false);

        Property crafting_replace_chiseled_recipe = config.get(crafting_title, "CRAFTING_REPLACE_CHISELED_RECIPE", true);
        crafting_replace_chiseled_recipe.setComment("Replace chiseled block recipes to require a work blade");
        CRAFTING_REPLACE_CHISELED_RECIPE = crafting_replace_chiseled_recipe.getBoolean(true);

        Property crafting_replace_arrow_recipe = config.get(crafting_title, "CRAFTING_REPLACE_ARROW_RECIPE", true);
        crafting_replace_arrow_recipe.setComment("Replace vanilla arrow recipe to use knapped flint");
        CRAFTING_REPLACE_ARROW_RECIPE = crafting_replace_arrow_recipe.getBoolean(true);

        Property survival_crafting_flintsteel = config.get(crafting_title, "CRAFTING_SURVIVAL_FLINTNSTEEL", true);
        survival_crafting_flintsteel.setComment("Enable a more realistic recipe for flint and steel, this drastically reduces the iron cost for early game");
        CRAFTING_SURVIVAL_FLINTNSTEEL = survival_crafting_flintsteel.getBoolean(true);

        Property crafting_farmland = config.get(crafting_title, "CRAFTING_FARMLAND", false);
        crafting_farmland.setComment("Tilling Farmland no longer works on vanilla dirt, replaced with a craftable dirt type called loam.");
        CRAFTING_FARMLAND = crafting_farmland.getBoolean(false);

        Property crafting_bark_removal_enable = config.get(crafting_title, "CRAFTING_BARK_REMOVAL_ENABLE", true);
        crafting_bark_removal_enable.setComment("Enable the in-world bark removal.　Used by the work blocks on log blocks");
        CRAFTING_BARK_REMOVAL_ENABLE = crafting_bark_removal_enable.getBoolean(true);

        Property crafting_in_world_knapping = config.get(crafting_title, "CRAFTING_KNAPPING_ENABLE", true);
        crafting_in_world_knapping.setComment("Enable the in-world knapping event. Used by flint, quartz, and obsidian.");
        CRAFTING_KNAPPING_ENABLE = crafting_in_world_knapping.getBoolean(true);
        
        Property crafting_drying_rack_base_time = config.get(crafting_title, "CRAFTING_DRYING_RACK_BASE_TIME", 1000);
        crafting_drying_rack_base_time.setComment("Base time for the drying rack to complete work on a stack, this is further modified by environment and the item being dried.");
        CRAFTING_DRYING_RACK_BASE_TIME = crafting_drying_rack_base_time.getInt(1000);

        Property crafting_knapping_difficulty_flint = config.get(crafting_title, "CRAFTING_KNAPPING_DIFFICULTY_FLINT", 0.40D);
        crafting_knapping_difficulty_flint.setComment("Chance of dropping knapped flint from in-world knapping, 1.0D is 100% drop rate.");
        CRAFTING_KNAPPING_DIFFICULTY_FLINT = crafting_knapping_difficulty_flint.getDouble(0.45D);

        Property crafting_knapping_difficulty_quartz = config.get(crafting_title, "CRAFTING_KNAPPING_DIFFICULTY_QUARTZ", 0.35D);
        crafting_knapping_difficulty_quartz.setComment("Chance of dropping knapped quartz from in-world knapping, 1.0D is 100% drop rate.");
        CRAFTING_KNAPPING_DIFFICULTY_QUARTZ = crafting_knapping_difficulty_quartz.getDouble(0.50D);

        Property crafting_knapping_difficulty_obsidian = config.get(crafting_title, "CRAFTING_KNAPPING_DIFFICULTY_OBSIDIAN", 0.25D);
        crafting_knapping_difficulty_obsidian.setComment("Chance of dropping knapping output from in-world knapping, 1.0D is 100% drop rate.");
        CRAFTING_KNAPPING_DIFFICULTY_OBSIDIAN = crafting_knapping_difficulty_obsidian.getDouble(0.30D);

        Property crafting_remove_names = config.get(crafting_title, "CRAFTING_REMOVE_NAMES", CRAFTING_REMOVE_NAMES);
        crafting_remove_names.setComment("List of item/block names to remove from crafting.");
        CRAFTING_REMOVE_NAMES = crafting_remove_names.getStringList();


        /// ************************************************************************ ///
        //  worldgen
        //
        String world_title = "world generation";
        ConfigCategory worldCategory = config.getCategory(world_title);
        worldCategory.setComment("Control the world and retro generation");
        //
        /// ************************************************************************ ///

        Property worldgen_enable = config.get(world_title, "WORLDGEN_ENABLE", true);
        worldgen_enable.setComment("Global control for all primal worldgen");
        WORLDGEN_ENABLE = worldgen_enable.getBoolean(true);

        Property worldgen_override_Nether = config.get(world_title, "WORLDGEN_OVERRIDE_NETHER", true);
        worldgen_override_Nether.setComment("Override the Nether World Provider, allows Nether spawn mechanics and additional features. Trust us.");
        WORLDGEN_OVERRIDE_NETHER = worldgen_override_Nether.getBoolean(true);

        Property worldgen_in_mod_dimensions = config.get(world_title, "WORLDGEN_IN_MOD_DIMENSIONS", true);
        worldgen_in_mod_dimensions.setComment("Allow Overworld generation to take place in custom dimensions");
        WORLDGEN_IN_MOD_DIMENSIONS = worldgen_in_mod_dimensions.getBoolean(true);

        Property worldgen_limestone = config.get(world_title, "WORLDGEN_LIMESTONE", true);
        worldgen_limestone.setComment("Enable Worldgen for Limestone/Carbonate Stone, appears primarily in the Overworld");
        WORLDGEN_LIMESTONE = worldgen_limestone.getBoolean(true);

        Property worldgen_basalt = config.get(world_title, "WORLDGEN_BASALT", true);
        worldgen_basalt.setComment("Enable Worldgen for Basalt/Ferrous Stone, appears primarily in the Nether");
        WORLDGEN_BASALT = worldgen_basalt.getBoolean(true);

        Property feature_worldgen_basalt = config.get(world_title, "WORLDGEN_EARTHWAX", true);
        feature_worldgen_basalt.setComment("Enable Worldgen for Earthwax, appears in both Overworld and Nether");
        WORLDGEN_EARTHWAX = feature_worldgen_basalt.getBoolean(true);

        Property worldgen_earthwax = config.get(world_title, "WORLDGEN_EARTHWAX", true);
        worldgen_earthwax.setComment("Enable Worldgen for Earthwax fuel, appears in both Overworld and Nether");
        WORLDGEN_EARTHWAX = worldgen_earthwax.getBoolean(true);

        Property worldgen_terracotta = config.get(world_title, "WORLDGEN_TERRACOTTA", true);
        worldgen_terracotta.setComment("Enable Worldgen for Terracotta Clay, appears in Overworld");
        WORLDGEN_TERRACOTTA = worldgen_terracotta.getBoolean(true);

        Property worldgen_ciniscotta = config.get(world_title, "WORLDGEN_CINISCOTTA", true);
        worldgen_ciniscotta.setComment("Enable Worldgen for Ciniscotta Clay, appears primarily in the Nether");
        WORLDGEN_CINISCOTTA = worldgen_ciniscotta.getBoolean(true);

        Property worldgen_mud = config.get(world_title, "WORLDGEN_MUD", true);
        worldgen_mud.setComment("Enable Worldgen for Mud, appears in the Overworld near water");
        WORLDGEN_MUD = worldgen_mud.getBoolean(true);

        Property worldgen_rush = config.get(world_title, "WORLDGEN_RUSH", true);
        worldgen_rush.setComment("Enable Worldgen for Rushes, primary resource for making Thatch, appears in the Overworld near water");
        WORLDGEN_RUSH = worldgen_rush.getBoolean(true);

        Property worldgen_corn = config.get(world_title, "WORLDGEN_CORN", true);
        worldgen_corn.setComment("Enable Worldgen for Corn, appears in the Overworld");
        WORLDGEN_CORN = worldgen_corn.getBoolean(true);

        Property worldgen_Nether_grass = config.get(world_title, "WORLDGEN_NETHER_GRASS", true);
        worldgen_Nether_grass.setComment("Enable Worldgen for Nether Grass, early game Nether progression");
        WORLDGEN_NETHER_GRASS = worldgen_Nether_grass.getBoolean(true);

        Property worldgen_Nether_palm = config.get(world_title, "WORLDGEN_NETHER_PALM", true);
        worldgen_Nether_palm.setComment("Enable Worldgen for Nether Palm trees, also known as Corypha Pachyptila, early game Nether progression");
        WORLDGEN_NETHER_PALM = worldgen_Nether_palm.getBoolean(true);

        Property worldgen_end_grass = config.get(world_title, "WORLDGEN_END_GRASS", true);
        worldgen_end_grass.setComment("Enable Worldgen for End Grass, early game End progression");
        WORLDGEN_END_GRASS = worldgen_end_grass.getBoolean(true);

        Property worldgen_end_wood = config.get(world_title, "WORLDGEN_END_WOOD", true);
        worldgen_end_wood.setComment("Enable Worldgen for End trees, early game End progression");
        WORLDGEN_END_WOOD = worldgen_end_wood.getBoolean(true);

        Property worldgen_salt_flats = config.get(world_title, "WORLDGEN_SALT_FLATS", true);
        worldgen_salt_flats.setComment("Enable Worldgen for Netjry Salt Falts, appears primarily in the Overworld");
        WORLDGEN_SALT_FLATS = worldgen_salt_flats.getBoolean(true);

        Property worldgen_salt_rock = config.get(world_title, "WORLDGEN_SALT_ROCK", true);
        worldgen_salt_rock.setComment("Enable Worldgen for Halite Rock Salt, appears primarily in the Overworld");
        WORLDGEN_SALT_ROCK = worldgen_salt_rock.getBoolean(true);

        Property worldgen_salt_nether = config.get(world_title, "WORLDGEN_SALT_NETHER", true);
        worldgen_salt_nether.setComment("Enable Worldgen for Fire Rock Salt, early game Nether progression");
        WORLDGEN_SALT_NETHER = worldgen_salt_nether.getBoolean(true);

        Property worldgen_salt_end = config.get(world_title, "WORLDGEN_SALT_END", true);
        worldgen_salt_end.setComment("Enable Worldgen for End Rock Salt, early game End progression");
        WORLDGEN_SALT_END = worldgen_salt_end.getBoolean(true);

        Property worldgen_ironwood = config.get(world_title, "WORLDGEN_IRONWOOD", true);
        worldgen_ironwood.setComment("Enable Worldgen for Ironwood trees, appear primarily in the Overworld");
        WORLDGEN_IRONWOOD = worldgen_ironwood.getBoolean(true);

        Property worldgen_primal_ore_iron = config.get(world_title, "WORLDGEN_PRIMAL_ORE_IRON", false);
        worldgen_primal_ore_iron.setComment("Enable Worldgen for Primal Iron Ore, this generates in large deposits with ore blocks of varying density. EXPERIMENTAL");
        WORLDGEN_PRIMAL_ORE_GOLD = worldgen_primal_ore_iron.getBoolean(false);

        Property worldgen_primal_ore_gold = config.get(world_title, "WORLDGEN_PRIMAL_ORE_GOLD", false);
        worldgen_primal_ore_gold.setComment("Enable Worldgen for Primal Gold Ore, this generates in large deposits with ore blocks of varying density. EXPERIMENTAL");
        WORLDGEN_PRIMAL_ORE_GOLD = worldgen_primal_ore_gold.getBoolean(false);

        Property vanilla_disable_ore_iron = config.get(world_title, "WORLDGEN_DISABLE_VANILLA_ORE_IRON", false);
        vanilla_disable_ore_iron.setComment("Disable worldgen for vanilla iron ore.");
        WORLDGEN_DISABLE_VANILLA_ORE_IRON = vanilla_disable_ore_iron.getBoolean(false);

        Property vanilla_disable_ore_gold = config.get(world_title, "WORLDGEN_DISABLE_VANILLA_ORE_GOLD", false);
        vanilla_disable_ore_gold.setComment("Disable worldgen for vanilla gold ore");
        WORLDGEN_DISABLE_VANILLA_ORE_GOLD = vanilla_disable_ore_gold.getBoolean(false);

        Property vanilla_disable_ore_coal = config.get(world_title, "WORLDGEN_DISABLE_VANILLA_ORE_COAL", false);
        vanilla_disable_ore_coal.setComment("Disable worldgen for vanilla coal ore");
        WORLDGEN_DISABLE_VANILLA_ORE_COAL = vanilla_disable_ore_coal.getBoolean(false);

        Property vanilla_disable_ore_redstone = config.get(world_title, "WORLDGEN_DISABLE_VANILLA_ORE_REDSTONE", false);
        vanilla_disable_ore_redstone.setComment("Disable worldgen for vanilla redstone ore");
        WORLDGEN_DISABLE_VANILLA_ORE_REDSTONE = vanilla_disable_ore_redstone.getBoolean(false);

        Property vanilla_disable_ore_lapis = config.get(world_title, "WORLDGEN_DISABLE_VANILLA_ORE_LAPIS", false);
        vanilla_disable_ore_lapis.setComment("Disable worldgen for vanilla lapis ore");
        WORLDGEN_DISABLE_VANILLA_ORE_LAPIS = vanilla_disable_ore_lapis.getBoolean(false);

        Property vanilla_disable_ore_diamond = config.get(world_title, "WORLDGEN_DISABLE_VANILLA_ORE_DIAMOND", false);
        vanilla_disable_ore_diamond.setComment("Disable worldgen for vanilla diamond ore");
        WORLDGEN_DISABLE_VANILLA_ORE_DIAMOND = vanilla_disable_ore_diamond.getBoolean(false);

        Property vanilla_disable_ore_emerald = config.get(world_title, "WORLDGEN_DISABLE_VANILLA_ORE_EMERALD", false);
        vanilla_disable_ore_emerald.setComment("Disable worldgen for vanilla emerald ore");
        WORLDGEN_DISABLE_VANILLA_ORE_EMERALD = vanilla_disable_ore_emerald.getBoolean(false);

        Property vanilla_disable_ore_quartz = config.get(world_title, "WORLDGEN_DISABLE_VANILLA_ORE_QUARTZ", false);
        vanilla_disable_ore_quartz.setComment("Disable worldgen for vanilla quartz ore");
        WORLDGEN_DISABLE_VANILLA_ORE_QUARTZ = vanilla_disable_ore_quartz.getBoolean(false);


        /// ************************************************************************ ///
        // dev and debugging
        //
        String debug_title = "debug settings";
        ConfigCategory settingCategory = config.getCategory(debug_title);
        settingCategory.setComment("Options useful for debugging and server operators");
        //
        /// ************************************************************************ ///

        Property dev_debug_level = config.get(debug_title, "DEBUG_LEVEL", 0);
        dev_debug_level.setComment("Debug levels 0-3, by default a zero value disables debug features.");
        DEBUG_LEVEL = dev_debug_level.getInt(0);


        /// ************************************************************************ ///
        // save config
        //
        if(config.hasChanged()) {
            config.save();
        }
        //
        /// ************************************************************************ ///
    }
}