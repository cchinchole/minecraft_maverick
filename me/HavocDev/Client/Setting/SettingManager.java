package me.HavocDev.Client.Setting;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Setting.Aimbot.AimbotCursorDistanceSetting;
import me.HavocDev.Client.Setting.Aimbot.AimbotSmoothLevelSetting;
import me.HavocDev.Client.Setting.Aimbot.aimbotDistanceSetting;
import me.HavocDev.Client.Setting.Aura.auraFOVSetting;
import me.HavocDev.Client.Setting.Aura.auraModeSetting;
import me.HavocDev.Client.Setting.Aura.auraRangeSetting;
import me.HavocDev.Client.Setting.Aura.auraSpeedSetting;
import me.HavocDev.Client.Setting.Aura.auraUseCooldownSetting;
import me.HavocDev.Client.Setting.Aura.criticalModeSetting;
import me.HavocDev.Client.Setting.Aura.targetAnimalsSetting;
import me.HavocDev.Client.Setting.Aura.targetFriendsSetting;
import me.HavocDev.Client.Setting.Aura.targetGolemSetting;
import me.HavocDev.Client.Setting.Aura.targetInvisiblePlayerSetting;
import me.HavocDev.Client.Setting.Aura.targetMobsSetting;
import me.HavocDev.Client.Setting.Aura.targetPlayersSetting;
import me.HavocDev.Client.Setting.Aura.targetSleepingPlayerSetting;
import me.HavocDev.Client.Setting.Aura.targetThroughWallSetting;
import me.HavocDev.Client.Setting.Aura.targetZombiePigManSetting;
import me.HavocDev.Client.Setting.Blink.BlinkModeSetting;
import me.HavocDev.Client.Setting.Bypass.bypassModeSetting;
import me.HavocDev.Client.Setting.Drop.DropAllSetting;
import me.HavocDev.Client.Setting.ESP.renderItemSetting;
import me.HavocDev.Client.Setting.ESP.renderMobsSetting;
import me.HavocDev.Client.Setting.ESP.renderPlayersSetting;
import me.HavocDev.Client.Setting.FastBreak.FastMineSetting;
import me.HavocDev.Client.Setting.Fly.FlightSpeedSetting;
import me.HavocDev.Client.Setting.Fly.FreecamModeSetting;
import me.HavocDev.Client.Setting.GUI.ComponentForegroundBlueSetting;
import me.HavocDev.Client.Setting.GUI.ComponentForegroundGreenSetting;
import me.HavocDev.Client.Setting.GUI.ComponentForegroundRedSetting;
import me.HavocDev.Client.Setting.GUI.FormBackgroundBlueSetting;
import me.HavocDev.Client.Setting.GUI.FormBackgroundGreenSetting;
import me.HavocDev.Client.Setting.GUI.FormBackgroundRedSetting;
import me.HavocDev.Client.Setting.GUI.FormForegroundBlueSetting;
import me.HavocDev.Client.Setting.GUI.FormForegroundGreenSetting;
import me.HavocDev.Client.Setting.GUI.FormForegroundSetting;
import me.HavocDev.Client.Setting.GUI.TextBlueSetting;
import me.HavocDev.Client.Setting.GUI.TextGreenSetting;
import me.HavocDev.Client.Setting.GUI.TextRedSetting;
import me.HavocDev.Client.Setting.Protcol.protocolModeSetting;
import me.HavocDev.Client.Setting.Speed.SpeedSetting;

public class SettingManager {
	
