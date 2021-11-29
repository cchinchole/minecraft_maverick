package me.HavocDev.Client.Events;

import net.minecraft.network.Packet;

public class PacketOutputEvent extends Event {

	public Packet calledPacket;
	public boolean isAlive;
	
	public PacketOutputEvent(Packet packetIn)
	{
		this.calledPacket = packetIn;
		this.isAlive = true;
	}

	public void cancel()
	{
		this.isAlive = false;
	}
	
}
