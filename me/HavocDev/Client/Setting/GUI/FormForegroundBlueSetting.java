package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class FormForegroundBlueSetting extends Setting {
	public FormForegroundBlueSetting() {
		super("Form B", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.formForeGround.getBlue();
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.formForeGround  = new Color(Variables.defaultFA.formForeGround.getRed(), Variables.defaultFA.formForeGround.getGreen(), (int)this.getMax());
		else if(v < (int)this.getLeast())	
			Variables.defaultFA.formForeGround  = new Color(Variables.defaultFA.formForeGround.getRed(), Variables.defaultFA.formForeGround.getGreen(), (int)this.getLeast());
		
		else	
			Variables.defaultFA.formForeGround  = new Color(Variables.defaultFA.formForeGround.getRed(), Variables.defaultFA.formForeGround.getGreen(), v);

		Variables.updateColors = true;
	}
}
