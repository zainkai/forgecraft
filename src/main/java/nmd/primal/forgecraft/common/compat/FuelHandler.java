package nmd.primal.forgecraft.common.compat;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

import java.util.Map;

/**
 * Created by kitsu on 11/23/2016.
 */
public class FuelHandler implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuelStack)
    {
        //if (ModConfig.FEATURE_ENABLE_FUELS) {
        //CommonUtils.debugLogger(2, "fuel", "size: " + ModRegistries.FUEL_REGISTRY.size() + ", value: " + ModRegistries.FUEL_REGISTRY.get(fuelStack));


        //}

        return 0;
    }
}
