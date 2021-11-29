package me.HavocDev.Client.Gui.Click.Component;

import java.awt.Color;
import java.math.BigDecimal;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Gui.Click.ColorScheme;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Utilities.GLUtils;
import me.HavocDev.Client.Variables.Colors;
import net.wurstclient.font.Fonts;

public class Slider extends Component{

	public Setting setting;
	
	
	public Slider(int x, int y, Setting s)
	{
		this(x, y, 50, 10, new Color(255, 0 ,0), new Color(255, 255, 255), new Color(255, 255, 255), s);
	}
	
	public Slider(int x, int y, Color b, Color f, Color c, Setting s)
	{
		this(x, y, 50, 10, f, b, c, s);
	}
	
	public Slider(int x, int y, int width, int height, Color foreground, Color background, Color c, Setting s)
	{
		this.x = x;
		this.y = y;
		this.xOriginal = x;
		this.yOriginal = y;
		this.width = width;
		this.height = height;
		this.backGround = background;
		this.foreGround = foreground;
		this.textC = c;
		this.setting = s;
		this.draggable = true;
	}
	
	
	int map(int x, int in_min, int in_max, int out_min, int out_max) {
		return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
	}
	
	float map(float x, float in_min, float in_max, float out_min, float out_max) {
		return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
	}
	
	public float round(float d, int decimalPlace) {
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}
	
	public Object getValue(Setting a) {

		Object out = null;

		switch (a.getValueType()) {
			case INT:
				out = a.getValue();
				break;
			case BOOL:
				out = a.getValue();
				break;
			case FLOAT:
				out = round((float) a.getValue(), 2);
				break;
			case STRING:
				out = a.getValue();
				break;
			default:
				out = a.getValue();
				break;
		}

		return out;
	}

	
	@Override
	public void draw() {
		
		GLUtils.drawLine(this.x, this.y, this.x+width, this.y, 2f, this.foreGround.getRGB());
		
		
		int newX = 0;
		
		switch(setting.getValueType())
		{
		case INT:
			int a = (int)getValue(setting);
			int max = (int) setting.getMax();
			int least = (int) setting.getLeast();
			newX = map(a, least, max, this.x, this.x+this.width);
			break;
		case FLOAT:
			float b = (float)getValue(setting);
			float max1 = (float) setting.getMax();
			float least1 = (float) setting.getLeast();
			newX = map((int)b, (int)least1,  (int)max1, this.x, this.x+this.width);
			break;
		default:
			break;

		}
		
		
		GLUtils.drawRect(newX, this.y-5, newX, this.y+5, this.foreGround.getRGB(), this.foreGround.getRGB());
		Fonts.calibri14.drawString(setting.getName(), this.x, this.y-10, this.textC.getRGB());
		
	}

	@Override
	public void drag(int x, int y) {
		if ( !this.draggable || !this.dragging ) {
			return;
		}
		
		
		
		switch(setting.getValueType())
		{
		case INT:
			int a = (int)getValue(setting);
			int max = (int) setting.getMax();
			int least = (int) setting.getLeast();
			this.setting.setValue( map(x, this.x, this.x+width,(int)setting.getLeast() , (int)setting.getMax()) );
			break;
		case FLOAT:
			float max1 = (float) setting.getMax();
			float least1 = (float) setting.getLeast();
			this.setting.setValue( map((float)x, (float)this.x, (float)this.x+width, Math.round((float)setting.getLeast()), Math.round((float)setting.getMax()) ));
			break;
		case BOOL:
		//	if()
		break;
		default:
			//color = Colors.WHITE;
			break;

		}
		
		
		
		//this.x = x;
		//this.y = y;
		
	}

	@Override
	public boolean mouseOver(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onMouseRelease(int x, int y) {
		this.dragging = false;
		
	}

	@Override
	public void onClick(int x, int y, int k) {
		
		if(k != 0)
			return;
		
		if ( this.clickedInside( x, y ) ) {
			this.dragging = true;
	}	
	}
	
	public boolean clickedInside( int x, int y ) {
		
	int newX = 0;
		
		switch(setting.getValueType())
		{
		case INT:
			int a = (int)getValue(setting);
			int max = (int) setting.getMax();
			int least = (int) setting.getLeast();
			newX = map(a, least, max, this.x, this.x+this.width);
			break;
		case FLOAT:
			float b = (float)getValue(setting);
			float max1 = (float) setting.getMax();
			float least1 = (float) setting.getLeast();
			newX = map((int)b, (int)least1, (int)max1, this.x, this.x+this.width);
			break;
		default:
			break;

		}
		
		if ( x > newX-2 ) {
			if ( y > this.y-5 ) {
				if ( x < ( newX+2 ) ) {
					if ( y < ( this.y + 5 ) ) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void changeTheme(ColorScheme c) {
		this.foreGround = c.formForeGround;
		this.backGround = c.formBackGround;
		this.textC = c.text;
	}

}
