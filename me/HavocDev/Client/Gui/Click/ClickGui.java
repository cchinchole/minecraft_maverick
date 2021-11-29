package me.HavocDev.Client.Gui.Click;

import java.awt.Color;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.HavocDev.Client.Gui.Click.Component.ComboBox;
import me.HavocDev.Client.Gui.Click.Component.MainFrame;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.client.gui.GuiScreen;

public class ClickGui extends GuiScreen{
	
//public ArrayList<Frame> frames;
	
	MainFrame mainFrame;
	
	public ClickGui( ) {
		/*
		frames = new ArrayList<Frame>( );
		//initFrames( );
		for ( Frame e : frames ) {
			e.minimized = false;
		}
		*/
	}
	
 @Override
	public boolean doesGuiPauseGame( ) {
		return false;
	}
	
 @Override
	public void initGui( ) {
		Keyboard.enableRepeatEvents( true );
	}
	
 @Override
	public void onGuiClosed( ) {
		Keyboard.enableRepeatEvents( true );
	}
	
 @Override
	protected void keyTyped( char c, int i ) {
		if ( i == 1 ) {
			mc.displayGuiScreen( null );
			return;
		}
		

		/*
		for ( Frame e : this.frames ) {
			for ( Component t : e.children ) {
				if ( t instanceof TextBox ) {
					//( (TextBox) t ).keyPressed( i );
				}
			}
		}
		*/
	}
 
 @Override
	protected void mouseReleased(int mouseX, int mouseY, int state){
		/*for ( Frame e : frames ) {
			e.onMouseRelease(mouseX, mouseY);
		}
		*/
	 mainFrame.onMouseRelease(mouseX, mouseY);
	}
	
 
 private boolean checkIfValid(ColorScheme a, ColorScheme b)
 {
	 
	 if(a.formBackGround != b.formBackGround)
		 return false;
	 else if(a.formForeGround != b.formForeGround)
		 return false;
	 
	 return true;
 }
 
 @Override
	public void drawScreen( int i, int j, float f ) {
	 /*
		for ( Frame e : frames ) {
			e.update( );
		}
		*/
	 
	 
	 if(Variables.updateColors){
		 mainFrame.changeTheme(Variables.defaultFA);
		 Variables.updateColors = false;
	 }
	 
	 
	 mainFrame.update();
	 
		this.mouseDragged( i, j );
		
	 
	}
	
 @Override
	protected void mouseClicked( int i, int j, int k ) {
	 
	 /*
		for ( Frame e : frames ) {
			e.onClick( i, j );
		}
		
		*/
	 mainFrame.onClick(i, j, k);
	}
	
 
	public void mouseDragged( int i, int j )
	{
		/*
		for ( Frame e : frames ) {
			int q = ( e.x - i ) / 2;
			int r = ( e.y - j ) / 2;
			q += i - ( e.width / 4 );
			r += j - ( e.oldHeight / 4 );
			e.drag( q, r );
		}
		*/
		int q = ( mainFrame.x - i ) / 2;
		int r = ( mainFrame.y - j ) / 2;
		q += i - ( mainFrame.width / 4 );
		r += j - ( mainFrame.formBorderHeight / 4 );
		mainFrame.drag( q, r );
		mainFrame.dragComp(i, j);
	}
	
	
	public void initFrames()
	{
		
		mainFrame = new MainFrame(20, 20, Variables.defaultFA);
		
		ArrayList<Category> categories = new ArrayList();
		
		for(Category c : Category.values())
		{
			categories.add(c);
		}
		
		mainFrame.children.add(new ComboBox(mainFrame, 0, 10, categories, true));
		mainFrame.changeTheme(Variables.defaultFA);
		
		
	}
	
}
