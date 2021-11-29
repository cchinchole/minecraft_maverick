package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class targetInvisiblePlayerSetting extends Setting {
	public targetInvisiblePlayerSetting() {
		super("Invisible", ValueType.BOOL);
	}
	
	public void addValue()
	{
		Variables.targetInvisiblePlayer = true;
	}

	public void lowerValue()
	{
		Variables.targetInvisiblePlayer = false;
	}
	
	public Object getValue()
	{
		return Variables.targetInvisiblePlayer;
	}
	public void setValue(Object val)
	{
		boolean v = (boolean)val;
		Variables.targetInvisiblePlayer = v;
	}
}
