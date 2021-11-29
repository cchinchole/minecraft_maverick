package me.HavocDev.Client.Mods.Movement;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;

public class FlyMod extends Mod{

	
	

	public FlyMod()
	{
		super("fly", "Fly", "Allows you to fly", Category.Movement, -9999);
	}

	public void onEnable()
	{
		Variables.flightEnabled = true;
	}

	public void onDisable()
	{
		Client.INSTANCE.player.capabilities.isFlying = false;
		Variables.flightEnabled = false;
	}
	
	public void onUpdate()
	{
		if(this.isActive)
		{
			Client.INSTANCE.player.capabilities.isFlying = true;
			if(Client.INSTANCE.mc.gameSettings.keyBindJump.isPressed())
				Client.INSTANCE.player.motionY += 0.0002;
			if(Client.INSTANCE.mc.gameSettings.keyBindSneak.isPressed())
				Client.INSTANCE.player.motionY -= 0.0002;
			if(Client.INSTANCE.mc.gameSettings.keyBindForward.isPressed())
				Client.INSTANCE.player.capabilities.setFlySpeed(Variables.flight/10);
		}
	}
	
}
