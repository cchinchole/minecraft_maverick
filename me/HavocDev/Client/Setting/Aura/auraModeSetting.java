package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class auraModeSetting extends Setting {
	public auraModeSetting() {
		super("Mode", ValueType.STRING, 1,0);
	}
	
	public void addValue()
	{
		Variables.auraMode+=1;
		
		if(Variables.auraMode > (int)this.getMax())
			Variables.auraMode = (int)this.getMax();
	}

	public void lowerValue()
	{
		Variables.auraMode-=1;
		
		if(Variables.auraMode < (int)this.getLeast())
			Variables.auraMode = (int)this.getLeast();
	}
	
	public Object getValue()
	{
		switch(Variables.auraMode)
		{
		case 0:
			return "Single";
		case 1:
			return "Multi";
		default:
			return "UNREACH";
		}
		
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.auraMode= (int)this.getMax();
		else if(v < (int)this.getLeast())
			Variables.auraMode = (int)this.getLeast();
		else
			Variables.auraMode = v;
	}
	

}
