package me.HavocDev.Client.Gui.Click.Component;

import java.awt.Color;
import java.util.ArrayList;

import me.HavocDev.Client.Gui.Click.ColorScheme;
import me.HavocDev.Client.Utilities.GLUtils;
import net.wurstclient.font.Fonts;

public class Frame extends Component {
	
	public ArrayList<Component> children;
	
	public int oldHeight;
	public boolean minimized;
	
	public Frame(int x, int y, int width, int height, String name)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		oldHeight = height;
		this.text = name;
		this.children = new ArrayList();
		this.draggable = true;
		this.minimized = false;
	}

	@Override
	public void draw() {

		int offset = oldHeight;
		offset /= 2;
		offset += 4;
		GLUtils.drawRect(this.x, this.y, this.x+width, this.y+( this.oldHeight ) + ( offset * ( this.children.size() + 1 ) ) + 10, new Color(0, 0, 0).getRGB(), new Color(255, 0, 0).getRGB());//( this.x + 2, ( this.x + this.width ) - 2, ( this.y + this.oldHeight ) - 6, 2, 0xff550055 );
		
		GLUtils.drawLine(this.x, this.y+this.oldHeight, this.x+width, this.y+this.oldHeight, 4f, new Color(255, 255,255).getRGB());
		
		Fonts.calibri22.drawString( this.text, this.x + 3, this.y + 3, 0xff87b5ff );
		
		if(!this.minimized)
		{
			for(Component c : children)
			{
				c.x = ( this.x ) + 3;
				c.y = ( this.y ) + ( offset * ( this.children.indexOf( c ) + 1) ) + 10;
				c.update();
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
		}
	}
		
	}

	@Override
	public void onMouseRelease(int x, int y) {
		if(this.isDragging())
			this.dragging = false;
		
	}

	@Override
	public void changeTheme(ColorScheme c) {
		// TODO Auto-generated method stub
		
	}

}
