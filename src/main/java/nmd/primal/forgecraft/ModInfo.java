package nmd.primal.forgecraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.Item.ModItems;

/**
 * Created by kitsu on 11/24/2016.
 */
public class ModInfo {
        /** Mod Details**/
    public static final String DEPENDENCIES = "after:primal;";
    public static final String MOD_ID = "forgecraft";
    public static final String MOD_PREFIX = MOD_ID + ":";
    public static final String MOD_CHANNEL = MOD_ID;
    public static final String MOD_VERSION = "0.0.0";
    public static final String MC_VERSIONS = "[1.9.4, 1.11.0)";

    /** Mod Structures **/
    public static final String COMMON_PROXY = "nmd.primal.forgecraft.proxy.CommonProxy";
    public static final String CLIENT_PROXY = "nmd.primal.forgecraft.proxy.ClientProxy";
    public static final String GUI_FACTORY  = "nmd.primal.forgecraft.gui.GuiFactory";
    public static final String UPDATE_JSON  = "";

    /** GUI IDs **/
    //public static final int WORKTABLE_BASIC = 0;
    //public static final int WORKTABLE_SHELF = 1;
    //public static final int WORKTABLE_CHEST = 2;
    //public static final int STORAGE_CRATE = 4;
    //public static final int CHEST_NETHER = 5;
    //public static final int QUERN = 6;
    //public static final int KLIN = 7;
    //public static final int OVEN = 8;

    /** Creative Tabs **/
    public static CreativeTabs TAB_FORGECRAFT = new CreativeTabs(MOD_ID) {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() { return ModItems.test; }
        };
}