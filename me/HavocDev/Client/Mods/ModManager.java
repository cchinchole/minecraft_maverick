package me.HavocDev.Client.Mods;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Events.Event;
import me.HavocDev.Client.Gui.Tab.TabGui;
import me.HavocDev.Client.Mods.Client.BypassMod;
import me.HavocDev.Client.Mods.Client.ProtocolMod;
import me.HavocDev.Client.Mods.Combat.AimbotMod;
import me.HavocDev.Client.Mods.Combat.AutoBlock;
import me.HavocDev.Client.Mods.Combat.ChestStealerMod;
import me.HavocDev.Client.Mods.Combat.CriticalsMod;
import me.HavocDev.Client.Mods.Combat.FastEatMod;
import me.HavocDev.Client.Mods.Combat.ForceFieldMod;
import me.HavocDev.Client.Mods.Combat.KillAuraMod;
import me.HavocDev.Client.Mods.Combat.ReachMod;
import me.HavocDev.Client.Mods.Combat.TimerMod;
import me.HavocDev.Client.Mods.Dev.Nuker;
import me.HavocDev.Client.Mods.Exploits.CrashServerMod;
import me.HavocDev.Client.Mods.Exploits.DropAllMod;
import me.HavocDev.Client.Mods.Exploits.GodMod;
import me.HavocDev.Client.Mods.Funny.SleepyMod;
import me.HavocDev.Client.Mods.Movement.AirHopMod;
import me.HavocDev.Client.Mods.Movement.BlinkMod;
import me.HavocDev.Client.Mods.Movement.BunnyhopMod;
import me.HavocDev.Client.Mods.Movement.FlyMod;
import me.HavocDev.Client.Mods.Movement.InventoryWalk;
import me.HavocDev.Client.Mods.Movement.JesusMod;
import me.HavocDev.Client.Mods.Movement.NofallMod;
import me.HavocDev.Client.Mods.Movement.SneakMod;
import me.HavocDev.Client.Mods.Movement.SpeedMod;
import me.HavocDev.Client.Mods.Movement.SprintMod;
import me.HavocDev.Client.Mods.Player.AntiFireMod;
import me.HavocDev.Client.Mods.Player.AutoToolMod;
import me.HavocDev.Client.Mods.Player.FastMineMod;
import me.HavocDev.Client.Mods.Player.FastPlaceMod;
import me.HavocDev.Client.Mods.Render.ArrayListMod;
import me.HavocDev.Client.Mods.Render.ChamsMod;
import me.HavocDev.Client.Mods.Render.ChestESPMod;
import me.HavocDev.Client.Mods.Render.ESPMod;
import me.HavocDev.Client.Mods.Render.FreecamMod;
import me.HavocDev.Client.Mods.Render.FullBrightMod;
import me.HavocDev.Client.Mods.Render.GuiColors;
import me.HavocDev.Client.Mods.Render.NameProtect;
import me.HavocDev.Client.Mods.Render.WaypointMod;
import me.HavocDev.Client.Mods.Render.WidgetMod;
import me.HavocDev.Client.Mods.Render.XRayMod;

public class ModManager {

	public ArrayList<Mod> mods;
	public boolean keyPresses = true;

	//Render
	public WidgetMod widgets = new WidgetMod();
	public FullBrightMod fullbright = new FullBrightMod();
	public ChestESPMod chestESP = new ChestESPMod();
	public ESPMod esp = new ESPMod();
	public ArrayListMod arraylist = new ArrayListMod();
	public FreecamMod freecam = new FreecamMod();
	public WaypointMod waypoints = new WaypointMod();
	public TabGui tabGUI = new TabGui();
	public ChamsMod wallhack = new ChamsMod();
	public XRayMod xray = new XRayMod();

	//Movement


	public SprintMod sprint = new SprintMod();
	public BlinkMod blink = new BlinkMod();
	public SpeedMod speedMod = new SpeedMod();
	public FlyMod fly = new FlyMod();
	public JesusMod jesus = new JesusMod();
	public AirHopMod airhop = new AirHopMod();
	public SneakMod sneak = new SneakMod();
	public NofallMod nofall = new NofallMod();
	public BunnyhopMod bunnyhop = new BunnyhopMod();
	public AimbotMod aimbot = new AimbotMod();

	//Exploits
	public DropAllMod drop = new DropAllMod();
	public GodMod god = new GodMod();
	public CrashServerMod crashserver = new CrashServerMod();

	//Combat

	public CriticalsMod criticals = new CriticalsMod();
	public ChestStealerMod cheststealer = new ChestStealerMod();
	public ForceFieldMod forceField = new ForceFieldMod();

	//World
	public TimerMod timer = new TimerMod();
	public ReachMod reach = new ReachMod();
	public Nuker nuker = new Nuker();


	//Player
	public FastMineMod fastMine = new FastMineMod();
	public FastPlaceMod fastPlace = new FastPlaceMod();
	public AntiFireMod fire = new AntiFireMod();
	public AutoToolMod autotool = new AutoToolMod();

	//Fun
	public SleepyMod sleepy = new SleepyMod();

	public BypassMod bypasses = new BypassMod();
	public ProtocolMod protocol = new ProtocolMod();

	public InventoryWalk inventorywalk = new InventoryWalk();
	public KillAuraMod killaura = new KillAuraMod();
	public AutoBlock autoblock = new AutoBlock();
	public FastEatMod fasteat = new FastEatMod();

	public NameProtect nameprotect = new NameProtect();


	public GuiColors colors = new GuiColors();
	

	/* Vanilla */



	public void changeMods(ArrayList<Mod> Modification)
	{
		this.mods.removeAll(this.mods);
			this.mods.addAll(Modification);
		for(int i = 0; i< mods.size(); i++)
			this.mods.get(i).setID(i);
	}


	public ModManager()
	{
		this.mods = new ArrayList();
	}
	
	public void fireEvent(Event event)
	{
		for(Mod m : mods)
		{
			m.onEvent(event);
		}
	}
	
	
	public void keyTyped(int i)
	{
		if(keyPresses)
		{
			if(i == Keyboard.KEY_RETURN && tabGUI.isActive)
				tabGUI.enterKey();
			if(i == Keyboard.KEY_UP & tabGUI.isActive)
				tabGUI.upKey();
			if(i == Keyboard.KEY_DOWN && tabGUI.isActive)
				tabGUI.downKey();
			if(i == Keyboard.KEY_LEFT && tabGUI.isActive)
				tabGUI.leftKey();
			if(i == Keyboard.KEY_RIGHT &&  tabGUI.isActive)
				tabGUI.rightKey();
			if(i == Keyboard.KEY_RSHIFT)
			{
				Client.INSTANCE.mc.displayGuiScreen(Client.INSTANCE.mc.guiHook.clickGUI);
			//	tabGUI.onToggle();
			}
							
			
			for(Mod m : mods)
			{
				if(m.getKeyBind() == i)
				{
					m.onToggle();
				}
			}
		}
	}
	
}
