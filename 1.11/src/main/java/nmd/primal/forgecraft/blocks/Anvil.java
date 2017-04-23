package nmd.primal.forgecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalItems;
import nmd.primal.core.api.PrimalMaterials;
import nmd.primal.core.common.items.tools.WorkMallet;
import nmd.primal.forgecraft.CommonUtils;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.crafting.AnvilCrafting;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.BaseMultiItem;
import nmd.primal.forgecraft.items.ForgeHammer;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.tiles.TileAnvil;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by mminaie on 3/4/17.
 */
public class Anvil extends CustomContainerFacing {


    double[] normalMin = {0.0625, 0.25, 0.4375, 0.625, 0.8125};

    public double getNormalMin(Integer x) {
        return normalMin[x];
    }

    double[] normalMax = {0.1875, 0.375, 0.5625, 0.75, 0.9375};

    public double getNormalMax(Integer x) {
        return normalMax[x];
    }

    double[] reverseMin = {0.8125, 0.625, 0.4375, 0.25, 0.0625};

    public double getReverseMin(Integer x) {
        return reverseMin[x];
    }

    double[] reverseMax = {0.9375, 0.75, 0.5625, 0.375, 0.1875};

    public double getReverseMax(Integer x) {
        return reverseMax[x];
    }

    public Anvil(Material material, String registryName, Float hardness) {
        super(material);
        setUnlocalizedName(registryName);
        setRegistryName(registryName);
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setHardness(hardness);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz) {

        /*if (!player.isSwingInProgress) {
            player.swingArm(hand);
        }*/


        /******************************************************************************
         Crafting Anvil Recipes
         *****************************************************************************/
        if (!world.isRemote) {
            ItemStack pItem = player.inventory.getCurrentItem();
            TileAnvil tile = (TileAnvil) world.getTileEntity(pos);
            if (tile != null) {
                //System.out.println("Tile is not null");
                //if ((player.inventory.getCurrentItem().getItem().equals(PrimalItems.STONE_GALLAGHER)) || (player.inventory.getCurrentItem().getItem() == ModItems.forgehammer)) {



                if ((pItem.getItem() instanceof WorkMallet) || (pItem.getItem() == ModItems.forgehammer)) {


                    String[] tempArray = new String[25];
                    for (int i = 0; i < 25; i++) {

                        tempArray[i] = tile.getSlotStack(i).getItem().getRegistryName().toString();
                        //System.out.println(i + " || " + tempArray[i] + " || " + tile.getSlotStack(i).getItem());
                    }

                    if(this.getRegistryName().toString().equals("stoneanvil")){
                        for (int i = 0; i < 25; i++) {
                            if (tile.getSlotStack(i).getItem() instanceof BaseMultiItem) {
                                if(((BaseMultiItem) tile.getSlotStack(i).getItem()).getMaterial(tile.getSlotStack(i).getItem()) != PrimalMaterials.TOOL_WROUGHT_IRON ) {
                                    world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                                    CommonUtils.spawnItemEntityFromWorld(world, pos, new ItemStack(PrimalItems.ROCK_STONE, 3));
                                    CommonUtils.spawnItemEntityFromWorld(world, pos, new ItemStack(ModBlocks.ironball, 1));
                                    for (ItemStack stack : tile.getSlotList()) {
                                        if (stack != null) {
                                            float offset = 0.7F;
                                            double offsetX = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                                            double offsetY = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                                            double offsetZ = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                                            EntityItem item = new EntityItem(world, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ, stack);
                                            item.setDefaultPickupDelay();
                                            world.spawnEntity(item);
                                            world.removeTileEntity(pos);
                                            world.playEvent(1031, pos, 0);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    AnvilCrafting recipe = AnvilCrafting.getRecipe(tempArray);

                    if (recipe != null) {
                        if (pItem.getItem() instanceof WorkMallet) {
                            pItem.damageItem(15, player);
                        }
                        if (pItem.getItem() instanceof ForgeHammer) {
                            pItem.damageItem(1, player);
                        }
                        world.playEvent(1031, pos, 0);


                        if (ThreadLocalRandom.current().nextInt(0, 2)==0) {

                            if (recipe.getOutput().getItem() instanceof ToolPart) {

                                if (!tile.getSlotStack(12).getItem().equals(recipe.getOutput().getItem())) {
                                    ItemStack tempStack = recipe.getOutput();
                                    tempStack.setTagCompound(new NBTTagCompound());
                                    NBTTagCompound tags = new NBTTagCompound();

                                    tempStack.getTagCompound().setTag("tags", tags);
                                    tempStack.getSubCompound("tags").setBoolean("hot", false);

                                    tempStack.getSubCompound("tags").setBoolean("emerald", false);
                                    tempStack.getSubCompound("tags").setInteger("diamond", 0);
                                    tempStack.getSubCompound("tags").setInteger("redstone", 0);
                                    tempStack.getSubCompound("tags").setInteger("lapis", 0);

                                    tempStack.getSubCompound("tags").setInteger("modifiers", 0);
                                    CommonUtils.spawnItemEntityFromWorld(world, pos, tempStack);
                                }

                                if (tile.getSlotStack(12).getItem().equals(recipe.getOutput().getItem())) {

                                    NBTTagCompound tempNBT = tile.getSlotStack(12).getSubCompound("tags");
                                    ItemStack outputStack = recipe.getOutput();
                                    outputStack.setTagCompound(new NBTTagCompound());
                                    outputStack.getTagCompound().setTag("tags", tempNBT);
                                    outputStack.getSubCompound("tags").setBoolean("hot", false);

                                    if (recipe.getUpgrade() == "repair") {
                                        CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                                    }

                                    if (outputStack.getSubCompound("tags").getInteger("modifiers") < 3) {

                                        //Upgrade emerald
                                        if (recipe.getUpgrade() == "emerald") {
                                            if (outputStack.getSubCompound("tags").getInteger("lapis") == 0) {
                                                if (outputStack.getSubCompound("tags").getBoolean("emerald") == false) {
                                                    outputStack.setItemDamage(tile.getSlotStack(12).getItemDamage());
                                                    outputStack.getSubCompound("tags").setInteger("emerald",
                                                            (outputStack.getSubCompound("tags").getInteger("emerald") + 1));
                                                    outputStack.getSubCompound("tags").setInteger("modifiers",
                                                            (outputStack.getSubCompound("tags").getInteger("modifiers") + 1));
                                                    CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                                                }
                                            }
                                        }

                                        //Upgrade diamond
                                        if (recipe.getUpgrade() == "diamond") {
                                            outputStack.setItemDamage(tile.getSlotStack(12).getItemDamage());
                                            outputStack.getSubCompound("tags").setInteger("diamond",
                                                    (outputStack.getSubCompound("tags").getInteger("diamond") + 1));
                                            outputStack.getSubCompound("tags").setInteger("modifiers",
                                                    (outputStack.getSubCompound("tags").getInteger("modifiers") + 1));
                                            CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                                        }

                                        //Upgrade redstone
                                        if (recipe.getUpgrade() == "redstone") {
                                            outputStack.setItemDamage(tile.getSlotStack(12).getItemDamage());
                                            outputStack.getSubCompound("tags").setInteger("redstone",
                                                    (outputStack.getSubCompound("tags").getInteger("redstone") + 1));
                                            outputStack.getSubCompound("tags").setInteger("modifiers",
                                                    (outputStack.getSubCompound("tags").getInteger("modifiers") + 1));
                                            CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                                        }

                                        //Upgrade lapis
                                        if (recipe.getUpgrade() == "lapis") {
                                            outputStack.setItemDamage(tile.getSlotStack(12).getItemDamage());
                                            if (outputStack.getSubCompound("tags").getBoolean("emerald") == false) {
                                                outputStack.getSubCompound("tags").setInteger("lapis",
                                                        (outputStack.getSubCompound("tags").getInteger("lapis") + 1));
                                                outputStack.getSubCompound("tags").setInteger("modifiers",
                                                        (outputStack.getSubCompound("tags").getInteger("modifiers") + 1));
                                                CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                                            }
                                        }
                                    }
                                }
                            } else {
                                CommonUtils.spawnItemEntityFromWorld(world, pos, recipe.getOutput());
                            }
                            //world.playEvent(1031, pos, 0);
                            for (int i = 0; i < tile.getSlotListSize(); i++) {
                                if (!tile.getSlotStack(i).isEmpty()) {
                                    tile.setSlotStack(i, ItemStack.EMPTY);
                                }
                            }
                            return true;
                        }
                    }
                }
                //}


                /*****************************************************************************
                 Adding and Removing Inventory With Tongs
                 *****************************************************************************/


                if ( (!(pItem.getItem() instanceof WorkMallet)) || (!(pItem.getItem() instanceof ForgeHammer)) ) {
                    if(Block.getBlockFromItem(pItem.getItem()) instanceof IngotBall) {
                        return false;
                    }

                    if (state.getValue(FACING) == EnumFacing.NORTH) {
                        int counter = 0;
                        for (int z = 0; z < 5; z++) {
                            for (int x = 0; x < 5; x++) {
                                if (hitx >= this.getNormalMin(x) && hitx <= this.getNormalMax(x)) {
                                    if (hitz >= this.getNormalMin(z) && hitz <= this.getNormalMax(z)) {
                                        doWork(pItem, counter, tile, world, pos, player);
                                        return true;
                                    }
                                }
                                counter++;
                            }
                        }
                    }
                    if (state.getValue(FACING) == EnumFacing.SOUTH) {
                        int counter = 0;
                        for (int z = 0; z < 5; z++) {
                            for (int x = 0; x < 5; x++) {
                                if (hitx >= this.getReverseMin(x) && hitx <= this.getReverseMax(x)) {
                                    if (hitz >= this.getReverseMin(z) && hitz <= this.getReverseMax(z)) {
                                        doWork(pItem, counter, tile, world, pos, player);
                                        return true;
                                    }
                                }
                                counter++;
                            }
                        }
                    }
                    if (state.getValue(FACING) == EnumFacing.WEST) {
                        int counter = 0;
                        for (int x = 0; x < 5; x++) {
                            for (int z = 0; z < 5; z++) {
                                if (hitx >= this.getNormalMin(x) && hitx <= this.getNormalMax(x)) {
                                    if (hitz >= this.getReverseMin(z) && hitz <= this.getReverseMax(z)) {
                                        doWork(pItem, counter, tile, world, pos, player);
                                        return true;
                                    }
                                }
                                counter++;
                            }
                        }
                    }
                    if (state.getValue(FACING) == EnumFacing.EAST) {
                        int counter = 0;
                        for (int x = 0; x < 5; x++) {
                            for (int z = 0; z < 5; z++) {
                                if (hitx >= this.getReverseMin(x) && hitx <= this.getReverseMax(x)) {
                                    if (hitz >= this.getNormalMin(z) && hitz <= this.getNormalMax(z)) {
                                        doWork(pItem, counter, tile, world, pos, player);
                                        return true;
                                    }
                                }
                                counter++;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    private boolean doWork(ItemStack pItem, Integer counter, TileAnvil tile, World world, BlockPos pos, EntityPlayer player) {

        if (pItem.getItem().equals(ModItems.stonetongs)) {
            if ((pItem.getTagCompound().getInteger("type") == 6) ||
                    (pItem.getTagCompound().getInteger("type") == 7) ||
                    (pItem.getTagCompound().getInteger("type") == 8) ||
                    (pItem.getTagCompound().getInteger("type") == 9) ||
                    (pItem.getTagCompound().getInteger("type") == 10) ||
                    (pItem.getTagCompound().getInteger("type") == 11) ||
                    (pItem.getTagCompound().getInteger("type") == 15) ||
                    (pItem.getTagCompound().getInteger("type") == 16) ||
                    (pItem.getTagCompound().getInteger("type") == 17) ||
                    (pItem.getTagCompound().getInteger("type") == 18) ||
                    (pItem.getTagCompound().getInteger("type") == 19) ||
                    (pItem.getTagCompound().getInteger("type") == 20) ||
                    (pItem.getTagCompound().getInteger("type") == 24) ||
                    (pItem.getTagCompound().getInteger("type") == 25) ||
                    (pItem.getTagCompound().getInteger("type") == 26) ||
                    (pItem.getTagCompound().getInteger("type") == 27) ||
                    (pItem.getTagCompound().getInteger("type") == 28) ||
                    (pItem.getTagCompound().getInteger("type") == 29) ||
                    (pItem.getTagCompound().getInteger("type") == 0)) {
                //System.out.println("Level 1");

                if (!tile.getSlotStack(counter).isEmpty()) {
                    if (pItem.getTagCompound().getInteger("type") == 0) {
                        if (tile.getSlotStack(counter).getItem().equals(ModItems.ironingotballhot)) {
                            pItem.getTagCompound().setInteger("type", 6);
                            tile.setSlotStack(counter, ItemStack.EMPTY);
                            return true;
                        }
                        if (tile.getSlotStack(counter).getItem().equals(ModItems.ironchunkhot)) {
                            pItem.getTagCompound().setInteger("type", 7);
                            tile.setSlotStack(counter, ItemStack.EMPTY);
                            return true;
                        }

                        if (tile.getSlotStack(counter).getItem().equals(ModItems.ironcleaningotballhot)) {
                            pItem.getTagCompound().setInteger("type", 15);
                            tile.setSlotStack(counter, ItemStack.EMPTY);
                            return true;
                        }
                        if (tile.getSlotStack(counter).getItem().equals(ModItems.ironcleanchunkhot)) {
                            pItem.getTagCompound().setInteger("type", 16);
                            tile.setSlotStack(counter, ItemStack.EMPTY);
                            return true;
                        }

                        if (tile.getSlotStack(counter).getItem().equals(ModItems.steelingotballhot)) {
                            pItem.getTagCompound().setInteger("type", 24);
                            tile.setSlotStack(counter, ItemStack.EMPTY);
                            return true;
                        }
                        if (tile.getSlotStack(counter).getItem().equals(ModItems.steelchunkhot)) {
                            pItem.getTagCompound().setInteger("type", 25);
                            tile.setSlotStack(counter, ItemStack.EMPTY);
                            return true;
                        }

                    }
                }

                if (tile.getSlotStack(counter).isEmpty()) {
                    //System.out.println("Activating");
                    if (pItem.getTagCompound().getInteger("type") == 6) {
                        //System.out.println("Tongs meta = 6");
                        tile.setSlotStack((counter), new ItemStack(ModItems.ironingotballhot, 1));
                        pItem.getTagCompound().setInteger("type", 0);
                        //return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 7) {
                        //System.out.println("Tongs meta = 7");
                        tile.setSlotStack((counter), new ItemStack(ModItems.ironchunkhot, 1));
                        pItem.getTagCompound().setInteger("type", 0);
                        ///System.out.println(counter);
                        //System.out.println(tile.getSlotStack(counter));
                        //return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 8) {
                        ItemStack tempStack = new ItemStack(ModItems.pickaxehead, 1);
                        tempStack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound tags = pItem.getSubCompound("tags").copy();
                        tempStack.getTagCompound().setTag("tags", tags);
                        tempStack.setItemDamage(pItem.getTagCompound().getInteger("tempDamage"));
                        tile.setSlotStack((counter), tempStack);

                        pItem.getTagCompound().setInteger("type", 0);
                        pItem.getSubCompound("tags").setBoolean("hot", false);
                        pItem.getSubCompound("tags").setBoolean("emerald", false);
                        pItem.getSubCompound("tags").setInteger("diamond", 0);
                        pItem.getSubCompound("tags").setInteger("redstone", 0);
                        pItem.getSubCompound("tags").setInteger("lapis", 0);
                        pItem.getSubCompound("tags").setInteger("modifiers", 0);
                        pItem.getTagCompound().setInteger("tempDamage", 0);
                        return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 9) {
                        ItemStack tempStack = new ItemStack(ModItems.ironaxehead, 1);
                        tempStack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound tags = pItem.getSubCompound("tags").copy();
                        tempStack.getTagCompound().setTag("tags", tags);
                        tempStack.setItemDamage(pItem.getTagCompound().getInteger("tempDamage"));
                        tile.setSlotStack((counter), tempStack);

                        pItem.getTagCompound().setInteger("type", 0);
                        pItem.getSubCompound("tags").setBoolean("hot", false);
                        pItem.getSubCompound("tags").setBoolean("emerald", false);
                        pItem.getSubCompound("tags").setInteger("diamond", 0);
                        pItem.getSubCompound("tags").setInteger("redstone", 0);
                        pItem.getSubCompound("tags").setInteger("lapis", 0);
                        pItem.getSubCompound("tags").setInteger("modifiers", 0);
                        pItem.getTagCompound().setInteger("tempDamage", 0);
                        return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 10) {
                        ItemStack tempStack = new ItemStack(ModItems.ironshovelhead, 1);
                        tempStack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound tags = pItem.getSubCompound("tags").copy();
                        tempStack.getTagCompound().setTag("tags", tags);
                        tempStack.setItemDamage(pItem.getTagCompound().getInteger("tempDamage"));
                        tile.setSlotStack((counter), tempStack);

                        pItem.getTagCompound().setInteger("type", 0);
                        pItem.getSubCompound("tags").setBoolean("hot", false);
                        pItem.getSubCompound("tags").setBoolean("emerald", false);
                        pItem.getSubCompound("tags").setInteger("diamond", 0);
                        pItem.getSubCompound("tags").setInteger("redstone", 0);
                        pItem.getSubCompound("tags").setInteger("lapis", 0);
                        pItem.getSubCompound("tags").setInteger("modifiers", 0);
                        pItem.getTagCompound().setInteger("tempDamage", 0);
                        return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 11) {
                        ItemStack tempStack = new ItemStack(ModItems.ironhoehead, 1);
                        tempStack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound tags = pItem.getSubCompound("tags").copy();
                        tempStack.getTagCompound().setTag("tags", tags);
                        tempStack.setItemDamage(pItem.getTagCompound().getInteger("tempDamage"));
                        tile.setSlotStack((counter), tempStack);

                        pItem.getTagCompound().setInteger("type", 0);
                        pItem.getSubCompound("tags").setBoolean("hot", false);
                        pItem.getSubCompound("tags").setBoolean("emerald", false);
                        pItem.getSubCompound("tags").setInteger("diamond", 0);
                        pItem.getSubCompound("tags").setInteger("redstone", 0);
                        pItem.getSubCompound("tags").setInteger("lapis", 0);
                        pItem.getSubCompound("tags").setInteger("modifiers", 0);
                        pItem.getTagCompound().setInteger("tempDamage", 0);
                        return true;
                    }

                    /*********************************
                     *            Clean Iron         *
                     *********************************/
                    if (pItem.getTagCompound().getInteger("type") == 15) {
                        //System.out.println("Tongs meta = 6");
                        tile.setSlotStack((counter), new ItemStack(ModItems.ironcleaningotballhot, 1));
                        pItem.getTagCompound().setInteger("type", 0);
                        //return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 16) {
                        //System.out.println("Tongs meta = 7");
                        tile.setSlotStack((counter), new ItemStack(ModItems.ironcleanchunkhot, 1));
                        pItem.getTagCompound().setInteger("type", 0);
                        ///System.out.println(counter);
                        //System.out.println(tile.getSlotStack(counter));
                        //return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 17) {
                        ItemStack tempStack = new ItemStack(ModItems.cleanironpickaxehead, 1);
                        tempStack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound tags = pItem.getSubCompound("tags").copy();
                        tempStack.getTagCompound().setTag("tags", tags);
                        tempStack.setItemDamage(pItem.getTagCompound().getInteger("tempDamage"));
                        tile.setSlotStack((counter), tempStack);

                        pItem.getTagCompound().setInteger("type", 0);
                        pItem.getSubCompound("tags").setBoolean("hot", false);
                        pItem.getSubCompound("tags").setBoolean("emerald", false);
                        pItem.getSubCompound("tags").setInteger("diamond", 0);
                        pItem.getSubCompound("tags").setInteger("redstone", 0);
                        pItem.getSubCompound("tags").setInteger("lapis", 0);
                        pItem.getSubCompound("tags").setInteger("modifiers", 0);
                        pItem.getTagCompound().setInteger("tempDamage", 0);
                        return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 18) {
                        ItemStack tempStack = new ItemStack(ModItems.cleanironaxehead, 1);
                        tempStack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound tags = pItem.getSubCompound("tags").copy();
                        tempStack.getTagCompound().setTag("tags", tags);
                        tempStack.setItemDamage(pItem.getTagCompound().getInteger("tempDamage"));
                        tile.setSlotStack((counter), tempStack);

                        pItem.getTagCompound().setInteger("type", 0);
                        pItem.getSubCompound("tags").setBoolean("hot", false);
                        pItem.getSubCompound("tags").setBoolean("emerald", false);
                        pItem.getSubCompound("tags").setInteger("diamond", 0);
                        pItem.getSubCompound("tags").setInteger("redstone", 0);
                        pItem.getSubCompound("tags").setInteger("lapis", 0);
                        pItem.getSubCompound("tags").setInteger("modifiers", 0);
                        pItem.getTagCompound().setInteger("tempDamage", 0);
                        return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 19) {
                        ItemStack tempStack = new ItemStack(ModItems.cleanironshovelhead, 1);
                        tempStack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound tags = pItem.getSubCompound("tags").copy();
                        tempStack.getTagCompound().setTag("tags", tags);
                        tempStack.setItemDamage(pItem.getTagCompound().getInteger("tempDamage"));
                        tile.setSlotStack((counter), tempStack);

                        pItem.getTagCompound().setInteger("type", 0);
                        pItem.getSubCompound("tags").setBoolean("hot", false);
                        pItem.getSubCompound("tags").setBoolean("emerald", false);
                        pItem.getSubCompound("tags").setInteger("diamond", 0);
                        pItem.getSubCompound("tags").setInteger("redstone", 0);
                        pItem.getSubCompound("tags").setInteger("lapis", 0);
                        pItem.getSubCompound("tags").setInteger("modifiers", 0);
                        pItem.getTagCompound().setInteger("tempDamage", 0);
                        return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 20) {
                        ItemStack tempStack = new ItemStack(ModItems.cleanironhoehead, 1);
                        tempStack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound tags = pItem.getSubCompound("tags").copy();
                        tempStack.getTagCompound().setTag("tags", tags);
                        tempStack.setItemDamage(pItem.getTagCompound().getInteger("tempDamage"));
                        tile.setSlotStack((counter), tempStack);

                        pItem.getTagCompound().setInteger("type", 0);
                        pItem.getSubCompound("tags").setBoolean("hot", false);
                        pItem.getSubCompound("tags").setBoolean("emerald", false);
                        pItem.getSubCompound("tags").setInteger("diamond", 0);
                        pItem.getSubCompound("tags").setInteger("redstone", 0);
                        pItem.getSubCompound("tags").setInteger("lapis", 0);
                        pItem.getSubCompound("tags").setInteger("modifiers", 0);
                        pItem.getTagCompound().setInteger("tempDamage", 0);
                        return true;
                    }

                    /*********************************
                     *              Steel            *
                     *********************************/
                    if (pItem.getTagCompound().getInteger("type") == 24) {
                        //System.out.println("Tongs meta = 6");
                        tile.setSlotStack((counter), new ItemStack(ModItems.steelingotballhot, 1));
                        pItem.getTagCompound().setInteger("type", 0);
                        //return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 25) {
                        //System.out.println("Tongs meta = 7");
                        tile.setSlotStack((counter), new ItemStack(ModItems.steelchunkhot, 1));
                        pItem.getTagCompound().setInteger("type", 0);
                        ///System.out.println(counter);
                        //System.out.println(tile.getSlotStack(counter));
                        //return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 26) {
                        ItemStack tempStack = new ItemStack(ModItems.steelpickaxehead, 1);
                        tempStack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound tags = pItem.getSubCompound("tags").copy();
                        tempStack.getTagCompound().setTag("tags", tags);
                        tempStack.setItemDamage(pItem.getTagCompound().getInteger("tempDamage"));
                        tile.setSlotStack((counter), tempStack);

                        pItem.getTagCompound().setInteger("type", 0);
                        pItem.getSubCompound("tags").setBoolean("hot", false);
                        pItem.getSubCompound("tags").setBoolean("emerald", false);
                        pItem.getSubCompound("tags").setInteger("diamond", 0);
                        pItem.getSubCompound("tags").setInteger("redstone", 0);
                        pItem.getSubCompound("tags").setInteger("lapis", 0);
                        pItem.getSubCompound("tags").setInteger("modifiers", 0);
                        pItem.getTagCompound().setInteger("tempDamage", 0);
                        return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 27) {
                        ItemStack tempStack = new ItemStack(ModItems.steelaxehead, 1);
                        tempStack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound tags = pItem.getSubCompound("tags").copy();
                        tempStack.getTagCompound().setTag("tags", tags);
                        tempStack.setItemDamage(pItem.getTagCompound().getInteger("tempDamage"));
                        tile.setSlotStack((counter), tempStack);

                        pItem.getTagCompound().setInteger("type", 0);
                        pItem.getSubCompound("tags").setBoolean("hot", false);
                        pItem.getSubCompound("tags").setBoolean("emerald", false);
                        pItem.getSubCompound("tags").setInteger("diamond", 0);
                        pItem.getSubCompound("tags").setInteger("redstone", 0);
                        pItem.getSubCompound("tags").setInteger("lapis", 0);
                        pItem.getSubCompound("tags").setInteger("modifiers", 0);
                        pItem.getTagCompound().setInteger("tempDamage", 0);
                        return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 28) {
                        ItemStack tempStack = new ItemStack(ModItems.steelshovelhead, 1);
                        tempStack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound tags = pItem.getSubCompound("tags").copy();
                        tempStack.getTagCompound().setTag("tags", tags);
                        tempStack.setItemDamage(pItem.getTagCompound().getInteger("tempDamage"));
                        tile.setSlotStack((counter), tempStack);

                        pItem.getTagCompound().setInteger("type", 0);
                        pItem.getSubCompound("tags").setBoolean("hot", false);
                        pItem.getSubCompound("tags").setBoolean("emerald", false);
                        pItem.getSubCompound("tags").setInteger("diamond", 0);
                        pItem.getSubCompound("tags").setInteger("redstone", 0);
                        pItem.getSubCompound("tags").setInteger("lapis", 0);
                        pItem.getSubCompound("tags").setInteger("modifiers", 0);
                        pItem.getTagCompound().setInteger("tempDamage", 0);
                        return true;
                    }
                    if (pItem.getTagCompound().getInteger("type") == 29) {
                        ItemStack tempStack = new ItemStack(ModItems.steelhoehead, 1);
                        tempStack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound tags = pItem.getSubCompound("tags").copy();
                        tempStack.getTagCompound().setTag("tags", tags);
                        tempStack.setItemDamage(pItem.getTagCompound().getInteger("tempDamage"));
                        tile.setSlotStack((counter), tempStack);

                        pItem.getTagCompound().setInteger("type", 0);
                        pItem.getSubCompound("tags").setBoolean("hot", false);
                        pItem.getSubCompound("tags").setBoolean("emerald", false);
                        pItem.getSubCompound("tags").setInteger("diamond", 0);
                        pItem.getSubCompound("tags").setInteger("redstone", 0);
                        pItem.getSubCompound("tags").setInteger("lapis", 0);
                        pItem.getSubCompound("tags").setInteger("modifiers", 0);
                        pItem.getTagCompound().setInteger("tempDamage", 0);
                        return true;
                    }

                }
            }
        }



        //System.out.println("1" + pItem);

        if (pItem.getItem().equals(Items.AIR) && player.isSneaking()) {

            if (tile.getSlotStack(counter).getItem().equals(Items.DIAMOND)) {
                CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                tile.setSlotStack(counter, ItemStack.EMPTY);
                return true;
            }
            if (tile.getSlotStack(counter).getItem().equals(PrimalItems.DIAMOND_KNAPP)) {
                CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                tile.setSlotStack(counter, ItemStack.EMPTY);
                return true;
            }
            if (tile.getSlotStack(counter).getItem().equals(Items.EMERALD)) {
                CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                tile.setSlotStack(counter, ItemStack.EMPTY);
                return true;
            }
            if (tile.getSlotStack(counter).getItem().equals(PrimalItems.EMERALD_KNAPP)) {
                CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                tile.setSlotStack(counter, ItemStack.EMPTY);
                return true;
            }
            if (tile.getSlotStack(counter).getItem().equals(Items.REDSTONE)) {
                CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                tile.setSlotStack(counter, ItemStack.EMPTY);
                return true;
            }

            if (tile.getSlotStack(counter).getItem().equals(Items.DYE) && tile.getSlotStack(counter).getItemDamage() == EnumDyeColor.BLUE.getDyeDamage()) {
                CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                tile.setSlotStack(counter, ItemStack.EMPTY);
                return true;
            }

            if (Block.getBlockFromItem(tile.getSlotStack(counter).getItem()) instanceof IngotBall ) {
                CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    return true;
            }

            if (tile.getSlotStack(counter).getItem().equals(ModItems.pickaxehead)) {
                if (tile.getSlotStack(counter).getSubCompound("tags").getBoolean("hot") == false) {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    return true;
                }
            }
            if (tile.getSlotStack(counter).getItem().equals(ModItems.ironaxehead)) {
                if (tile.getSlotStack(counter).getSubCompound("tags").getBoolean("hot") == false) {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    return true;
                }
            }
            if (tile.getSlotStack(counter).getItem().equals(ModItems.ironshovelhead)) {
                if (tile.getSlotStack(counter).getSubCompound("tags").getBoolean("hot") == false) {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    return true;
                }
            }
            if (tile.getSlotStack(counter).getItem().equals(ModItems.ironhoehead)) {
                if (tile.getSlotStack(counter).getSubCompound("tags").getBoolean("hot") == false) {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    return true;
                }
            }
        }

        if (pItem.getItem().equals(Items.DIAMOND)) {
            //System.out.println("It Is Diamond");
            if (tile.getSlotStack(counter).isEmpty()) {
                //System.out.println("Slot is empty");
                tile.setSlotStack(counter, new ItemStack(pItem.getItem(), 1));
                pItem.shrink(1);
                return true;
            }
        }

        if (pItem.getItem().equals(Items.EMERALD)) {
            if (tile.getSlotStack(counter).isEmpty()) {
                tile.setSlotStack(counter, new ItemStack(pItem.getItem(), 1));
                pItem.shrink(1);
                return true;
            }
        }

        if (pItem.getItem().equals(PrimalItems.EMERALD_KNAPP)) {
            if (tile.getSlotStack(counter).isEmpty()) {
                tile.setSlotStack(counter, new ItemStack(pItem.getItem(), 1));
                pItem.shrink(1);
                return true;
            }
        }

        if (pItem.getItem().equals(PrimalItems.DIAMOND_KNAPP)) {
            if (tile.getSlotStack(counter).isEmpty()) {
                tile.setSlotStack(counter, new ItemStack(pItem.getItem(), 1));
                pItem.shrink(1);
                return true;
            }
        }

        if (pItem.getItem().equals(Items.REDSTONE)) {
            if (tile.getSlotStack(counter).isEmpty()) {
                tile.setSlotStack(counter, new ItemStack(pItem.getItem(), 1));
                pItem.shrink(1);
                return true;
            }
        }

        if (pItem.getItem().equals(Items.DYE) && pItem.getItemDamage() == EnumDyeColor.BLUE.getDyeDamage()) {
            if (tile.getSlotStack(counter).isEmpty()) {
                tile.setSlotStack(counter, new ItemStack(pItem.getItem(), 1, pItem.getItemDamage()));
                pItem.shrink(1);
                return true;
            }
        }
        return false;
    }



    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        if (!world.isRemote && world.getGameRules().getBoolean("doTileDrops"))
        {
            TileAnvil tile = (TileAnvil) world.getTileEntity(pos);
            if (tile !=null)
            {
                for (ItemStack stack : tile.getSlotList())
                {
                    if (stack != null) {
                        float offset = 0.7F;
                        double offsetX = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        double offsetY = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        double offsetZ = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        EntityItem item = new EntityItem(world, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ, stack);
                        item.setDefaultPickupDelay();
                        world.spawnEntity(item);
                    }
                }
            }
        }

        super.breakBlock(world, pos, state);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileAnvil();
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        //if(!worldIn.isRemote) {
            worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing()), 2);
        //}
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if( state.getValue(FACING) == EnumFacing.EAST) {
            i = 0;
            return i;
        }
        if( state.getValue(FACING) == EnumFacing.WEST) {
            i = 1;
            return i;
        }
        if( state.getValue(FACING) == EnumFacing.SOUTH){
            i = 2;
            return i;
        }
        if( state.getValue(FACING) == EnumFacing.NORTH){
            i = 3;
            return i;
        }
        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        if (meta == 0){
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
        }
        if (meta == 1) {
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
        }
        if (meta == 2) {
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
        }
        if (meta == 3) {
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
        }
        return iblockstate;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullyOpaque(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

}
