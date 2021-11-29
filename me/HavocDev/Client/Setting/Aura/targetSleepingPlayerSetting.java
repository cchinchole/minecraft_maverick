package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class targetSleepingPlayerSetting extends Setting {
	public targetSleepingPlayerSetting() {
		super("Sleeping Players", ValueType.BOOL);
	}
	
	public void addValue()
	{
		Variables.targetSleepingPlayer = true;
	}

	public void lowerValue()
	{
		Variables.targetSleepingPlayer = false;
	}
	
	public Object getValue()
	{
		return Variables.targetSleepingPlayer;
	}
	public void setValue(Object val)
	{
		boolean v = (boolean)val;
		Variables.targetSleepingPlayer = v;
	}
}
