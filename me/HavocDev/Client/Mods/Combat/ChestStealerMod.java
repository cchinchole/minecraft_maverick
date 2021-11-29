package me.HavocDev.Client.Mods.Combat;

import java.util.ArrayList;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Runnables.ChestRaid;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.tileentity.TileEntityChest;

public class ChestStealerMod extends Mod {

    public ChestStealerMod() {
        super("cheststealer", "Chest Stealer", "Steal items from chest", Category.Combat, -99999);

        // TODO Auto-generated constructor stub
    }

    ArrayList<TileEntityChest> openedChests = new ArrayList<TileEntityChest>();
    private boolean stole = true;
    private ChestRaid chestraid;



    @Override
    public void onLateUpdate() {

        if(!this.isActive)
            return;

        if (Client.INSTANCE.mc.currentScreen instanceof GuiChest) {
        	
        	
        	
        	
        	if(chestraid == null || chestraid.hasStole)
        	{
           chestraid = new ChestRaid();
           chestraid.start();
        	}
        }
        
        
        
    }


}
