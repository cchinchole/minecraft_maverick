package me.HavocDev.Client.Utilities;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

public class GLUtils {
	
	public static void drawCircle(double d, double e, double r, int c)
	  {
	      float f = ((c >> 24) & 0xff) / 255F;
	      float f1 = ((c >> 16) & 0xff) / 255F;
	      float f2 = ((c >> 8) & 0xff) / 255F;
	      float f3 = (c & 0xff) / 255F;
		 // float f3 = 1.0f;
	      GL11.glEnable(GL11.GL_BLEND);
	      GL11.glDisable(GL11.GL_TEXTURE_2D);
	      GL11.glEnable(GL11.GL_LINE_SMOOTH);
	      GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	      GL11.glColor4f(f1, f2, f3, f);
	      GL11.glBegin(GL11.GL_LINE_LOOP);

	      for (int i = 0; i <= 360; i++)
	      {
	          double x2 = Math.sin(((i * Math.PI) / 180)) * r;
	          double y2 = Math.cos(((i * Math.PI) / 180)) * r;
	          GL11.glVertex2d(d + x2, e + y2);
	      }

	      GL11.glEnd();
	      GL11.glDisable(GL11.GL_LINE_SMOOTH);
	      GL11.glEnable(GL11.GL_TEXTURE_2D);
	      GL11.glDisable(GL11.GL_BLEND);
	  }
	
	
	public static void drawBorderedCircle(int x, int y, float radius, int outsideC, int insideC)
	  {
	    GL11.glEnable(3042);
	    
	    GL11.glDisable(3553);
	    
	    GL11.glBlendFunc(770, 771);
	    
	    GL11.glEnable(2848);
	    
	    GL11.glPushMatrix();
	    
	    float scale = 0.1F;
	    
	    GL11.glScalef(scale, scale, scale);
	    
	    x = (int)(x * (1.0F / scale));
	    
	    y = (int)(y * (1.0F / scale));
	    
	    radius *= 1.0F / scale;
	    
	    drawCircle(x, y, radius, insideC);
	    
	    drawUnfilledCircle(x, y, radius, 1.0F, outsideC);
	    
	    GL11.glScalef(1.0F / scale, 1.0F / scale, 1.0F / scale);
	    
	    GL11.glPopMatrix();
	    
	    GL11.glEnable(3553);
	    
	    GL11.glDisable(3042);
	    
	    GL11.glDisable(2848);
	  }
	  public static void drawUnfilledCircle(int x, int y, float radius, float lineWidth, int color)
	  {
	    float alpha = (color >> 24 & 0xFF) / 255.0F;
	    
	    float red = (color >> 16 & 0xFF) / 255.0F;
	    
	    float green = (color >> 8 & 0xFF) / 255.0F;
	    
	    float blue = (color & 0xFF) / 255.0F;
	    
	    GL11.glColor4f(red, green, blue, alpha);
	    
	    GL11.glLineWidth(lineWidth);
	    
	    GL11.glEnable(2848);
	    
	    GL11.glBegin(2);
	    for (int i = 0; i <= 360; i++) {
	      GL11.glVertex2d(x + Math.sin(i * 3.141526D / 180.0D) * radius, y + Math.cos(i * 3.141526D / 180.0D) * radius);
	    }
	    GL11.glEnd();
	    
	    GL11.glDisable(2848);
	  }


	public static void drawBox(int x1, int y1, int x2, int y2) {
		

		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		
		// color
		GL11.glColor4f(0.F, 0.F, 0.F, 0.5F);

		// box
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glVertex2i(x1, y1);
			GL11.glVertex2i(x2, y1);
			GL11.glVertex2i(x2, y2);
			GL11.glVertex2i(x1, y2);
		}
		GL11.glEnd();

		// outline positions
		double xi1 = x1 - 0.1;
		double xi2 = x2 + 0.1;
		double yi1 = y1 - 0.1;
		double yi2 = y2 + 0.1;

