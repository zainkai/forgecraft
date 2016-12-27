package nmd.primal.forgecraft.tiles;

import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;

/**
 * Created by mminaie on 12/25/16.
 */
public abstract class TileBaseSlot extends BaseTile {

    private NonNullList<ItemStack> slotList = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);

    // ***************************************************************************** //
    //  Controls
    // ***************************************************************************** //

    // ***************************************************************************** //
    //  get
    //
    public NonNullList<ItemStack> getSlotList()
    {
        return this.slotList;
    }

    public ItemStack getSlotStack(int i)
    {
        return this.slotList.get(i);
    }

    public int getSlotListSize()
    {
        return slotList.size();
    }

    public int getSlotLimit()
    {
        //return ((ShelfBasic)this.getBlockType()).getShelfSize();
        //return 1;
        return 64;
    }

    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.getSlotList(), index, count);
    }

    // ***************************************************************************** //
    //  set
    //
    public void setSlotStack(int index, ItemStack stack)
    {
        this.slotList.set(index, stack);
        this.markDirty();
        this.updateBlock();
    }

    public void clearSlots()
    {
        this.slotList.clear();
    }

    /**
     public boolean replaceStack(int index, ItemStack stack)
     {
     if (stack != null && stack.getCount() <= this.getSlotLimit()) {
     this.setSlotStack(index, stack);
     return true;
     }

     return false;
     } **/

    // ***************************************************************************** //
    //  NBT
    // ***************************************************************************** //
    @Override
    public NBTTagCompound readNBT(NBTTagCompound nbt)
    {
        //super.readNBT(nbt);
        this.slotList = NonNullList.<ItemStack>withSize(this.getSlotListSize(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(nbt, this.slotList);

        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        //super.writeNBT(nbt);
        ItemStackHelper.saveAllItems(nbt, this.slotList);

        return nbt;
    }
}