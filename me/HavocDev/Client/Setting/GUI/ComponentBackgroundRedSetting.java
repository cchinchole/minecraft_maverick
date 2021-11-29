package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class ComponentBackgroundRedSetting extends Setting {
	public ComponentBackgroundRedSetting() {
		super("Component R", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.componentBackGround.getRed();
	}
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.componentBackGround  = new Color((int)this.getMax(), Variables.defaultFA.componentBackGround.getGreen(), Variables.defaultFA.componentBackGround.getBlue(), 180);
		else if(v < (int)this.getLeast())	
			Variables.defaultFA.componentBackGround  = new Color((int)this.getLeast(), Variables.defaultFA.componentBackGround.getGreen(), Variables.defaultFA.componentBackGround.getBlue(), 180);
		
		else	
			Variables.defaultFA.componentBackGround  = new Color(v, Variables.defaultFA.componentBackGround.getGreen(), Variables.defaultFA.componentBackGround.getBlue(), 180);

		Variables.updateColors = true;
	}
}
