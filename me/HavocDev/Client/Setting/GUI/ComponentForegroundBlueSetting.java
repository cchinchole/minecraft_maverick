package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class ComponentForegroundBlueSetting extends Setting {
	public ComponentForegroundBlueSetting() {
		super("Component B", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.componentForeGround.getBlue();
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.componentForeGround  = new Color(Variables.defaultFA.componentForeGround.getRed(), Variables.defaultFA.componentForeGround.getGreen(), (int)this.getMax());
		else if(v < (int)this.getLeast())	
			Variables.defaultFA.componentForeGround  = new Color(Variables.defaultFA.componentForeGround.getRed(), Variables.defaultFA.componentForeGround.getGreen(), (int)this.getLeast());
		
		else	
			Variables.defaultFA.componentForeGround  = new Color(Variables.defaultFA.componentForeGround.getRed(), Variables.defaultFA.componentForeGround.getGreen(), v);

		Variables.updateColors = true;
	}
}
