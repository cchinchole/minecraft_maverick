package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class auraRangeSetting extends Setting {
	public auraRangeSetting() {
		super("Range", ValueType.FLOAT, 7f, 3.5f);
	}

	public void addValue() {
		Variables.auraRange += .5f;

		if (Variables.auraRange > (float) this.getMax())
			Variables.auraRange = (float) this.getMax();
	}

	public void lowerValue() {
		Variables.auraRange -= .5f;

		if (Variables.auraRange < (float) this.getLeast())
			Variables.auraRange = (float) this.getLeast();
	}

	public Object getValue() {
		return Variables.auraRange;
	}
	
	public void setValue(Object val)
	{
		float v = (float)val;
		if(v > (float)this.getMax())
			Variables.auraRange= (float)this.getMax();
		else if(v < (float)this.getLeast())
			Variables.auraRange= (float)this.getLeast();
		else
			Variables.auraRange = v;
	}
}
