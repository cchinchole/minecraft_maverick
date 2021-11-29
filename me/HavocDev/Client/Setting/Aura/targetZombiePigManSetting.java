package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class targetZombiePigManSetting  extends Setting {
	public targetZombiePigManSetting() {
		super("Pigmen", ValueType.BOOL);
	}
	
	public void addValue()
	{
		Variables.targetpigMan = true;
	}

	public void lowerValue()
	{
		Variables.targetpigMan = false;
	}
	
	public Object getValue()
	{
		return Variables.targetpigMan;
	}
	public void setValue(Object val)
	{
		boolean v = (boolean)val;
		Variables.targetpigMan = v;
	}
}
