package me.HavocDev.Client.Mods.Render;

import java.util.ArrayList;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Utilities.RenderUtils;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;

public class ESPMod extends Mod{

	public ESPMod() {
		super("esp", "ESP", "Draws a box around entities in the world", Category.Render, -999999);
	}
	private int itemBox;
	private final ArrayList<EntityItem> items = new ArrayList<>();
	private final ArrayList<EntityPlayer> players = new ArrayList<>();
	private final ArrayList<EntityLiving> mobs = new ArrayList<>();
	
	public void onUpdate()
	{
		if(!this.isActive)
			return;
		
		items.clear();
		players.clear();
		mobs.clear();
		for(Entity e : Client.INSTANCE.world.loadedEntityList)
		{
			if(e instanceof EntityItem)
			{
				EntityItem ea = (EntityItem)e;
				items.add(ea);
			}
		}
		
		for(Entity e : Client.INSTANCE.world.loadedEntityList)
		{
			if ( e instanceof EntityPlayer)
			{
				
				EntityPlayer ea = (EntityPlayer)e;
				if(ea != Client.INSTANCE.player)
					players.add(ea);
			}
		}
		
		for(Entity e : Client.INSTANCE.world.loadedEntityList)
		{
			if ( e instanceof EntityLiving)
			{
				EntityLiving ea = (EntityLiving)e;
				mobs.add(ea);
			}
		}
		
		
	}
	
	public void onRender(float partialTicks)
	{ 
		if(this.getActive())
		{
				if(Variables.renderItems)
				for(EntityItem e : items)
					RenderUtils.drawItemESP(itemBox, e, partialTicks);
				
				if(Variables.renderPlayers)
				for(EntityPlayer p : players)
				if(Variables.friends.contains(p.getName()))
					RenderUtils.entityESPBox(p, RenderUtils.friend);
				else if(Client.INSTANCE.modManager.killaura.currentTarget != null && Client.INSTANCE.modManager.killaura.currentTarget.getName() == p.getName())
					RenderUtils.entityESPBox(p, RenderUtils.target);
				else
					RenderUtils.entityESPBox(p, RenderUtils.other);
				
				if(Variables.renderMobs)
				for(EntityLiving e : mobs)
					RenderUtils.drawMobESP(e, partialTicks);
				
			}
	}
}
