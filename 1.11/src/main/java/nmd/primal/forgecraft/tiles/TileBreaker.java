package nmd.primal.forgecraft.tiles;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;

/**
 * Created by mminaie on 4/9/17.
 */
public class TileBreaker extends TileBaseSlot {

    private float charge;

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }

    public NonNullList<ItemStack> slotList = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY);

    // ***************************************************************************** //
    //  NBT
    // ***************************************************************************** //
    @Override
    public NBTTagCompound readNBT(NBTTagCompound nbt)
    {
        super.readNBT(nbt);
        this.charge = nbt.getFloat("charge");
        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        nbt.setFloat("charge", this.charge);
        super.writeNBT(nbt);
        return nbt;
    }

}
