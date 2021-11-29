package me.HavocDev.Client.Bypass;

import me.HavocDev.Client.Bypass.Bypasses.Bypass;
import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;

import java.util.ArrayList;

public class Bypasses {

    public enum Bypass{
        NCP_OLD, NCP, WATCHDOG, MINEPLEX, VANILLA,
    }

	public static Bypass selected = Bypass.VANILLA;

    public static ArrayList<Mod> getBypasses(Bypass s)
    {

        ArrayList<Mod> mods = new ArrayList();

        selected = s;

        mods.add(Client.INSTANCE.modManager.chestESP);
        mods.add(Client.INSTANCE.modManager.fullbright);
        mods.add(Client.INSTANCE.modManager.wallhack);
        mods.add(Client.INSTANCE.modManager.tabGUI);
        mods.add(Client.INSTANCE.modManager.waypoints);
        mods.add(Client.INSTANCE.modManager.arraylist);
        mods.add(Client.INSTANCE.modManager.xray);
        mods.add(Client.INSTANCE.modManager.esp);
        mods.add(Client.INSTANCE.modManager.widgets);
        mods.add(Client.INSTANCE.modManager.autotool);
        mods.add(Client.INSTANCE.modManager.bypasses);
        mods.add(Client.INSTANCE.modManager.inventorywalk);
        mods.add(Client.INSTANCE.modManager.protocol);
        mods.add(Client.INSTANCE.modManager.aimbot);
        mods.add(Client.INSTANCE.modManager.killaura);
        mods.add(Client.INSTANCE.modManager.sprint);
        mods.add(Client.INSTANCE.modManager.blink);
        mods.add(Client.INSTANCE.modManager.fastPlace);
        mods.add(Client.INSTANCE.modManager.criticals);
        mods.add(Client.INSTANCE.modManager.freecam);
        mods.add(Client.INSTANCE.modManager.sleepy);
        mods.add(Client.INSTANCE.modManager.fire);
        mods.add(Client.INSTANCE.modManager.forceField);
        mods.add(Client.INSTANCE.modManager.bunnyhop);
        mods.add(Client.INSTANCE.modManager.drop);
        mods.add(Client.INSTANCE.modManager.autoblock);
        mods.add(Client.INSTANCE.modManager.nameprotect);
        mods.add(Client.INSTANCE.modManager.colors);

        switch(s)
        {
            case NCP:
            	/*
            	 *
            	 * 
            	 */
                mods.add(Client.INSTANCE.modManager.cheststealer);
                //mods.add(Client.INSTANCE.modManager.speedMod);
                break;
            case VANILLA:
                mods.add(Client.INSTANCE.modManager.cheststealer);
                mods.add(Client.INSTANCE.modManager.sneak);
                mods.add(Client.INSTANCE.modManager.nofall);
                mods.add(Client.INSTANCE.modManager.fastMine);
                mods.add(Client.INSTANCE.modManager.speedMod);
                mods.add(Client.INSTANCE.modManager.nuker);
                mods.add(Client.INSTANCE.modManager.fly);
                mods.add(Client.INSTANCE.modManager.reach);
                mods.add(Client.INSTANCE.modManager.god);
                mods.add(Client.INSTANCE.modManager.jesus);
                mods.add(Client.INSTANCE.modManager.airhop);
                mods.add(Client.INSTANCE.modManager.timer);
                mods.add(Client.INSTANCE.modManager.fasteat);
                mods.add(Client.INSTANCE.modManager.crashserver);
                break;
            case MINEPLEX:
                mods.add(Client.INSTANCE.modManager.fasteat);
                break;
            case WATCHDOG:
                mods.add(Client.INSTANCE.modManager.fasteat);
                break;
            default:
                break;
        }

        return mods;

    }


}
