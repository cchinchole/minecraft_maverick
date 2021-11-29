package me.HavocDev.Client.Setting.Fly;

import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Variables.Variables;

public class FlightSpeedSetting extends Setting {

    public FlightSpeedSetting()
    {
        super("Speed", ValueType.FLOAT, 10f, 0.5f);
    }


    public void addValue()
    {
        Variables.flight+=0.05f;

        if(Variables.flight > (float)this.getMax())
            Variables.flight = (float)this.getMax();
    }

    public void lowerValue()
    {
        Variables.flight-=0.05f;

        if(Variables.flight < (float)this.getLeast())
            Variables.flight = (float)this.getLeast();
    }

    public Object getValue()
    {
        return Variables.flight;
    }
    
    public void setValue(Object val)
	{
		float v = (float)val;
		if(v > (float)this.getMax())
			Variables.flight= (float)this.getMax();
		else if(v < (float)this.getLeast())
			Variables.flight= (float)this.getLeast();
		else
			Variables.flight = v;
	}

}
