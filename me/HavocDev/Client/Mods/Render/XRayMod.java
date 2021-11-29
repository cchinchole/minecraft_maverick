package me.HavocDev.Client.Mods.Render;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Utilities.ChatUtils;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.block.Block;

public class XRayMod extends Mod{

	public XRayMod()
	{
		super("xray", "X-Ray", "Block Xray", Category.Render, -999);
	}
	
	
	
	public void onToggle()
	{
		Client.INSTANCE.mc.renderGlobal.loadRenderers();
		this.isActive = !this.isActive;
		Variables.XRay = !Variables.XRay;
		if(!Client.INSTANCE.modManager.fullbright.getActive())
			Client.INSTANCE.modManager.fullbright.onToggle();
		else
			Client.INSTANCE.modManager.fullbright.onToggle();
		ChatUtils.addChatMessage("Xray: "+this.getActive());
	}
	
}
