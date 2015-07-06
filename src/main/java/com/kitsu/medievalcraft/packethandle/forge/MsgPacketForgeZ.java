package com.kitsu.medievalcraft.packethandle.forge;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacketForgeZ implements IMessage {

	public int locz;

	public MsgPacketForgeZ() {}

	public MsgPacketForgeZ(int z){
		this.locz = z;
	}


	@Override
	public void fromBytes(ByteBuf buf) {

		this.locz = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.locz);
	}

}
