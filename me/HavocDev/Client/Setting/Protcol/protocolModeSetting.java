package me.HavocDev.Client.Setting.Protcol;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;

public class protocolModeSetting extends Setting {
	public protocolModeSetting() {
		super("Mode", ValueType.STRING, 2,0);
	}
	
	public void addValue()
	{
		Client.INSTANCE.compatibility+=1;
		
		if(Client.INSTANCE.compatibility > (int)this.getMax())
			Client.INSTANCE.compatibility = (int)this.getMax();
	}

	public void lowerValue()
	{
		Client.INSTANCE.compatibility-=1;
		
		if(Client.INSTANCE.compatibility < (int)this.getLeast())
			Client.INSTANCE.compatibility = (int)this.getLeast();
	}
	
	public Object getValue()
	{
		switch(Client.INSTANCE.compatibility)
		{
		case 0:
			return "1.12";
		case 1:
			return "1.12.1";
			case 2 :
				return "1.12.2";
			default:
				return "UNKNOWN";
		}
		
	}
	

}
