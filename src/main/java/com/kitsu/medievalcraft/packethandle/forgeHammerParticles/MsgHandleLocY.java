package com.kitsu.medievalcraft.packethandle.forgeHammerParticles;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandleLocY implements IMessageHandler<MsgPacketLocY, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketLocY message, MessageContext ctx) {

		//HotIronBlock.locY = message.locy;
		//HotIronPlate.locY = message.locy;
		//ItemRendererLongbow.tick = message.lTick;
		
		//System.out.println(message.lTick);
		//ctx.getClientHandler().addToSendQueue(new MsgPacket(message.useme));
		
		return null;
	}
}
