package com.kitsu.medievalcraft.packethandle.cannon;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class MsgPacketCannon implements IMessage {

	public boolean fired;

	public MsgPacketCannon() {}

	public MsgPacketCannon(boolean x){
		this.fired = x;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.fired = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(this.fired);
	}

}
