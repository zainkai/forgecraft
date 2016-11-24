package nmd.primal.forgecraft.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by kitsu on 11/24/2016.
 */
public class GuiHandler implements IGuiHandler
{
    /**
     * Returns a Server side Container to be displayed to the user.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
        switch (ID)
        {
            //case ModInfo.WORKTABLE_BASIC: return new ContainerWorkTableBasic(player.inventory, (TileWorkTableBasic)tile, world);
            //case ModInfo.WORKTABLE_SHELF: return new ContainerWorkTableShelf(player.inventory, (TileWorkTableShelf)tile, world);
            //case ModInfo.WORKTABLE_CHEST: return new ContainerWorkTableChest(player.inventory, (TileWorkTableChest)tile, world);
            default: return null;
        }
    }

    /**
     * Returns a Container to be displayed to the user. On the client side, this
     * needs to return a instance of GuiScreen On the server side, this needs to
     * return a instance of Container
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
        switch (ID)
        {
            //case ModInfo.WORKTABLE_BASIC: return new GuiWorkTableBasic(player.inventory, (TileWorkTableBasic) tile, world);
            //case ModInfo.WORKTABLE_SHELF: return new GuiWorkTableShelf(player.inventory, (TileWorkTableShelf) tile, world);
            //case ModInfo.WORKTABLE_CHEST: return new GuiWorkTableBasic(player.inventory, (TileWorkTableChest) tile, world);
            default: return null;
        }
    }
}