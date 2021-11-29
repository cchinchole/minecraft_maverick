package me.HavocDev.Client.Mods.Render;

import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;

/**
 * Created by christian on 11/4/2016.
 */
public class RenderCoordsMod extends Mod {

    public RenderCoordsMod() {super("coords", "Render Coordinates", "Renders your coordinates", Category.Render, -999);
    }

    public void onToggle()
    {
        this.isActive = !this.isActive;
        Variables.RenderCoords = !Variables.RenderCoords;
    }

}
