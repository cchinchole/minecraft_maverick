package me.HavocDev.Client.Events;

public class RenderEvent extends Event{
	
	public float partialTicks = 0;
	
	public RenderEvent(float f)
	{
		partialTicks = f;
	}
	
}
