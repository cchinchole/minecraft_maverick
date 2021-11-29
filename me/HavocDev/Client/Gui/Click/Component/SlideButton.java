package me.HavocDev.Client.Gui.Click.Component;

import java.awt.Color;

import me.HavocDev.Client.Gui.Click.ColorScheme;
import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Utilities.GLUtils;
import net.wurstclient.font.Fonts;

public class SlideButton extends Component {

	public Setting setting;
	
	public SlideButton(int x, int y, Setting s)
	{
		this(x, y, 25, 10, new Color(255, 0 ,0), new Color(255, 255, 255), s);
	}
	
	public SlideButton(int x, int y, Color b, Color f, Setting s)
	{
		this(x, y, 25, 10, f, b, s);
	}
	
	public SlideButton(int x, int y, int width, int height, Color foreground, Color background, Setting s)
	{
		this.x = x;
		this.y = y;
		this.xOriginal = x;
		this.yOriginal = y;
		this.width = width;
		this.height = height;
		this.backGround = background;
		this.foreGround = foreground;
		this.setting = s;
		this.draggable = false;
	}
	
	@Override
	public void draw() {
		
		
		GLUtils.drawRect(this.x, this.y, this.x+width, this.y+height, this.backGround.getRGB(), this.foreGround.getRGB());
		if(!(boolean)this.setting.getValue())
		{
			GLUtils.drawRect(this.x+(this.width/2), this.y, this.x+width, this.y+height, new Color(255, 0, 0).getRGB(), this.foreGround.getRGB());
		}else
		{
			GLUtils.drawRect(this.x, this.y, this.x+(width/2), this.y+height, new Color(0, 255, 0).getRGB(), this.foreGround.getRGB());
			
		}
		Fonts.calibri14.drawString(setting.getName(), this.x, this.y-10, this.textC.getRGB());
		
	}

	@Override
	public void drag(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mouseOver(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onMouseRelease(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(int x, int y, int k) {
		if(this.clickedInside(x, y))
		{
			setting.setValue(!(boolean)this.setting.getValue());
		}
		
	}

	@Override
	public void changeTheme(ColorScheme c) {
		this.foreGround = c.formForeGround;
		this.backGround = c.formBackGround;
		this.textC = c.text;
		
	}

}