		// outline
		GL11.glLineWidth(1);
		GL11.glColor4f( (float)(255/255) , (float)(255/255), (float)(0/255), 1F);
		GL11.glBegin(GL11.GL_LINE_LOOP);
		{
			GL11.glVertex2d(xi1, yi1);
			GL11.glVertex2d(xi2, yi1);
			GL11.glVertex2d(xi2, yi2);
			GL11.glVertex2d(xi1, yi2);
		}
		GL11.glEnd();

		// shadow positions
		xi1 -= 0.9;
		xi2 += 0.9;
		yi1 -= 0.9;
		yi2 += 0.9;

		float[] shadow;
		shadow = new float[]{0.125F, 0.125F, 0.125F};

		// top left
		GL11.glBegin(GL11.GL_POLYGON);
		{
			GL11.glColor4f( (float)(255/255) , (float)(255/255), (float)(255/255), 0.8F);
			GL11.glVertex2d(x1, y1);
			GL11.glVertex2d(x2, y1);
			GL11.glColor4f( (float)(255/255) , (float)(255/255), (float)(255/255), 0.8F);
			GL11.glVertex2d(xi2, yi1);
			GL11.glVertex2d(xi1, yi1);
			GL11.glVertex2d(xi1, yi2);
			GL11.glColor4f( (float)(255/255) , (float)(255/255), (float)(255/255), 0.8F);
			GL11.glVertex2d(x1, y2);
		}
		GL11.glEnd();

