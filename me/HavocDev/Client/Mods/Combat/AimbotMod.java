package me.HavocDev.Client.Mods.Combat;

import java.util.Random;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Utilities.PlayerUtils;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class AimbotMod extends Mod {

	 public AimbotMod() {
	        super("aimbot", "Aimbot", "Lock onto enemies", Category.Combat, -99999);

	        // TODO Auto-generated constructor stub
	    }
	 

	 
	  
		
	   public int smoothLevel = 3;
	   public int maxDistance = 8;
	   public int maxCursor = 15;
	   
	 public void onUpdate()
	 {
		 
		 if(!this.isActive || Client.INSTANCE.modManager.freecam.getActive())
			 return;
		 
		 
		 
		 
		 
		 
		 
		 	EntityPlayer bestTarget = null;
			for(Entity e : Client.INSTANCE.world.loadedEntityList)
			{
				if ( e instanceof EntityPlayer)
				{
					if(!(e instanceof EntityPlayerSP))
					{
						EntityPlayer player = (EntityPlayer)e;
						
						
						if(bestTarget == null && Client.INSTANCE.player.canEntityBeSeen(player) && PlayerUtils.getDistanceToEntity(player) < maxDistance)
						{
							bestTarget = player;
							continue;
						}
						
						if(bestTarget != null)
						if(Client.INSTANCE.player.canEntityBeSeen(player) && PlayerUtils.getDistanceToEntity(player) < maxDistance && (PlayerUtils.getDistanceToEntity(player) < PlayerUtils.getDistanceToEntity(bestTarget)))
							bestTarget = player;
						}
				}
			}
			
			
			if(bestTarget != null)
			{
				float PI = 3.141592653589f;
			

				float yaw = (float) (Math.atan2(bestTarget.posZ - Client.INSTANCE.player.posZ, bestTarget.posX - Client.INSTANCE.player.posX) * 180.0D / PI) - 90.0F;

				float pitch = (float) -(Math.atan2(bestTarget.posY - Client.INSTANCE.player.posY, PlayerUtils.getDistanceToEntity(bestTarget)) * 180.0D / PI);
            

				Random rand = new Random();
				float newYaw = (float) (Client.INSTANCE.player.rotationYaw + (MathHelper
						.wrapAngleTo180_float(yaw - Client.INSTANCE.player.rotationYaw))
						/ (smoothLevel * (rand.nextDouble() * 2 + 1)));
				
				float newPitch = (float) (Client.INSTANCE.player.rotationPitch + (MathHelper
						.wrapAngleTo180_float(pitch - Client.INSTANCE.player.rotationPitch))
						/ (smoothLevel * (rand.nextDouble() * 2 + 1)));
				
			
				if(PlayerUtils.getDistance(new Vec3(Client.INSTANCE.player.rotationYaw, Client.INSTANCE.player.rotationPitch, 0), new Vec3(newYaw, newPitch, 0)) < maxCursor)
				{
					Client.INSTANCE.player.rotationYaw = newYaw;
					Client.INSTANCE.player.rotationPitch = newPitch;
				}
			}
			
			
			
			
			
	 }
	
	
}
