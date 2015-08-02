package com.kitsu.medievalcraft.renderer.itemrenderer.tools;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraft.util.IIcon;

public class IRironPicks implements IItemRenderer {

	private static RenderItem renderItem = new RenderItem();
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch(type) {
		case EQUIPPED: {
			return true;
		} 
		case EQUIPPED_FIRST_PERSON: {
			return true;
		} 
		case INVENTORY: {
			return true;
		}
		case ENTITY: {
			return true;
		}
		default: return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data) {
        // ====================== Render item texture ======================
       IIcon icon = itemStack.getIconIndex();
        renderItem.renderIcon(0, 0, icon, 16, 16);

	}

}
