package nmd.primal.forgecraft.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.items.ItemBellowsHandle;
import nmd.primal.forgecraft.items.ItemForgingManual;
import nmd.primal.forgecraft.items.ItemSoftCrucible;
import nmd.primal.forgecraft.items.ItemStoneTongs;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ModItems {

    public static Item pistonbellows;
    public static Item softcrucible;
    public static Item stonetongs;
    //public static Item forgingmanual;

    public static void init() {
        OBJLoader.INSTANCE.addDomain(ModInfo.MOD_ID);
        pistonbellows = new ItemBellowsHandle();
        softcrucible = new ItemSoftCrucible();
        stonetongs = new ItemStoneTongs("stonetongs");
        //forgingmanual = new ItemForgingManual();
    }

    public static void register() {
        GameRegistry.register(pistonbellows);
        GameRegistry.register(softcrucible);
        GameRegistry.register(stonetongs);
        //GameRegistry.register(forgingmanual);
    }

    public static void registerRenders() {
        registerRender(pistonbellows);
        registerRender(softcrucible);
        //registerRender(forgingmanual);
    }

    public static void registerCustomRenders(){
        ModelBakery.registerItemVariants(ModItems.stonetongs, ModItems.stonetongs.getRegistryName(),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_default"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_emptyhot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_emptyhotcracked"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotiron"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotironcooked"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotironfailed")
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
                  else return new ModelResourceLocation(stack.getItem().getRegistryName(), "inventory");
                }
                return new ModelResourceLocation(stack.getItem().getRegistryName(), "inventory");
            }
        });
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
    /*public static void registerRender(Item item, int meta, String fileName) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(fileName), "inventory"));

    }

    public static void registerRender(Item item, int meta, String fileName) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(fileName, "inventory"));
    }*/



}
