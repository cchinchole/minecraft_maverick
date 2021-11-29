package me.HavocDev.Client.Mods.Player;

import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;

public class AutoToolMod extends Mod {

	public AutoToolMod() {
		super("autotool", "Auto Tool", "Switches tools automatically", Category.Player, -999);
		}
	
	public void onToggle()
	{
		this.isActive = !this.isActive;
		Variables.AutoTool = !Variables.AutoTool;
	}

}
