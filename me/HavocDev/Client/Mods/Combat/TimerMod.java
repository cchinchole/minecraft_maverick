package me.HavocDev.Client.Mods.Combat;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;

public class TimerMod extends Mod {

    public TimerMod()
    {
        super("timer", "Timer", "Set Minecraft's Time", Category.World, -99);
    }

    float prevTime = 0;

    public void onDisable()
    {
        Client.INSTANCE.mc.timer.timerSpeed = prevTime;
    }

    public void onEnable()
    {
        prevTime = Client.INSTANCE.mc.timer.timerSpeed;
        Client.INSTANCE.mc.timer.timerSpeed = 10f;
    }

}
