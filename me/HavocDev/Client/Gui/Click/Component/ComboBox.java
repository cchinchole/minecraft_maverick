package me.HavocDev.Client.Gui.Click.Component;

import java.awt.Color;
import java.util.ArrayList;

import me.HavocDev.Client.Gui.Click.ColorScheme;
import me.HavocDev.Client.Utilities.GLUtils;
import me.HavocDev.Client.Variables.Category;
import net.wurstclient.font.Fonts;

public class ComboBox extends Component {

	
	
	ArrayList selections;
	Object selectedIndex;
	boolean thisTicked = false;
	MainFrame parent;
	boolean isThisOne = true;
	
	public ComboBox(MainFrame parent, int x, int y, ArrayList selections, boolean isOne)
	{
		this(parent, x, y, 50, 10, new Color(0, 0, 0), new Color(255, 0, 0), new Color(255, 255, 255),selections, selections.get(0).toString(), isOne);
	}
	
	boolean isCollapsed = false;
	public ComboBox(MainFrame parent, int x, int y, int width, int height, Color background, Color foreground, Color c,ArrayList selections, String text, boolean isOne)
	{
	this.x = x;
	this.y = y;
	this.xOriginal = x;
	this.yOriginal = y;
	this.width = width;
	this.height = height;
	this.selections = selections;
	this.selectedIndex = selections.get(0);
	this.text = text;
	this.parent = parent;
	this.foreGround = foreground;
	this.backGround = background;
	this.textC = c;
	this.isThisOne = isOne;
	if(isThisOne)
	{
		parent.changeCategory( (Category)selectedIndex );
	}
	
	}
	
	@Override
	public void draw() {
		

		GLUtils.drawRect(this.x, this.y, this.x+width, this.y+height, this.backGround.getRGB(), this.foreGround.getRGB());
		Fonts.calibri14.drawString(selectedIndex.toString(), this.x+3, this.y+2, this.textC.getRGB());
		
		if(this.isCollapsed)
		{
			int index = 15;
			for(Object o : selections)
			{
				GLUtils.drawRect(this.x,this.y+index, this.x+width, this.y+height+3+index, this.backGround.getRGB(), this.foreGround.getRGB());
				//GLUtils.drawRect(this.x, this.y+index, this.x+width, this.y+height+3+index, this.backGround, this.foreGround);
				Fonts.calibri14.drawString(o.toString(), this.x+3, this.y+index, this.textC.getRGB());
				index+=15;
			}
		}
		
		
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
		
		if(k != 0)
			return;
		
		if(this.clickedInside(x, y))
		{
			this.isCollapsed = !this.isCollapsed;
		}
		else
		{
			if(this.isCollapsed)
			{
				int index = 15;
				for(Object o : selections)
				{
					//GLUtils.drawRect(this.x, this.y, this.x+width, this.y+height+3, color, foreground);
					//Fonts.calibri14.drawString(o.toString(), this.x+3, this.y+index, foreground.getRGB());
					
					if ( x > this.x ) {
						if ( y > this.y ) {
							if ( x < ( this.x + this.width ) ) {
								if ( y < ( this.y + this.height+index+3 ) ) {
									this.selectedIndex = o;
									
									if(isThisOne)
									{
										parent.changeCategory( (Category)selectedIndex );
									}
									else
										thisTicked = true;
									
									this.isCollapsed = false;
									this.doBreak = true;
									break;
								}
							}
						}
					}
					
					index+=15;
				}
			}
			}
		}

	@Override
	public void changeTheme(ColorScheme c) {
		this.foreGround = c.componentForeGround;
		this.backGround = c.componentBackGround;
		this.textC = c.text;
		
	}


}
