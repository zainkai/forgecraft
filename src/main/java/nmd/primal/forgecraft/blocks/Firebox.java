package nmd.primal.forgecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.tiles.TileFirebox;

import javax.annotation.Nullable;

/**
 * Created by kitsu on 11/26/2016.
 */
public class Firebox extends CustomContainerFacing implements ITileEntityProvider {

    public static final PropertyBool ACTIVE =  PropertyBool.create("active");

    public Firebox(Material material) {
        super(material);
        setUnlocalizedName(ModInfo.ForgecraftBlocks.FIREBOX.getUnlocalizedName());
        setRegistryName(ModInfo.ForgecraftBlocks.FIREBOX.getRegistryName());
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, Boolean.valueOf(false)));
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileFirebox();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
            TileFirebox tile = (TileFirebox) world.getTileEntity(pos);
            if (tile != null)
            {

                ItemStack playerStack = player.getHeldItemMainhand();
                Item playerItem;

                ItemStack tileStack = tile.getStackInSlot(0);

                //System.out.println("Player Stack = " + playerStack);
                //System.out.println("TileStack = " + tileStack);
                if(playerStack != null){
                    playerItem = playerStack.getItem();
                    if (playerItem.equals(Items.FLINT_AND_STEEL)) {
                        world.setBlockState(pos, state.withProperty(ACTIVE, Boolean.valueOf(true)), 2);
                        BlockPos tempPos = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
                        if(world.getBlockState(tempPos).getBlock().equals(Blocks.AIR)){
                            world.setBlockState(tempPos, Blocks.FIRE.getDefaultState(), 3);
                        }
                    }
                }


                if(tileStack == null && playerStack != null){
                    tile.setInventorySlotContents(0, playerStack);
                    player.setHeldItem(EnumHand.MAIN_HAND, null);
                    return true;
                }

                if(tileStack != null && playerStack == null && player.isSneaking()){
                    tile.setInventorySlotContents(0, null);
                    player.setHeldItem(EnumHand.MAIN_HAND, tileStack);
                    return true;
                }



                /*
                if (tile.getStackInSlot(0) == null){
                    if (player.inventory.getCurrentItem()!=null) {
                        tile.setInventorySlotContents(0, player.inventory.getCurrentItem());
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                        return true;
                    }
                }
                if (tile.getStackInSlot(0) != null){
                    if (player.inventory.getCurrentItem()==null) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, tile.getStackInSlot(0));
                        tile.setInventorySlotContents(0, null);
                        return true;
                    }
                }
                */

            }
        }

        return false;
    }

    /**
     * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
     */
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote && worldIn.getGameRules().getBoolean("doTileDrops"))
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileFirebox)
            {
                InventoryHelper.dropInventoryItems(worldIn, pos, (TileFirebox)tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        }

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        IBlockState state = super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
        return state.withProperty(FACING, placer.getHorizontalFacing());
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        if (stack.hasDisplayName()){
            ((TileFirebox) world.getTileEntity(pos)).setCustomName(stack.getDisplayName());
        }
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING, ACTIVE});
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

/*
Firebox States
Off
On

 */