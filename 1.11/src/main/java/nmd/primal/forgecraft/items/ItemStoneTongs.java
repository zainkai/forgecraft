package nmd.primal.forgecraft.items;

import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.tiles.TileBloomery;

/**
 * Created by mminaie on 1/23/17.
 */
public class ItemStoneTongs extends BaseItem {

    public ItemStoneTongs() {
        setUnlocalizedName(ModInfo.ForgecraftItems.STONETONGS.getUnlocalizedName());
        //setRegistryName();
        setRegistryName(new ResourceLocation(ModInfo.MOD_ID, ModInfo.ForgecraftItems.STONETONGS.getRegistryName()));
        setMaxDamage(100);
        setNoRepair();
        setMaxStackSize(1);
    }

    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        //pos = pos.offset(facing);
        ItemStack itemstack = player.getHeldItem(hand);

        if (world.getBlockState(pos).getBlock() == ModBlocks.bloomery) {
            TileBloomery tile = (TileBloomery) world.getTileEntity(pos);
            System.out.println(tile.getSlotStack(1));
            itemstack.damageItem(1, player);
            return EnumActionResult.SUCCESS;
        } else return EnumActionResult.FAIL;
    }

}
