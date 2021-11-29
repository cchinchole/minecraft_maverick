package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class auraSpeedSetting extends Setting {
	public auraSpeedSetting() {
		super("Speed", ValueType.INT, 20, 1);
	}
	
	public void addValue()
	{
		Variables.auraSpeed+=1;
		
		if(Variables.auraSpeed > (int)this.getMax())
			Variables.auraSpeed = (int)this.getMax();
	}

	public void lowerValue()
	{
		Variables.auraSpeed-=1;
		
		if(Variables.auraSpeed < (int)this.getLeast())
			Variables.auraSpeed = (int)this.getLeast();
	}
	
	public Object getValue()
	{
		return Variables.auraSpeed;
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.auraSpeed= (int)this.getMax();
		else if(v < (int)this.getLeast())
			Variables.auraSpeed= (int)this.getLeast();
		else
			Variables.auraSpeed = v;
	}
}
