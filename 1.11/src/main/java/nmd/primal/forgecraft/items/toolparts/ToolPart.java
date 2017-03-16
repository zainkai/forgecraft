package nmd.primal.forgecraft.items.toolparts;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.enchantment.EnchantmentDigging;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.ModInfo;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by mminaie on 3/9/17.
 */
public class ToolPart extends Item {

    public ToolPart(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        this.setMaxStackSize(1);

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter()
        {

            /***

             hot . emerald . diamond . redstone . lapis
             0  .    0    .    0    .     0    .   0

             ***/

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack item, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (item.hasTagCompound()) {

                    if (getHot(item) == false) {
                        if (getModifiers(item) != 0) {
                            if ( (getEmerald(item) == true) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.1F;
                            }

                            if ( (getEmerald(item) == true) &&
                                    (getDiamondLevel(item) == 1) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.11F;
                            }

                            if ( (getEmerald(item) == true) &&
                                    (getDiamondLevel(item) == 2) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.12F;
                            }

                            if ( (getEmerald(item) == true) &&
                                    (getDiamondLevel(item) == 1) &&
                                    (getRedstoneLevel(item) == 1) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.111F;
                            }

                            if ( (getEmerald(item) == true) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 2) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.102F;
                            }

                            // ============

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 1) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.01F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 2) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.02F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 3) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.03F;
                            }

                            //=======

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 1) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.001F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 2) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.002F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 3) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.003F;
                            }

                            //=========

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 1)) {
                                return 0.0001F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 2)) {
                                return 0.0002F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 3)) {
                                return 0.0003F;
                            }

                            //=======

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 1) &&
                                    (getRedstoneLevel(item) == 1) &&
                                    (getLapisLevel(item) == 1)) {
                                return 0.0111F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 2) &&
                                    (getRedstoneLevel(item) == 1) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.021F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 1) &&
                                    (getRedstoneLevel(item) == 2) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.012F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 1) &&
                                    (getLapisLevel(item) == 2)) {
                                return 0.0012F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 2) &&
                                    (getLapisLevel(item) == 1)) {
                                return 0.0021F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 1) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 2) ) {
                                return 0.0102F;
                            }
                        }
                    }
                    if (getHot(item) == true) {
                        return 1.0F;
                    }

                    if (getHot(item) == false) {
                        if (item.getSubCompound("tags").getInteger("modifiers") == 0) {
                            return 0.0F;
                        }
                    }
                }
                return 0.0F;
            }
        });

    }

    public boolean getHot(ItemStack stack){
        return stack.getSubCompound("tags").getBoolean("hot");
    }
    public void setHot(ItemStack stack, Boolean bool){
        stack.getSubCompound("tags").setBoolean("hot", bool);
    }

    public int getModifiers(ItemStack stack) {
        return stack.getSubCompound("tags").getInteger("modifiers");
    }
    public void setModifiers(ItemStack stack, Integer mods){
        stack.getSubCompound("tags").setInteger("modifiers", mods);
    }

    public boolean getEmerald(ItemStack stack){
        return stack.getSubCompound("tags").getBoolean("emerald");
    }
    public void setEmerald(ItemStack stack, Boolean bool){
        stack.getSubCompound("keys").setBoolean("emerald", bool);
    }

    public int getDiamondLevel(ItemStack stack) {
        return stack.getSubCompound("tags").getInteger("diamond");
    }

    public void setDiamondLevel(ItemStack stack, Integer level){
        stack.getSubCompound("tags").setInteger("diamond", level);
    }


    public int getRedstoneLevel(ItemStack stack) {
        return stack.getSubCompound("tags").getInteger("redstone");
    }
    public void setRedstoneLevel(ItemStack stack, Integer level){
        stack.getSubCompound("tags").setInteger("redstone", level);
    }

    public int getLapisLevel(ItemStack stack) {
        return stack.getSubCompound("tags").getInteger("lapis");
    }
    public void setLapisLevel(ItemStack stack, Integer level){
        stack.getSubCompound("tags").setInteger("lapis", level);
    }

    public NBTTagCompound getTags(ItemStack stack){
        return stack.getSubCompound("tags");
    }


    public static boolean isHidden()
    {
        return false;
    }

    @Override
    public void onCreated(ItemStack item, World worldIn, EntityPlayer playerIn) {

        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
            NBTTagCompound tags = new NBTTagCompound();

            item.getTagCompound().setTag("tags", tags);

            item.getSubCompound("tags").setBoolean("hot", false);

            item.getSubCompound("tags").setBoolean("emerald", false);
            item.getSubCompound("tags").setInteger("diamond", 0);
            item.getSubCompound("tags").setInteger("redstone", 0);
            item.getSubCompound("tags").setInteger("lapis", 0);

            item.getSubCompound("tags").setInteger("modifiers", 0);
        }

    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
            NBTTagCompound tags = new NBTTagCompound();

            item.getTagCompound().setTag("tags", tags);

            item.getSubCompound("tags").setBoolean("hot", false);

            item.getSubCompound("tags").setBoolean("emerald", false);
            item.getSubCompound("tags").setInteger("diamond", 0);
            item.getSubCompound("tags").setInteger("redstone", 0);
            item.getSubCompound("tags").setInteger("lapis", 0);

            item.getSubCompound("tags").setInteger("modifiers", 0);
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
        if(player.getEntityWorld().isRemote) {

            if(item.hasTagCompound()) {

                tooltip.add(ChatFormatting.GRAY + "Upgrades");
                if  (getEmerald(item) == true) {
                    tooltip.add(ChatFormatting.DARK_GREEN + "Emerald");
                }
                if (getDiamondLevel(item) > 0) {
                    tooltip.add(ChatFormatting.AQUA + "Diamond Level: " + getDiamondLevel(item));
                }
                if (getRedstoneLevel(item) > 0) {
                    tooltip.add(ChatFormatting.RED + "Redstone Level: " + getRedstoneLevel(item));
                }
                if (getLapisLevel(item) > 0) {
                    tooltip.add(ChatFormatting.BLUE + "Lapis Level: " + getLapisLevel(item));
                }
            }
        }
    }




}
