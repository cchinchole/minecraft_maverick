package me.HavocDev.Client.Commands;

import java.util.ArrayList;

import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Utilities.ChatUtils;

public class CommandManager {

	ArrayList<Command> commands = new ArrayList();
	
	public Toggle toggle = new Toggle();
	public Bind bind = new Bind();
	public Friend friend = new Friend();
	public Help help = new Help();
	public Teleport teleport = new Teleport();
	public WaypointCommand waypoint = new WaypointCommand();
	public XrayCommand xray = new XrayCommand();
	
	public CommandManager()
	{
		commands.add(toggle);
		commands.add(bind);
		commands.add(friend);
		commands.add(help);
		commands.add(teleport);
		commands.add(waypoint);
		commands.add(xray);
	}
	

	public void callCommand(String input)
	{
		String[] args = input.split(" ");
		for(Command m : commands)
		{
			if(m.command.equalsIgnoreCase(args[0]))
			{
				try
				{
					m.onCommand(args);
				}
				catch(Exception deea){}
				return;
			}
		}
		ChatUtils.addChatMessage("\247cCommand not found.\247f");
	}
	
}
