package me.HavocDev.Client.Commands;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Utilities.ChatUtils;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class Friend extends Command{


	public Friend() {
		super("friend", "friend <add / nick / remove / coords> name <nick>");
	}

	/*

		Commands:

		.friend add havocdev;
		.friend nick havocdev NICK;
		.friend remove havocdev;
		.friend coords havocdev;

	 */
	
	private String setName(String s)
	{
		
		String newa = s;
		
		for(Entity e : Client.INSTANCE.world.loadedEntityList)
		{
			if(e instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)e;
				if(player.getName() != Client.INSTANCE.player.getName()) {
					if (player.getName().equalsIgnoreCase(s))
					{
						newa = s.replace(s, player.getName());
					}
				}
			}
		}
		return newa;
	}

	private boolean checkReality(String s)
	{
		for(Entity e : Client.INSTANCE.world.loadedEntityList)
		{
			if(e instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)e;
				if(player.getName() != Client.INSTANCE.player.getName()) {
					if (player.getName().equalsIgnoreCase(s))
					{
						return true;
					}
				}
			}
		}
		return false;
	}


	int curInd = 0;
	@Override
	public void onCommand(String[] args)
	{
		if(args.length >= 3) {
			args[2] = setName(args[2]);
			if (args[1].equalsIgnoreCase("coords"))
			{
				if(Variables.friends.contains(args[2]))
				{
					for(int i = 0; i < 2; i++)
					if(Variables.RenderCoordsFriendNames[i].equalsIgnoreCase(args[2]))
					{
						Variables.RenderCoordsFriendNames[i] = "";
						curInd--;
						ChatUtils.addChatMessage("Removed "+args[2]+" from coords!");
						return;
					}

					Variables.RenderCoordsFriend = true;
					if(curInd>2)
					{
						ChatUtils.errorMessage("Cannot have more than 3 coordinates displayed.");
						return;
					}
					Variables.RenderCoordsFriendNames[curInd] = args[2];
					curInd++;
					ChatUtils.addChatMessage("Displaying "+args[2]+" coords!");
				}
				else
				{
					ChatUtils.errorMessage("Friend does not exist.");
				}
			}

			if(args[1].equalsIgnoreCase("add"))
			{
				if(checkReality(args[2])) {
					if (!Variables.friends.contains(args[2])) {
						Variables.friends.add(args[2]);
						ChatUtils.addChatMessage(args[2] + " added to friends!");
					} else
						ChatUtils.errorMessage("Friend already exists.");
				}
				else
				{
					ChatUtils.errorMessage(args[2]+" could not be found.");
				}
			}

			if(args[1].equalsIgnoreCase("nick"))
			{
				String nick = "";
				
				for(int a = 3; a < args.length; a++)
				nick += args[a];
				if(Variables.friends.contains(args[2]))
				{

					if(Variables.friendNick.containsKey(args[2]))
					{
						Variables.friendNick.remove(args[2]);
						Variables.friendNick.put(args[2], nick);
						ChatUtils.addChatMessage("Changed nick of "+args[2]+" to " + nick);
					}
					else
					{
						Variables.friendNick.put(args[2], nick);
						ChatUtils.addChatMessage("Changed nick of "+args[2]+" to " + nick);
					}

				}
				else
				{
					ChatUtils.errorMessage("Friend does not exist.");
				}
			}
		}
		else
		{
			ChatUtils.addChatMessage("\247cSyntax: "+this.syntax+"\247f");
		}
		
		
	}

}
