package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class TextGreenSetting extends Setting {
	public TextGreenSetting() {
		super("Text G", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.text.getGreen();
	}
	
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.text  = new Color(Variables.defaultFA.text.getRed(), (int)this.getMax(), Variables.defaultFA.text.getBlue());
		else if(v < (int)this.getLeast())	

			Variables.defaultFA.text  = new Color(Variables.defaultFA.text.getRed(), (int)this.getLeast(), Variables.defaultFA.text.getBlue());
		else	
			Variables.defaultFA.text  = new Color(Variables.defaultFA.text.getRed(), v, Variables.defaultFA.text.getBlue());
		

		Variables.updateColors = true;
	}
}
