package me.HavocDev.Client.Hook;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Gui.Click.ClickGui;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Colors;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.wurstclient.font.Fonts;

public class GuiHook extends GuiIngame{
	
	/*
	 * Hooks into minecraft's gui screen.
	 *
	 */

	public ClickGui clickGUI;

	
	private int yOffset = 16, offset = 0;
	
	public GuiHook(Minecraft minecraft)
	{
		super(minecraft);
		clickGUI = new ClickGui();
	}
	int yy = Colors.MAGENTA;

	public void drawClientInfo()
	{
			if (Client.INSTANCE.isAuthenticated()) {
				Fonts.calibri14.drawString(Client.INSTANCE.getClientName(), 300, 16, Colors.LIGHT_GRAY);
			} else {
				Fonts.calibri14.drawString( Client.INSTANCE.getClientName() + " Unlicensed", 300, 6, Colors.RED);
				Fonts.calibri14.drawString("You must license to use mods.", 280, 16, Colors.RED);
			}

			for(int y = -4; y < 24; y=y+2)
			{

				Fonts.calibri14.drawString( "|", 290, y, yy);
				if(yy == Colors.LIGHT_GRAY)
					yy = Colors.WHITE;
				else
					yy = Colors.LIGHT_GRAY;
			}

			for(int x = 290; x < 500; x=x+1)
			{
				Fonts.calibri14.drawString( "-", x, 24, yy);
				if(yy == Colors.LIGHT_GRAY)
					yy = Colors.WHITE;
				else
					yy = Colors.LIGHT_GRAY;
			}
	}

	int colIndex = Colors.MAGENTA;
	
	private int nextColor()
	{
		if(colIndex == Colors.LIGHT_GRAY)
			return Colors.WHITE;
		if(colIndex == Colors.LIGHT_GRAY)
			return Colors.WHITE;
		return Colors.RED;
	}

	
	public void drawMods()
	{
		int y = 32;
			if (Client.INSTANCE.isAuthenticated())
				Fonts.calibri14.drawString("Welcome "+Client.INSTANCE.player.getName()+" to", 300, 6, Colors.CLIENT_COLOR);

		for(Mod m : Client.INSTANCE.modManager.mods)
		{
			colIndex = nextColor();
			if(m.color == -1)
			{
				m.color = colIndex;
			}

			if(m.getActive())
			{
				Fonts.calibri14.drawString(m.getDisplayName(), 300, y, m.color);
				y += 10;
			}
		}

		if(Variables.RenderCoords)
		{
			DecimalFormat df = new DecimalFormat("##.###");
			df.setRoundingMode(RoundingMode.DOWN);
			String mystring = "X: "+df.format(Client.INSTANCE.player.posX);
			String mystring2 = "Y: "+df.format(Client.INSTANCE.player.posY);
			String mystring3 = "Z: "+df.format(Client.INSTANCE.player.posZ);
			Fonts.calibri14.drawString( mystring, 25, 16, Colors.ORANGE);
			Fonts.calibri14.drawString( mystring2, 25, 26, Colors.ORANGE);
			Fonts.calibri14.drawString( mystring3, 25, 36, Colors.ORANGE);
		}


			if(Variables.RenderCoordsFriend)
			{
				DecimalFormat df = new DecimalFormat("##.###");
				df.setRoundingMode(RoundingMode.DOWN);
				int yyy = 56;

				for(String s : Variables.RenderCoordsFriendNames) {
					s = s.toLowerCase();
					EntityPlayer play = null;

					for(Entity e : Client.INSTANCE.world.loadedEntityList)
					{
						if(e instanceof EntityPlayer)
						{
							if(e.getName().toLowerCase().equalsIgnoreCase(s.toLowerCase()))
								play = (EntityPlayer)e;
						}
					}

					if(play != null) {


						String mystring = "X: " + df.format(play.posX);
						String mystring2 = "Y: " + df.format(play.posY);
						String mystring3 = "Z: " + df.format(play.posZ);
						Fonts.calibri14.drawString( s + " location:", 25, yyy, Colors.ORANGE);
						Fonts.calibri14.drawString( mystring, 25, yyy + 10, Colors.ORANGE);
						Fonts.calibri14.drawString( mystring2, 25, yyy + 20, Colors.ORANGE);
						Fonts.calibri14.drawString( mystring3, 25, yyy + 30, Colors.ORANGE);
						yyy = yyy + 40;
					}
				}
			}
	}
	
	
	


	public void renderGameOverlay(float partialTicks) {
		super.renderGameOverlay(partialTicks);
		UIRenderer.renderFrames(partialTicks);
	}
}
