package nmd.primal.forgecraft.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

/**
 * Created by mminaie on 2/12/17.
 */
public class ItemBlockIngotBall extends ItemBlock {

    public ItemBlockIngotBall(Block block){
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);

        //this.setRegistryName(name);
    }

    public int getMetadata(int damage)
    {
        return damage;
    }



}
