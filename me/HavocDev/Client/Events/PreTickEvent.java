package me.HavocDev.Client.Events;

import net.minecraft.network.Packet;

public class PreTickEvent extends Event {

    public Packet calledPacket;
    public boolean isAlive;
    float yaw, pitch;

    public PreTickEvent(float yaw, float ptich)
    {
        this.yaw = yaw;
        this.pitch = ptich;
        this.isAlive = true;
    }

}
