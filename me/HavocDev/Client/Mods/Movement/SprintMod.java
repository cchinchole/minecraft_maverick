package me.HavocDev.Client.Mods.Movement;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;

public class SprintMod extends Mod{

	public SprintMod() {
		super("sprint", "Auto Sprint", "Always sprinting.", Category.Movement, -99999);
	}
	
	
	
	public void onUpdate()
	{
		if(this.getActive())
		{
			Client.INSTANCE.player.setSprinting(true);
		}
	}

}
