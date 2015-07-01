package com.kitsu.medievalcraft.packethandle.forgeHammerParticles;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacketlTicks implements IMessage {

	public int locx;

	public MsgPacketlTicks() {}

	public MsgPacketlTicks(int x){
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
