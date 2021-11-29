package me.HavocDev.Client.Utilities;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Commands.Command;
import me.HavocDev.Client.Mods.Mod;
import net.minecraft.util.ChatComponentText;

public class ChatUtils {
	public static void errorMessage(String s)
	{
		Client.INSTANCE.mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("[\2475M\247f] \247c"+s));
	}
	
	public static void addChatMessage(String s)
	{
		Client.INSTANCE.mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("[\2475M\247f] "+s));
	}
	
	public static void addCommandSyntax(Command c)
	{
		Client.INSTANCE.mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("[\2475M\247f] \247e"+c.command+"\247f - \247c"+c.syntax));
	}
	
	public static void addCommandDesc(Mod m)
	{
		Client.INSTANCE.mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("[\2475M\247f] \247e"+m.getName()+"\247f - \247f"+m.getDescription()));
	}
}
