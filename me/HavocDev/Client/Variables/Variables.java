package me.HavocDev.Client.Variables;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import me.HavocDev.Client.Bypass.Bypasses;
import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Gui.Click.ColorScheme;
import me.HavocDev.Client.Mods.Render.Waypoint;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;

public class Variables {

	public static int dropSpeed = 50;
	public static ArrayList<String> friends = new ArrayList();
	public static HashMap<String, String> friendNick = new HashMap<String, String>();
	public static ArrayList<String> admins = new ArrayList();
	public static HashMap<String, String> adminNick = new HashMap<String, String>();
	public static boolean fastSpeedActive = false;
	public static boolean XRay = false;
	public static boolean AutoTool = false;
	public static boolean RenderCoords = false;
	public static boolean RenderCoordsFriend = false;
	public static boolean Chams = false;
	public static boolean reach = false;
	public static ArrayList<Block> XRayBlock = new ArrayList<Block>();
	public static String[] RenderCoordsFriendNames = new String[3];
	public static int R = 128, B = 128, G = 128;
	
	public static boolean flightEnabled = false;

	public static float flight = 0.05f;

	public static float fastSpeed = .5f;

	public static float playerSpeed = 20f;
	
	//ESP Settings
	public static boolean renderPlayers = true;
	public static boolean renderItems = false;
	public static boolean renderMobs = false;
	
	
	//Criticals Settings
	public static int criticalsMode = 1;

	//Waypoint settings
	public static ArrayList<Waypoint>waypoints = new ArrayList();

	//Bypass Settings
	public static Bypasses.Bypass bypassSetting = Bypasses.Bypass.VANILLA;

	
	//Aura Settings
	
	
	public static boolean useCooldown = true;
	public static float auraRange = 5f;
	public static int auraFOV = 120;
	public static boolean targetFriends = false;
	public static boolean targetMobs = true;
	public static boolean targetAnimals = true;
	public static boolean targetInvisibleMobs = true;
	public static boolean targetThroughWall = false;
	public static boolean targetPlayers = true;
	public static boolean targetSleepingPlayer = false;
	public static boolean targetInvisiblePlayer = false;
	public static boolean targetGolem = false;
	public static boolean targetpigMan = false;
	
	public static int auraMode = 0;
	public static int auraSpeed = 7;
	
	
	public static ColorScheme defaultFA = new ColorScheme(new Color(255, 0, 255), new Color(0, 0, 0, 180), new Color(255, 0, 255, 180), new Color(0, 0, 0, 180), new Color(255, 255, 255));
	public static boolean updateColors = false;
	
	public static EntityPlayer target;
	

	public static void cc()
	{
		XRayBlock.clear();
		for(int i = 0; i < RenderCoordsFriendNames.length; i++)
			RenderCoordsFriendNames[i] = "";
	}
	
	public static boolean checkBlock(Block b)
	{
		if(XRayBlock.contains(b))
			return true;
		else
			return false;
	}
	
	public static String getName(String s)
	{
		String newString = s;
		
		
		if(newString.contains(Client.INSTANCE.player.getName()))
			newString = newString.replace(Client.INSTANCE.player.getName(), "You");
		else
		{
			for(String as : friends)
			{
				if(friendNick.containsKey(as))
				newString = newString.replace(as, friendNick.get(as));
			}
		}
		return newString;
	}
}
