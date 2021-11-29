package me.HavocDev.Client.Mods.Render;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Colors;
import net.wurstclient.font.Fonts;

public class WidgetMod extends Mod{
	public WidgetMod() {
		super("widgets", "Widgets", "Displays Widgets (FPS)", Category.Render, -999999);
	}
	
	
	public void render(float partialTicks)
	{
		if(this.isActive)
		{
			Fonts.corbel14.drawString("FPS: "+Client.INSTANCE.mc.getDebugFPS(), 20, 15, Colors.CLIENT_COLOR);
		}
	}
}
