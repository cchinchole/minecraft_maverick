package me.HavocDev.Client.Hook;

import me.HavocDev.Client.Variables.Variables;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.*;
import org.lwjgl.opengl.GL11;

public class RenderPlayerHook  extends RenderPlayer {




    public RenderPlayerHook(RenderManager renderManager)
    {
        this(renderManager, false);
    }

    public RenderPlayerHook(RenderManager renderManager, boolean useSmallArms)
    {
        super(renderManager);
        this.smallArms = useSmallArms;
        this.addLayer(new LayerBipedArmor(this));
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerArrow(this));
        this.addLayer(new LayerDeadmau5Head(this));
        this.addLayer(new LayerCape(this));
        this.addLayer(new LayerCustomHead(this.getMainModel().bipedHead));
    }
    
    public void doRender(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        if (!entity.isUser() || this.renderManager.livingPlayer == entity)
        {
            double d0 = y;

            if (entity.isSneaking() && !(entity instanceof EntityPlayerSP))
            {
                d0 = y - 0.125D;
            }

            this.setModelVisibilities(entity);
            
            if(Variables.Chams) {
                GL11.glEnable(32823);
                GL11.glPolygonOffset(1, -1000000);
            }
            
            super.doRender(entity, x, d0, z, entityYaw, partialTicks);
            
            if(Variables.Chams) {
                GL11.glDisable(32823);
                GL11.glPolygonOffset(1, 1000000);
            }
        }
    }


}
