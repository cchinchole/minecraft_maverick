package me.HavocDev.Client.Setting.GUI;

import java.awt.Color;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class ComponentBackgroundGreenSetting extends Setting {
	public ComponentBackgroundGreenSetting() {
		super("Component G", ValueType.INT, 255, 0);
	}
	public Object getValue()
	{
		return Variables.defaultFA.componentBackGround.getGreen();
	}
	
	
	public void setValue(Object val)
	{
		int v = (int)val;
		if(v > (int)this.getMax())
			Variables.defaultFA.componentBackGround  = new Color(Variables.defaultFA.componentBackGround.getRed(), (int)this.getMax(), Variables.defaultFA.componentBackGround.getBlue(), 180);
		else if(v < (int)this.getLeast())	

			Variables.defaultFA.componentBackGround  = new Color(Variables.defaultFA.componentBackGround.getRed(), (int)this.getLeast(), Variables.defaultFA.componentBackGround.getBlue(), 180);
		else	
			Variables.defaultFA.componentBackGround  = new Color(Variables.defaultFA.componentBackGround.getRed(), v, Variables.defaultFA.componentBackGround.getBlue(), 180);
		

		Variables.updateColors = true;
	}
}
