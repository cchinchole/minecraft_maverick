package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class FormForegroundSetting extends Setting {
	public FormForegroundSetting() {
		super("Form R", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.formForeGround.getRed();
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.formForeGround  = new Color((int)this.getMax(), Variables.defaultFA.formForeGround.getGreen(), Variables.defaultFA.formForeGround.getBlue());
		else if(v < (int)this.getLeast())	
			Variables.defaultFA.formForeGround  = new Color((int)this.getLeast(), Variables.defaultFA.formForeGround.getGreen(), Variables.defaultFA.formForeGround.getBlue());
		
		else	
			Variables.defaultFA.formForeGround  = new Color(v, Variables.defaultFA.formForeGround.getGreen(), Variables.defaultFA.formForeGround.getBlue());

		Variables.updateColors = true;
	}
}
