package nmd.primal.forgecraft;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by mminaie on 3/17/17.
 */
public interface ToolNBT {

    default boolean getHot(ItemStack stack){
        if(stack.hasTagCompound()){
            return stack.getSubCompound("tags").getBoolean("hot");
        }
        return false;
    }
    default void setHot(ItemStack stack, Boolean bool){
        stack.getSubCompound("tags").setBoolean("hot", bool);
    }

    default int getModifiers(ItemStack stack) {
        if(stack.hasTagCompound()) {
            return stack.getSubCompound("tags").getInteger("modifiers");
        }
        return 0;
    }
    default void setModifiers(ItemStack stack, Integer mods){
        stack.getSubCompound("tags").setInteger("modifiers", mods);
    }

    default boolean getEmerald(ItemStack stack){
        return stack.getSubCompound("tags").getBoolean("emerald");
    }
    default void setEmerald(ItemStack stack, Boolean bool){
        stack.getSubCompound("tags").setBoolean("emerald", bool);
    }

    default int getDiamondLevel(ItemStack stack) {
        return stack.getSubCompound("tags").getInteger("diamond");
    }

    default void setDiamondLevel(ItemStack stack, Integer level){
        stack.getSubCompound("tags").setInteger("diamond", level);
    }


    default int getRedstoneLevel(ItemStack stack) {
        return stack.getSubCompound("tags").getInteger("redstone");
    }
    default void setRedstoneLevel(ItemStack stack, Integer level){
        stack.getSubCompound("tags").setInteger("redstone", level);
    }

    default int getLapisLevel(ItemStack stack) {
        return stack.getSubCompound("tags").getInteger("lapis");
    }
    default void setLapisLevel(ItemStack stack, Integer level){
        stack.getSubCompound("tags").setInteger("lapis", level);
    }

    default NBTTagCompound getTags(ItemStack stack){
        return stack.getSubCompound("tags");
    }

}