	public SettingManager()
	{

		Client.INSTANCE.modManager.criticals.addSeting(new criticalModeSetting());
		
		Client.INSTANCE.modManager.fastMine.addSeting(new FastMineSetting());
		
		Client.INSTANCE.modManager.drop.addSeting(new DropAllSetting());
		
		Client.INSTANCE.modManager.speedMod.addSeting(new SpeedSetting());

		auraRangeSetting auraRange = new auraRangeSetting();
		auraModeSetting auraMode = new auraModeSetting();
		auraSpeedSetting auraSpeed = new auraSpeedSetting();
		
		Client.INSTANCE.modManager.forceField.addSeting(new auraFOVSetting());
		Client.INSTANCE.modManager.forceField.addSeting(auraRange);
		Client.INSTANCE.modManager.forceField.addSeting(new auraUseCooldownSetting());
		Client.INSTANCE.modManager.forceField.addSeting(new targetAnimalsSetting());
		Client.INSTANCE.modManager.forceField.addSeting(new targetFriendsSetting());
		Client.INSTANCE.modManager.forceField.addSeting(new targetGolemSetting());
		Client.INSTANCE.modManager.forceField.addSeting(new targetInvisiblePlayerSetting());
		Client.INSTANCE.modManager.forceField.addSeting(new targetMobsSetting());
		Client.INSTANCE.modManager.forceField.addSeting(new targetZombiePigManSetting());
		Client.INSTANCE.modManager.forceField.addSeting(new targetPlayersSetting());
		Client.INSTANCE.modManager.forceField.addSeting(new targetSleepingPlayerSetting());
		Client.INSTANCE.modManager.forceField.addSeting(new targetThroughWallSetting());
		

		Client.INSTANCE.modManager.esp.addSeting(new renderPlayersSetting());
		Client.INSTANCE.modManager.esp.addSeting(new renderMobsSetting());
		Client.INSTANCE.modManager.esp.addSeting(new renderItemSetting());

		FlightSpeedSetting flightSpeed = new FlightSpeedSetting();
		Client.INSTANCE.modManager.fly.addSeting(flightSpeed);
		Client.INSTANCE.modManager.freecam.addSeting(flightSpeed);

		Client.INSTANCE.modManager.blink.addSeting(new BlinkModeSetting());

		Client.INSTANCE.modManager.freecam.addSeting(new FreecamModeSetting());
		Client.INSTANCE.modManager.bypasses.addSeting(new bypassModeSetting());


		Client.INSTANCE.modManager.protocol.addSeting(new protocolModeSetting());
		

		Client.INSTANCE.modManager.aimbot.addSeting(new AimbotCursorDistanceSetting());
		Client.INSTANCE.modManager.aimbot.addSeting(new aimbotDistanceSetting());
		Client.INSTANCE.modManager.aimbot.addSeting(new AimbotSmoothLevelSetting());
		
		Client.INSTANCE.modManager.killaura.addSeting(auraRange);
		Client.INSTANCE.modManager.killaura.addSeting(auraMode);
		Client.INSTANCE.modManager.killaura.addSeting(auraSpeed);
		

		//Client.INSTANCE.modManager.colors.addSeting(new ComponentBackgroundBlueSetting());
		//Client.INSTANCE.modManager.colors.addSeting(new ComponentBackgroundGreenSetting());
		//Client.INSTANCE.modManager.colors.addSeting(new ComponentBackgroundRedSetting());
		Client.INSTANCE.modManager.colors.addSeting(new TextBlueSetting());
		Client.INSTANCE.modManager.colors.addSeting(new TextGreenSetting());
		Client.INSTANCE.modManager.colors.addSeting(new TextRedSetting());
		Client.INSTANCE.modManager.colors.addSeting(new ComponentForegroundBlueSetting());
		Client.INSTANCE.modManager.colors.addSeting(new ComponentForegroundGreenSetting());
		Client.INSTANCE.modManager.colors.addSeting(new ComponentForegroundRedSetting());
		Client.INSTANCE.modManager.colors.addSeting(new FormBackgroundBlueSetting());
		Client.INSTANCE.modManager.colors.addSeting(new FormBackgroundGreenSetting());
		Client.INSTANCE.modManager.colors.addSeting(new FormBackgroundRedSetting());
		Client.INSTANCE.modManager.colors.addSeting(new FormForegroundBlueSetting());
		Client.INSTANCE.modManager.colors.addSeting(new FormForegroundGreenSetting());
		Client.INSTANCE.modManager.colors.addSeting(new FormForegroundSetting());


	}

}
