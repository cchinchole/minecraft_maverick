package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class auraUseCooldownSetting extends Setting {
	public auraUseCooldownSetting() {
		super("Swing Cooldown", ValueType.BOOL);
	}
	
	public void addValue()
	{
		Variables.useCooldown = true;
	}

	public void lowerValue()
	{
		Variables.useCooldown = false;
	}
	
	public Object getValue()
	{
		return Variables.useCooldown;
	}
	
	public void setValue(Object val)
	{
		boolean v = (boolean)val;
		Variables.useCooldown = v;
	}
}
