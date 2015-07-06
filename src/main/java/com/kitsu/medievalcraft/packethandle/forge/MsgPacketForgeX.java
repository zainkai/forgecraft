package com.kitsu.medievalcraft.packethandle.forge;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacketForgeX implements IMessage {

	public int locx;

	public MsgPacketForgeX() {}

	public MsgPacketForgeX(int x){
		this.locx = x;
	}


	@Override
	public void fromBytes(ByteBuf buf) {

		this.locx = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.locx);
	}

}
