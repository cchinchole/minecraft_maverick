package me.HavocDev.Client.Commands;

import java.awt.Color;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Render.Waypoint;
import me.HavocDev.Client.Utilities.ChatUtils;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.util.Vec3;

public class WaypointCommand extends Command {
	
	public WaypointCommand()
	{
		super("waypoint", "waypoint <add / remove / list> <name> <color>");
	}
	
	
	  public boolean checkIfExists(String name, boolean delete)
	    {
	        for(Waypoint w : Variables.waypoints)
	          {
	            if(w.getName().equalsIgnoreCase(name))
	            {
	                if(delete)
	                    Variables.waypoints.remove(w);
	                    return true;
	             }
	          }
	    return false;
	    }

	    public void onCommand(String[] args)
	    {
	        if (args.length == 3)
	        {
	            if(args[1].equalsIgnoreCase("add"))
	            {
	            if(!checkIfExists(args[2], false)) {


	                Variables.waypoints.add(new Waypoint(args[2], new Color(255, 255, 255), new Vec3(Client.INSTANCE.player.posX, Client.INSTANCE.player.posY, Client.INSTANCE.player.posZ)));
	                ChatUtils.addChatMessage("Successfully added Waypoint!");
	                }
	            else
	                {
	                    ChatUtils.errorMessage("Waypoint "+args[2]+" already exists!");
	                }
	            }
	        }
	        else  if(args.length == 3)
	        {
	            if(args[1].equalsIgnoreCase("remove"))
	            {
	                if(checkIfExists(args[2], true))
	                {
	                    ChatUtils.addChatMessage("Successfully removed Waypoint!");
	                }
	                else
	                {
	                    ChatUtils.errorMessage("Waypoint "+args[2]+" does not exist!");
	                }
	            }
	        }
	        else if(args.length == 2)
	        {
	            if(args[1].equalsIgnoreCase("list")) {
	                ChatUtils.addChatMessage("Displaying waypoints!");
	                for (Waypoint w : Variables.waypoints) {
	                    ChatUtils.addChatMessage(w.getName() + ": " + w.getPos());
	                }
	            }
	        }
	        else
	        {
	            ChatUtils.addCommandSyntax(new Command("", ""));
	        }
	    }

	

}
