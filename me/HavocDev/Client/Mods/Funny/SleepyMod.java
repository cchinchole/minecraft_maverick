package me.HavocDev.Client.Mods.Funny;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.network.play.client.C03PacketPlayer;

public class SleepyMod extends Mod{
	public SleepyMod() {
		super("sleepy", "Sleepy", "Funny Sleep ", Category.Fun, -99);
	}
	
	public void onUpdate()
	{
		if(this.isActive)
		Client.INSTANCE.sendPacket(
				new C03PacketPlayer.C05PacketPlayerLook(Client.INSTANCE.player.rotationYaw,
						Client.INSTANCE.player.ticksExisted % 100,
						Client.INSTANCE.player.onGround));

	}
	
}

