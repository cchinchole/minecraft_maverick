package me.HavocDev.Client.Mods.Movement;

import java.util.ArrayList;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Events.PacketOutputEvent;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;

public class BlinkMod extends Mod{

	public BlinkMod() {
		super("blink", "Blink", " Allows you to teleport up to 20blocks from origin ", Category.Movement, -99);
	}
	
	ArrayList<Packet> lostPackets = new ArrayList();
	//private EntityOtherPlayerMP foobarPlayer = null;
	long blinkTime, lastTime;
	public boolean autoBlink = false;

	private long delay = 1500L;
	private long last = System.nanoTime() / 1000000L;


private EntityFakePlayer fakePlayer;
	
	public void onEnable()
	{
		lastTime = System.currentTimeMillis();
		//foobarPlayer = new EntityOtherPlayerMP(Client.INSTANCE.mc.world, Client.INSTANCE.player.getGameProfile());
	//	foobarPlayer.clonePlayer(Client.INSTANCE.player, true);
		//foobarPlayer.copyLocationAndAnglesFrom(Client.INSTANCE.player);
	//	foobarPlayer.rotationYawHead = Client.INSTANCE.player.rotationYawHead;
	//	Client.INSTANCE.mc.world.addEntityToWorld(foobarID, foobarPlayer);
		last = System.nanoTime() / 1000000L;




		fakePlayer = new EntityFakePlayer();



	}
	
	int abs = 0;
	public void onDisable()
	{
		//foobarPlayer = null;
		fakePlayer.despawn();
		//fakePlayer = null;
		blinkTime = 0;
		abs = 0;
		for(Packet p : lostPackets)
		{
			Client.INSTANCE.sendPacket(p);
		}
		lostPackets.clear();

	}



	public void onUpdate() {

		if (!this.isActive || fakePlayer == null)
			return;

	}
	
	public void onPacket(Packet pack)
	{
		if(pack instanceof C03PacketPlayer && this.getActive())
		{
			if(pack instanceof C03PacketPlayer.C04PacketPlayerPosition || pack instanceof C03PacketPlayer.C06PacketPlayerPosLook)
			{
				blinkTime += System.currentTimeMillis() - lastTime;
				lostPackets.add(pack);
			}

			( (PacketOutputEvent)this.event ).isAlive = false;





			lastTime = System.currentTimeMillis();
					this.setName("Blink [ "+blinkTime+ " ]");
		}
	}

}
