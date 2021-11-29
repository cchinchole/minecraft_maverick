package me.HavocDev.Client.Events;

public class LateUpdateEvent extends Event {
	
	float yaw, pitch;
	
	public LateUpdateEvent(float yaw, float pitch)
	{
		this.yaw = yaw;
		this.pitch = pitch;
	}
	
}
