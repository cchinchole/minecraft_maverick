package me.HavocDev.Client.Mods.Render;

import java.awt.Color;

import me.HavocDev.Client.Client.Client;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public class Waypoint {

    Color color;
    String name = "";
    Vec3 p;
    float drawX;
    float drawY;
    float drawZ;

    public Waypoint(String name, Color color, Vec3 p)
    {
        this.color = color;
        this.name = name;
        this.p  = p;
    }

    public BlockPos getPos()
    {
        return new BlockPos(p.xCoord, p.yCoord, p.zCoord);
    }

    public Vec3 getDraw()
    {
        return new Vec3( (float)p.xCoord - (float) Client.INSTANCE.mc.getRenderManager().renderPosX,
                (float)p.yCoord - (float) Client.INSTANCE.mc.getRenderManager().renderPosY,
                (float)p.zCoord - (float) Client.INSTANCE.mc.getRenderManager().renderPosZ );
    }

    public Color getColor()
    {
        return color;
    }

    public String getName()
    {
        return name;
    }

}
