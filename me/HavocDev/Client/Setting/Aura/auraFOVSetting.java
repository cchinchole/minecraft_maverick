package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class auraFOVSetting extends Setting {
	public auraFOVSetting() {
		super("FOV", ValueType.INT, 360, 90);
	}
	
	public void addValue()
	{
		Variables.auraFOV+=5;
		
		if(Variables.auraFOV > (int)this.getMax())
			Variables.auraFOV = (int)this.getMax();
	}

	public void lowerValue()
	{
		Variables.auraFOV-=5;
		
		if(Variables.auraFOV < (int)this.getLeast())
			Variables.auraFOV = (int)this.getLeast();
	}
	
	public Object getValue()
	{
		return Variables.auraFOV;
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.auraFOV = (int)this.getMax();
		else if(v < (int)this.getLeast())
			Variables.auraFOV = (int)this.getLeast();
		else
			Variables.auraFOV= v;
	}
}
