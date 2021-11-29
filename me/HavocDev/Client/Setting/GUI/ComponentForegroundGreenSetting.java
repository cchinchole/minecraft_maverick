package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class ComponentForegroundGreenSetting extends Setting {
	public ComponentForegroundGreenSetting() {
		super("Component G", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.componentForeGround.getGreen();
	}
	
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.componentForeGround  = new Color(Variables.defaultFA.componentForeGround.getRed(), (int)this.getMax(), Variables.defaultFA.componentForeGround.getBlue());
		else if(v < (int)this.getLeast())	

			Variables.defaultFA.componentForeGround  = new Color(Variables.defaultFA.componentForeGround.getRed(), (int)this.getLeast(), Variables.defaultFA.componentForeGround.getBlue());
		else	
			Variables.defaultFA.componentForeGround  = new Color(Variables.defaultFA.componentForeGround.getRed(), v, Variables.defaultFA.componentForeGround.getBlue());
		

		Variables.updateColors = true;
	}
}
