package com.kitsu.medievalcraft.packethandle.cannon;

import com.kitsu.medievalcraft.tileents.cannon.TileCannon_28;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandleCannon implements IMessageHandler<MsgPacketCannon, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketCannon message, MessageContext ctx) {
		TileCannon_28.smoke = message.fired;
		return null;
	}
}
