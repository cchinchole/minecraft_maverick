package me.HavocDev.Client.Mods.Movement;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;

public class AirHopMod extends Mod {
    public AirHopMod() {
        super("airhop", "Air Hop", " Allows you to hop in the air.", Category.Movement, -99);
    }

    public void onUpdate()
    {
        if(!this.isActive)
            return;

        if(Client.INSTANCE.mc.gameSettings.keyBindJump.isPressed())
            Client.INSTANCE.player.motionY = 1.0f;
    }

}
