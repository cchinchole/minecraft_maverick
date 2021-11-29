package me.HavocDev.Client.Commands;

import me.HavocDev.Client.Utilities.ChatUtils;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.block.Block;

public class XrayCommand extends Command{

	public XrayCommand()
	{
		super("xray", "xray <add / remove> <name / id>");
	}


	@Override
	public void onCommand(String[] args)
	{
		if(args.length == 4) {
			if (args[1].equalsIgnoreCase("add")) {
				if (args[2].equalsIgnoreCase("name")) {
					Variables.XRayBlock.add(Block.getBlockFromName(args[3]));
					ChatUtils.addChatMessage("\247bAdded "+args[3]+" to Xray!\247f");
				} else if (args[2].equalsIgnoreCase("id")) {
					Variables.XRayBlock.add(Block.getBlockById(Integer.parseInt(args[3])));
					ChatUtils.addChatMessage("\247bAdded "+args[3]+" to Xray!\247f");
				} else {
					ChatUtils.addChatMessage("\247cSyntax: "+this.syntax+"\247f");
				}
			} else if (args[1].equalsIgnoreCase("remove")) {

				if (args[2].equalsIgnoreCase("name")) {
					Variables.XRayBlock.remove(Block.getBlockFromName(args[3]));
					ChatUtils.addChatMessage("\247bRemoved "+args[3]+" from Xray!\247f");
				} else if (args[2].equalsIgnoreCase("id")) {
					Variables.XRayBlock.remove(Block.getBlockById(Integer.parseInt(args[2])));
					ChatUtils.addChatMessage("\247bRemoved "+args[3]+" from Xray!\247f");
				} else {
					ChatUtils.addChatMessage("\247cSyntax: "+this.syntax+"\247f");
				}

			} else {
				ChatUtils.addChatMessage("\247cSyntax: "+this.syntax+"\247f");
			}
		}
		else
		{
			ChatUtils.addChatMessage("\247cSyntax: "+this.syntax+"\247f");
		}
		
		
	}
	
}
