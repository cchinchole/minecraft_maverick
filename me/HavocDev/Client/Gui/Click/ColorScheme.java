package me.HavocDev.Client.Gui.Click;

import java.awt.Color;

public class ColorScheme {
	
	public Color formForeGround;
	public Color formBackGround;
	
	public Color componentForeGround;
	public Color componentBackGround;
	
	public Color text;
	
	public ColorScheme(Color f, Color b, Color cf, Color cb, Color t)
	{
		this.formForeGround = f;
		this.formBackGround = b;
		this.componentBackGround = cb;
		this.componentForeGround = cf;
		this.text = t;
	}
	

}
