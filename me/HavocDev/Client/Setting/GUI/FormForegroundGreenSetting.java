package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class FormForegroundGreenSetting extends Setting {
	public FormForegroundGreenSetting() {
		super("Form G", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.formForeGround.getGreen();
	}
	
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.formForeGround  = new Color(Variables.defaultFA.formForeGround.getRed(), (int)this.getMax(), Variables.defaultFA.formForeGround.getBlue());
		else if(v < (int)this.getLeast())	

			Variables.defaultFA.formForeGround  = new Color(Variables.defaultFA.formForeGround.getRed(), (int)this.getLeast(), Variables.defaultFA.formForeGround.getBlue());
		else	
			Variables.defaultFA.formForeGround  = new Color(Variables.defaultFA.formForeGround.getRed(), v, Variables.defaultFA.formForeGround.getBlue());
		

		Variables.updateColors = true;
	}
}
