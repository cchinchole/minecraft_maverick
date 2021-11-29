package me.HavocDev.Client.Setting.Aimbot;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class AimbotCursorDistanceSetting extends Setting {
	
	public AimbotCursorDistanceSetting() {
		super("Cursor Distance", ValueType.INT, 24, 6);
	}
	
	public void addValue()
	{
		Client.INSTANCE.modManager.aimbot.maxCursor+=2;
		
		if(Client.INSTANCE.modManager.aimbot.maxCursor > (int)this.getMax())
			Client.INSTANCE.modManager.aimbot.maxCursor = (int)this.getMax();
	}

	public void lowerValue()
	{
		Client.INSTANCE.modManager.aimbot.maxCursor-=2;
		
		if(Client.INSTANCE.modManager.aimbot.maxCursor < (int)this.getLeast())
			Client.INSTANCE.modManager.aimbot.maxCursor = (int)this.getLeast();
	}
	
	public Object getValue()
	{
		return Client.INSTANCE.modManager.aimbot.maxCursor;
	}

	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Client.INSTANCE.modManager.aimbot.maxCursor = (int)this.getMax();
		else if(v < (int)this.getLeast())
			Client.INSTANCE.modManager.aimbot.maxCursor = (int)this.getLeast();
		else
			Client.INSTANCE.modManager.aimbot.maxCursor = v;
	}
	
}
