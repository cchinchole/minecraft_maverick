package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class targetThroughWallSetting extends Setting {
	public targetThroughWallSetting() {
		super("Through Walls", ValueType.BOOL);
	}
	
	public void addValue()
	{
		Variables.targetThroughWall = true;
	}

	public void lowerValue()
	{
		Variables.targetThroughWall = false;
	}
	
	public Object getValue()
	{
		return Variables.targetThroughWall;
	}
	public void setValue(Object val)
	{
		boolean v = (boolean)val;
		Variables.targetThroughWall = v;
	}
}
