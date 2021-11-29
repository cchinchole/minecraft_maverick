package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class ComponentBackgroundBlueSetting extends Setting {
	public ComponentBackgroundBlueSetting() {
		super("Component B", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.componentBackGround.getBlue();
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.componentBackGround  = new Color(Variables.defaultFA.componentBackGround.getRed(), Variables.defaultFA.componentBackGround.getGreen(), (int)this.getMax(), 180);
		else if(v < (int)this.getLeast())	
			Variables.defaultFA.componentBackGround  = new Color(Variables.defaultFA.componentBackGround.getRed(), Variables.defaultFA.componentBackGround.getGreen(), (int)this.getLeast(), 180);
		
		else	
			Variables.defaultFA.componentBackGround  = new Color(Variables.defaultFA.componentBackGround.getRed(), Variables.defaultFA.componentBackGround.getGreen(), v, 180);

		Variables.updateColors = true;
	}
}
