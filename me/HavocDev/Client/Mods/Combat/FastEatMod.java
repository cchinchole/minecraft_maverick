package me.HavocDev.Client.Mods.Combat;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.item.ItemFood;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;

public class FastEatMod extends Mod {

    public FastEatMod()
    {
        super("fasteat", "Fast Eat", "Eat Fast", Category.Combat, -999);
    }

    /*

    CANNOT BYPASS ANY NCP

     */

    public void onUpdate()
    {
        if(!this.isActive)
            return;
		if (Client.INSTANCE.mc.thePlayer.inventory.getCurrentItem() == null) {
			return;
		}
        if (!(Client.INSTANCE.player.inventory.getCurrentItem().getItem() instanceof ItemFood)) {
            return;
        }
        if (Client.INSTANCE.mc.gameSettings.keyBindUseItem.isKeyDown()) {
            for (int i = 0; i < 32; i++) {
                Client.INSTANCE.sendPacketBypass(new C03PacketPlayer(false));
            }
        }
    }


    public void onPacket(Packet pack) {
    	if(Client.INSTANCE.mc.thePlayer == null) {
			return;
		}
		if(Client.INSTANCE.mc.thePlayer.inventory == null) {
			return;
		}
		if (Client.INSTANCE.mc.thePlayer.inventory.getCurrentItem() == null) {
			return;
		}
		if (!(Client.INSTANCE.mc.thePlayer.inventory.getCurrentItem().getItem() instanceof ItemFood)) {
			return;
		}
        if (Client.INSTANCE.mc.gameSettings.keyBindUseItem.isKeyDown()) {
            if (pack instanceof C03PacketPlayer) {
                Client.INSTANCE.sendPacketBypass(pack);
            }
        }
    }

}
