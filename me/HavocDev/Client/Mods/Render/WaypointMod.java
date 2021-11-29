package me.HavocDev.Client.Mods.Render;

import java.awt.Color;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Commands.Command;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Utilities.ChatUtils;
import me.HavocDev.Client.Utilities.RenderUtils;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public class WaypointMod extends Mod {
    public WaypointMod()
    {
        super("waypoint", "Waypoint", "Waypoint", Category.Render, -999);
    }

  

    public void onRender(float partialTicks)
    {
        for(Waypoint w : Variables.waypoints) {
            RenderUtils.blockESP(w.getPos(), 1);
            RenderUtils.drawTag("Point: "+w.getName(), w.getDraw().xCoord, w.getDraw().yCoord, w.getDraw().zCoord, w.getColor());
        }
    }

}
