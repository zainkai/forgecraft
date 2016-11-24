package nmd.primal.forgecraft.api;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ForgeCraftMaterials
{
    /**
     * Vanilla ToolMaterials
     * ToolMaterial addToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability)
     *
     * WOOD(0, 59, 2.0F, 0.0F, 15),
     * STONE(1, 131, 4.0F, 1.0F, 5),
     * IRON(2, 250, 6.0F, 2.0F, 14),
     * DIAMOND(3, 1561, 8.0F, 3.0F, 10),
     * GOLD(0, 32, 12.0F, 0.0F, 22);
     *
     * CLOTH(5, new int[]{1, 3, 2, 1}, 15), CHAIN(15, new int[]{2, 5, 4, 1}, 12), IRON(15, new int[]{2, 6, 5, 2}, 9), GOLD(7, new int[]{2, 5, 3, 1}, 25), DIAMOND(33, new int[]{3, 8, 6, 3}, 10);
     *
     * survivalist
     * "flint", 1, 150, 5.0F, 1.5F, 5
     */
    //Tool ToolMaterials
    //public static Item.ToolMaterial TOOL_BONE        = EnumHelper.addToolMaterial("BONE", 0, 64, 2.0F, 0, 16);


     //Armor ToolMaterials
     //public static ItemArmor.ArmorMaterial ARMOR_BONE         = EnumHelper.addArmorMaterial("BONE", "", 8, new int[]{3, 7, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 1.0F);


    ///
    // Block Materials
    ///

    public boolean canBurn;
    public boolean replaceable;
    public boolean isTranslucent;
    public boolean requiresNoTool = true;

    //public static final Material CRAFTED_SNOW = (new Material(MapColor.SNOW)).setRequiresTool();
    //public static final Material ASH;


    /**
     * Marks the material as translucent
     */
    private Material setTranslucent(Material material)
    {
        this.isTranslucent = true;
        return material;
    }

    /**
     * Makes blocks with this material require the correct tool to be harvested.
     */
    protected Material setRequiresTool(Material material)
    {
        this.requiresNoTool = false;
        return material;
    }

    /**
     * Set the canBurn bool to True and return the current object.
     */
    protected Material setBurning(Material material)
    {
        this.canBurn = true;
        return material;
    }

}