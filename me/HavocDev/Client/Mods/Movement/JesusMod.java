package me.HavocDev.Client.Mods.Movement;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Events.PacketOutputEvent;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.util.BlockPos;

public class JesusMod extends Mod {

    public JesusMod()
    {
        super("jesus", "Jesus", "Walk on water", Category.Movement, -99);
    }


	@Override
	public void onEnable() {
		this.reset();
		super.onEnable();
	}
	

	public static Block getBlock(BlockPos pos) {
		return Client.INSTANCE.world.getBlockState(pos).getBlock();
	}
	
	public Block getBlockRelativeToEntity(Entity en, double d) {
		return getBlock(new BlockPos(en.posX, en.posY + d, en.posZ));
	}
	
  public void onPacket(Packet pack)
  {
		if (pack instanceof C03PacketPlayer) {
			if (Client.INSTANCE.mc.gameSettings.keyBindJump.pressed) {
				if (getBlockRelativeToEntity(Client.INSTANCE.player, -0.1).getMaterial() == Material.water) {
					System.out.println("aaa");
					// Jigsaw.chatMessage("LOL");
					((PacketOutputEvent)event).cancel();
					C06PacketPlayerPosLook playerPacket = new C06PacketPlayerPosLook();
					playerPacket.rotating = true;
					playerPacket.moving = true;
					playerPacket.x = Client.INSTANCE.player.posX;
					playerPacket.y = Client.INSTANCE.player.posY - 0.005;
					playerPacket.z = Client.INSTANCE.player.posZ;
					playerPacket.onGround = Client.INSTANCE.player.onGround;
					playerPacket.yaw = Client.INSTANCE.player.rotationYaw;
					playerPacket.pitch = Client.INSTANCE.player.rotationPitch;
					Client.INSTANCE.sendPacketBypass(playerPacket);
				}
			} else {
				if (getBlockRelativeToEntity(Client.INSTANCE.player, -0.1).getMaterial() == Material.water
						&& this.hasTimeElapsed(100, false)) {
					// Jigsaw.chatMessage("LOL");
					((PacketOutputEvent)event).cancel();
					C06PacketPlayerPosLook playerPacket = new C06PacketPlayerPosLook();
					playerPacket.rotating = true;
					playerPacket.moving = true;
					playerPacket.x = Client.INSTANCE.player.posX;
					playerPacket.y = Client.INSTANCE.player.posY - 0.005;
					playerPacket.z = Client.INSTANCE.player.posZ;
					playerPacket.onGround = Client.INSTANCE.player.onGround;
					playerPacket.yaw = Client.INSTANCE.player.rotationYaw;
					playerPacket.pitch = Client.INSTANCE.player.rotationPitch;
					Client.INSTANCE.sendPacketBypass(playerPacket);
					this.reset();
				}
			}
			if (getBlockRelativeToEntity(Client.INSTANCE.player, 0.1).getMaterial() != Material.water) {

			}

		}
  }


    public boolean isOverLiquid()
    {
        boolean foundLiquid = false;
        boolean foundSolid = false;

        // check collision boxes below player
        for(net.minecraft.util.AxisAlignedBB bb :Client.INSTANCE.world.getCollidingBoundingBoxes(
                Client.INSTANCE.player,
                Client.INSTANCE.player.boundingBox.offset(0, -0.5, 0)))
        {
        	
            BlockPos pos = new BlockPos(bb.getCenter());
            Material material = Client.INSTANCE.world.getBlockState(pos).getBlock().getMaterial();

            if(material == Material.water || material == Material.lava)
                foundLiquid = true;
            else if(material != Material.air)
                foundSolid = true;
        }

        return foundLiquid && !foundSolid;
    }

    public boolean shouldBeSolid()
    {
        return this.isActive && Client.INSTANCE.player != null
                && Client.INSTANCE.player.fallDistance <= 3
                && !Client.INSTANCE.mc.gameSettings.keyBindSneak.isPressed()
                && !Client.INSTANCE.player.isInWater();
    }



}
