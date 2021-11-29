package me.HavocDev.Client.Setting.ESP;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class renderMobsSetting extends Setting {
	
	public renderMobsSetting() {
		super("Mobs", ValueType.BOOL);
	}
	
	public void addValue()
	{
		Variables.renderMobs = true;
	}

	public void lowerValue()
	{
		Variables.renderMobs = false;
	}
	
	public Object getValue()
	{
		return Variables.renderMobs;
	}
	 public void setValue(Object val)
		{
			boolean v = (boolean)val;
			Variables.renderMobs = v;
		}
}
