package me.HavocDev.Client.Setting.Speed;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class SpeedSetting extends Setting {

	public SpeedSetting() {
		super("Speed", ValueType.FLOAT, 100f, 10f);
	}
	
	public void addValue()
	{
		Variables.playerSpeed+=2f;
		
		if(Variables.playerSpeed > (float)this.getMax())
			Variables.playerSpeed = (float)this.getMax();
	}

	public void lowerValue()
	{
		Variables.playerSpeed-=2f;
		
		if(Variables.playerSpeed < (float)this.getLeast())
			Variables.playerSpeed = (float)this.getLeast();
	}
	
	public Object getValue()
	{
		return (float)Variables.playerSpeed;
	}
	
	 public void setValue(Object val)
		{
			float v = (float)val;
			if(v > (float)this.getMax())
				Variables.playerSpeed= (float)this.getMax();
			else if(v < (float)this.getLeast())
				Variables.playerSpeed= (float)this.getLeast();
			else
				Variables.playerSpeed = v;
		}


}
