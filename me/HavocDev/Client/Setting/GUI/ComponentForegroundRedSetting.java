package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class ComponentForegroundRedSetting extends Setting {
	public ComponentForegroundRedSetting() {
		super("Component R", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.componentForeGround.getRed();
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.componentForeGround  = new Color((int)this.getMax(), Variables.defaultFA.componentForeGround.getGreen(), Variables.defaultFA.componentForeGround.getBlue());
		else if(v < (int)this.getLeast())	
			Variables.defaultFA.componentForeGround  = new Color((int)this.getLeast(), Variables.defaultFA.componentForeGround.getGreen(), Variables.defaultFA.componentForeGround.getBlue());
		
		else	
			Variables.defaultFA.componentForeGround  = new Color(v, Variables.defaultFA.componentForeGround.getGreen(), Variables.defaultFA.componentForeGround.getBlue());

		Variables.updateColors = true;
	}
}
