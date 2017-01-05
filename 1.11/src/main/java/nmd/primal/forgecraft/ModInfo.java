package nmd.primal.forgecraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.blocks.PistonBellows;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;
//import nmd.primal.forgecraft.Item.ModItems;

/**
 * Created by kitsu on 11/24/2016.
 */
public class ModInfo {
        /** Mod Details**/
    //public static final String DEPENDENCIES = "after:primal;";
    public static final String MOD_ID = "forgecraft";
    public static final String MOD_NAME = "Kitsu's ForgeCraft";
    //public static final String MOD_PREFIX = MOD_ID + ":";
    //public static final String MOD_CHANNEL = MOD_ID;
    public static final String MOD_VERSION = "1.0.1";
    public static final String MC_VERSIONS = "[1.9.4, 1.11.2)";

    /** Mod Structures **/
    public static final String SERVER_PROXY = "nmd.primal.forgecraft.proxy.ServerProxy";
    public static final String CLIENT_PROXY = "nmd.primal.forgecraft.proxy.ClientProxy";
    //public static final String GUI_FACTORY  = "nmd.primal.forgecraft.gui.GuiFactory";
    //public static final String UPDATE_JSON  = "";

    public enum ForgecraftItems {
        TEST("test", "ItemTest");

        private String unlocalizedName;
        private String registryName;

        ForgecraftItems(String unlocalizedName, String registryName) {
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }
        public String getRegistryName() {
            return registryName;
        }

    }

    public enum ForgecraftBlocks {
        FIREBOX("firebox", "firebox"),
        PISTONBELLOWS("pistonbellows", "pistonbellows");

        private String unlocalizedName;
        private String registryName;

        ForgecraftBlocks(String unlocalizedName, String registryName) {
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }
        public String getRegistryName() {
            return registryName;
        }

    }

    /** Creative Tabs **/
    public static CreativeTabs TAB_FORGECRAFT = new CreativeTabs(MOD_ID)
    {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ModBlocks.firebox);
        }
    };

    /*
        public static CreativeTabs TAB_PRIMAL = new CreativeTabs(MOD_ID)
    {

        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(PrimalItems.FLINT_HATCHET);
        }

    };
    */


}