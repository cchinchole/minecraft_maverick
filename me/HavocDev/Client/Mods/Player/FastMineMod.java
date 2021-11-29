package me.HavocDev.Client.Mods.Player;


import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;

public class FastMineMod extends Mod{

	public FastMineMod()
	{
		super("fastmine", "Fast Mine", "Mine blocks quickly", Category.Player, -99);
	}
	
	public void onToggle()
	{
		this.isActive = !this.isActive;
		Variables.fastSpeedActive = !Variables.fastSpeedActive;
	}
	
}
