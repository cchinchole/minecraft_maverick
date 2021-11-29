package me.HavocDev.Client.Mods.Render;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Events.PacketOutputEvent;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Mods.Movement.EntityFakePlayer;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;

public class FreecamMod extends Mod{
	public FreecamMod()
	{
		super("freecam","Freecam", "Freely Move Around", Category.Render, -99);
	}

	private EntityFakePlayer fakePlayer;
	public boolean tele = false;

	public void onEnable()
	{
		fakePlayer = new EntityFakePlayer();
	}
	
	public void onDisable()
	{
		//Client.INSTANCE.player.posX = fakePlayer.posX ;
		//Client.INSTANCE.player.posY = fakePlayer.posY ;
		//Client.INSTANCE.player.posZ = fakePlayer.posZ ;
		fakePlayer.resetPlayerPosition();
		fakePlayer.despawn();
		Client.INSTANCE.player.noClip = false;
		Client.INSTANCE.mc.renderGlobal.loadRenderers();
	}

	public void onPacket(Packet pack) {
		if(!tele) {
			if (pack instanceof C03PacketPlayer && this.getActive()) {
				if (pack instanceof C03PacketPlayer.C04PacketPlayerPosition || pack instanceof C03PacketPlayer.C06PacketPlayerPosLook) {
					((PacketOutputEvent) this.event).isAlive = false;
				}
			}
		}
	}
	
	public void onUpdate() {

		if(this.isActive)
		{
			if(Variables.flightEnabled) {
				Client.INSTANCE.player.noClip = true;
				Client.INSTANCE.player.onGround = false;
			}
			else
			{
				Client.INSTANCE.player.noClip = false;
			}
		}

/*
		if (this.isActive) {
			Client.INSTANCE.player.motionX = 0;
			Client.INSTANCE.player.motionY = 0;
			Client.INSTANCE.player.motionZ = 0;

			Client.INSTANCE.player.jumpMovementFactor = Variables.flight / 10f;

			if (Client.INSTANCE.mc.gameSettings.keyBindJump.isPressed())
				Client.INSTANCE.player.motionY += Variables.flight;


			if (Client.INSTANCE.mc.gameSettings.keyBindSneak.isPressed())
				Client.INSTANCE.player.motionY -= Variables.flight;
		}

		*/
	}
}
