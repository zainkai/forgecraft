package nmd.primal.forgecraft.items.toolparts;

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

/**
 * Created by mminaie on 3/9/17.
 */
public abstract class ToolPart extends Item {

    public ToolPart(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        this.setMaxStackSize(1);

        /*this.addPropertyOverride(new ResourceLocation("upgrade"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    return 1.0F;
                }
            }
        });*/

    }



    public static boolean isHidden()
    {
        return false;
    }

    /*
    item.setTagCompound(new NBTTagCompound());
            item.getTagCompound().setBoolean("silk_touch", false);
            item.getTagCompound().setInteger("durability", 50);
            item.getTagCompound().setFloat("speed", 0.0F);
            item.getTagCompound().setFloat("fortune", 0.0F);
            item.getTagCompound().setInteger("modifiers", 0);
            this.setMaxDamage(item.getTagCompound().getInteger("durability"));
     */

    /*@Override
    public void onCreated(ItemStack item, World worldIn, EntityPlayer playerIn) {

        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
            //this.setDamage(item, 1000);

            item.getTagCompound().setBoolean("silk_touch", false);
            item.getTagCompound().setInteger("durability", 50);
            item.getTagCompound().setFloat("speed", 0.0F);
            item.getTagCompound().setFloat("fortune", 0.0F);
            item.getTagCompound().setInteger("modifiers", 0);
            this.setMaxDamage(item.getTagCompound().getInteger("durability"));
        }

    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
            item.getTagCompound().setBoolean("silk_touch", false);
            item.getTagCompound().setInteger("durability", 50);
            item.getTagCompound().setFloat("speed", 0.0F);
            item.getTagCompound().setFloat("fortune", 0.0F);
            item.getTagCompound().setInteger("modifiers", 0);
            this.setMaxDamage(item.getTagCompound().getInteger("durability"));
        }
    }*/


}
