package me.HavocDev.Client.Mods.Render;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;

public class FullBrightMod extends Mod{
	
	public FullBrightMod()
	{
		super("fullbright", "Full Bright", "Brighten up the place!", Category.Render, -999);
	}
	
	float real = 10f;
	
	public void onEnable()
	{
		real = Client.INSTANCE.mc.gameSettings.gammaSetting;
		Client.INSTANCE.mc.gameSettings.gammaSetting = 100000f;
	}

	public void onDisable()
	{	Client.INSTANCE.mc.gameSettings.gammaSetting = real;
	}
	
}
