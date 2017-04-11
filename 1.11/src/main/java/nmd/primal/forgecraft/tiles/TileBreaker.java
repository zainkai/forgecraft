package nmd.primal.forgecraft.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by mminaie on 4/9/17.
 */
public class TileBreaker extends TileBaseSlot implements ITickable {

    private float charge;

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }

    public NonNullList<ItemStack> slotList = NonNullList.<ItemStack>withSize(10, ItemStack.EMPTY);

    @Override
    public void update () {
        World world = this.getWorld();
        if (!world.isRemote) {
            IBlockState state = world.getBlockState(this.pos);
            for(int i =0; i < this.getSlotListSize(); i++) {
                //System.out.println(this.getSlotStack(i));
            }
        }
    }

    @Override
    public int getSlotLimit() {
        return 1;
    }

    // ***************************************************************************** //
    //  NBT
    // ***************************************************************************** //
    /*@Override
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
    }*/

}
