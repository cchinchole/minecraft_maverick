package me.HavocDev.Client.Mods.Player;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;

public class FastPlaceMod extends Mod {

	public FastPlaceMod()
	{
		super("fastplace", "Fast Place", "Place blocks quickly", Category.Player, -999);
	}
	
	public void onUpdate()
	{
		if(this.getActive())
		{
			Client.INSTANCE.mc.rightClickDelayTimer = 0;
		}
		else
		{
			Client.INSTANCE.mc.rightClickDelayTimer = 4;
		}
	}
	
}
