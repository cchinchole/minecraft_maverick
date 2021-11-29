package me.HavocDev.Client.Mods;

import java.util.ArrayList;

import me.HavocDev.Client.Events.EntityLivingEvent;
import me.HavocDev.Client.Events.Event;
import me.HavocDev.Client.Events.LateUpdateEvent;
import me.HavocDev.Client.Events.LeftClickEvent;
import me.HavocDev.Client.Events.PacketOutputEvent;
import me.HavocDev.Client.Events.PostMotionEvent;
import me.HavocDev.Client.Events.PreMotionEvent;
import me.HavocDev.Client.Events.RenderEvent;
import me.HavocDev.Client.Events.UpdateEvent;
import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Utilities.ChatUtils;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.network.Packet;

public class Mod {

	protected Category cat;
	public String realName = "";
	protected String displayName = "";
	protected String desc = "";
	protected int keyBind = 0;
	protected boolean isActive = false;
	protected Event event;
	protected int ID;
	public int color = -1;
	public ArrayList<Setting> settings = new ArrayList<Setting>();
	public long time;
	
	public Mod(String realname, String displayname, String description, Category category, int KeyBind)
	{
		this.cat = category;
		this.desc = description;
		this.displayName = displayname;
		this.realName = realname;
		this.keyBind = KeyBind;
		this.time = (System.nanoTime() / 1000000l);
	}
	public boolean hasTimeElapsed(long time, boolean reset) {
		if (getTime() >= time) {
			if (reset) {
				reset();
			}
				return true;
			}
			return false;
		}

		public long getTime() {
			return System.nanoTime() / 1000000l - this.time;
		}

		public void reset() {
			this.time = (System.nanoTime() / 1000000l);
		}
	
	public void addSeting(Setting s)
	{
		settings.add(s);
	}

	public void setKeybind(int id)
	{
		this.keyBind = id;
	}
	
	public Category getCategory()
	{
		return cat;
	}
	
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	public String getDescription()
	{
		return this.desc;
	}
	
	public String getName()
	{
		return realName;
	}
	
	public String getDisplayName()
	{
		return displayName;
	}
	
	public void setName(String s)
	{
		this.displayName = s;
	}
	
	public boolean getActive()
	{
		return isActive;
	}
	
	public int getKeyBind()
	{
		return this.keyBind;
	}
	
	public void onEnable(){}
	public void onDisable(){}
	public void onEvent(Event event){
		this.event = event;
		
		if(!this.isActive)
			return;
		
		if(event instanceof EntityLivingEvent)
		{
			this.onLivingUpdate();
		}
		if(event instanceof UpdateEvent)
		{
			this.onUpdate();
		}
		if(event instanceof PreMotionEvent)
		{
			this.onPreMotion();
		}
		if(event instanceof PostMotionEvent)
		{
			this.onPostMotion();
		}
		if(event instanceof RenderEvent)
		{
			this.onRender( ((RenderEvent)event).partialTicks );
		}
		
		if(event instanceof PacketOutputEvent)
		{
			this.onPacket( ((PacketOutputEvent)event).calledPacket );
		}
		if(event instanceof LeftClickEvent)
		{
			this.onLeftClick();
		}
		if(event instanceof LateUpdateEvent)
			this.onLateUpdate();

		
		
	}
	public void onLivingUpdate(){}
	public void onLateUpdate(){}
	public void onUpdate(){}
	public void onPreMotion(){}
	public void onPostMotion(){}
	public void onLeftClick(){}
	public void onPacket(Packet packIn){}
	public void onRender(float partialTicks){}
	public void onToggle(){ 
		this.isActive = !this.isActive;
		ChatUtils.addChatMessage(this.getDisplayName()+": "+this.getActive());
		if(this.isActive)
			this.onEnable();
		else
			this.onDisable();
	}
	
}
