package com.kitsu.medievalcraft.packethandle.forge;

import com.kitsu.medievalcraft.block.machines.Forge;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MsgHandleBurning implements IMessageHandler<MsgPacketBurning, IMessage>{

	@Override
	public IMessage onMessage(MsgPacketBurning message, MessageContext ctx) {
		Forge.coalParts = message.packetOn;
		return null;
	}
}
