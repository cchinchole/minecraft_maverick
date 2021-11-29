package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class targetAnimalsSetting extends Setting {
	public targetAnimalsSetting() {
		super("Animals", ValueType.BOOL);
	}
	
	public void addValue()
	{
		Variables.targetAnimals = true;
	}

	public void lowerValue()
	{
		Variables.targetAnimals = false;
	}
	
	public Object getValue()
	{
		return Variables.targetAnimals;
	}
	
	public void setValue(Object val)
	{
		boolean v = (boolean)val;
		Variables.targetAnimals = v;
	}
}
