package nmd.primal.forgecraft.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.blocks.IngotBall;
import nmd.primal.forgecraft.enumhandler.EnumHandler;
import nmd.primal.forgecraft.items.*;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.items.tools.*;
import nmd.primal.forgecraft.items.weapons.CustomSword;
import nmd.primal.forgecraft.items.weapons.Musket;
import nmd.primal.forgecraft.util.ToolMaterials;
import nmd.primal.forgecraft.items.tools.BaseTool.ForgeToolMaterial;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ModItems {

    //public static Item test;
    public static Item pistonbellows;
    public static Item forgehammer;
    public static Item softcrucible;
    public static Item stonetongs;

    public static Item ironingotballhot;
    public static Item ironchunkhot;
    public static Item ironcleaningotballhot;
    public static Item ironcleanchunkhot;
    public static Item steelingotballhot;
    public static Item steelchunkhot;
    public static Item wootzingotballhot;
    public static Item wootzchunkhot;



    public static Item pickaxehead;
    public static Item ironaxehead;
    public static Item ironshovelhead;
    public static Item ironhoehead;

    public static Item cleanironpickaxehead;
    public static Item cleanironaxehead;
    public static Item cleanironshovelhead;
    public static Item cleanironhoehead;

    public static Item steelpickaxehead;
    public static Item steelaxehead;
    public static Item steelshovelhead;
    public static Item steelhoehead;

    public static Item wootzpickaxehead;
    public static Item wootzaxehead;
    public static Item wootzshovelhead;
    public static Item wootzhoehead;



    public static Item ironpickaxe;
    public static Item ironaxe;
    public static Item ironshovel;
    public static Item ironhoe;

    public static Item cleanironpickaxe;
    public static Item cleanironaxe;
    public static Item cleanironshovel;
    public static Item cleanironhoe;

    public static Item steelpickaxe;
    public static Item steelaxe;
    public static Item steelshovel;
    public static Item steelhoe;

    public static Item wootzpickaxe;
    public static Item wootzaxe;
    public static Item wootzshovel;
    public static Item wootzhoe;

    public static Item ironsword;
    public static Item cleanironsword;
    public static Item steelsword;
    public static Item wootzsword;

    public static Item matchlockmusket;

    //public static Item forgingmanual;

    public static void init() {
        //OBJLoader.INSTANCE.addDomain(ModInfo.MOD_ID);
        pistonbellows = new ItemBellowsHandle();
        softcrucible = new ItemSoftCrucible();
        stonetongs = new ItemStoneTongs("stonetongs");
        forgehammer = new ForgeHammer("forgehammer");
        //matchlockmusket = new Musket("matchlock_musket");

        /**********
         TOOL PARTS
         **********/
        pickaxehead = new ToolPart("ironpickaxehead", ModMaterials.TOOL_WROUGHT_IRON);
        ironaxehead = new ToolPart("ironaxehead", ModMaterials.TOOL_WROUGHT_IRON);
        ironshovelhead = new ToolPart("ironshovelhead", ModMaterials.TOOL_WROUGHT_IRON);
        ironhoehead = new ToolPart("ironhoehead", ModMaterials.TOOL_WROUGHT_IRON);

        cleanironpickaxehead = new ToolPart("cleanironpickaxehead", ModMaterials.CLEAN_IRON);
        cleanironaxehead = new ToolPart("cleanironaxehead", ModMaterials.CLEAN_IRON);
        cleanironshovelhead = new ToolPart("cleanironshovelhead", ModMaterials.CLEAN_IRON);
        cleanironhoehead = new ToolPart("cleanironhoehead", ModMaterials.CLEAN_IRON);

        steelpickaxehead = new ToolPart("steelpickaxehead", ModMaterials.BASIC_STEEL);
        steelaxehead = new ToolPart("steelaxehead", ModMaterials.BASIC_STEEL);
        steelshovelhead = new ToolPart("steelshovelhead", ModMaterials.BASIC_STEEL);
        steelhoehead = new ToolPart("steelhoehead", ModMaterials.BASIC_STEEL);

        wootzpickaxehead = new ToolPart("wootzpickaxehead", ModMaterials.WOOTZ_STEEL);
        wootzaxehead = new ToolPart("wootzaxehead", ModMaterials.WOOTZ_STEEL);
        wootzshovelhead = new ToolPart("wootzshovelhead", ModMaterials.WOOTZ_STEEL);
        wootzhoehead = new ToolPart("wootzhoehead", ModMaterials.WOOTZ_STEEL);
        /**********
         TOOLS
         **********/
        ironpickaxe = new CustomPickaxe("ironpickaxe", ModMaterials.TOOL_WROUGHT_IRON);
        ironaxe = new CustomAxe("ironaxe", ModMaterials.TOOL_WROUGHT_IRON);
        ironshovel = new CustomShovel("ironshovel", ModMaterials.TOOL_WROUGHT_IRON);
        ironhoe = new CustomHoe("ironhoe", ModMaterials.TOOL_WROUGHT_IRON);

        cleanironpickaxe = new CustomPickaxe("cleanironpickaxe", ModMaterials.CLEAN_IRON);
        cleanironaxe = new CustomAxe("cleanironaxe", ModMaterials.CLEAN_IRON);
        cleanironshovel = new CustomShovel("cleanironshovel", ModMaterials.CLEAN_IRON);
        cleanironhoe = new CustomHoe("cleanironhoe", ModMaterials.CLEAN_IRON);

        steelpickaxe = new CustomPickaxe("steelpickaxe", ModMaterials.BASIC_STEEL);
        steelaxe = new CustomAxe("steelaxe", ModMaterials.BASIC_STEEL);
        steelshovel = new CustomShovel("steelshovel", ModMaterials.BASIC_STEEL);
        steelhoe = new CustomHoe("steelhoe", ModMaterials.BASIC_STEEL);

        wootzpickaxe = new CustomPickaxe("wootzpickaxe", ModMaterials.WOOTZ_STEEL);
        wootzaxe = new CustomAxe("wootzaxe", ModMaterials.WOOTZ_STEEL);
        wootzshovel = new CustomShovel("wootzshovel", ModMaterials.WOOTZ_STEEL);
        wootzhoe = new CustomHoe("wootzhoe", ModMaterials.WOOTZ_STEEL);

        /**********
         WEAPONS
         **********/
        ironsword = new CustomSword("ironsword", ModMaterials.TOOL_WROUGHT_IRON);
        cleanironsword = new CustomSword("ironsword", ModMaterials.CLEAN_IRON);
        steelsword = new CustomSword("ironsword", ModMaterials.BASIC_STEEL);
        wootzsword = new CustomSword("ironsword", ModMaterials.WOOTZ_STEEL);

        /**********
         INGOTS AND CHUNKS
         **********/
        ironingotballhot = new BaseMultiItem("ironingothot", ModMaterials.TOOL_WROUGHT_IRON);
        ironchunkhot = new BaseMultiItem("ironchunkhot", ModMaterials.TOOL_WROUGHT_IRON);
        ironcleaningotballhot= new BaseMultiItem("ironcleaningotballhot", ModMaterials.CLEAN_IRON);
        ironcleanchunkhot= new BaseMultiItem("ironcleanchunkhot", ModMaterials.CLEAN_IRON);
        steelingotballhot= new BaseMultiItem("steelingotballhot", ModMaterials.BASIC_STEEL);
        steelchunkhot= new BaseMultiItem("steelchunkhot", ModMaterials.BASIC_STEEL);
        wootzingotballhot= new BaseMultiItem("wootzingotballhot", ModMaterials.WOOTZ_STEEL);
        wootzchunkhot= new BaseMultiItem("wootzchunkhot", ModMaterials.WOOTZ_STEEL);

        //forgingmanual = new ItemForgingManual();
        //test = new ItemTest("ironsword");
    }

    public static void register() {
        GameRegistry.register(pistonbellows);
        GameRegistry.register(softcrucible);
        GameRegistry.register(stonetongs);
        GameRegistry.register(forgehammer);
        GameRegistry.register(ironingotballhot);
        GameRegistry.register(ironchunkhot);
        GameRegistry.register(ironcleaningotballhot);
        GameRegistry.register(ironcleanchunkhot);
        GameRegistry.register(steelingotballhot);
        GameRegistry.register(steelchunkhot);
        GameRegistry.register(wootzingotballhot);
        GameRegistry.register(wootzchunkhot);
        //GameRegistry.register(test);

        /**********
         TOOL PARTS
         **********/
        GameRegistry.register(pickaxehead);
        GameRegistry.register(ironaxehead);
        GameRegistry.register(ironshovelhead);
        GameRegistry.register(ironhoehead);

        GameRegistry.register(cleanironpickaxehead);
        GameRegistry.register(cleanironaxehead);
        GameRegistry.register(cleanironshovelhead);
        GameRegistry.register(cleanironhoehead);

        GameRegistry.register(steelpickaxehead);
        GameRegistry.register(steelaxehead);
        GameRegistry.register(steelshovelhead);
        GameRegistry.register(steelhoehead);

        GameRegistry.register(wootzpickaxehead);
        GameRegistry.register(wootzaxehead);
        GameRegistry.register(wootzshovelhead);
        GameRegistry.register(wootzhoehead);

        /**********
         TOOLS
         **********/
        GameRegistry.register(ironpickaxe);
        GameRegistry.register(ironaxe);
        GameRegistry.register(ironshovel);
        GameRegistry.register(ironhoe);

        GameRegistry.register(cleanironpickaxe);
        GameRegistry.register(cleanironaxe);
        GameRegistry.register(cleanironshovel);
        GameRegistry.register(cleanironhoe);

        GameRegistry.register(steelpickaxe);
        GameRegistry.register(steelaxe);
        GameRegistry.register(steelshovel);
        GameRegistry.register(steelhoe);

        GameRegistry.register(wootzpickaxe);
        GameRegistry.register(wootzaxe);
        GameRegistry.register(wootzshovel);
        GameRegistry.register(wootzhoe);

        /**********
         WEAPONS
         **********/
        GameRegistry.register(ironsword);
        //GameRegistry.register(matchlockmusket);

        //GameRegistry.register(forgingmanual);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        registerRender(pistonbellows);
        registerRender(softcrucible);
        registerRender(forgehammer);
        registerRender(ironingotballhot);
        registerRender(ironchunkhot);
        registerRender(ironcleaningotballhot);
        registerRender(ironcleanchunkhot);
        registerRender(steelingotballhot);
        registerRender(steelchunkhot);
        //registerRender(test);

        /**********
         TOOL PARTS
         **********/
        registerRender(pickaxehead);
        registerRender(ironaxehead);
        registerRender(ironshovelhead);
        registerRender(ironhoehead);

        registerRender(cleanironpickaxehead);
        registerRender(cleanironaxehead);
        registerRender(cleanironshovelhead);
        registerRender(cleanironhoehead);

        registerRender(steelpickaxehead);
        registerRender(steelaxehead);
        registerRender(steelshovelhead);
        registerRender(steelhoehead);

        registerRender(wootzpickaxehead);
        registerRender(wootzaxehead);
        registerRender(wootzshovelhead);
        registerRender(wootzhoehead);

        /**********
         TOOLS
         **********/
        registerRender(ironpickaxe);
        registerRender(ironaxe);
        registerRender(ironshovel);
        registerRender(ironhoe);

        registerRender(cleanironpickaxe);
        registerRender(cleanironaxe);
        registerRender(cleanironshovel);
        registerRender(cleanironhoe);

        registerRender(steelpickaxe);
        registerRender(steelaxe);
        registerRender(steelshovel);
        registerRender(steelhoe);

        registerRender(wootzpickaxe);
        registerRender(wootzaxe);
        registerRender(wootzshovel);
        registerRender(wootzhoe);

        /**********
         WEAPONS
         **********/
        registerRender(ironsword);
        //registerRender(forgingmanual);
        //registerRender(matchlockmusket);
    }

    @SideOnly(Side.CLIENT)
    public static void registerCustomRenders(){
        ModelBakery.registerItemVariants(ModItems.stonetongs, ModItems.stonetongs.getRegistryName(),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_default"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_emptyhot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_emptyhotcracked"),

                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotiron"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotironcooked"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotironfailed"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_ingot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_chunk"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_pickaxe_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_axe_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_shovel_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hoe_hot"),

                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotcleaniron"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotcleanironcooked"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotcleanironfailed"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_cleanironingot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_cleanironchunk"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_cleaniron_pickaxe_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_cleaniron_axe_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_cleaniron_shovel_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_cleaniron_hoe_hot"),

                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotsteel"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotsteelcooked"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotsteelfailed"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_steelingot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_steelchunk"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_steel_pickaxe_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_steel_axe_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_steel_shovel_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_steel_hoe_hot")
                );
        ModelLoader.setCustomMeshDefinition(ModItems.stonetongs, new ItemMeshDefinition() {

            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                if (stack.hasTagCompound()) {
                  if (stack.getTagCompound().getInteger("type") == 0 ){
                    return new ModelResourceLocation(stack.getItem().getRegistryName() + "_default", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 1 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_emptyhot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 2 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_emptyhotcracked", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 3 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotiron", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 4 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotironcooked", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 5 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotironfailed", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 6 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_ingot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 7 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_chunk", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 8 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_pickaxe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 9 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_axe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 10 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_shovel_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 11 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hoe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 12 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotcleaniron", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 13 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotcleanironcooked", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 14 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotcleanironfailed", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 15 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_cleanironingot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 16 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_cleanironchunk", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 17 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_cleaniron_pickaxe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 18 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_cleaniron_axe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 19 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_cleaniron_shovel_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 20 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_cleaniron_hoe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 21 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotsteel", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 22 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotsteelcooked", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 23 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotsteelfailed", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 24 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_steelingot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 25 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_steelchunk", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 26 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_steel_pickaxe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 27 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_steel_axe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 28 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_steel_shovel_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 29 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_steel_hoe_hot", "inventory");
                  }
                  else return new ModelResourceLocation(stack.getItem().getRegistryName(), "inventory");
                }
                return new ModelResourceLocation(stack.getItem().getRegistryName(), "inventory");
            }
        });
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    private static void registerRenderItemBlock(ItemBlock item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    /*public static void registerRender(Item item, int meta, String fileName) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(fileName), "inventory"));

    }

    public static void registerRender(Item item, int meta, String fileName) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(fileName, "inventory"));
    }*/



}
