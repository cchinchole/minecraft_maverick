package me.HavocDev.Client.Mods.Movement;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.BlockPos;

public class NofallMod extends Mod{
	
	public NofallMod()
	{
		super("nofall","No Fall", "Removes fall damage", Category.Movement, -99);
	}
	/*
	public void onUpdate()
	{
		if(!Client.INSTANCE.player.onGround){
		if(Client.INSTANCE.player.fallDistance > 2f){
			Client.INSTANCE.player.setVelocity(0, 0, 0);
		}
		Client.INSTANCE.player.fallDistance = 0;
	}
		*/
	
	public void onPacket(Packet pack)
	{
		
		  if (pack instanceof C03PacketPlayer) {
              if (Client.INSTANCE.player.fallDistance > 3.0F) {
                  C03PacketPlayer packet = (C03PacketPlayer)pack;
                  packet.onGround = true;
              }
          } 
		
		/*
		
		  if (Client.INSTANCE.world.getBlockState(new BlockPos(Client.INSTANCE.player.posX, Client.INSTANCE.player.posY - 2, Client.INSTANCE.player.posZ)).getBlock() != Blocks.air && Client.INSTANCE.player.fallDistance >= 3.0F) {
              Client.INSTANCE.player.setPosition(Client.INSTANCE.player.posX, Client.INSTANCE.player.posY - 2.5, Client.INSTANCE.player.posZ);
              Client.INSTANCE.player.motionX *= 0.0F;
              Client.INSTANCE.player.fallDistance = 0.0F;
              Client.INSTANCE.player.setInWeb();
              Client.INSTANCE.player.motionZ *= 0.0F;
		  }
		  
		  */
		  
	}
	

}

