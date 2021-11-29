package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class targetGolemSetting extends Setting {
	public targetGolemSetting() {
		super("Golem", ValueType.BOOL);
	}
	
	public void addValue()
	{
		Variables.targetGolem = true;
	}

	public void lowerValue()
	{
		Variables.targetGolem = false;
	}
	
	public Object getValue()
	{
		return Variables.targetGolem;
	}
	
	public void setValue(Object val)
	{
		boolean v = (boolean)val;
		Variables.targetGolem = v;
	}
}
