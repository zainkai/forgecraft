package nmd.primal.forgecraft.common.tiles;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by kitsu on 11/24/2016.
 */
public class ForgeCraftTile extends TileEntity
{
    /**
     * Called from Chunk.setBlockIDWithMetadata and Chunk.fillChunk, determines if this tile entity should be re-created when the ID, or Metadata changes.
     * Use with caution as this will leave straggler TileEntities, or create conflicts with other TileEntities if not used properly.
     *
     * @param world Current world
     * @param pos Tile's world position
     * @param oldState The old ID of the block
     * @param newState The new ID of the block (May be the same)
     * @return true forcing the invalidation of the existing TE, false not to invalidate the existing TE
     *
     * Override TileEntity#shouldRefresh to return oldState.getBlock() != newSate.getBlock().
     * This way the TileEntity will only be recreated when the Block changes.
     *
     * In 1.9, override TileEntity#getDescriptionPacket to write the data that needs syncing to a compound tag
     * and then create and return an SPacketUpdateTileEntity with the position and NBT.
     * Override TileEntity#onDataPacket to read from the packet's NBT.
     *
     * In 1.9.4, override TileEntity#getUpdateTag to write the data that needs syncing to a compound tag and return it.
     * Override TileEntity#getUpdatePacket to create and return an SPacketUpdateTileEntity with the position and update tag.
     * Override TileEntity#onDataPacket to read from the packet's NBT.
     *
     */
    //public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    //{
    //return isVanilla ? (oldState.getBlock() != newSate.getBlock()) : oldState != newSate;
    //}

    /**
     * NBT
     */
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.readNBT(nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        nbt = super.writeToNBT(nbt);
        return this.writeNBT(nbt);
    }

    public NBTTagCompound readNBT(NBTTagCompound nbt)
    {
        // Override in lower tile classes
        return nbt;
    }

    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        // Override in lower tile classes
        return nbt;
    }
}