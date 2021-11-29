package me.HavocDev.Client.Mods.Render;

import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;

public class ChamsMod extends Mod{

    public ChamsMod() {super("wallhack", "Wallhack", "Show Players Through Walls", Category.Render, -999);
    }

    public void onToggle()
    {
        this.isActive = !this.isActive;
        Variables.Chams = !Variables.Chams;
    }

}
