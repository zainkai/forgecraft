package com.kitsu.medievalcraft.packethandle.forge;

import com.kitsu.medievalcraft.block.ingots.IngotBase;
import com.kitsu.medievalcraft.block.machines.Forge;
import com.kitsu.medievalcraft.packethandle.forgeHammerParticles.MsgPacketLocX;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandleForgeX implements IMessageHandler<MsgPacketForgeX, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketForgeX message, MessageContext ctx) {

		//IngotBase.locX = message.locx;
		Forge.locX = message.locx;
		//ItemRendererLongbow.tick = message.lTick;
		
		//System.out.println(message.lTick);
		//ctx.getClientHandler().addToSendQueue(new MsgPacket(message.useme));
		
		return null;
	}
}
