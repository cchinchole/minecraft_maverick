package me.HavocDev.Client.Mods.Player;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.network.play.client.C03PacketPlayer;

public class RegenMod extends Mod{

	public RegenMod() {
		super("regen", "Regen", "Allows you to regenerate quickly", Category.Player, -99999999);
	}
	

	public void onUpdate()
	{
		if(this.isActive)
		if(!Client.INSTANCE.player.capabilities.isCreativeMode
			&& Client.INSTANCE.player.getFoodStats().getFoodLevel() > 17
			&& Client.INSTANCE.player.getHealth() < 20 && Client.INSTANCE.player.getHealth() != 0
			&& Client.INSTANCE.player.onGround)
			for(int i = 0; i < 1000; i++)
				Client.INSTANCE.player.sendQueue.addToSendQueue(new C03PacketPlayer());
}

}
