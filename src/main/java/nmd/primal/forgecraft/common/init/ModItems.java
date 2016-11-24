package nmd.primal.forgecraft.common.init;

import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import nmd.primal.forgecraft.api.ForgeCraftBlocks;
import nmd.primal.forgecraft.api.ForgeCraftMaterials;
import nmd.primal.forgecraft.common.ForgeCraft;
//import nmd.primal.forgecraft.common.items.*;
import nmd.primal.forgecraft.common.ForgeCraft;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

//import static nmd.primal.core.api.PrimalItems.*;


public class ModItems
{
    //public static final Set<Item> ITEMS = new HashSet<>();
    public static final Set<Item> ITEMS = new HashSet<Item>();

    /*******************************************************************************
     * Items
     */
    public static void registerItems()
    {
        // ***************************************************************************** //
        // items
        // plantTwine      = new Cordage("plantTwine", plantFiber).thaumcraftAspects((new AspectList()).add(Aspect.PLANT, 1).add(Aspect.CRAFT, 1));
        //


        /// ***************************************************************************** //
        // Projectiles
        //
        //MUCK                = registerItem("muck", new Muck(), "muck");

        /// ***************************************************************************** //
        // parts
        //
        //EMERALD_POINT       = registerItem("emerald_point", new PrimalItem());


        // ***************************************************************************** //
        //  FoodStuff, Plants, Seeds, etc
        //        COD(0, "cod", 2, 0.1F, 5, 0.6F),
        //        SALMON(1, "salmon", 2, 0.1F, 6, 0.8F),
        //        CLOWNFISH(2, "clownfish", 1, 0.1F),
        //        PUFFERFISH(3, "pufferfish", 1, 0.1F);
        //
        //LARD                = registerItem("lard", new Foodstuff(1, 0.5F, true).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 200, 0), 0.6F), "foodFat");


        // ***************************************************************************** //
        //  Ores
        //
        //ASH                     = registerItem("ash", new Ash(), "dustAsh");


        // ***************************************************************************** //
        //  Tools and Armor
        //

        ///
        // crating tools
        ///
        //STONE_BASIN         = registerItem("stone_basin", new StoneBasin(16));
        //FIRE_BOW            = registerItem("fire_bow", new FireBow(24));
        //QUARTZ_SAW          = registerItem("quartz_saw", new HandSaw(ForgeCraftMaterials.TOOL_QUARTZ.getMaxUses()));
        //QUARTZ_CLIPPERS     = registerItem("quartz_clippers", new HandClipper(ForgeCraftMaterials.TOOL_QUARTZ));
        //IRON_SAW            = registerItem("iron_saw", new HandSaw(Item.ToolMaterial.IRON.getMaxUses()));
        //IRON_CLIPPERS       = registerItem("iron_clippers", new HandClipper(Item.ToolMaterial.IRON));

        //TORCH_WOOD_LIT      = registerItem("torch_wood_lit", new LitTorch(ForgeCraftBlocks.TORCH_WOOD), "torch");
        //TORCH_NETHER_LIT    = registerItem("torch_nether_lit", new LitTorch(ForgeCraftBlocks.TORCH_NETHER), "torch");
    }


    /*******************************************************************************
     * Item Registration Methods
     */
    private static <ITEM extends Item> ITEM registerItem(String name, ITEM item, @Nullable String dictionary_names, Boolean hidden)
    {
        item.setRegistryName(name);
        item.setUnlocalizedName(item.getRegistryName().toString());

        ForgeRegistries.ITEMS.register(item);
        //PrimalCore.proxy.renderItem(item);
        ForgeCraft.proxy.registerItemSided(item);
        ITEMS.add(item);

        if (dictionary_names != null)
        {
            String [] dictionary_name_array = dictionary_names.replaceAll("\\s+","").split(",");
            //List<String> dictionary_name_list = Arrays.asList(dictionary_name_array);
            for (String dictionary_name : dictionary_name_array) {
                OreDictionary.registerOre(dictionary_name, item);
            }
        }

        if (!hidden) {
            item.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        }

        return item;
    }

    private static <ITEM extends Item> ITEM registerItem(String name, ITEM item) {
        return registerItem(name, item, null, false);
    }

    private static <ITEM extends Item> ITEM registerItem(String name, ITEM item, Boolean hidden) {
        return registerItem(name, item, null, hidden);
    }

    private static <ITEM extends Item> ITEM registerItem(String name, ITEM item, @Nullable String dictionary_names) {
        return registerItem(name, item, dictionary_names, false);
    }

}