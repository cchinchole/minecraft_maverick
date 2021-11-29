package me.HavocDev.Client.Commands;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Utilities.ChatUtils;

public class Toggle extends Command{
	
	public Toggle()
	{
		super("toggle", "toggle <mod_name>");
	}
	
	public void onCommand(String[] args)
	{
		if(args.length == 2)
		{
			for(Mod m : Client.INSTANCE.modManager.mods)
			{
				if(m.getName().equalsIgnoreCase(args[1]))
				{
					try
					{
						m.onToggle();
					}
					catch(Exception deea){}
					return;
				}
			}
			ChatUtils.addChatMessage("\247c"+args[1]+" not found.\247f");
		}
		else
		{
			ChatUtils.errorMessage(syntax);
		}
	}

}
