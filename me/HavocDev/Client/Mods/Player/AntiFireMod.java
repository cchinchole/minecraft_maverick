package me.HavocDev.Client.Mods.Player;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.network.play.client.C03PacketPlayer;

public class AntiFireMod extends Mod{

    public AntiFireMod() {
        super("antifire", "Anti Fire", "Removes burning effects when on ground.", Category.Player, -99);
    }

    public void onUpdate()
    {
        if(this.isActive && Client.INSTANCE.player.isBurning() && !Client.INSTANCE.player.capabilities.isCreativeMode && Client.INSTANCE.player.onGround)
        {
            System.out.println("aaa");
            for (int i = 0; i < 100; i++) {
            Client.INSTANCE.player.sendQueue.addToSendQueue(new C03PacketPlayer(true));
        }
        }
    }

}
