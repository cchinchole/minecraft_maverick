package me.HavocDev.Client.Mods.Movement;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.network.play.client.C0BPacketEntityAction;

public class SneakMod extends Mod{
	public SneakMod()
	{
		super("sneak","Always Sneaking", "Always Sneaks", Category.Movement, -99);
	}
	
	public void onUpdate()
	{
		if(this.getActive())
			Client.INSTANCE.sendPacket(new C0BPacketEntityAction(Client.INSTANCE.player, C0BPacketEntityAction.Action.START_SNEAKING));
	}
}
