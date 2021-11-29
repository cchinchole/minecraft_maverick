package me.HavocDev.Client.Setting.Drop;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class DropAllSetting extends Setting {
	
	public DropAllSetting() {
		super("Speed", ValueType.INT, 100, 0);
	}
	
	public void addValue()
	{
		Variables.dropSpeed+=5;
		
		if(Variables.dropSpeed > (int)this.getMax())
			Variables.dropSpeed = (int)this.getMax();
	}

	public void lowerValue()
	{
		Variables.dropSpeed-=5;
		
		if(Variables.dropSpeed < (int)this.getLeast())
			Variables.dropSpeed = (int)this.getLeast();
	}
	
	public Object getValue()
	{
		return Variables.dropSpeed;
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.dropSpeed = (int)this.getMax();
		else if(v < (int)this.getLeast())
			Variables.dropSpeed = (int)this.getLeast();
		else
			Variables.dropSpeed = v;
	}
	

}
