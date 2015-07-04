package com.kitsu.medievalcraft.packethandle.forgeHammerParticles;

import com.kitsu.medievalcraft.block.ingots.IngotBase;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandleLocX implements IMessageHandler<MsgPacketLocX, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketLocX message, MessageContext ctx) {

		IngotBase.locX = message.locx;
		//HotIronPlate.locX = message.locx;
		//ItemRendererLongbow.tick = message.lTick;
		
		//System.out.println(message.lTick);
		//ctx.getClientHandler().addToSendQueue(new MsgPacket(message.useme));
		
		return null;
	}
}
