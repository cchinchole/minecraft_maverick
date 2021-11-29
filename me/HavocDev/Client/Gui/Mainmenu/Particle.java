package me.HavocDev.Client.Gui.Mainmenu;

import java.awt.Color;
import java.util.Random;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import me.HavocDev.Client.Utilities.GLUtils;

public class Particle {
	
	public int x;
	public int y;
	public int k;
	public float size;
	public Random r = new Random();
	public Color c;

	private int width = 0, height = 0;

	public Particle(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.size = 1.25f;
		this.c = new Color(69, 1, genRandom(125, 200));
	}
	
	public void drawParticle()
	{
		
		if(x == -1)
		{
			x = width;
		}
		
		if(y == -1)
		{
			y = height;
		}

		this.x -= r.nextInt(2);
		this.y -= r.nextInt(2);
		int xx = (int) (MathHelper.cos(0.1F * (this.x + this.k)) * 10.0F);
		
		
		GLUtils.drawCircle(this.x+xx, this.y, this.size/2, c.getRGB());
	}
	
	
	
	
	public int genRandom(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}
}
