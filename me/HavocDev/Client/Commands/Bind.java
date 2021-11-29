package me.HavocDev.Client.Commands;

import org.lwjgl.input.Keyboard;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Utilities.ChatUtils;

public class Bind extends Command {
	
	public Bind()
	{
		super("bind", "bind add / remove <mod_name> <key>");
	}
	
	public boolean checkRealMod(String name)
	{
		for(Mod m : Client.INSTANCE.modManager.mods)
		{
			if(m.getName() == name)
				return true;
		}
		
		return false;
	}
	
	public void onCommand(String[] args)
	{
		if(args.length == 4)
		{
			if(args[1].equalsIgnoreCase("add"))
			{
				boolean result = false;
				for(Mod m : Client.INSTANCE.modManager.mods)
				{
					if(m.getName().equalsIgnoreCase(args[2]))
					{
						result = true;
						m.setKeybind(Keyboard.getKeyIndex(args[3].toUpperCase()));
						break;
					}
				}
				if(!result)
					ChatUtils.errorMessage(args[2] + " not found!");
				else
					ChatUtils.addChatMessage(args[2] + " has been binded to "+args[3]+"!");
				
			}
			else
			{
				ChatUtils.errorMessage(syntax);
			}
		}
		else if(args.length == 3)
		{
			if(args[1].equalsIgnoreCase("remove"))
			{
				boolean result = false;
				for(Mod m : Client.INSTANCE.modManager.mods)
				{
					if(m.getName().equalsIgnoreCase(args[2]))
					{
						result = true;
						m.setKeybind(-9999);
						break;
					}
				}
				if(!result)
					ChatUtils.errorMessage(args[2] + " not found!");
				else
					ChatUtils.addChatMessage(args[2] + " has been unbinded");
			}
		}
		else
		{
			ChatUtils.errorMessage(syntax);
		}
	}

}
