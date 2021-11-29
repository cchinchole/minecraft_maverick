package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class TextBlueSetting extends Setting {
	public TextBlueSetting() {
		super("Text B", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.text.getBlue();
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.text  = new Color(Variables.defaultFA.text.getRed(), Variables.defaultFA.text.getGreen(), (int)this.getMax());
		else if(v < (int)this.getLeast())	
			Variables.defaultFA.text  = new Color(Variables.defaultFA.text.getRed(), Variables.defaultFA.text.getGreen(), (int)this.getLeast());
		
		else	
			Variables.defaultFA.text  = new Color(Variables.defaultFA.text.getRed(), Variables.defaultFA.text.getGreen(), v);

		Variables.updateColors = true;
	}
}
