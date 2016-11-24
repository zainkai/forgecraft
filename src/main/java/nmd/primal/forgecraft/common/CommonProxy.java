package nmd.primal.forgecraft.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fluids.IFluidBlock;

/**
 * Created by kitsu on 11/23/2016.
 */

public class CommonProxy
{

    public void registerClientEvents()
    {
    }

    public void renderBlock(Block block)
    {
        // see ClientProxy
    }

    public void renderItem(Item item)
    {
        // see ClientProxy
    }

    public void preInit() {

    }

    public void init() {

    }

    public void postInit() {

    }

    public void registerFluidBlockRendering(Block block, String name) {
        // see ClientProxy
    }

    public void registerItemVariantModel(Item item, String name, int metadata) {
        // see ClientProxy
    }

    public void registerFluidRendering(IFluidBlock fluidBlock, String name) {
        // see ClientProxy
    }

    public void registerBlockSided(Block block)
    {
        //
    }

    public void registerItemSided(Item item)
    {
        // register sub types if there are any
    }

    public void registerFluidModels() {
        // see ClientProxy
    }

    public void registerFluidModel(IFluidBlock fluidBlock) {
        // see ClientProxy
    }

    public void registerTickHandler() {
        // see ClientProxy
    }

    public void registerSounds() {
        // see ClientProxy
    }

    public void registerRendering() {
        //see ClientProxy
    }

    public void registerTileRendering()
    {

    }

    /*public void spawnParticle(ForgeCraftParticles particle, double x, double y, double z, Object... info) {
        //see ClientProxy
    }*/

    public int registerArmor(String armor) {
        //see ClientProxy
        return 0;
    }

    public Object getClient() {
        //see ClientProxy
        return null;
    }

    public World getClientWorld() {
        //see ClientProxy
        return null;
    }

    public void setClientEnvironment() {
        //see ClientProxy
    }

    /**
     @Override
     public World getServerWorld() {
     return FMLServerHandler.instance().getServer().getEntityWorld();
     }
     **/
}
