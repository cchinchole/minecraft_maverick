package me.HavocDev.Client.Setting.ESP;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class renderPlayersSetting extends Setting {
	
	public renderPlayersSetting() {
		super("Players", ValueType.BOOL);
	}
	
	public void addValue()
	{
		Variables.renderPlayers = true;
	}

	public void lowerValue()
	{
		Variables.renderPlayers = false;
	}
	
	public Object getValue()
	{
		return Variables.renderPlayers;
	}
	
	 public void setValue(Object val)
		{
			boolean v = (boolean)val;
			Variables.renderPlayers = v;
		}

}
