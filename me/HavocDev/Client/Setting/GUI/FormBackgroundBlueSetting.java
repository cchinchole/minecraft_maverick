package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class FormBackgroundBlueSetting extends Setting {
	public FormBackgroundBlueSetting() {
		super("Form B", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.formBackGround.getBlue();
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.formBackGround  = new Color(Variables.defaultFA.formBackGround.getRed(), Variables.defaultFA.formBackGround.getGreen(), (int)this.getMax(), 180);
		else if(v < (int)this.getLeast())	
			Variables.defaultFA.formBackGround  = new Color(Variables.defaultFA.formBackGround.getRed(), Variables.defaultFA.formBackGround.getGreen(), (int)this.getLeast(), 180);
		
		else	
			Variables.defaultFA.formBackGround  = new Color(Variables.defaultFA.formBackGround.getRed(), Variables.defaultFA.formBackGround.getGreen(), v, 180);

		Variables.updateColors = true;
	}
}
