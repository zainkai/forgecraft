package com.kitsu.medievalcraft.packethandle.forgeHammerParticles;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandlelTicks implements IMessageHandler<MsgPacketlTicks, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketlTicks message, MessageContext ctx) {

		//HotIronBlock.locX = message.locx;
		//HotIronPlate.locX = message.locx;
		//ItemRendererLongbow.tick = message.lTick;
		
		//System.out.println(message.lTick);
		//ctx.getClientHandler().addToSendQueue(new MsgPacket(message.useme));
		
		return null;
	}
}
