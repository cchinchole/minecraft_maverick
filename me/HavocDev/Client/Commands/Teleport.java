package me.HavocDev.Client.Commands;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Utilities.ChatUtils;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Teleport extends Command{

	public Teleport() {
		super("tp", "tp <up / player> <blocks / name>");
	}
	
	private EntityPlayer checkReality(String s)
	{
		for(Entity e : Client.INSTANCE.world.loadedEntityList)
		{
			if(e instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)e;
				if(player.getName() != Client.INSTANCE.player.getName()) {
					if (player.getName().equalsIgnoreCase(s))
					{
						return (EntityPlayer)e;
					}
				}
			}
		}
		return null;
	}

    @Override
    public void onCommand(String[] args)
    {
    	if(args.length == 3)
    	{
    		if(args[1].equalsIgnoreCase("up"))
    		{
    			int pos;
    			try
    			{
    				pos = Integer.parseInt(args[2]);
    			}
    			catch(Exception e)
    			{
    				pos = 0;
    				ChatUtils.addChatMessage("\247cInvalid Posistion: "+args[2]+"\247f");
    				return;
    			}
    			Client.INSTANCE.player.setPosition(Client.INSTANCE.player.posX, Client.INSTANCE.player.posY+pos, Client.INSTANCE.player.posZ);
    			ChatUtils.addChatMessage("\247bYou've been moved "+args[2]+" blocks high!\247f");
    		} else
    			if(args[1].equalsIgnoreCase("player"))
        		{
    				
    				if(checkReality(args[2]) != null) {
						EntityPlayer player = (EntityPlayer) checkReality(args[2]);
						if (player.getName() != Client.INSTANCE.player.getName()) {
							if (player.getName().equalsIgnoreCase(args[2])) {
								Client.INSTANCE.player.setPosition(player.posX , player.posY, player.posZ );
							}
						}

            			
            			ChatUtils.addChatMessage("\247bYou've been moved to "+args[2]+"!\247f");
    				}
    				else
    				ChatUtils.errorMessage("Player does not exist!");
        		}
    	}
    	else if(args.length == 4)
		{
			try
			{
				//int x = (Integer.parseInt(args[1]));
				//int y = (Integer.parseInt(args[2]));
				//int z = (Integer.parseInt(args[3]));
				for(int i = 0; i < 500; i ++) {
					Client.INSTANCE.sendPacket(new C03PacketPlayer.C04PacketPlayerPosition(Client.INSTANCE.player.posX + i, Client.INSTANCE.player.posY, Client.INSTANCE.player.posZ, false));
				}
				//Client.INSTANCE.mc.getConnection().sendPacket(new CPacketPlayer.Position(x, y, z, true));
				//Client.INSTANCE.player.setPosition(x, y, z);

			}
			catch (Exception ee)
			{
				System.out.println(args[0] + ""+ args[1]+ "" + args[2]);
				ChatUtils.addChatMessage("\247cInvalid Location: \247f");
			}
		}
    	else
			ChatUtils.addChatMessage("\247cSyntax: "+this.syntax+"\247f");
    }

	
}
