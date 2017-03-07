package nmd.primal.forgecraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalItems;
import nmd.primal.core.common.blocks.PrimalBlock;
import nmd.primal.forgecraft.CommonUtils;
import nmd.primal.forgecraft.blocks.*;
import nmd.primal.forgecraft.items.blocks.ItemBlockIngotBall;
import nmd.primal.forgecraft.tiles.TileAnvil;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ModBlocks {

    public static Block firebox;
    public static Block bloomery;
    public static Block pistonbellowsoak;
    public static Block pistonbellowsjungle;
    public static Block pistonbellowsbirch;
    public static Block pistonbellowsspruce;
    public static Block pistonbellowsdarkoak;
    public static Block pistonbellowsacacia;
    public static Block emptycrucible;
    public static Block emptycruciblehot;
    public static Block emptycruciblecracked;
    public static Block emptycruciblecrackedhot;

    public static Block rawironcrucible;
    public static Block hotironcrucible;
    public static Block hotcookedironcrucible;
    public static Block coolironcrucible;
    public static Block failedironcrucible;
    public static Block failedironcruciblehot;

    public static Block ironball;
    public static Block ironchunk;
    //public static ItemBlock ironballitemcool;
    //public static ItemBlock ironballitemhot;

    public static Block stoneanvil;


    public static void init() {

        firebox = new Forge(Material.ROCK);

        bloomery = new Bloomery(Material.ROCK, "bloomery");

        pistonbellowsoak = new PistonBellows(Material.WOOD, "pistonbellowsoak");
        pistonbellowsjungle = new PistonBellows(Material.WOOD, "pistonbellowsjungle");
        pistonbellowsbirch = new PistonBellows(Material.WOOD, "pistonbellowsbirch");
        pistonbellowsspruce = new PistonBellows(Material.WOOD, "pistonbellowsspruce");
        pistonbellowsdarkoak = new PistonBellows(Material.WOOD, "pistonbellowsdarkoak");
        pistonbellowsacacia = new PistonBellows(Material.WOOD, "pistonbellowsacacia");

        emptycrucible = new Crucible(Material.ROCK, "emptycrucible");
        emptycruciblehot = new CrucibleHot(Material.ROCK, "emptycruciblehot");
        emptycruciblecracked = new Crucible(Material.ROCK, "emptycruciblecracked");
        emptycruciblecrackedhot = new CrucibleHot(Material.ROCK, "emptycruciblecrackedhot");

        rawironcrucible = new Crucible(Material.ROCK, "rawironcrucible");
        hotironcrucible = new CrucibleHot(Material.ROCK, "hotironcrucible");
        hotcookedironcrucible = new CrucibleHot(Material.ROCK, "hotcookedironcrucible");
        coolironcrucible = new Crucible(Material.ROCK, "coolironcrucible");
        failedironcrucible = new Crucible(Material.ROCK, "failedironcrucible");
        failedironcruciblehot = new CrucibleHot(Material.ROCK, "failedironcruciblehot");

        ironball = new IngotBall(Material.IRON, "ironball", 5.0F, "ingot") {
            @Override
            public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz)
            {
                if(!world.isRemote){
                    Item pItem = player.getHeldItem(hand).getItem();
                    BlockPos belowPos = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());

                    if (pItem.equals(PrimalItems.STONE_GALLAGHER) && world.getBlockState(belowPos).getBlock().equals(Blocks.STONE)) {
                        player.swingArm(hand);
                        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                        world.setBlockState(belowPos, ModBlocks.stoneanvil.getDefaultState().withProperty(Anvil.FACING, player.getHorizontalFacing()), 2);
                        world.playEvent(1031, pos, 0);
                        //CommonUtils.spawnItemEntityFromWorld(world, pos, new ItemStack(ModBlocks.stoneanvil, 1));
                        return true;
                    }
                    if (pItem.equals(PrimalItems.STONE_GALLAGHER) && world.getBlockState(belowPos).getBlock().equals(ModBlocks.stoneanvil)) {
                        TileAnvil tile = (TileAnvil) world.getTileEntity(belowPos);


                        if (tile.getSlotStack(6).isEmpty() &&
                                tile.getSlotStack(7).isEmpty() &&
                                tile.getSlotStack(8).isEmpty() &&
                                tile.getSlotStack(11).isEmpty() &&
                                tile.getSlotStack(12).isEmpty() &&
                                tile.getSlotStack(13).isEmpty() &&
                                tile.getSlotStack(16).isEmpty() &&
                                tile.getSlotStack(17).isEmpty() &&
                                tile.getSlotStack(18).isEmpty()
                                ) {
                            player.swingArm(hand);
                            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                            tile.setSlotStack(6, new ItemStack(ModItems.ironchunkhot, 1));
                            tile.setSlotStack(7, new ItemStack(ModItems.ironchunkhot, 1));
                            tile.setSlotStack(8, new ItemStack(ModItems.ironchunkhot, 1));
                            tile.setSlotStack(11, new ItemStack(ModItems.ironchunkhot, 1));
                            tile.setSlotStack(12, new ItemStack(ModItems.ironchunkhot, 1));
                            tile.setSlotStack(13, new ItemStack(ModItems.ironchunkhot, 1));
                            tile.setSlotStack(16, new ItemStack(ModItems.ironchunkhot, 1));
                            tile.setSlotStack(17, new ItemStack(ModItems.ironchunkhot, 1));
                            tile.setSlotStack(18, new ItemStack(ModItems.ironchunkhot, 1));
                            world.playEvent(1031, pos, 0);
                            return true;
                        }
                    }

                }
                return false;
            }
        };

        ironchunk = new IngotBall(Material.IRON, "ironchunk", 5.0F, "chunk");

        stoneanvil = new Anvil(Material.ROCK, "stoneanvil", 5.0f);
        //ironballitemcool = new ItemBlockIngotBall(ironball);
        //ironballitemhot = new ItemBlockIngotBall(ironball);

    }


    public static void register() {
        registerBlock(firebox);
        registerBlock(bloomery);

        registerBlock(pistonbellowsoak);
        registerBlock(pistonbellowsjungle);
        registerBlock(pistonbellowsbirch);
        registerBlock(pistonbellowsspruce);
        registerBlock(pistonbellowsdarkoak);
        registerBlock(pistonbellowsacacia);

        registerBlock(emptycrucible);
        registerBlock(emptycruciblehot);
        registerBlock(emptycruciblecracked);
        registerBlock(emptycruciblecrackedhot);

        registerBlock(rawironcrucible);
        registerBlock(hotironcrucible);
        registerBlock(hotcookedironcrucible);
        registerBlock(coolironcrucible);
        registerBlock(failedironcrucible);
        registerBlock(failedironcruciblehot);

        registerBlock(ironball);
        registerBlock(ironchunk);
        //registerBlockSubType(ironball, ironballitemcool, "ironcool");
        //registerBlockSubType(ironball, ironballitemhot, "ironhot");

        registerBlock(stoneanvil);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        registerRender(firebox);
        registerRender(pistonbellowsoak);
        registerRender(pistonbellowsjungle);
        registerRender(pistonbellowsbirch);
        registerRender(pistonbellowsspruce);
        registerRender(pistonbellowsdarkoak);
        registerRender(pistonbellowsacacia);
        registerRender(bloomery);
        registerRender(emptycrucible);
        registerRender(emptycruciblehot);
        registerRender(emptycruciblecracked);
        registerRender(emptycruciblecrackedhot);

        registerRender(rawironcrucible);
        registerRender(hotironcrucible);
        registerRender(hotcookedironcrucible);
        registerRender(coolironcrucible);
        registerRender(failedironcrucible);
        registerRender(failedironcruciblehot);

        registerRender(ironball);
        registerRender(ironchunk);
        //registerRenderCustom(ironballitemcool, 0, new ModelResourceLocation(ironballitemcool.getUnlocalizedName()));
        //registerRenderCustom(ironballitemhot, 1, new ModelResourceLocation(ironballitemhot.getUnlocalizedName()));

        registerRender(stoneanvil);

    }

    private static void registerBlock(Block block) {
        GameRegistry.register(block);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        GameRegistry.register(item);
    }

    private static void registerBlockSubType(Block block, ItemBlock itemBlock, String registryName){
        GameRegistry.register(block);
        ItemBlock item = itemBlock;
        item.setRegistryName(registryName);
        GameRegistry.register(item);
    }

    private static void registerRender(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    private static void registerRenderCustom(ItemBlock item, Integer meta, ModelResourceLocation model){
        ModelLoader.setCustomModelResourceLocation(item, meta, model);
    }

}
