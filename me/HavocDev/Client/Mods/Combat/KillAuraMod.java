package me.HavocDev.Client.Mods.Combat;

import java.util.ArrayList;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Events.UpdateEvent;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Utilities.PlayerUtils;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.util.MathHelper;

public class KillAuraMod extends Mod{
	
	public KillAuraMod() {
		super("killaura", "Kill Aura", "Kil Aura", Category.Combat, -99999);
	}
	
	/*
	 * Modes
	 *  0: Single Target (CLOSEEST)
	 *  1: Multi Target  (RANGE)
	 * 
	 * 
	 */
	
	
	ArrayList<EntityLivingBase> entities = new ArrayList();
	int selectedEntity = 0;
	
	private boolean readyToAttack = false;
	public EntityPlayer currentTarget = null;
	
	public void attackEntity(Entity e)
	{

		Client.INSTANCE.modManager.autoblock.stopBlock();
		
		if(Client.INSTANCE.modManager.criticals.getActive())
			Client.INSTANCE.modManager.criticals.doCritical();
		
		Client.INSTANCE.player.swingItem();
		Client.INSTANCE.sendPacketBypass(new C02PacketUseEntity(e, Action.ATTACK));
		Client.INSTANCE.modManager.autoblock.startBlock();
	}
	
	public void onEnable()
	{
		reset();
		super.onEnable();
	}
	
	public boolean checkEntity(EntityPlayer player)
	{
		
		boolean result = false;
		
		
		if(!Variables.friends.contains(player.getName().toLowerCase()))
			result = true;
		
		
		return result;
		
	}
	
	public boolean doBlock()
	{
		return this.entities.isEmpty() || this.currentTarget != null;
	}
	
	
	@Override
	public void onUpdate()
	{
		entities.clear();
		currentTarget = null;
		for(Entity e : Client.INSTANCE.world.loadedEntityList)
		{
			if(e instanceof EntityPlayer)
			{
				if(!(e instanceof EntityPlayerSP))
				{
				EntityPlayer player = (EntityPlayer)e;
				
				if(!checkEntity(player))
					continue;
				
				if(PlayerUtils.getDistanceToEntity(player) < Variables.auraRange)
				{
					if(!entities.contains(player))
						entities.add(player);
					
					
					switch(Variables.auraMode)
					{
					case 0:
						
						if(currentTarget == null)
							currentTarget = player;
						else if(PlayerUtils.getDistanceToEntity(player) < PlayerUtils.getDistanceToEntity(currentTarget))
							currentTarget = player;
						break;
					}
					
					
				}
				}
			}
		}
		

		if(!this.hasTimeElapsed(1000/Variables.auraSpeed, false))
			return;
		
		
		switch(Variables.auraMode)
		{
		case 0:
			if(currentTarget != null)
			{

				float yaw = (float) (Math.atan2(currentTarget.posZ - Client.INSTANCE.player.posZ, currentTarget.posX - Client.INSTANCE.player.posX) * 180.0D / 3.14159) - 90.0F;

				float pitch = (float) -(Math.atan2(currentTarget.posY - Client.INSTANCE.player.posY, PlayerUtils.getDistanceToEntity(currentTarget)) * 180.0D / 3.14159);

				float a = Client.INSTANCE.player.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - Client.INSTANCE.player.rotationYaw);
				float b = Client.INSTANCE.player.rotationPitch + MathHelper.wrapAngleTo180_float(pitch - Client.INSTANCE.player.rotationPitch);

				Client.INSTANCE.player.rotationYaw = a;
				Client.INSTANCE.player.rotationPitch = b;
				
				
				
				((UpdateEvent)event).yaw = a;
				((UpdateEvent)event).pitch = b;
				readyToAttack = true;
				
			}
			break;
		case 1:
			if(!entities.isEmpty())
			{
				for(EntityLivingBase e : entities)
				{
					float yaw = (float) (Math.atan2(e.posZ - Client.INSTANCE.player.posZ, e.posX - Client.INSTANCE.player.posX) * 180.0D / 3.14159) - 90.0F;

					float pitch = (float) -(Math.atan2(e.posY - Client.INSTANCE.player.posY, PlayerUtils.getDistanceToEntity(e)) * 180.0D / 3.14159);

					float a = Client.INSTANCE.player.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - Client.INSTANCE.player.rotationYaw);
					float b = Client.INSTANCE.player.rotationPitch + MathHelper.wrapAngleTo180_float(pitch - Client.INSTANCE.player.rotationPitch);
					((UpdateEvent)event).yaw = a;
					((UpdateEvent)event).pitch = b;
					readyToAttack = true;
				}
			}
		}
		
		if(readyToAttack)
			reset();
		
		
	}
	
	public void onLateUpdate()
	{
		
		if(!readyToAttack)
			return;
		
		readyToAttack = false;
		
		switch(Variables.auraMode)
		{
		
		case 0:
			if(currentTarget != null)
			{
				attackEntity(currentTarget);
			}
			break;
		case 1:
			for(EntityLivingBase player : entities)
			{
				attackEntity(player);
			}
		
		}
	}
	

}
