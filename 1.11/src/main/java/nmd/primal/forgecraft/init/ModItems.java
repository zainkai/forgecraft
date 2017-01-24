package nmd.primal.forgecraft.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.items.ItemBellowsHandle;
import nmd.primal.forgecraft.items.ItemSoftCrucible;
import nmd.primal.forgecraft.items.ItemStoneTongs;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ModItems {

    public static Item pistonbellows;
    public static Item test;
    public static Item softcrucible;
    public static Item stonetongs;

    //public static ModelResourceLocation modelLocation = new ModelResourceLocation("stonetongs", "inventory");

    /*
        @Override
    public void preInit(FMLPreInitializationEvent event) {
        OBJLoader.INSTANCE.addDomain(TutorialMod.MODID);
        registerModel(ModItems.tutorialItem);
    }

    public void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(TutorialMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
    */



    public static void init() {
        OBJLoader.INSTANCE.addDomain(ModInfo.MOD_ID);
        pistonbellows = new ItemBellowsHandle();
        softcrucible = new ItemSoftCrucible();
        stonetongs = new ItemStoneTongs();
        //test = new ItemTest();
    }

    public static void register() {
        GameRegistry.register(pistonbellows);
        GameRegistry.register(softcrucible);
        GameRegistry.register(stonetongs);
        //GameRegistry.register(test);
    }

    public static void registerRenders() {
        registerRender(pistonbellows);
        registerRender(softcrucible);
        registerRender(stonetongs);
        //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(stonetongs, 0, new ModelResourceLocation("stonetongs", "inventory"););
        //ModelLoader.setCustomModelResourceLocation(stonetongs, 0, new ModelResourceLocation(ModInfo.MOD_ID + ":" + stonetongs + ".obj", "inventory"));
        //registerRender(test);
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
