package com.kitsu.medievalcraft.packethandle.forge;

import com.kitsu.medievalcraft.block.machines.Forge;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandleForgeY implements IMessageHandler<MsgPacketForgeY, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketForgeY message, MessageContext ctx) {

		//IngotBase.locX = message.locx;
		Forge.locY = message.locy;
		//ItemRendererLongbow.tick = message.lTick;
		
		//System.out.println(message.lTick);
		//ctx.getClientHandler().addToSendQueue(new MsgPacket(message.useme));
		
		return null;
	}
}
