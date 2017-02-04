package nmd.primal.forgecraft.items;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.tiles.TileBloomery;
import nmd.primal.forgecraft.handler.EnumHandler.TongTypes;

import java.util.List;

/**
 * Created by mminaie on 1/23/17.
 */
public class ItemStoneTongs extends Item {

    public ItemStoneTongs(String unlocalizedName) {
        setUnlocalizedName(unlocalizedName);
        this.setRegistryName(unlocalizedName);
        //this.setMaxDamage(0);
        //this.setHasSubtypes(true);  //This just says the item has metadata
        this.setMaxStackSize(1);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
    }


    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
            //this.setDamage(item, 1000);
            item.getTagCompound().setInteger("type", 0);
            //item.getTagCompound().setBoolean("active", false);
        }
    }

    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote) {
            ItemStack itemstack = player.getHeldItem(hand);
            if (world.getBlockState(pos).getBlock() != ModBlocks.bloomery) {
                if (world.getBlockState(pos).getMaterial() == Material.ROCK || world.getBlockState(pos).getMaterial() == Material.ROCK) {
                    BlockPos tempPos = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
                    if (world.getBlockState(tempPos).getBlock() == Blocks.AIR) {
                        switch (itemstack.getTagCompound().getInteger("type")) {
                            case 0:
                                break;
                            case 1:
                                world.setBlockState(tempPos, ModBlocks.emptycruciblehot.getDefaultState(), 3);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 2:
                                world.setBlockState(tempPos, ModBlocks.emptycruciblecrackedhot.getDefaultState(), 3);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 3:
                                return EnumActionResult.FAIL;
                            case 4:
                                return EnumActionResult.FAIL;
                            case 5:
                                return EnumActionResult.FAIL;
                            case 6:
                                return EnumActionResult.FAIL;
                            case 7:
                                return EnumActionResult.FAIL;
                        }
                    }
                }
            }
            if (world.getBlockState(pos).getBlock() == ModBlocks.bloomery) {
                TileBloomery tile = (TileBloomery) world.getTileEntity(pos);
                if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.emptycruciblehot))) {
                    itemstack.getTagCompound().setInteger("type", 1);
                    tile.setSlotStack(1, ItemStack.EMPTY);
                    return EnumActionResult.SUCCESS;
                } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.emptycruciblecrackedhot))) {
                    itemstack.getTagCompound().setInteger("type", 2);
                    tile.setSlotStack(1, ItemStack.EMPTY);
                    return EnumActionResult.SUCCESS;
                } else return EnumActionResult.FAIL;
            } else return EnumActionResult.FAIL;
        }
        return EnumActionResult.FAIL;
    }

}
