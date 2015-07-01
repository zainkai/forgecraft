package com.kitsu.medievalcraft;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.entity.EntityModelArrow;
import com.kitsu.medievalcraft.entity.EntityShit;
import com.kitsu.medievalcraft.entity.EntityTester;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.renderer.RendererRegistry;
import com.kitsu.medievalcraft.renderer.blocks.RenderModelArrow;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderer() { 	
    	RenderingRegistry.registerEntityRenderingHandler(EntityShit.class, new RenderSnowball(ModItems.itemShit));
    	RenderingRegistry.registerEntityRenderingHandler(EntityTester.class, new RenderSnowball(ModItems.itemTester));
    	RenderingRegistry.registerEntityRenderingHandler(EntityModelArrow.class, new RenderModelArrow());
    }
    
    @Override
    public void registerItemRenderers() {

    	RenderId.init();
    	RendererRegistry.init();
    }
    
    @Override
    public void registerSounds() {
        //MinecraftForge.EVENT_BUS.register(new ModSounds());//register the sound event handling class
    }

    
    @Override
    public Object getClient() {
    	return FMLClientHandler.instance().getClient();
    }

    @Override
    public World getClientWorld() {
    	return FMLClientHandler.instance().getClient().theWorld;
    }
    
}
