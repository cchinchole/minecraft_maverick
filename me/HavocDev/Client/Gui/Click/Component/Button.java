package me.HavocDev.Client.Gui.Click.Component;

import java.awt.Color;

import me.HavocDev.Client.Gui.Click.ColorScheme;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Utilities.GLUtils;
import net.wurstclient.font.Fonts;

public class Button extends Component{
	
	Mod m;
	String text;
	MainFrame parent;
	Color prev;
	
	public Button(MainFrame parent, int x, int y, Mod m)
	{
		this(parent, x, y, 50, 10, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), m);
	}
	
	public Button(MainFrame parent, int x, int y, Color f, Color b,Color c, Mod m)
	{
		this(parent, x, y, 50, 10, f, b, c, m);
	}
	
	
	public Button(MainFrame parent, int x, int y, int width, int height, Color foreground, Color background, Color c, Mod m)
	{
		this.parent = parent;
		this.x = x;
		this.y = y;
		this.xOriginal = x;
		this.yOriginal = y;
		this.width = width;
		this.height = height;
		this.backGround = background;
		this.foreGround = foreground;
		this.m = m;
		this.text = m.getDisplayName();
		this.textC = c;
		this.prev = c;
		
	}

	@Override
	public void draw() {
		GLUtils.drawRect(this.x, this.y, this.x+width, this.y+height, this.backGround.getRGB(), this.foreGround.getRGB());
		Fonts.calibri12.drawString(text, x+2, y+3, textC.getRGB());
		
	}

	@Override 
	public void drag(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public boolean mouseOver(int x, int y) {
		
		return false;
	}

	@Override
	public void onClick(int x, int y, int k) {
		System.out.print(k);
		if(this.clickedInside(x, y) && k == 0)
		{
			this.m.onToggle();
			
			if(this.m.getActive())
			{
				this.textC = new Color(0, 255, 0);
			}
			else
			{
				this.textC = this.prev;
			}
		}
		else if(this.clickedInside(x, y) && k == 1)
		{
			parent.addSettings(m);
			this.doBreak = true;
		}
		
	}

	@Override
	public void onMouseRelease(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeTheme(ColorScheme c) {
		
		

		this.foreGround = c.componentForeGround;
		this.backGround = c.componentBackGround;
		this.textC = c.text;
		this.prev = textC;
		
	}

}
