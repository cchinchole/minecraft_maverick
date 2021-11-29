package me.HavocDev.Client.Setting.ESP;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class renderItemSetting extends Setting {
	
	public renderItemSetting() {
		super("Items", ValueType.BOOL);
	}
	
	public void addValue()
	{
		Variables.renderItems = true;
	}

	public void lowerValue()
	{
		Variables.renderItems = false;
	}
	
	public Object getValue()
	{
		return Variables.renderItems;
	}
	
	 public void setValue(Object val)
		{
			boolean v = (boolean)val;
			Variables.renderItems = v;
		}

}
