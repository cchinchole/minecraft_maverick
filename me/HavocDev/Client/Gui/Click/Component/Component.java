package me.HavocDev.Client.Gui.Click.Component;

import java.awt.Color;

import me.HavocDev.Client.Gui.Click.ColorScheme;

public abstract class Component {

	public Frame parent;
	public int x;
	public int y;
	public int xOriginal;
	public int yOriginal;
	public int width;
	public int height;
	public boolean draggable, dragging;
	public Color foreGround, backGround, textC;
	public String text;
	public boolean doBreak = false;
	
	public abstract void draw();
	public void update(){this.draw();}
	public abstract void drag(int x, int y);
	public abstract boolean mouseOver( int x, int y );
	public boolean isDragging( ) {
		if ( draggable ) {
			if ( dragging ) {
				return true;
			}
		}
		return false;
	}
	public abstract void changeTheme(ColorScheme c);
	public abstract void onMouseRelease(int x, int y);
	public abstract void onClick(int x, int y, int k);
	public boolean clickedInside( int x, int y ) {
		if ( x > this.x ) {
			if ( y > this.y ) {
				if ( x < ( this.x + this.width ) ) {
					if ( y < ( this.y + this.height ) ) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
}
