package me.HavocDev.Client.Setting.Aimbot;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;

public class aimbotDistanceSetting extends Setting {
	public aimbotDistanceSetting() {
		super("Distance", ValueType.INT, 8, 3);
	}
	
	public void addValue()
	{
		Client.INSTANCE.modManager.aimbot.maxDistance+=1;
		
		if(Client.INSTANCE.modManager.aimbot.maxDistance > (int)this.getMax())
			Client.INSTANCE.modManager.aimbot.maxDistance = (int)this.getMax();
	}

	public void lowerValue()
	{
		Client.INSTANCE.modManager.aimbot.maxDistance-=1;
		
		if(Client.INSTANCE.modManager.aimbot.maxDistance < (int)this.getLeast())
			Client.INSTANCE.modManager.aimbot.maxDistance = (int)this.getLeast();
	}
	
	public Object getValue()
	{
		return Client.INSTANCE.modManager.aimbot.maxDistance;
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Client.INSTANCE.modManager.aimbot.maxDistance = (int)this.getMax();
		else if(v < (int)this.getLeast())
			Client.INSTANCE.modManager.aimbot.maxDistance = (int)this.getLeast();
		else
			Client.INSTANCE.modManager.aimbot.maxDistance = v;
	}
	

}
