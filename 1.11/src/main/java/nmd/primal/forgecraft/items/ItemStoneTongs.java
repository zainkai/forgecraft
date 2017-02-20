package nmd.primal.forgecraft.items;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.blocks.Crucible;
import nmd.primal.forgecraft.blocks.CrucibleHot;
import nmd.primal.forgecraft.blocks.IngotBall;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.tiles.TileBaseCrucible;
import nmd.primal.forgecraft.tiles.TileBloomery;

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
            item.getTagCompound().setInteger("cooldown", 0);
            //item.getTagCompound().setBoolean("active", false);
        }
    }

    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {

        /*
        0 | Default StoneTongs
        1 | Empty Crucible Hot
        2 | Empty Crucible Cracked Hot
        3 | Hot Iron Crucible
        4 | Hot Cooked Iron Crucible
        5 | Hot Failed Iron Crucible
        6 | Hot Iron Ingot
        7 |
         */

        if(!world.isRemote) {
            ItemStack itemstack = player.getHeldItem(hand);

            /*****
             Picks Up Hot Ingots from the Ground
             *****/
            if (world.getBlockState(pos).getBlock() != ModBlocks.bloomery) {
                if (world.getBlockState(pos).getBlock() instanceof IngotBall) {
                    //TileBaseCrucible tileCrucible = (TileBaseCrucible) world.getTileEntity(pos);
                    if (world.getBlockState(pos).getBlock() == ModBlocks.ironball) {
                        if(world.getBlockState(pos).getValue(IngotBall.ACTIVE) == true) {
                            itemstack.getTagCompound().setInteger("type", 6);
                            //itemstack.getTagCompound().setInteger("cooldown", tileCrucible.countdown);
                            world.setBlockToAir(pos);
                            System.out.println(itemstack.getTagCompound().getInteger("type"));
                            return EnumActionResult.SUCCESS;
                        }
                    }
                }
            }


/*****
 Picks Up Hot Crucibles from the Ground
 *****/
            if (world.getBlockState(pos).getBlock() != ModBlocks.bloomery) {
                if(world.getBlockState(pos).getBlock() instanceof CrucibleHot) {
                    TileBaseCrucible tileCrucible = (TileBaseCrucible) world.getTileEntity(pos);
                    if (world.getBlockState(pos).getBlock() == ModBlocks.emptycruciblehot) {
                        itemstack.getTagCompound().setInteger("type", 1);
                        itemstack.getTagCompound().setInteger("cooldown", tileCrucible.countdown);
                        world.setBlockToAir(pos);
                        return EnumActionResult.SUCCESS;
                    }
                    if (world.getBlockState(pos).getBlock() == ModBlocks.emptycruciblecrackedhot) {
                        itemstack.getTagCompound().setInteger("type", 2);
                        itemstack.getTagCompound().setInteger("cooldown", tileCrucible.countdown);
                        world.setBlockToAir(pos);
                        return EnumActionResult.SUCCESS;
                    }
                    if (world.getBlockState(pos).getBlock() == ModBlocks.hotironcrucible) {
                        itemstack.getTagCompound().setInteger("type", 3);
                        itemstack.getTagCompound().setInteger("cooldown", tileCrucible.countdown);
                        world.setBlockToAir(pos);
                        return EnumActionResult.SUCCESS;
                    }
                    if (world.getBlockState(pos).getBlock() == ModBlocks.hotcookedironcrucible) {
                        itemstack.getTagCompound().setInteger("type", 4);
                        itemstack.getTagCompound().setInteger("cooldown", tileCrucible.countdown);
                        world.setBlockToAir(pos);
                        return EnumActionResult.SUCCESS;
                    }
                    if (world.getBlockState(pos).getBlock() == ModBlocks.failedironcruciblehot) {
                        itemstack.getTagCompound().setInteger("type", 5);
                        itemstack.getTagCompound().setInteger("cooldown", tileCrucible.countdown);
                        world.setBlockToAir(pos);
                        return EnumActionResult.SUCCESS;
                    }
                }
/*****
 Places the content from the Tongs to the World
 *****/
                if ((world.getBlockState(pos).getBlock() instanceof Crucible) || (world.getBlockState(pos).getBlock() instanceof CrucibleHot)) {
                    return EnumActionResult.FAIL;
                } else if (world.getBlockState(pos).getMaterial() == Material.ROCK || world.getBlockState(pos).getMaterial() == Material.SAND)
                {
                    BlockPos tempPos = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
                    if (world.getBlockState(tempPos).getBlock() == Blocks.AIR) {
                        switch (itemstack.getTagCompound().getInteger("type")) {
                            case 0:
                                break;
                            case 1:
                                world.setBlockState(tempPos, ModBlocks.emptycruciblehot.getDefaultState(), 3);
                                TileBaseCrucible tileCrucible1 = (TileBaseCrucible) world.getTileEntity(tempPos);
                                tileCrucible1.countdown = itemstack.getTagCompound().getInteger("cooldown");
                                itemstack.getTagCompound().setInteger("cooldown", 0);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 2:
                                world.setBlockState(tempPos, ModBlocks.emptycruciblecrackedhot.getDefaultState(), 3);
                                TileBaseCrucible tileCrucible2 = (TileBaseCrucible) world.getTileEntity(tempPos);
                                tileCrucible2.countdown = itemstack.getTagCompound().getInteger("cooldown");
                                itemstack.getTagCompound().setInteger("cooldown", 0);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 3:
                                world.setBlockState(tempPos, ModBlocks.hotironcrucible.getDefaultState(), 3);
                                TileBaseCrucible tileCrucible3 = (TileBaseCrucible) world.getTileEntity(tempPos);
                                tileCrucible3.countdown = itemstack.getTagCompound().getInteger("cooldown");
                                itemstack.getTagCompound().setInteger("cooldown", 0);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 4:
                                world.setBlockState(tempPos, ModBlocks.hotcookedironcrucible.getDefaultState(), 3);
                                TileBaseCrucible tileCrucible4 = (TileBaseCrucible) world.getTileEntity(tempPos);
                                tileCrucible4.countdown = itemstack.getTagCompound().getInteger("cooldown");
                                itemstack.getTagCompound().setInteger("cooldown", 0);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 5:
                                world.setBlockState(tempPos, ModBlocks.failedironcruciblehot.getDefaultState(), 3);
                                TileBaseCrucible tileCrucible5 = (TileBaseCrucible) world.getTileEntity(tempPos);
                                tileCrucible5.countdown = itemstack.getTagCompound().getInteger("cooldown");
                                itemstack.getTagCompound().setInteger("cooldown", 0);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 6:
                                world.setBlockState(tempPos, ModBlocks.ironball.getDefaultState().withProperty(IngotBall.ACTIVE, true), 3);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 7:
                                return EnumActionResult.FAIL;
                        }
                    }
                }
            }
/*****
 Pulls the crucible from the Bloomery
 *****/
            if(itemstack.getTagCompound().getInteger("type") == 0){
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
                    } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.hotironcrucible))) {
                        itemstack.getTagCompound().setInteger("type", 3);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.hotcookedironcrucible))) {
                        itemstack.getTagCompound().setInteger("type", 4);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.failedironcruciblehot))) {
                        itemstack.getTagCompound().setInteger("type", 5);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    }
                }

            }
            else return EnumActionResult.FAIL;
            System.out.println(itemstack.getTagCompound().getInteger("type"));
        }
        return EnumActionResult.FAIL;
    }

}
