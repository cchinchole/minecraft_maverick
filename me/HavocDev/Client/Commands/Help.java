package me.HavocDev.Client.Commands;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Utilities.ChatUtils;
import me.HavocDev.Client.Variables.Category;

public class Help extends Command{
	   public Help()
	    {
	        super("help", "help <mod_name>");
	    }
	   
	    public void onCommand(String[] args)
	   {
		   if(args.length == 1)
		   {
			   for(Command m : Client.INSTANCE.commandManager.commands)
			   	{
					   ChatUtils.addCommandSyntax(m);
			   	}
		   }
		   else if(args.length == 2)
		   {
			   for(Mod m : Client.INSTANCE.modManager.mods)
			   	{
				   if(m.realName.toLowerCase().equals(args[1].toLowerCase())){
					   ChatUtils.addCommandDesc(m);
					  // ChatUtils.addChatMessage(m.realName+": "+m.syntax);
					   break;
				   }   
			   	}
			   
			   
			   
			   
		   }
		   else
			   ChatUtils.addCommandSyntax(this);
				//ChatUtils.addChatMessage("\247cSyntax: "+this.syntax+"\247f");
	   }
}
