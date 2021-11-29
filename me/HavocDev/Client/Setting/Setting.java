package me.HavocDev.Client.Setting;

public class Setting {

	
	private String name;
	private ValueType valueType;
	private Object maxValue;
	private Object leastValue;
	
	public Setting(String name, ValueType valueType)
	{
		this.valueType = valueType;
		this.name = name;
	}
	
	public Setting(String name, ValueType valueType, Object maxValue, Object leastValue)
	{
		this.valueType = valueType;
		this.name = name;
		this.maxValue = maxValue;
		this.leastValue = leastValue;
	}
	
	public Object getMax()
	{
		return maxValue;
	}
	
	public Object getLeast()
	{
		return leastValue;
	}
	
	public ValueType getValueType()
	{
		return valueType;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Object getValue()
	{
		return -1;
	}
	
	public void addValue()
	{
		
	}
	
	public void lowerValue()
	{
		
	}
	
	public void setValue(Object val){}

}
