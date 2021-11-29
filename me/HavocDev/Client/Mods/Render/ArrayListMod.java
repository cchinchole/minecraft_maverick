package me.HavocDev.Client.Mods.Render;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Colors;
import net.wurstclient.font.Fonts;

public class ArrayListMod extends Mod{
	public ArrayListMod() {
		super("arraylist", "ArrayList", "Displays Active Mods", Category.Render, -999999);
	}
	
	
	public void render(float partialTicks)
	{
		if(this.isActive)
		{
			int yy = 50;
			for(Mod m : Client.INSTANCE.modManager.mods)
			{
				if(m.getCategory().id <= Category.Movement.numOfCats && m.getActive()){
					Fonts.corbel14.drawString(m.getDisplayName(), 350, yy, Colors.CLIENT_COLOR);
					yy += 15;
				}
			}
		}
	}
}
