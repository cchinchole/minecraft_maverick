package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class FormBackgroundRedSetting extends Setting {
	public FormBackgroundRedSetting() {
		super("Form R", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.formBackGround.getRed();
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.formBackGround  = new Color((int)this.getMax(), Variables.defaultFA.formBackGround.getGreen(), Variables.defaultFA.formBackGround.getBlue(), 180);
		else if(v < (int)this.getLeast())	
			Variables.defaultFA.formBackGround  = new Color((int)this.getLeast(), Variables.defaultFA.formBackGround.getGreen(), Variables.defaultFA.formBackGround.getBlue(), 180);
		
		else	
			Variables.defaultFA.formBackGround  = new Color(v, Variables.defaultFA.formBackGround.getGreen(), Variables.defaultFA.formBackGround.getBlue(), 180);

		Variables.updateColors = true;
	}
}
