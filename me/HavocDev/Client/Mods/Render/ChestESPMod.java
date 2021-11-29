package me.HavocDev.Client.Mods.Render;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Utilities.RenderUtils;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntitySign;

public class ChestESPMod extends Mod{

	public ChestESPMod() {
		super("chestesp", "Chest ESP", "Draws a box around chests in the world.", Category.Render, -999999);
	}
	
	public void onRender(float partialTicks)
	{
		if(this.getActive())
		{
			for(Object o : Client.INSTANCE.world.loadedTileEntityList)
			{
				if ( o instanceof TileEntityChest)
					//RenderUtils.drawBlockESP(((TileEntityChest) o).getPos().getX(), ((TileEntityChest) o).getPos().getY(), ((TileEntityChest) o).getPos().getZ(), 255, 0, 0, 255, 255, 255, 255, 255, 2);
					RenderUtils.blockESP(((TileEntityChest)o).getPos(), 3);
				else if(o instanceof TileEntityEnderChest)
					RenderUtils.blockESP(((TileEntityChest)o).getPos(), 2);
					
				}
			}
		}
	}
