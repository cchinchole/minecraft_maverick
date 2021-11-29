package me.HavocDev.Client.Setting.FastBreak;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class FastMineSetting extends Setting {

	public FastMineSetting() {
		super("Speed", ValueType.FLOAT, 10f, 0f);
	}
	
	public void addValue()
	{
		Variables.fastSpeed+=2.5f;
		
		if(Variables.fastSpeed > (float)this.getMax())
			Variables.fastSpeed = (float)this.getMax();
	}

	public void lowerValue()
	{
		Variables.fastSpeed-=2.5f;
		
		if(Variables.fastSpeed < (float)this.getLeast())
			Variables.fastSpeed = (float)this.getLeast();
	}
	
	public Object getValue()
	{
		return Variables.fastSpeed;
	}
	
	public void setValue(Object val)
	{
		float v = (float)val;
		if(v > (float)this.getMax())
			Variables.fastSpeed= (float)this.getMax();
		else if(v < (float)this.getLeast())
			Variables.fastSpeed= (float)this.getLeast();
		else
			Variables.fastSpeed = v;
	}
}
