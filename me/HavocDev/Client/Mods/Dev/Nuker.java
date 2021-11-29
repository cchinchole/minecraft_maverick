package me.HavocDev.Client.Mods.Dev;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Utilities.ChatUtils;
import me.HavocDev.Client.Utilities.RenderUtils;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class Nuker extends Mod{

	private BlockPos sel;
	
public Nuker(){
	super("nuker", "Nuker", "Creative Mode Instant break", Category.World, -99);
}
public void onUpdate(){
	if(this.isActive){
		if(!Client.INSTANCE.player.capabilities.isCreativeMode)
		{
			ChatUtils.errorMessage("You must be in creative!");
			return;
		}

		int blocks = 5;
		
		for(int i = blocks; i > -blocks; i--)
			for(int j = blocks; j > -blocks; j--)
				for(int k = blocks; k > -blocks; k--)
				{
						double d = Client.INSTANCE.player.posX + (double)i;
						double d2 = Client.INSTANCE.player.posY + (double)j;
						double d3 = Client.INSTANCE.player.posZ + (double)k;
						  int k1 = (int)d;
	                        int l1 = (int)d2;
	                        int i2 = (int)d3;
	                        BlockPos p = new BlockPos(k1, l1, i2);
	                        Block j2 = Client.INSTANCE.world.getBlockState(p).getBlock();
	                        if(j2 != null && j2 != Blocks.air)
	                        {
	                			Client.INSTANCE.sendPacket(new C07PacketPlayerDigging(
	                				Action.START_DESTROY_BLOCK, p, EnumFacing.NORTH));
	                			Client.INSTANCE.sendPacket(
	                				new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, p, EnumFacing.NORTH));
	                        
	                        }
				}
		
		
		/*
		Iterable<BlockPos> validBlocks =
				BlockActionUtils.getValidBlocksByDistanceReversed(3, true,
					validator);
		validBlocks.forEach((pos) -> BlockActionUtils.breakBlockPacketSpam(pos));
}
	
	*/
	}
	
}

public void onRender()
{
	if(sel != null && this.isActive)
	RenderUtils.blockESP(sel, 0);
}
	
}
