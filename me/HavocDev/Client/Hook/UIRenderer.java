package me.HavocDev.Client.Hook;

import me.HavocDev.Client.Client.Client;

public class UIRenderer {
	
	public static void renderFrames(float partialTicks)
	{
		Client.INSTANCE.modManager.tabGUI.renderT(partialTicks);
		Client.INSTANCE.modManager.arraylist.render(partialTicks);
		Client.INSTANCE.modManager.widgets.render(partialTicks);
		Client.INSTANCE.modManager.bypasses.render(partialTicks);
	//	Client.INSTANCE.modManager.waypoints.render(partialTicks);

			//TabGui.render();
			//GL11.glPopMatrix();
			//Client.INSTANCE.modManager.itemESP.render(partialTicks);
		
		/*
		
		for(Frame f : Client.INSTANCE.guiManager.getFrames())
		{
			f.update();
			if(f.isPinned() || Client.INSTANCE.mc.currentScreen instanceof GuiManagerDisplayScreen)
			{
				f.render();
			}
		}*/
	}

}
