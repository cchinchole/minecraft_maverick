package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class targetPlayersSetting extends Setting {
	public targetPlayersSetting() {
		super("Players", ValueType.BOOL);
	}
	
	public void addValue()
	{
		Variables.targetPlayers = true;
	}

	public void lowerValue()
	{
		Variables.targetPlayers = false;
	}
	
	public Object getValue()
	{
		return Variables.targetPlayers;
	}
	
	public void setValue(Object val)
	{
		boolean v = (boolean)val;
		Variables.targetPlayers = v;
	}
}
