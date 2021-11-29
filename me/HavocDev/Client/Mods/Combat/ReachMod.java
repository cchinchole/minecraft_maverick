package me.HavocDev.Client.Mods.Combat;

import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;

public class ReachMod extends Mod{

    public ReachMod() {super("reach", "Reach", "Reach Blocks", Category.World, -999);
    }

    public void onToggle()
    {
        this.isActive = !this.isActive;
        Variables.reach = !Variables.reach;
    }

}
