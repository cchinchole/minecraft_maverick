package me.HavocDev.Client.Mods.Combat;

import java.util.ArrayList;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Util.EnumOS;
import net.wurstclient.utils.RotationUtils;

public class ForceFieldMod extends Mod{
	
	public ForceFieldMod() {
		super("forcefield", "Force Field", "Force Field", Category.Combat, -99999);
	}
	
	public boolean isCorrectEntity(Entity en)
	{
		// non-entities
		if(en == null)
			return false;
		
		// dead entities
		if(en instanceof EntityLivingBase && (((EntityLivingBase)en).isDead
			|| ((EntityLivingBase)en).getHealth() <= 0))
			return false;
		
		// entities outside the range
		if(Client.INSTANCE.player.getDistanceToEntity(en) > Variables.auraRange)
			return false;
		
		// entities outside the FOV
		if(Variables.auraFOV < 360F && RotationUtils.getAngleToClientRotation(
			en.boundingBox.getCenter()) > Variables.auraFOV / 2F)
			return false;
		
		// entities behind walls
		if(!Variables.targetThroughWall
			&& !Client.INSTANCE.player.canEntityBeSeen(en))
			return false;
		
		// friends
		if(!Variables.targetFriends && Variables.friends.contains(en.getName().toLowerCase()))
			return false;
		
		// players
		if(en instanceof EntityPlayer)
		{
			// normal players
			if(!Variables.targetPlayers)
			{
				if(!((EntityPlayer)en).isPlayerSleeping()
					&& !((EntityPlayer)en).isInvisible())
					return false;
				
				// sleeping players
			}else if(!Variables.targetSleepingPlayer)
			{
				if(((EntityPlayer)en).isPlayerSleeping())
					return false;
				
				// invisible players
			}else if(!Variables.targetInvisiblePlayer)
				if(((EntityPlayer)en).isInvisible())
					return false;
			
			// the user
			if(en == Client.INSTANCE.player)
				return false;
			
			// Freecam entity
			if(((EntityPlayer)en).getName()
				.equals(Client.INSTANCE.player.getName()))
				return false;
			
			// mobs
		}else if(en instanceof EntityLiving)
		{
			// invisible mobs
			if(((EntityLiving)en).isInvisible())
			{
				if(!Variables.targetInvisibleMobs)
					return false;
				
				// animals
			}else if(en instanceof EntityAgeable
				|| en instanceof EntityAmbientCreature
				|| en instanceof EntityWaterMob)
			{
				if(!Variables.targetAnimals)
					return false;
				
				// monsters
			}else if(!(en instanceof EntityPigZombie) && (en instanceof EntityMob || en instanceof EntitySlime
				|| en instanceof EntityFlying))
			{
				if(!Variables.targetMobs)
					return false;
				
				// golems
			}else if(en instanceof EntityGolem)
			{
				if(!Variables.targetGolem)
					return false;
				
				// other mobs
			}
			else if(en instanceof EntityPigZombie)
			{
				if(!Variables.targetpigMan)
					return false;
			}
			else
				return false;
			/*
			// team mobs
			if(settings.targetTeams() && ((EntityLiving)en).hasCustomName()
				&& !checkName(((EntityLiving)en).getCustomNameTag(),
					settings.getTeamColors()))
				return false;
			*/
			// other entities
		}else
			return false;
		
		return true;
	}
	
	
	
	
	public ArrayList<Entity> getValidEntities()
	{
		ArrayList<Entity> validEntities = new ArrayList<>();
		
		for(Entity entity : Client.INSTANCE.world.loadedEntityList)
		{
			if(isCorrectEntity(entity))
				validEntities.add(entity);
			
			if(validEntities.size() >= 64)
				break;
		}
		
		return validEntities;
	}
	

	
	public void onUpdate()
	{
		
		if(!this.isActive)
			return;
		
		if(Variables.useCooldown)
		{
			//if(Client.INSTANCE.player.getCooledAttackStrength(0) < 1 )
			//	return;
		}
		
		Client.INSTANCE.modManager.criticals.doCritical();
		
		ArrayList<Entity> entities = getValidEntities();
		
		if(entities.isEmpty())
			return;
		for(Entity entity : entities)
		{
			RotationUtils.faceEntityPacket(entity);
			Client.INSTANCE.mc.playerController
			.attackEntity(Client.INSTANCE.player, entity);
			Client.INSTANCE.player.swingItem();
			
			
		}
		
		
	}

}
