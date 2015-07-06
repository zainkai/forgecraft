package com.kitsu.medievalcraft.packethandle.forge;

import com.kitsu.medievalcraft.block.machines.Forge;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandleOn implements IMessageHandler<MsgPacketOn, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketOn message, MessageContext ctx) {
		Forge.furnaceParts = message.packetOn;
		return null;
	}
}
