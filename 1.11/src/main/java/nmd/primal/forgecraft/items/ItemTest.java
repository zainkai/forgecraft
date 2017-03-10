package nmd.primal.forgecraft.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.ModInfo;

import javax.annotation.Nullable;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ItemTest extends BaseItem {

    public ItemTest() {
        setUnlocalizedName(ModInfo.ForgecraftItems.TEST.getUnlocalizedName());
        setRegistryName(ModInfo.ForgecraftItems.TEST.getRegistryName());

        this.addPropertyOverride(new ResourceLocation("test"), new IItemPropertyGetter()
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
        });
    }

}
