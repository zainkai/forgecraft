package com.kitsu.medievalcraft.packethandle.forge;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MsgPacketForgeY implements IMessage {

	public int locy;

	public MsgPacketForgeY() {}

	public MsgPacketForgeY(int y){
		this.locy = y;
	}


	@Override
	public void fromBytes(ByteBuf buf) {

		this.locy = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.locy);
	}

}
