package me.HavocDev.Client.Runnables;

import me.HavocDev.Client.Bypass.Bypasses;
import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import net.minecraft.util.BlockPos;

public class ChestRaid implements Runnable{
	
	Thread t;
	public boolean alive = true;
	public boolean hasStole = false;
	public void run(){
			 GuiChest chest = (GuiChest) Client.INSTANCE.mc.currentScreen;
	            //chest.steal();
	            
	        	for (int ii = 0; ii < chest.inventoryRows * 9; ii++) {
	    			Slot s = chest.inventorySlots.inventorySlots.get(ii);
	    			if (s.getStack() == null) {
	    				continue;
	    			}
	    			
	    			
	    			chest.handleMouseClick(s, s.slotNumber, 0, 1);
	    			
	    			if(Bypasses.selected == Bypasses.Bypass.NCP)
		    			try {
		    				Thread.sleep(65);
		    			} catch (InterruptedException e) {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
		    			
	    			
	    			chest.handleMouseClick(s, s.slotNumber, 0, 6);
	    			
	    			if(Bypasses.selected == Bypasses.Bypass.NCP)
		    			try {
		    				Thread.sleep(65);
		    			} catch (InterruptedException e) {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
	    		}
	            
	            
	            if(chest.isEmpty()) {
	                Client.INSTANCE.player.closeScreen();
	            }
	            hasStole = true;
	}
	
	public void start()
	{
		if(t == null)
		{
			t = new Thread(this, "akbar");
			t.start();
		}
	}

}
