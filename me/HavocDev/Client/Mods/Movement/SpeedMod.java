package me.HavocDev.Client.Mods.Movement;

import me.HavocDev.Client.Bypass.Bypasses;
import me.HavocDev.Client.Bypass.Bypasses.Bypass;
import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Events.PreMotionEvent;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.MovementInput;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpeedMod extends Mod{
	

	public SpeedMod()
	{
		super("speed", "Speed", "Run Quickly", Category.Movement, -9999);
	}


	private double moveSpeedVanilla;
	private double speed;
	private int stage;
	private double moveSpeed;
	private double lastDist;



	@Override
	public void onToggle() {
		reset();
		this.moveSpeed = getBaseMoveSpeed();
		speed = 1;
		this.stage = 2;
		super.onToggle();
	}

	
	public void onPreMotion()
	{

		if(!this.isActive)
			return;

		if(Bypasses.selected == Bypass.VANILLA)
		{
		MovementInput movementInput = Client.INSTANCE.player.movementInput;
		this.moveSpeedVanilla = Variables.playerSpeed / 20;
		float forward = movementInput.moveForward;
		float strafe =  movementInput.moveStrafe;
		float yaw = Minecraft.getMinecraft().thePlayer.rotationYaw;
		if ((forward == 0.0F) && (strafe == 0.0F)) {
			((PreMotionEvent)event).x = 0.0D;
			((PreMotionEvent)event).z = 0.0D;
		} else if (forward != 0.0F) {
			if (strafe >= 1.0F) {
				yaw += (forward > 0.0F ? -45 : 45);
				strafe = 0.0F;
			} else if (strafe <= -1.0F) {
				yaw += (forward > 0.0F ? 45 : -45);
				strafe = 0.0F;
			}
			if (forward > 0.0F) {
				forward = 1.0F;
			} else if (forward < 0.0F) {
				forward = -1.0F;
			}
		}
		double mx = Math.cos(Math.toRadians(yaw + 90.0F));
		double mz = Math.sin(Math.toRadians(yaw + 90.0F));
		((PreMotionEvent)event).x = (forward * this.moveSpeedVanilla * mx + strafe * this.moveSpeedVanilla * mz);
		((PreMotionEvent)event).z = (forward * this.moveSpeedVanilla * mz - strafe * this.moveSpeedVanilla * mx);
		}
		else if(Bypasses.selected == Bypass.NCP)
		{
			if (Client.INSTANCE.player.isInWater() || Client.INSTANCE.player.isInLava()) {
				return;
			}
			
			System.out.println("AA");
			
			MovementInput movementInput = Client.INSTANCE.player.movementInput;
			float forward = movementInput.moveForward;
			float strafe = movementInput.moveStrafe;
			float yaw = Minecraft.getMinecraft().thePlayer.rotationYaw;
			if ((this.stage == 1) && ((Client.INSTANCE.player.moveForward != 0.0F) || (Client.INSTANCE.player.moveStrafing != 0.0F))) {
				this.stage = 2;
				this.moveSpeed = (1.38D * getBaseMoveSpeed() - 0.01D);
			} else if (this.stage == 2) {
				this.stage = 3;
				((PreMotionEvent)event).y = 0.399399995803833D;
				this.moveSpeed *= 2.149D;
			} else if (this.stage == 3) {
				this.stage = 4;
				double difference = 0.66D * (this.lastDist - getBaseMoveSpeed());
				this.moveSpeed = (this.lastDist - difference);
				if (((forward != 0.0F) || (strafe != 0.0F)) && !Client.INSTANCE.mc.gameSettings.keyBindJump.pressed) {
					((PreMotionEvent)event).y = -0.4;
					// Client.INSTANCE.player.motionY = -1;
					stage = 2;
				}
			} else {
				if ((Client.INSTANCE.world.getCollidingBoundingBoxes(Client.INSTANCE.player,
						Client.INSTANCE.player.boundingBox.offset(0.0D, Client.INSTANCE.player.motionY, 0.0D), true).size() > 0)
						|| (Client.INSTANCE.player.isCollidedVertically)) {
					this.stage = 1;
				}
				this.moveSpeed = (this.lastDist - this.lastDist / 159.0D);
			}

			this.moveSpeed = Math.max(this.moveSpeed, getBaseMoveSpeed());
			if ((forward == 0.0F) && (strafe == 0.0F)) {
				((PreMotionEvent)event).x = 0.0D;
				((PreMotionEvent)event).z = 0.0D;
			} else if (forward != 0.0F) {
				if (strafe >= 1.0F) {
					yaw += (forward > 0.0F ? -45 : 45);
					strafe = 0.0F;
				} else if (strafe <= -1.0F) {
					yaw += (forward > 0.0F ? 45 : -45);
					strafe = 0.0F;
				}
				if (forward > 0.0F) {
					forward = 1.0F;
				} else if (forward < 0.0F) {
					forward = -1.0F;
				}
			}
			double mx = Math.cos(Math.toRadians(yaw + 90.0F));
			double mz = Math.sin(Math.toRadians(yaw + 90.0F));
			((PreMotionEvent)event).x = (forward * this.moveSpeed * mx + strafe * this.moveSpeed * mz);
			((PreMotionEvent)event).z = (forward * this.moveSpeed * mz - strafe * this.moveSpeed * mx);
		}
		
	/*

	if(Client.INSTANCE.player.moveForward != 0.0)
		System.out.println(Client.INSTANCE.player.moveForward);

		if(this.isActive)
		{
			// return if sneaking or not walking
			if(Client.INSTANCE.player.isSneaking()
				||!Client.INSTANCE.mc.gameSettings.keyBindForward.isPressed()
					&& Client.INSTANCE.mc.gameSettings.keyBindLeft.isPressed() || Client.INSTANCE.mc.gameSettings.keyBindRight.isPressed())
				return;
			
			// activate sprint if walking forward
			if(Client.INSTANCE.mc.gameSettings.keyBindForward.isPressed()
				&& !Client.INSTANCE.player.isCollidedHorizontally)
				Client.INSTANCE.player.setSprinting(true);
			
			// activate mini jump if on ground
			if(Client.INSTANCE.player.onGround)
			{
				Client.INSTANCE.player.motionY += 0.1;
				Client.INSTANCE.player.motionX *= 1.8;
				Client.INSTANCE.player.motionZ *= 1.8;
				double currentSpeed =
					Math.sqrt(Math.pow(Client.INSTANCE.player.motionX, 2)
						+ Math.pow(Client.INSTANCE.player.motionZ, 2));
				
				// limit speed to highest value that works on NoCheat+ version
				// 3.13.0-BETA-sMD5NET-b878
				// UPDATE: Patched in NoCheat+ version 3.13.2-SNAPSHOT-sMD5NET-b888
				double maxSpeed = 0.66f;//Variables.playerSpeed;//0.66F;
				if(currentSpeed > maxSpeed)
				{
					Client.INSTANCE.player.motionX =
							Client.INSTANCE.player.motionX / currentSpeed * maxSpeed;
					Client.INSTANCE.player.motionZ =
							Client.INSTANCE.player.motionZ / currentSpeed * maxSpeed;
				}
	}

		}
*/

	}
	
	private double getBaseMoveSpeed() {
		double baseSpeed = 0.2873D;
		if (Client.INSTANCE.player.isPotionActive(Potion.moveSpeed)) {
			int amplifier = Client.INSTANCE.player.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
			baseSpeed *= (1.0D + 0.2D * (amplifier + 1));
		}
		return baseSpeed;
	}

	public static double round(double value, int places) {
		if (places < 0) {
			throw new IllegalArgumentException();
		}
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public void onLateUpdate() {

		if(!this.isActive)
			return;

		double xDist = Client.INSTANCE.player.posX - Client.INSTANCE.player.prevPosX;
		double zDist =  Client.INSTANCE.player.posZ - Client.INSTANCE.player.prevPosZ;
		this.lastDist = Math.sqrt(xDist * xDist + zDist * zDist);
	}

}
