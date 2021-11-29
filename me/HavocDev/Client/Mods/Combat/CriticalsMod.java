package me.HavocDev.Client.Mods.Combat;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C03PacketPlayer;

public class CriticalsMod extends Mod{

	

	public CriticalsMod() {
		super("criticals", "Criticals", "Always hit criticals", Category.Combat, -99999);
				
		// TODO Auto-generated constructor stub
	}
	
	public void onLeftClick()
	{

		if(Client.INSTANCE.mc.objectMouseOver != null
			&& Client.INSTANCE.mc.objectMouseOver.entityHit instanceof EntityLivingBase)
				doCritical();
	}
	

	public void doCritical()
	{
		if(!this.isActive)
			return;
		if(!Client.INSTANCE.player.isInWater()
			&& !Client.INSTANCE.player.isInsideOfMaterial(Material.lava)
			&& Client.INSTANCE.player.onGround)
			switch(Variables.criticalsMode)
			{
				case 0:
					Client.INSTANCE.player.motionY = 0.1F;
					Client.INSTANCE.player.fallDistance = 0.1F;
					Client.INSTANCE.player.onGround = false;
					break;
				case 1:
					double posX = Client.INSTANCE.player.posX;
					double posY = Client.INSTANCE.player.posY;
					double posZ = Client.INSTANCE.player.posZ;
					
					Client.INSTANCE.sendPacket(new C03PacketPlayer.C04PacketPlayerPosition(posX,
						posY + 0.0625D, posZ, true));
					Client.INSTANCE.sendPacket(
						new C03PacketPlayer.C04PacketPlayerPosition(posX, posY, posZ, false));
					Client.INSTANCE.sendPacket(new C03PacketPlayer.C04PacketPlayerPosition(posX,
						posY + 1.1E-5D, posZ, false));
					Client.INSTANCE.sendPacket(
						new C03PacketPlayer.C04PacketPlayerPosition(posX, posY, posZ, false));
					break;
			}
}
	
}
