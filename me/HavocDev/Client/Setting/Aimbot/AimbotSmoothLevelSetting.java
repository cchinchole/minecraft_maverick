package me.HavocDev.Client.Setting.Aimbot;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;

public class AimbotSmoothLevelSetting extends Setting {
	public AimbotSmoothLevelSetting() {
		super("Smooth", ValueType.INT, 10, 1);
	}
	
	public void addValue()
	{
		Client.INSTANCE.modManager.aimbot.smoothLevel+=1;
		
		if(Client.INSTANCE.modManager.aimbot.smoothLevel > (int)this.getMax())
			Client.INSTANCE.modManager.aimbot.smoothLevel = (int)this.getMax();
	}

	public void lowerValue()
	{
		Client.INSTANCE.modManager.aimbot.smoothLevel-=1;
		
		if(Client.INSTANCE.modManager.aimbot.smoothLevel < (int)this.getLeast())
			Client.INSTANCE.modManager.aimbot.smoothLevel = (int)this.getLeast();
	}
	
	public Object getValue()
	{
		return Client.INSTANCE.modManager.aimbot.smoothLevel;
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Client.INSTANCE.modManager.aimbot.smoothLevel = (int)this.getMax();
		else if(v < (int)this.getLeast())
			Client.INSTANCE.modManager.aimbot.smoothLevel = (int)this.getLeast();
		else
			Client.INSTANCE.modManager.aimbot.smoothLevel = v;
	}
	
}
