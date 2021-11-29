package me.HavocDev.Client.Setting.Aura;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class targetFriendsSetting extends Setting {
	public targetFriendsSetting() {
		super("Friends", ValueType.BOOL);
	}
	
	public void addValue()
	{
		Variables.targetFriends = true;
	}

	public void lowerValue()
	{
		Variables.targetFriends = false;
	}
	
	public Object getValue()
	{
		return Variables.targetFriends;
	}
	
	public void setValue(Object val)
	{
		boolean v = (boolean)val;
		Variables.targetFriends = v;
	}
}
