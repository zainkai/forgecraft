package nmd.primal.forgecraft.items;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.blocks.Crucible;
import nmd.primal.forgecraft.blocks.CrucibleHot;
import nmd.primal.forgecraft.blocks.IngotBall;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.tiles.TileBaseCrucible;
import nmd.primal.forgecraft.tiles.TileBloomery;
import nmd.primal.forgecraft.tiles.TileForge;

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

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
            NBTTagCompound tags = new NBTTagCompound();
            //this.setDamage(item, 1000);
            item.getTagCompound().setInteger("type", 0);
            item.getTagCompound().setInteger("cooldown", 0);

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
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {

        /*
         0 | Default StoneTongs
         1 | Empty Crucible Hot
         2 | Empty Crucible Cracked Hot

        ================================

         3 | Hot Iron Crucible
         4 | Hot Cooked Iron Crucible
         5 | Hot Failed Iron Crucible
         6 | Hot Iron Ingot
         7 | Hot Iron Chunk
         --------------------------------
         8 | Hot Iron Pickaxe Head
         9 | Hot Iron Axe Head
        10 | Hot Iron Shovel Head
        11 | Hot Iron Hoe Head

        ================================

        12 | Hot Clean Iron Crucible
        13 | Hot Cooked Clean Iron Crucible
        14 | Hot Failed Clean Iron Crucible
        15 | Hot Clean Iron Ball
        16 | Hot Clean Iron Chunk
        --------------------------------
        17 | Hot Clean Iron Pickaxe Head
        18 | Hot Clean Iron Axe Head
        19 | Hot Clean Iron Shovel Head
        20 | Hot Clean Iron Hoe Head

        ================================

        21 | Hot Steel Crucible
        22 | Hot Cooked Steel Crucible
        23 | Hot Failed Steel Crucible
        24 | Hot Steel Ingot
        25 | Hot Steel Chunk
        --------------------------------
        26 | Hot Steel Pickaxe Head
        27 | Hot Steel Axe Head
        28 | Hot Steel Shovel Head
        29 | Hot Steel Hoe Head
         */

        if(!world.isRemote) {
            ItemStack itemstack = player.getHeldItem(hand);
            //System.out.println(itemstack.getTagCompound().getInteger("type"));
            //System.out.println(itemstack.getSubCompound("tags"));

            /*****
             Picks Up Hot Ingots from the Ground
             *****/
            if (world.getBlockState(pos).getBlock() != ModBlocks.bloomery) {
                if (world.getBlockState(pos).getBlock() instanceof IngotBall) {
                    if(world.getBlockState(pos).getValue(IngotBall.ACTIVE) == true) {
                        if (world.getBlockState(pos).getBlock() == ModBlocks.ironball) {
                            itemstack.getTagCompound().setInteger("type", 6);
                            world.setBlockToAir(pos);
                            return EnumActionResult.SUCCESS;
                        }
                        if (world.getBlockState(pos).getBlock() == ModBlocks.ironchunk) {
                            itemstack.getTagCompound().setInteger("type", 7);
                            world.setBlockToAir(pos);
                            return EnumActionResult.SUCCESS;
                        }
                        if (world.getBlockState(pos).getBlock() == ModBlocks.ironcleanball) {
                            itemstack.getTagCompound().setInteger("type", 15);
                            world.setBlockToAir(pos);
                            return EnumActionResult.SUCCESS;
                        }
                        if (world.getBlockState(pos).getBlock() == ModBlocks.ironcleanchunk) {
                            itemstack.getTagCompound().setInteger("type", 16);
                            world.setBlockToAir(pos);
                            return EnumActionResult.SUCCESS;
                        }
                        if (world.getBlockState(pos).getBlock() == ModBlocks.steelball) {
                            itemstack.getTagCompound().setInteger("type", 24);
                            world.setBlockToAir(pos);
                            return EnumActionResult.SUCCESS;
                        }
                        if (world.getBlockState(pos).getBlock() == ModBlocks.steelchunk) {
                            itemstack.getTagCompound().setInteger("type", 25);
                            world.setBlockToAir(pos);
                            return EnumActionResult.SUCCESS;
                        }
                        /* TODO Wootz */
                    }
                }
            }


/*****
 Picks Up Hot Crucibles from the Ground
 *****/
            if (world.getBlockState(pos).getBlock() != ModBlocks.bloomery) {
                if(world.getBlockState(pos).getBlock() instanceof CrucibleHot) {
                    TileBaseCrucible tileCrucible = (TileBaseCrucible) world.getTileEntity(pos);
                    /***************************
                     *       Crucibles         *
                     ***************************/
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
                    /***************************
                     *           Iron          *
                     ***************************/
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
                    /***************************
                     *         Clean Iron      *
                     ***************************/
                    if (world.getBlockState(pos).getBlock() == ModBlocks.hotcleanironcrucible) {
                        itemstack.getTagCompound().setInteger("type", 12);
                        itemstack.getTagCompound().setInteger("cooldown", tileCrucible.countdown);
                        world.setBlockToAir(pos);
                        return EnumActionResult.SUCCESS;
                    }
                    if (world.getBlockState(pos).getBlock() == ModBlocks.hotcookedcleanironcrucible) {
                        itemstack.getTagCompound().setInteger("type", 13);
                        itemstack.getTagCompound().setInteger("cooldown", tileCrucible.countdown);
                        world.setBlockToAir(pos);
                        return EnumActionResult.SUCCESS;
                    }
                    if (world.getBlockState(pos).getBlock() == ModBlocks.failedcleanironcruciblehot) {
                        itemstack.getTagCompound().setInteger("type", 14);
                        itemstack.getTagCompound().setInteger("cooldown", tileCrucible.countdown);
                        world.setBlockToAir(pos);
                        return EnumActionResult.SUCCESS;
                    }
                    /***************************
                     *          Steel          *
                     ***************************/
                    if (world.getBlockState(pos).getBlock() == ModBlocks.hotsteelcrucible) {
                        itemstack.getTagCompound().setInteger("type", 21);
                        itemstack.getTagCompound().setInteger("cooldown", tileCrucible.countdown);
                        world.setBlockToAir(pos);
                        return EnumActionResult.SUCCESS;
                    }
                    if (world.getBlockState(pos).getBlock() == ModBlocks.hotcookedsteelcrucible) {
                        itemstack.getTagCompound().setInteger("type", 22);
                        itemstack.getTagCompound().setInteger("cooldown", tileCrucible.countdown);
                        world.setBlockToAir(pos);
                        return EnumActionResult.SUCCESS;
                    }
                    if (world.getBlockState(pos).getBlock() == ModBlocks.failedsteelcruciblehot) {
                        itemstack.getTagCompound().setInteger("type", 23);
                        itemstack.getTagCompound().setInteger("cooldown", tileCrucible.countdown);
                        world.setBlockToAir(pos);
                        return EnumActionResult.SUCCESS;
                    }
                    /* TODO Wootz */
                }
/*****
 Places the content from the Tongs to the World
 *****/
                if ((world.getBlockState(pos).getBlock() instanceof Crucible) || (world.getBlockState(pos).getBlock() instanceof CrucibleHot)) {
                    return EnumActionResult.FAIL;
                } else if (world.getBlockState(pos).getMaterial() == Material.ROCK ||
                        world.getBlockState(pos).getMaterial() == Material.SAND ||
                        world.getBlockState(pos).getMaterial() == Material.IRON ||
                        world.getBlockState(pos).getMaterial() == Material.ANVIL )
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
                                world.setBlockState(tempPos, ModBlocks.ironchunk.getDefaultState().withProperty(IngotBall.ACTIVE, true), 3);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 8:
                                return EnumActionResult.FAIL;
                            case 9:
                                return EnumActionResult.FAIL;
                            case 10:
                                return EnumActionResult.FAIL;
                            case 11:
                                return EnumActionResult.FAIL;
                            case 12:
                                world.setBlockState(tempPos, ModBlocks.hotcleanironcrucible.getDefaultState(), 3);
                                TileBaseCrucible tileCrucible12 = (TileBaseCrucible) world.getTileEntity(tempPos);
                                tileCrucible12.countdown = itemstack.getTagCompound().getInteger("cooldown");
                                itemstack.getTagCompound().setInteger("cooldown", 0);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 13:
                                world.setBlockState(tempPos, ModBlocks.hotcookedcleanironcrucible.getDefaultState(), 2);
                                TileBaseCrucible tileCrucible13 = (TileBaseCrucible) world.getTileEntity(tempPos);
                                tileCrucible13.countdown = itemstack.getTagCompound().getInteger("cooldown");
                                itemstack.getTagCompound().setInteger("cooldown", 0);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 14:
                                world.setBlockState(tempPos, ModBlocks.failedcleanironcruciblehot.getDefaultState(), 3);
                                TileBaseCrucible tileCrucible14 = (TileBaseCrucible) world.getTileEntity(tempPos);
                                tileCrucible14.countdown = itemstack.getTagCompound().getInteger("cooldown");
                                itemstack.getTagCompound().setInteger("cooldown", 0);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 15:
                                world.setBlockState(tempPos, ModBlocks.ironcleanball.getDefaultState().withProperty(IngotBall.ACTIVE, true), 3);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 16:
                                world.setBlockState(tempPos, ModBlocks.ironcleanchunk.getDefaultState().withProperty(IngotBall.ACTIVE, true), 3);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 17:
                                return EnumActionResult.FAIL;
                            case 18:
                                return EnumActionResult.FAIL;
                            case 19:
                                return EnumActionResult.FAIL;
                            case 20:
                                return EnumActionResult.FAIL;
                            case 21:
                                world.setBlockState(tempPos, ModBlocks.hotsteelcrucible.getDefaultState(), 3);
                                TileBaseCrucible tileCrucible21 = (TileBaseCrucible) world.getTileEntity(tempPos);
                                tileCrucible21.countdown = itemstack.getTagCompound().getInteger("cooldown");
                                itemstack.getTagCompound().setInteger("cooldown", 0);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 22:
                                world.setBlockState(tempPos, ModBlocks.hotcookedsteelcrucible.getDefaultState(), 3);
                                TileBaseCrucible tileCrucible22 = (TileBaseCrucible) world.getTileEntity(tempPos);
                                tileCrucible22.countdown = itemstack.getTagCompound().getInteger("cooldown");
                                itemstack.getTagCompound().setInteger("cooldown", 0);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 23:
                                world.setBlockState(tempPos, ModBlocks.failedsteelcruciblehot.getDefaultState(), 3);
                                TileBaseCrucible tileCrucible23 = (TileBaseCrucible) world.getTileEntity(tempPos);
                                tileCrucible23.countdown = itemstack.getTagCompound().getInteger("cooldown");
                                itemstack.getTagCompound().setInteger("cooldown", 0);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 24:
                                world.setBlockState(tempPos, ModBlocks.steelball.getDefaultState().withProperty(IngotBall.ACTIVE, true), 3);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
                            case 25:
                                world.setBlockState(tempPos, ModBlocks.steelchunk.getDefaultState().withProperty(IngotBall.ACTIVE, true), 3);
                                itemstack.getTagCompound().setInteger("type", 0);
                                return EnumActionResult.SUCCESS;
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
                        itemstack.getTagCompound().setInteger("cooldown", 0);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.emptycruciblecrackedhot))) {
                        itemstack.getTagCompound().setInteger("cooldown", 0);
                        itemstack.getTagCompound().setInteger("type", 2);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.hotironcrucible))) {
                        itemstack.getTagCompound().setInteger("cooldown", 0);
                        itemstack.getTagCompound().setInteger("type", 3);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.hotcookedironcrucible))) {
                        itemstack.getTagCompound().setInteger("cooldown", 0);
                        itemstack.getTagCompound().setInteger("type", 4);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.failedironcruciblehot))) {
                        itemstack.getTagCompound().setInteger("cooldown", 0);
                        itemstack.getTagCompound().setInteger("type", 5);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.hotcleanironcrucible))) {
                        itemstack.getTagCompound().setInteger("cooldown", 0);
                        itemstack.getTagCompound().setInteger("type", 12);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.hotcookedcleanironcrucible))) {
                        itemstack.getTagCompound().setInteger("cooldown", 0);
                        itemstack.getTagCompound().setInteger("type", 13);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.failedcleanironcrucible))) {
                        itemstack.getTagCompound().setInteger("cooldown", 0);
                        itemstack.getTagCompound().setInteger("type", 14);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.hotsteelcrucible))) {
                        itemstack.getTagCompound().setInteger("cooldown", 0);
                        itemstack.getTagCompound().setInteger("type", 21);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.hotcookedsteelcrucible))) {
                        itemstack.getTagCompound().setInteger("cooldown", 0);
                        itemstack.getTagCompound().setInteger("type", 22);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    } else if (tile.getSlotStack(1).getItem().equals(Item.getItemFromBlock(ModBlocks.failedsteelcrucible))) {
                        itemstack.getTagCompound().setInteger("cooldown", 0);
                        itemstack.getTagCompound().setInteger("type", 23);
                        tile.setSlotStack(1, ItemStack.EMPTY);
                        return EnumActionResult.SUCCESS;
                    }
                }

            }

