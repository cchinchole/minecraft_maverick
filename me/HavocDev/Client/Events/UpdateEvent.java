package me.HavocDev.Client.Events;

public class UpdateEvent extends Event{
	  public boolean isAlive, onGround;
	    public double x, y, z;
	    public float yaw, pitch;

	    public UpdateEvent(float yaw, float pitch, double x, double y, double z, boolean onGround)
	    {
	    	this.yaw = yaw;
	    	this.pitch = pitch;
	    	this.onGround = onGround;
	        this.x = x;
	        this.y = y;
	        this.z = z;
	        this.isAlive = true;
	    }

	    public void cancel()
	    {
	        this.isAlive = false;
	    }
}
