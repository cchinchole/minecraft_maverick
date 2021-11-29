package me.HavocDev.Client.Gui.Click.Component;

import java.awt.Color;
import java.util.ArrayList;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Gui.Click.ColorScheme;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Setting.ValueType;
import me.HavocDev.Client.Setting.GUI.FormBackgroundBlueSetting;
import me.HavocDev.Client.Setting.GUI.FormBackgroundGreenSetting;
import me.HavocDev.Client.Setting.GUI.FormBackgroundRedSetting;
import me.HavocDev.Client.Setting.GUI.FormForegroundBlueSetting;
import me.HavocDev.Client.Setting.GUI.FormForegroundGreenSetting;
import me.HavocDev.Client.Setting.GUI.FormForegroundSetting;
import me.HavocDev.Client.Utilities.GLUtils;
import me.HavocDev.Client.Variables.Category;
import net.wurstclient.font.Fonts;

public class MainFrame extends Component{
	public ArrayList<Component> children;
	
	public int oldHeight;
	public int formBorderHeight;
	public boolean minimized;
	
	
	private Color componentForeground;
	private Color componentBackground;

	
	public MainFrame(int x, int y, ColorScheme c)
	{
		this.x = x;
		this.y = y;
		this.width = 300;
		this.height = 250;
		this.formBorderHeight = 15;
		oldHeight = height;
		this.text = Client.INSTANCE.getClientName();
		this.children = new ArrayList();
		this.draggable = true;
		this.minimized = false;
		
		this.foreGround = new Color(255, 255, 255);
		this.backGround = new Color(0, 0, 0, (int)(0.4*255));
		
		
		this.caf = c;
	}

	@Override
	public void draw() {

		int offset = oldHeight;
		offset /= 2;
		offset += 4;
		
		//Dim Background
		
		GLUtils.drawRect(0, 0, Client.INSTANCE.mc.displayWidth, Client.INSTANCE.mc.displayHeight, new Color(0, 0, 0, 100).getRGB(), new Color(0, 0, 0, 20).getRGB());
		
		//Background
		GLUtils.drawRect(this.x, this.y, this.x+width, this.y+this.oldHeight, this.backGround.getRGB(), this.foreGround.getRGB());//( this.x + 2, ( this.x + this.width ) - 2, ( this.y + this.oldHeight ) - 6, 2, 0xff550055 );
		
		//Top Bar
		GLUtils.drawLine(this.x, this.y+this.formBorderHeight, this.x+width, this.y+this.formBorderHeight, 4f, this.foreGround.getRGB());
		

		
		//Midle Right Bar
		
		GLUtils.drawLine(this.x + (2*(width/3)), this.y+this.formBorderHeight, this.x + (2*(width/3)), this.y+( this.oldHeight ), 4f, this.foreGround.getRGB());

		//Middle Left Bar
		
		GLUtils.drawLine(this.x + (width/3), this.y+this.formBorderHeight, this.x + (width/3), this.y+( this.oldHeight ), 4f, this.foreGround.getRGB());
		
		
		//Name
		
		
		Fonts.calibri22.drawCenteredString( this.text, this.x + (width  / 2), this.y + 3, this.foreGround.getRGB() );
		
		
		for(Component c : children)
		{
			c.x = (this.x) + 3 + c.xOriginal;
			c.y = (this.y) + this.formBorderHeight + c.yOriginal;
			c.update();
		}
	}
	
	public void changeCategory(Category c)
	{
		ArrayList<Component> toRemove = new ArrayList();
		for(Component ca : children)
		{
			if(ca instanceof Button)
			{
				toRemove.add(ca);
			}
		}
		children.removeAll(toRemove);
		
		int index = 10;
		
		for(Mod m : Client.INSTANCE.modManager.mods)
		{
			if(m.getCategory() == c)
			{
				Button b = new Button(this,  ((width/3)), index, caf.componentBackGround, caf.componentForeGround, caf.text, m);
				b.changeTheme(caf);
				children.add(b);
				index+= b.height+10;
			}
		}
	}

	public void addSettings(Mod m)
	{
		ArrayList<Component> toRemove = new ArrayList();
		for(Component ca : children)
		{
			if(ca instanceof Slider || ca instanceof SlideButton)
			{
				toRemove.add(ca);
			}
		}
		children.removeAll(toRemove);
		
		
		int index = 10;
		
		for(Setting s : m.settings)
		{
			if(s.getValueType() == ValueType.FLOAT || s.getValueType() == ValueType.INT)
			{
				//Button b = new Button(this.x + ((width/3)), index, m);
			Slider b = new Slider(  (2*(width/3)), index, caf.componentBackGround, caf.componentForeGround, caf.text, s );
			b.changeTheme(caf);
			children.add(b);
				index+= b.height+10;
			}
			else if(s.getValueType() == ValueType.BOOL)
			{
				SlideButton b = new SlideButton( (2*(width/3)), index, caf.componentBackGround, caf.componentForeGround, s );
				b.changeTheme(caf);
				children.add(b);
					index+= b.height+10;
			}
		}
	}
	
	@Override
	public void drag(int x, int y) {
		
		
		
		if ( !this.draggable || !this.dragging ) {
			return;
		}
		
		this.x = x;
		this.y = y;
		
		
		
		
	}
	
	public void dragComp(int x, int y)
	{
		for(Component c : this.children)
		{
			c.drag(x, y);
		}
	}

	@Override
	public boolean mouseOver(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onClick(int x, int y, int k) {
		
		if ( this.clickedInside( x, y ) ) {
				this.dragging = true;
		}
		
		
		if(!this.minimized)
		{
			for(Component c : children)
			{
				c.onClick(x, y, k);
				
				if(c.doBreak)
				{
					c.doBreak = false;
					break;
				}
				
			}
		}
		
	}

	@Override
	public void onMouseRelease(int x, int y) {
		
		for(Component c : this.children)
		{
			c.onMouseRelease(x, y);
		}
		
		
		if(this.isDragging())
			this.dragging = false;
		
	}

	@Override
	public boolean clickedInside( int x, int y ) {
		if ( x > this.x ) {
			if ( y > this.y ) {
				if ( x < ( this.x + this.width ) ) {
					if ( y < ( this.y + this.formBorderHeight ) ) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	ColorScheme caf;

	@Override
	public void changeTheme(ColorScheme c) {
		this.foreGround = c.formForeGround;
		this.backGround = c.formBackGround;
		caf = c;
		c.componentBackGround = c.formBackGround;
		for(Component ca : this.children)
		{
			ca.changeTheme(c);
		}
		
	}
	
}
