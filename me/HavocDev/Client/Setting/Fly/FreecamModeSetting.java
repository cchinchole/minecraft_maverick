package me.HavocDev.Client.Setting.Fly;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class FreecamModeSetting extends Setting {

    public FreecamModeSetting()
    {
        super("Teleport", ValueType.BOOL);
    }

    public void addValue()
    {
        Client.INSTANCE.modManager.freecam.tele = true;
    }

    public void lowerValue(){
    Client.INSTANCE.modManager.freecam.tele = false;
    }

    public Object getValue()
    {
        return  Client.INSTANCE.modManager.freecam.tele;
    }

    public void setValue(Object val)
	{
		boolean v = (boolean)val;
		Client.INSTANCE.modManager.freecam.tele= v;
	}
    
}
