package me.HavocDev.Client.Utilities;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import me.HavocDev.Client.Client.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.wurstclient.font.Fonts;

public class RenderUtils {

	public static int enemy = 0;
	public static int friend = 1;
	public static int other = 2;
	public static int target = 3;
	public static int team = 4;
	/*
	public static void drawSelectionBoundingBox(AxisAlignedBB boundingBox)
	{
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder vertexbuffer = tessellator.getBuffer();
		vertexbuffer.begin(3, DefaultVertexFormats.POSITION);
		vertexbuffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ)
			.endVertex();
		tessellator.draw();
		vertexbuffer.begin(3, DefaultVertexFormats.POSITION);
		vertexbuffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ)
			.endVertex();
		tessellator.draw();
		vertexbuffer.begin(1, DefaultVertexFormats.POSITION);
		vertexbuffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ)
			.endVertex();
		vertexbuffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ)
			.endVertex();
		tessellator.draw();
	}*/
	
	
	public static void drawOutlinedBoundingBox(AxisAlignedBB aa) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(1, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		tessellator.draw();

	}

	public static void drawBoundingBox(AxisAlignedBB aa)
	{
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();
		worldRenderer.startDrawingQuads();
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		;
		tessellator.draw();
		worldRenderer.startDrawingQuads();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		;
		tessellator.draw();
		worldRenderer.startDrawingQuads();
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		;
		tessellator.draw();
		worldRenderer.startDrawingQuads();
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		;
		tessellator.draw();
		worldRenderer.startDrawingQuads();
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		;
		tessellator.draw();
		worldRenderer.startDrawingQuads();
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		;
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		;
		tessellator.draw();
	}
	
	public static void drawItemESP(int itemBox, EntityItem e, float partialTicks)
	{
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glLineWidth(2);
		float x = (float)(e.prevPosX + (e.posX - e.prevPosX) * partialTicks
				- Client.INSTANCE.mc.getRenderManager().renderPosX);
		float y = (float)(e.prevPosY + (e.posY - e.prevPosY) * partialTicks
				- Client.INSTANCE.mc.getRenderManager().renderPosY);
		float z = (float)(e.prevPosZ + (e.posZ - e.prevPosZ) * partialTicks
				- Client.INSTANCE.mc.getRenderManager().renderPosZ);
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glColor4f(1, 1, 0, 0.5F);
		GL11.glColor4f(1, 1, 0, 0.5F);
		RenderUtils.drawOutlinedBoundingBox(new AxisAlignedBB(-0.175, 0, -0.175, 0.175, 0.35, 0.175));
		GL11.glPopMatrix();
		ItemStack stack = e.getEntityItem();
		EntityRenderer.drawNameplate(Client.INSTANCE.mc.fontRendererObj,
				stack.stackSize + "x " + stack.getDisplayName(),
				x, y + 1, z, 0, Client.INSTANCE.mc.getRenderManager().playerViewY,
				Client.INSTANCE.mc.getRenderManager().playerViewX,
				Client.INSTANCE.mc.gameSettings.thirdPersonView == 2, false);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glColor4f(1, 1, 1, 1);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
	}

	public static void drawMobESP(EntityLiving e, float partialTicks)
	{
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glLineWidth(2);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glPushMatrix();
		GL11.glTranslated(-Client.INSTANCE.mc.getRenderManager().renderPosX,
			-Client.INSTANCE.mc.getRenderManager().renderPosY,
			-Client.INSTANCE.mc.getRenderManager().renderPosZ);
		GL11.glPushMatrix();
		float x = (float) (e.prevPosX + (e.posX - e.prevPosX) * partialTicks);
		float y = (float) (e.prevPosY + (e.posY - e.prevPosY) * partialTicks);
		float z = (float) (e.prevPosZ + (e.posZ - e.prevPosZ) * partialTicks);
		float f = Client.INSTANCE.player.getDistanceToEntity(e) / 20F;
		GL11.glTranslated(x, y, z);
		GL11.glScaled(e.width + 0.1, e.height + 0.1, e.width + 0.1);
		GL11.glColor4f(2 - f, f, 0, 0.5F);
		RenderUtils.drawOutlinedBoundingBox(new AxisAlignedBB(-0.5, 0, -0.5, 0.5, 1, 0.5));
		GL11.glPopMatrix();GL11.glPopMatrix();
		GL11.glColor4f(1, 1, 1, 1);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
	}

