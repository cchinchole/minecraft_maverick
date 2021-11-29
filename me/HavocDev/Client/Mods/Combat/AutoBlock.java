package me.HavocDev.Client.Mods.Combat;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class AutoBlock extends Mod{
	
	public AutoBlock()
	{
		super("autoblock", "Auto Block", "Block Automatically", Category.Combat, -99);
	}
	
	public void onUpdate()
	{

		if(Client.INSTANCE.player.inventory.getCurrentItem() == null) {
			return;
		}
		
		if(!Client.INSTANCE.modManager.killaura.doBlock())
			return;
		
		Client.INSTANCE.mc.playerController.sendUseItem(Client.INSTANCE.player, Client.INSTANCE.world, Client.INSTANCE.player.getHeldItem());
		Client.INSTANCE.player.setItemInUse(Client.INSTANCE.player.getHeldItem(),
				Client.INSTANCE.player.getHeldItem().getMaxItemUseDuration());
	}
	
	public static void startBlock() {
		if(Client.INSTANCE.player.isBlocking()) {
			Client.INSTANCE.mc.playerController.sendUseItem(Client.INSTANCE.player, Client.INSTANCE.world, Client.INSTANCE.player.getHeldItem());
			Client.INSTANCE.player.setItemInUse(Client.INSTANCE.player.getHeldItem(),
					Client.INSTANCE.player.getHeldItem().getMaxItemUseDuration());
		}
	}

	public static void stopBlock() {
		if(Client.INSTANCE.player.isBlocking()) {
			Client.INSTANCE.sendPacketBypass(new C07PacketPlayerDigging(Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.UP));
		}
	}

}
