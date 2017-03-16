package nmd.primal.forgecraft;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nmd.primal.core.api.PrimalBlocks;
import nmd.primal.core.api.PrimalItems;
import nmd.primal.core.api.PrimalRegistries;
import nmd.primal.core.common.init.ModConfig;
import nmd.primal.forgecraft.items.tools.CustomPickaxe;

/**
 * Created by mminaie on 3/15/17.
 */
public class CommonEvents {


    /*******************************************************************************
     * Block Harvesting
     *  leaf stick drops, plant fiber drops, extra flint and rock drops, stone harvesting
     */
    @SubscribeEvent(priority= EventPriority.LOWEST, receiveCanceled=true)
    public void onBlockHarvest(BlockEvent.HarvestDropsEvent event)
    {
        World world = event.getWorld();
        EntityPlayer player = event.getHarvester();

        if (!world.isRemote && player!=null) //&& !event.isSilkTouching()
        {
            BlockPos pos = event.getPos();
            IBlockState state = event.getState();
            Block block = state.getBlock();
            Material material = state.getBlock().getMaterial(state);

            ItemStack event_stack = new ItemStack(block, 1, block.getMetaFromState(state));
            ItemStack held_stack = player.getHeldItemMainhand();

            //System.out.println(event.getDrops());
            System.out.println(event.getFortuneLevel());

            if(held_stack.getItem() instanceof CustomPickaxe){
                if(((CustomPickaxe) held_stack.getItem()).getLapisLevel(held_stack) > 0){
                    //held_stack.addEnchantment(Enchantment.getEnchantmentByID(35), ((CustomPickaxe) held_stack.getItem()).getLapisLevel(held_stack));
                }
                if( ((CustomPickaxe) held_stack.getItem()).getEmerald(held_stack) == true) {

                }
            }




            if (!event.isSilkTouching()) {
                // ***************************************************************************** //
                //  Extra Rock/Flint Drop
                // ***************************************************************************** //


            }

        }
    }


}
