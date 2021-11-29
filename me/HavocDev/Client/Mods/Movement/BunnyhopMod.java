package me.HavocDev.Client.Mods.Movement;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;

public class BunnyhopMod extends Mod{
	
	public BunnyhopMod()
	{
		super("bunnyhop", "Bunny Hop", "Auto jumps", Category.Movement, -999);
	}
	
	//Client.INSTANCE.player.moveForward != 0 ||
	//(Client.INSTANCE.player.moveStrafing != 0) &&
	
	public void onUpdate()
	{
		if(this.getActive())
		{
			//System.out.println(Client.INSTANCE.player.moveForward+"");
			if(Client.INSTANCE.mc.gameSettings.keyBindForward.isPressed() &&  !Client.INSTANCE.player.isSneaking() && Client.INSTANCE.player.onGround )
			{
				Client.INSTANCE.player.jump();
			}
		}
	}

}
