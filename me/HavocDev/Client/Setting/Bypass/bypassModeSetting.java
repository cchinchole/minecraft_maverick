package me.HavocDev.Client.Setting.Bypass;

import me.HavocDev.Client.Bypass.Bypasses;
import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class bypassModeSetting extends Setting {
	public bypassModeSetting() {
		super("Mode", ValueType.STRING, 1,0);
	}

	int val = Variables.bypassSetting.ordinal();

	public void addValue()
	{
		val++;

		if(val >  Bypasses.Bypass.values().length-1)
			val = Bypasses.Bypass.values().length-1;

		Variables.bypassSetting = Bypasses.Bypass.values()[val];
		Client.INSTANCE.modManager.changeMods(Bypasses.getBypasses(Variables.bypassSetting));
	}

	public void lowerValue()
	{
		val--;
		
		if(val < 0)
			val = 0;

		Variables.bypassSetting = Bypasses.Bypass.values()[val];
		Client.INSTANCE.modManager.changeMods(Bypasses.getBypasses(Variables.bypassSetting));
	}
	
	public Object getValue()
	{
		switch(Variables.bypassSetting)
		{
			case VANILLA:
			return "Vanilla";
			case MINEPLEX:
			return "Mineplex";
			case WATCHDOG:
			return "Watchdog";
			case NCP:
				return "NoCheatPlus";
			case NCP_OLD:
				return "NoCheatPlus(OLD)";
		}
		return "NONE";
	}
	
	
	

}
