package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class criticalModeSetting extends Setting {
	public criticalModeSetting() {
		super("Mode", ValueType.STRING, 1,0);
	}
	
	public void addValue()
	{
		Variables.criticalsMode+=1;
		
		if(Variables.criticalsMode > (int)this.getMax())
			Variables.criticalsMode = (int)this.getMax();
	}

	public void lowerValue()
	{
		Variables.criticalsMode-=1;
		
		if(Variables.criticalsMode < (int)this.getLeast())
			Variables.criticalsMode = (int)this.getLeast();
	}
	
	public Object getValue()
	{
		switch(Variables.criticalsMode)
		{
		case 0:
			return "Jump";
		case 1:
			return "Packet";
		default:
			return "UNREACH";
		}
		
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.criticalsMode= (int)this.getMax();
		else if(v < (int)this.getLeast())
			Variables.criticalsMode= (int)this.getLeast();
		else
			Variables.criticalsMode = v;
	}
	

}
