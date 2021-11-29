package me.HavocDev.Client.Gui.Mainmenu;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import me.HavocDev.Client.Utilities.GLUtils;
import me.HavocDev.Client.Utilities.PlayerUtils;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class ParticleManager {

	public ArrayList<Particle> particles;
	Random r = new Random();
	
	public ParticleManager(int width, int height)
	{
		particles = new ArrayList();
		
		for(int i = 0; i < 125; i++)
			particles.add(new Particle(r.nextInt(width), r.nextInt(height), width, height));
	}

	int maxDistanceParticles = 60;
	int maxDistanceMouse = 15;



	
	public void draw(int mouseX, int mouseY)
	{
		for(Particle p : particles)
		{
			int xx = (int) (MathHelper.cos(0.1F * (p.x + p.k)) * 10.0F);
				if(mouseX >=(p.x+xx-p.size-maxDistanceMouse) && mouseX <= (p.x+xx+p.size+maxDistanceMouse) && mouseY <= (p.y+p.size+maxDistanceMouse) && mouseY >= (p.y-p.size-maxDistanceMouse))
				{
					
					
					
					for(Particle pp : particles) {
						if ( Math.abs( PlayerUtils.getDistance(new Vec3(p.x, p.y, 0), new Vec3(pp.x, pp.y, 0)) ) <= maxDistanceParticles) {
							int xx2 = (int) (MathHelper.cos(0.1F * (pp.x + pp.k)) * 10.0F);

							
							GLUtils.drawLine(p.x+xx, p.y, pp.x+xx2, pp.y, 0.5f, new Color(0, 0, 0).getRGB());
						}
					}
				}


			p.drawParticle();
		}
	}
	
}