/*****
 Pulls the Tool Parts from the Forge
 *****/
            if(itemstack.getTagCompound().getInteger("type") == 0){
                if (world.getBlockState(pos).getBlock() == ModBlocks.firebox) {
                    TileForge tile = (TileForge) world.getTileEntity(pos);
                    for (int i = 2; i < tile.getSlotListSize(); i++) {
                        if (tile.getSlotStack(i).getItem().equals(ModItems.ironchunkhot)) {
                            tile.setSlotStack(i, ItemStack.EMPTY);
                            itemstack.getTagCompound().setInteger("type", 7);
                            return EnumActionResult.SUCCESS;
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.ironingotballhot)) {
                            tile.setSlotStack(i, ItemStack.EMPTY);
                            itemstack.getTagCompound().setInteger("type", 6);
                            return EnumActionResult.SUCCESS;
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.pickaxehead)) {
                            if(tile.getSlotStack(i).getSubCompound("tags").getBoolean("hot") == true) {
                                itemstack.getTagCompound().setInteger("type", 8);
                                NBTTagCompound tags = tile.getSlotStack(i).getSubCompound("tags").copy();
                                itemstack.getTagCompound().setTag("tags", tags);
                                itemstack.getTagCompound().setInteger("tempDamage", tile.getSlotStack(i).getItemDamage());
                                //itemstack.getSubCompound("tags").setBoolean("hot", true);
                                tile.setSlotStack(i, ItemStack.EMPTY);
                                return EnumActionResult.SUCCESS;
                            }
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.ironaxehead)) {
                            if(tile.getSlotStack(i).getSubCompound("tags").getBoolean("hot") == true) {
                                itemstack.getTagCompound().setInteger("type", 9);
                                NBTTagCompound tags = tile.getSlotStack(i).getSubCompound("tags").copy();
                                itemstack.getTagCompound().setTag("tags", tags);
                                itemstack.getTagCompound().setInteger("tempDamage", tile.getSlotStack(i).getItemDamage());
                                //itemstack.getSubCompound("tags").setBoolean("hot", true);
                                tile.setSlotStack(i, ItemStack.EMPTY);
                                return EnumActionResult.SUCCESS;
                            }
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.ironshovelhead)) {
                            if(tile.getSlotStack(i).getSubCompound("tags").getBoolean("hot") == true) {
                                itemstack.getTagCompound().setInteger("type", 10);
                                NBTTagCompound tags = tile.getSlotStack(i).getSubCompound("tags").copy();
                                itemstack.getTagCompound().setTag("tags", tags);
                                itemstack.getTagCompound().setInteger("tempDamage", tile.getSlotStack(i).getItemDamage());
                                //itemstack.getSubCompound("tags").setBoolean("hot", true);
                                tile.setSlotStack(i, ItemStack.EMPTY);
                                return EnumActionResult.SUCCESS;
                            }
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.ironhoehead)) {
                            if(tile.getSlotStack(i).getSubCompound("tags").getBoolean("hot") == true) {
                                itemstack.getTagCompound().setInteger("type", 11);
                                NBTTagCompound tags = tile.getSlotStack(i).getSubCompound("tags").copy();
                                itemstack.getTagCompound().setTag("tags", tags);
                                itemstack.getTagCompound().setInteger("tempDamage", tile.getSlotStack(i).getItemDamage());
                                //itemstack.getSubCompound("tags").setBoolean("hot", true);
                                tile.setSlotStack(i, ItemStack.EMPTY);
                                return EnumActionResult.SUCCESS;
                            }
                        }

                        if (tile.getSlotStack(i).getItem().equals(ModItems.ironcleanchunkhot)) {
                            tile.setSlotStack(i, ItemStack.EMPTY);
                            itemstack.getTagCompound().setInteger("type", 16);
                            return EnumActionResult.SUCCESS;
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.ironcleaningotballhot)) {
                            tile.setSlotStack(i, ItemStack.EMPTY);
                            itemstack.getTagCompound().setInteger("type", 15);
                            return EnumActionResult.SUCCESS;
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.cleanironpickaxehead)) {
                            if(tile.getSlotStack(i).getSubCompound("tags").getBoolean("hot") == true) {
                                itemstack.getTagCompound().setInteger("type", 17);
                                NBTTagCompound tags = tile.getSlotStack(i).getSubCompound("tags").copy();
                                itemstack.getTagCompound().setTag("tags", tags);
                                itemstack.getTagCompound().setInteger("tempDamage", tile.getSlotStack(i).getItemDamage());
                                //itemstack.getSubCompound("tags").setBoolean("hot", true);
                                tile.setSlotStack(i, ItemStack.EMPTY);
                                return EnumActionResult.SUCCESS;
                            }
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.cleanironaxehead)) {
                            if(tile.getSlotStack(i).getSubCompound("tags").getBoolean("hot") == true) {
                                itemstack.getTagCompound().setInteger("type", 18);
                                NBTTagCompound tags = tile.getSlotStack(i).getSubCompound("tags").copy();
                                itemstack.getTagCompound().setTag("tags", tags);
                                itemstack.getTagCompound().setInteger("tempDamage", tile.getSlotStack(i).getItemDamage());
                                //itemstack.getSubCompound("tags").setBoolean("hot", true);
                                tile.setSlotStack(i, ItemStack.EMPTY);
                                return EnumActionResult.SUCCESS;
                            }
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.cleanironshovelhead)) {
                            if(tile.getSlotStack(i).getSubCompound("tags").getBoolean("hot") == true) {
                                itemstack.getTagCompound().setInteger("type", 19);
                                NBTTagCompound tags = tile.getSlotStack(i).getSubCompound("tags").copy();
                                itemstack.getTagCompound().setTag("tags", tags);
                                itemstack.getTagCompound().setInteger("tempDamage", tile.getSlotStack(i).getItemDamage());
                                //itemstack.getSubCompound("tags").setBoolean("hot", true);
                                tile.setSlotStack(i, ItemStack.EMPTY);
                                return EnumActionResult.SUCCESS;
                            }
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.cleanironhoehead)) {
                            if(tile.getSlotStack(i).getSubCompound("tags").getBoolean("hot") == true) {
                                itemstack.getTagCompound().setInteger("type", 20);
                                NBTTagCompound tags = tile.getSlotStack(i).getSubCompound("tags").copy();
                                itemstack.getTagCompound().setTag("tags", tags);
                                itemstack.getTagCompound().setInteger("tempDamage", tile.getSlotStack(i).getItemDamage());
                                //itemstack.getSubCompound("tags").setBoolean("hot", true);
                                tile.setSlotStack(i, ItemStack.EMPTY);
                                return EnumActionResult.SUCCESS;
                            }
                        }

                        if (tile.getSlotStack(i).getItem().equals(ModItems.steelchunkhot)) {
                            tile.setSlotStack(i, ItemStack.EMPTY);
                            itemstack.getTagCompound().setInteger("type", 25);
                            return EnumActionResult.SUCCESS;
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.steelingotballhot)) {
                            tile.setSlotStack(i, ItemStack.EMPTY);
                            itemstack.getTagCompound().setInteger("type", 24);
                            return EnumActionResult.SUCCESS;
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.steelpickaxehead)) {
                            if(tile.getSlotStack(i).getSubCompound("tags").getBoolean("hot") == true) {
                                itemstack.getTagCompound().setInteger("type", 26);
                                NBTTagCompound tags = tile.getSlotStack(i).getSubCompound("tags").copy();
                                itemstack.getTagCompound().setTag("tags", tags);
                                itemstack.getTagCompound().setInteger("tempDamage", tile.getSlotStack(i).getItemDamage());
                                //itemstack.getSubCompound("tags").setBoolean("hot", true);
                                tile.setSlotStack(i, ItemStack.EMPTY);
                                return EnumActionResult.SUCCESS;
                            }
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.steelaxehead)) {
                            if(tile.getSlotStack(i).getSubCompound("tags").getBoolean("hot") == true) {
                                itemstack.getTagCompound().setInteger("type", 27);
                                NBTTagCompound tags = tile.getSlotStack(i).getSubCompound("tags").copy();
                                itemstack.getTagCompound().setTag("tags", tags);
                                itemstack.getTagCompound().setInteger("tempDamage", tile.getSlotStack(i).getItemDamage());
                                //itemstack.getSubCompound("tags").setBoolean("hot", true);
                                tile.setSlotStack(i, ItemStack.EMPTY);
                                return EnumActionResult.SUCCESS;
                            }
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.steelshovelhead)) {
                            if(tile.getSlotStack(i).getSubCompound("tags").getBoolean("hot") == true) {
                                itemstack.getTagCompound().setInteger("type", 28);
                                NBTTagCompound tags = tile.getSlotStack(i).getSubCompound("tags").copy();
                                itemstack.getTagCompound().setTag("tags", tags);
                                itemstack.getTagCompound().setInteger("tempDamage", tile.getSlotStack(i).getItemDamage());
                                //itemstack.getSubCompound("tags").setBoolean("hot", true);
                                tile.setSlotStack(i, ItemStack.EMPTY);
                                return EnumActionResult.SUCCESS;
                            }
                        }
                        if (tile.getSlotStack(i).getItem().equals(ModItems.steelhoehead)) {
                            if(tile.getSlotStack(i).getSubCompound("tags").getBoolean("hot") == true) {
                                itemstack.getTagCompound().setInteger("type", 29);
                                NBTTagCompound tags = tile.getSlotStack(i).getSubCompound("tags").copy();
                                itemstack.getTagCompound().setTag("tags", tags);
                                itemstack.getTagCompound().setInteger("tempDamage", tile.getSlotStack(i).getItemDamage());
                                //itemstack.getSubCompound("tags").setBoolean("hot", true);
                                tile.setSlotStack(i, ItemStack.EMPTY);
                                return EnumActionResult.SUCCESS;
                            }
                        }
                    }
                }
            }



            else return EnumActionResult.FAIL;
            //System.out.println(itemstack.getTagCompound().getInteger("type"));
        }
        //System.out.println(player.getHeldItem(hand).getTagCompound().getInteger("type"));
        return EnumActionResult.SUCCESS;

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
        //tooltip.add(ChatFormatting.BLUE + "NBT: " + item.getSubCompound("tags"));
        //tooltip.add(ChatFormatting.RED + "NBT: " + item.getTagCompound().getInteger("type"));
    }

}
