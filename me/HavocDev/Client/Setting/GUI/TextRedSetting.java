package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class TextRedSetting extends Setting {
	public TextRedSetting() {
		super("Text R", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.text.getRed();
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.text  = new Color((int)this.getMax(), Variables.defaultFA.text.getGreen(), Variables.defaultFA.text.getBlue());
		else if(v < (int)this.getLeast())	
			Variables.defaultFA.text  = new Color((int)this.getLeast(), Variables.defaultFA.text.getGreen(), Variables.defaultFA.text.getBlue());
		
		else	
			Variables.defaultFA.text  = new Color(v, Variables.defaultFA.text.getGreen(), Variables.defaultFA.text.getBlue());

		Variables.updateColors = true;
	}
}
