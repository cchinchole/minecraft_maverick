package me.HavocDev.Client.Utilities;

import me.HavocDev.Client.Client.Client;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class PlayerUtils {
	
	public static Vec3 getEyesPos()
	{
		return new Vec3(Client.INSTANCE.player.posX,
				Client.INSTANCE.player.posY + Client.INSTANCE.player.getEyeHeight(),
				Client.INSTANCE.player.posZ);
	}
	
	 public static double getDistance(Vec3 from, Vec3 to)
	    {
	        double d0 = from.xCoord - to.xCoord;
	        double d1 = from.yCoord - to.yCoord;
	        double d2 = from.zCoord - to.zCoord;
	        return Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
	    }
	   
	   public static float getDistanceToEntity(Entity entityIn)
	    {
		   
	        float f = (float)(Client.INSTANCE.player.posX - entityIn.posX);
	        float f1 = (float)(Client.INSTANCE.player.posY - entityIn.posY);
	        float f2 = (float)(Client.INSTANCE.player.posZ - entityIn.posZ);
	        return MathHelper.sqrt_float(f * f + f1 * f1 + f2 * f2);
	    }
	 
	
	
}
