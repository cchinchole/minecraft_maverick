package me.HavocDev.Client.Events;

public class PostMotionEvent extends Event {

    public boolean isAlive;
    public double x, y, z;

    public PostMotionEvent(double x, double y, double z)
    {
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
