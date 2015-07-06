package com.kitsu.medievalcraft.packethandle.forge;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacketOn implements IMessage {

	public boolean packetOn;

	public MsgPacketOn() {}

	public MsgPacketOn(boolean x){
		this.packetOn = x;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.packetOn = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(this.packetOn);
	}

}