		// bottom right
		GL11.glBegin(GL11.GL_POLYGON);
		{
			GL11.glVertex2d(x2, y2);
			GL11.glVertex2d(x2, y1);
			GL11.glColor4f( (float)(255/255) , (float)(255/255), (float)(255/255), 0.8F);
			GL11.glVertex2d(xi2, yi1);
			GL11.glVertex2d(xi2, yi2);
			GL11.glVertex2d(xi1, yi2);
			GL11.glColor4f( (float)(255/255) , (float)(255/255), (float)(255/255), 0.8F);
			GL11.glVertex2d(x1, y2);
		}
		GL11.glEnd();

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
	}
	
	
	public static void drawRect(int x1, int y1, int x2, int y2, int back, int side)
	{
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		
		
		float f = ((back >> 24) & 0xff) / 255F;
	      float f1 = ((back >> 16) & 0xff) / 255F;
	      float f2 = ((back >> 8) & 0xff) / 255F;
	      float f3 = (back & 0xff) / 255F;

		//GL11.glColor4f(f1, f2,  f3, f);
		
		float af = ((side >> 24) & 0xff) / 255F;
	      float af1 = ((side >> 16) & 0xff) / 255F;
	      float af2 = ((side >> 8) & 0xff) / 255F;
	      float af3 = (side & 0xff) / 255F;

		//GL11.glColor4f(f1, f2,  f3, f);
		
		// color
		GL11.glColor4f(f1, f2, f3, f);

		// box
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glVertex2i(x1, y1);
			GL11.glVertex2i(x2, y1);
			GL11.glVertex2i(x2, y2);
			GL11.glVertex2i(x1, y2);
		}
		GL11.glEnd();

		// outline positions
		double xi1 = x1 - 0.1;
		double xi2 = x2 + 0.1;
		double yi1 = y1 - 0.1;
		double yi2 = y2 + 0.1;

		// outline
		GL11.glLineWidth(0.5F);
		GL11.glColor4f( (float)(255/255) , (float)(255/255), (float)(0/255), 1F);
		GL11.glBegin(GL11.GL_LINE_LOOP);
		{
			GL11.glVertex2d(xi1, yi1);
			GL11.glVertex2d(xi2, yi1);
			GL11.glVertex2d(xi2, yi2);
			GL11.glVertex2d(xi1, yi2);
		}
		GL11.glEnd();

		// shadow positions
		xi1 -= 0.9;
		xi2 += 0.9;
		yi1 -= 0.9;
		yi2 += 0.9;

		float[] shadow;
		shadow = new float[]{0.125F, 0.125F, 0.125F};

		// top left
		GL11.glBegin(GL11.GL_POLYGON);
		{
			GL11.glColor4f(af1 , af2, af3, af);
			GL11.glVertex2d(x1, y1);
			GL11.glVertex2d(x2, y1);
			GL11.glColor4f(af1 , af2, af3, af);
			GL11.glVertex2d(xi2, yi1);
			GL11.glVertex2d(xi1, yi1);
			GL11.glVertex2d(xi1, yi2);
			GL11.glColor4f(af1 , af2, af3, af);
			GL11.glVertex2d(x1, y2);
		}
		GL11.glEnd();

		// bottom right
		GL11.glBegin(GL11.GL_POLYGON);
		{
			GL11.glVertex2d(x2, y2);
			GL11.glVertex2d(x2, y1);
			GL11.glColor4f(af1 , af2, af3, af);
			GL11.glVertex2d(xi2, yi1);
			GL11.glVertex2d(xi2, yi2);
			GL11.glVertex2d(xi1, yi2);
			GL11.glColor4f(af1 , af2, af3, af);
			GL11.glVertex2d(x1, y2);
		}
		GL11.glEnd();

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
	}
	

	public static void drawBox(int x1, int y1, int x2, int y2, float r, float g, float b, float a) {

		

		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		
		// color
		GL11.glColor4f(0, 0, 0, a);

		// box
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glVertex2i(x1, y1);
			GL11.glVertex2i(x2, y1);
			GL11.glVertex2i(x2, y2);
			GL11.glVertex2i(x1, y2);
		}
		GL11.glEnd();

		// outline positions
		double xi1 = x1 - 0.1;
		double xi2 = x2 + 0.1;
		double yi1 = y1 - 0.1;
		double yi2 = y2 + 0.1;

		// outline
		GL11.glLineWidth(1);
		GL11.glColor4f( (float)(255/255) , (float)(255/255), (float)(0/255), 1F);
		GL11.glBegin(GL11.GL_LINE_LOOP);
		{
			GL11.glVertex2d(xi1, yi1);
			GL11.glVertex2d(xi2, yi1);
			GL11.glVertex2d(xi2, yi2);
			GL11.glVertex2d(xi1, yi2);
		}
		GL11.glEnd();

		// shadow positions
		xi1 -= 0.9;
		xi2 += 0.9;
		yi1 -= 0.9;
		yi2 += 0.9;

		float[] shadow;
		shadow = new float[]{0.125F, 0.125F, 0.125F};

		// top left
		GL11.glBegin(GL11.GL_POLYGON);
		{
			GL11.glColor4f( (float)(r/255) , (float)(g/255), (float)(b/255), 1);
			GL11.glVertex2d(x1, y1);
			GL11.glVertex2d(x2, y1);
			GL11.glColor4f( (float)(r/255) , (float)(g/255), (float)(b/255), 1);
			GL11.glVertex2d(xi2, yi1);
			GL11.glVertex2d(xi1, yi1);
			GL11.glVertex2d(xi1, yi2);
			GL11.glColor4f( (float)(r/255) , (float)(g/255), (float)(b/255), 1);
			GL11.glVertex2d(x1, y2);
		}
		GL11.glEnd();

		// bottom right
		GL11.glBegin(GL11.GL_POLYGON);
		{
			GL11.glVertex2d(x2, y2);
			GL11.glVertex2d(x2, y1);
			GL11.glColor4f( (float)(r/255) , (float)(g/255), (float)(b/255), 1);
			GL11.glVertex2d(xi2, yi1);
			GL11.glVertex2d(xi2, yi2);
			GL11.glVertex2d(xi1, yi2);
			GL11.glColor4f( (float)(r/255) , (float)(g/255), (float)(b/255), 1);
			GL11.glVertex2d(x1, y2);
		}
		GL11.glEnd();

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
		
	}
	
	public static void drawLine(int x, int y, int x2, int y2, float thickness, int c)
	{

		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		
			float f = ((c >> 24) & 0xff) / 255F;
	      float f1 = ((c >> 16) & 0xff) / 255F;
	      float f2 = ((c >> 8) & 0xff) / 255F;
	      float f3 = (c & 0xff) / 255F;

		GL11.glLineWidth(thickness);
		GL11.glColor4f(f1, f2,  f3, f);
		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x2, y2);
		GL11.glEnd();

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
	}
	
	
	
}
