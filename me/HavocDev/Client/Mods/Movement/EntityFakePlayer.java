package me.HavocDev.Client.Mods.Movement;

import me.HavocDev.Client.Client.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.player.EntityPlayer;

public class EntityFakePlayer extends EntityOtherPlayerMP{
	

//private static Minecraft mc = Minecraft.getMinecraft();
	
	private Client mc = Client.INSTANCE;

	private int id;

	public EntityFakePlayer()
	{
		super(Client.INSTANCE.world, Client.INSTANCE.player.getGameProfile());
		copyLocationAndAnglesFrom(mc.player);
		
		// fix inventory
		inventory.copyInventory(mc.player.inventory);
		//copyPlayerModel(mc.player, this);
		this.clonePlayer(mc.player, true);
		
		// fix rotation
		rotationYawHead = mc.player.rotationYawHead;
		renderYawOffset = mc.player.renderYawOffset;
		
		// fix cape movement
		chasingPosX = posX;
		chasingPosY = posY;
		chasingPosZ = posZ;

		id = getEntityId();
		// spawn
		mc.world.addEntityToWorld(id, this);
	}

	public void reset()
	{
		copyLocationAndAnglesFrom(mc.player);

		// fix inventory
		inventory.copyInventory(mc.player.inventory);
		this.clonePlayer(mc.player, true);

		// fix rotation
		rotationYawHead = mc.player.rotationYawHead;
		renderYawOffset = mc.player.renderYawOffset;

		// fix cape movement
		chasingPosX = posX;
		chasingPosY = posY;
		chasingPosZ = posZ;

	}
	
	public void resetPlayerPosition()
	{
		mc.player.setPositionAndRotation(posX, posY, posZ, rotationYaw,
			rotationPitch);
	}
	public void despawn()
	{
		mc.world.removeEntityFromWorld(id);
	}

}
