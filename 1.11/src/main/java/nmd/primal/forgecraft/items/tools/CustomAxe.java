package nmd.primal.forgecraft.items.tools;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.ToolNBT;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by mminaie on 3/20/17.
 */
public class CustomAxe extends ItemAxe implements ToolNBT {

    public CustomAxe(String name, Item.ToolMaterial material) {
        super(material, 6, -3.1f);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        this.setMaxStackSize(1);
        this.setNoRepair();

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {

            /***

             hot . emerald . diamond . redstone . lapis
             0  .    0    .    0    .     0    .   0

             ***/

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack item, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (item.hasTagCompound()) {



                        if (getHot(item) != true) {
                            if (getModifiers(item) != 0) {
                                if ((getEmerald(item) == true) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.1F;
                                }

                                if ((getEmerald(item) == true) &&
                                        (getDiamondLevel(item) == 1) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.11F;
                                }

                                if ((getEmerald(item) == true) &&
                                        (getDiamondLevel(item) == 2) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.12F;
                                }

                                if ((getEmerald(item) == true) &&
                                        (getDiamondLevel(item) == 1) &&
                                        (getRedstoneLevel(item) == 1) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.111F;
                                }

                                if ((getEmerald(item) == true) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 2) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.102F;
                                }

                                // ============

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 1) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.01F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 2) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.02F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 3) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.03F;
                                }

                                //=======

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 1) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.001F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 2) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.002F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 3) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.003F;
                                }

                                //=========

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 1)) {
                                    return 0.0001F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 2)) {
                                    return 0.0002F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 3)) {
                                    return 0.0003F;
                                }

                                //=======

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 1) &&
                                        (getRedstoneLevel(item) == 1) &&
                                        (getLapisLevel(item) == 1)) {
                                    return 0.0111F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 2) &&
                                        (getRedstoneLevel(item) == 1) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.021F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 1) &&
                                        (getRedstoneLevel(item) == 2) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.012F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 1) &&
                                        (getLapisLevel(item) == 2)) {
                                    return 0.0012F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 2) &&
                                        (getLapisLevel(item) == 1)) {
                                    return 0.0021F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 1) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 2)) {
                                    return 0.0102F;
                                }
                            }
                        }
                        if (getHot(item) == true) {
                            return 1.0F;
                        }

                        if (getHot(item) == false) {
                            if (getModifiers(item) == 0) {
                                return 0.0F;
                            }
                        }

                }
                return 0.0F;
            }
        });
    }

    public static boolean isHidden()
    {
        return false;
    }

    @Override
    public void onCreated(ItemStack item, World world, EntityPlayer playerIn) {

        if(!world.isRemote) {
            if (!item.hasTagCompound()) {
                item.setTagCompound(new NBTTagCompound());
                NBTTagCompound tags = new NBTTagCompound();

                item.getTagCompound().setTag("tags", tags);

                /*setHot(item, false);

                setHot(item, false);
                setEmerald(item, false);
                setDiamondLevel(item, 0);
                setRedstoneLevel(item, 0);
                setLapisLevel(item, 0);
                setModifiers(item, 0);*/
            }
        }

    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        if(!world.isRemote) {
            if (!item.hasTagCompound()) {
                item.setTagCompound(new NBTTagCompound());
                NBTTagCompound tags = new NBTTagCompound();

                item.getTagCompound().setTag("tags", tags);

                setHot(item, false);
                setEmerald(item, false);
                setDiamondLevel(item, 0);
                setRedstoneLevel(item, 0);
                setLapisLevel(item, 0);
                setModifiers(item, 0);

            }
        }
    }

    //public void onItemTooltip(ItemTooltipEvent event){

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
        if(!item.isEmpty()) {
            if (player.getEntityWorld().isRemote) {

                if (item.hasTagCompound()) {

                    tooltip.add(ChatFormatting.GRAY + "Upgrades Left: " + (3 - getModifiers(item)) );
                    if (getEmerald(item) == true) {
                        tooltip.add(ChatFormatting.DARK_GREEN + "Emerald");
                    }
                    if (getDiamondLevel(item) > 0) {
                        tooltip.add(ChatFormatting.AQUA + "Diamond Level: " + getDiamondLevel(item));
                    }
                    if (getRedstoneLevel(item) > 0) {
                        tooltip.add(ChatFormatting.RED + "Redstone Level: " + getRedstoneLevel(item) );
                    }
                    if (getLapisLevel(item) > 0) {
                        tooltip.add(ChatFormatting.BLUE + "Lapis Level: " + getLapisLevel(item) );
                    }
                    tooltip.add(ChatFormatting.LIGHT_PURPLE + "Damage: " + item.getItemDamage() );
                }
            }
        }
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        if(!player.world.isRemote){
            World world = player.getEntityWorld();
            //System.out.println(world.getBlockState(pos).getBlock());
            if(itemstack.getItem() instanceof CustomAxe){
                if( getEmerald(itemstack)){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(33), 1);
                }
                if( getDiamondLevel(itemstack) > 0 ){
                    //itemstack.addEnchantment(Enchantment.getEnchantmentByID(34), getDiamondLevel(itemstack));
                    itemstack.getItem().setHarvestLevel("pickaxe", 3);
                }
                /*if( getRedstoneLevel(itemstack) > 0 ){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(32), getRedstoneLevel(itemstack));
                    //System.out.println(itemstack.getEnchantmentTagList());
                }*/
                if ( getLapisLevel(itemstack) > 0) {
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(35), getLapisLevel(itemstack));
                }
            }
        }

        return false;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if (!worldIn.isRemote && (double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {

            stack.getTagCompound().removeTag("ench");
            //System.out.println(stack.getTagCompound());
            if(getDiamondLevel(stack) > 0) {
                if(ThreadLocalRandom.current().nextInt(0, getDiamondLevel(stack)) == 0) {
                    stack.damageItem(1, entityLiving);
                }
            } else stack.damageItem(1, entityLiving);
        }

        return true;
    }

    @Override
    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        //return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;

        if(material != Material.WOOD && material != Material.PLANTS && material != Material.VINE){
            return  super.getStrVsBlock(stack, state);
        } else {
            return this.efficiencyOnProperMaterial * ( (this.getRedstoneLevel(stack) * 2 ) + 1);
        }

    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return false;
    }

    @Override
    public boolean isRepairable()
    {
        return false;
    }

    public int getItemEnchantability(ItemStack stack)
    {
        return 0;
    }

}
