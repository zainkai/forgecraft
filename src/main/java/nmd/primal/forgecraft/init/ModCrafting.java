package nmd.primal.forgecraft.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by kitsu on 11/30/2016.
 */
public class ModCrafting {

    public static void register() {
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.firebox),  "XXX", "XYX", "XXX", 'X', Items.BRICK, 'Y', Blocks.FURNACE);
    }
}
