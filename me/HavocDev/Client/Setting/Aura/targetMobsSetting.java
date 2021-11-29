package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class targetMobsSetting extends Setting {
	public targetMobsSetting() {
		super("Mobs", ValueType.BOOL);
	}
	
	public void addValue()
	{
		Variables.targetMobs = true;
	}

	public void lowerValue()
	{
		Variables.targetMobs = false;
	}
	
	public Object getValue()
	{
		return Variables.targetMobs;
	}
	public void setValue(Object val)
	{
		boolean v = (boolean)val;
		Variables.targetMobs = v;
	}
}