	public static void entityESPBox(Entity entity, int mode)
	{
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(2.0F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		if(mode == 0)// Enemy
			GL11.glColor4d(
					1 - Client.INSTANCE.player
							.getDistanceToEntity(entity) / 40,
					Client.INSTANCE.player.getDistanceToEntity(entity)
							/ 40,
					0, 0.5F);
		else if(mode == 1)// Friend
			GL11.glColor4d(0, 0, 1, 0.5F);
		else if(mode == 2)// Other
			GL11.glColor4d(1, 1, 0, 0.5F);
		else if(mode == 3)// Target
			GL11.glColor4d(1, 0, 0, 0.5F);
		else if(mode == 4)// Team
			GL11.glColor4d(0, 1, 0, 0.5F);
		RenderManager renderManager =
				Minecraft.getMinecraft().getRenderManager();
		RenderUtils.drawOutlinedBoundingBox(new AxisAlignedBB(
				entity.boundingBox.minX - 0.05 - entity.posX
						+ (entity.posX - renderManager.renderPosX),
				entity.boundingBox.minY - entity.posY
						+ (entity.posY - renderManager.renderPosY),
				entity.boundingBox.minZ - 0.05 - entity.posZ
						+ (entity.posZ - renderManager.renderPosZ),
				entity.boundingBox.maxX + 0.05 - entity.posX
						+ (entity.posX - renderManager.renderPosX),
				entity.boundingBox.maxY + 0.1 - entity.posY
						+ (entity.posY - renderManager.renderPosY),
				entity.boundingBox.maxZ + 0.05 - entity.posZ
						+ (entity.posZ - renderManager.renderPosZ)));
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
	}

	public static void drawTag(String s, double d, double d1, double d2, Color c) {
		RenderManager renderManager = Client.INSTANCE.mc.getRenderManager();
		float f = 5;
		d += 0.5D;
		d2 += 0.5D;
		FontRenderer fontrenderer = Client.INSTANCE.mc.fontRendererObj;
		float scale = f / 100;
		RenderManager renderManager1 = Client.INSTANCE.mc.getRenderManager();
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d, (float)d1 + 1.5F, (float)d2 - 0.5F);
		GL11.glNormal3f(0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-renderManager1.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(renderManager1.playerViewX, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(-scale, -scale, scale);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(770, 771);
		byte byte0 = 0;
		int i = fontrenderer.getStringWidth(s) / 2;
		Fonts.calibri14.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, c.getRGB());
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();
	}
	
	public static void drawBlockESP(double x, double y, double z, float red, float green, float blue, float alpha,
			float lineRed, float lineGreen, float lineBlue, float lineAlpha, float lineWidth) {
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(770, 771);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glColor4f(red, green, blue, alpha);
		drawBoundingBox(new AxisAlignedBB(x, y, z, x + 1D, y + 1D, z + 1D));
		GL11.glLineWidth(lineWidth);
		GL11.glColor4f(lineRed, lineGreen, lineBlue, lineAlpha);
		drawOutlinedBoundingBox(new AxisAlignedBB(x, y, z, x + 1D, y + 1D, z + 1D));
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

	public static void drawSolidBlockESP(double x, double y, double z, float red, float green, float blue,
			float alpha) {
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(770, 771);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glColor4f(red, green, blue, alpha);
		drawBoundingBox(new AxisAlignedBB(x, y, z, x + 1D, y + 1D, z + 1D));
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

	public static void blockESP(BlockPos blockPos, int mode)
	{
	double x = blockPos.getX() - Minecraft.getMinecraft().getRenderManager().viewerPosX;	
	double y = blockPos.getY() - Minecraft.getMinecraft().getRenderManager().viewerPosY;
	double z = blockPos.getZ() - Minecraft.getMinecraft().getRenderManager().viewerPosZ;
	
	GL11.glBlendFunc(770, 771);
	GL11.glEnable(GL11.GL_BLEND);
	GL11.glLineWidth(2.0f);
	GL11.glColor4d(0, 1, 0, 0.15f);
	GL11.glDisable(GL11.GL_TEXTURE_2D);
	GL11.glDisable(GL11.GL_DEPTH_TEST);
	GL11.glDepthMask(false);
	
	if(mode == 1)
	{
		GL11.glColor4d(0f, 1f, 0f, 0.5f);
	}
	else if(mode == 2)
	{
		GL11.glColor4d(0f, 0f, 1f, 0.5f);
	}
	else if(mode == 3)
	{
		GL11.glColor4d(1f, 0f, 0f, 0.5f);
	}
	//drawBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
	drawOutlinedBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
	GL11.glEnable(GL11.GL_TEXTURE_2D);
	GL11.glEnable(GL11.GL_DEPTH_TEST);
	GL11.glDepthMask(true);
	GL11.glDisable(GL11.GL_BLEND);
	
	}

}
