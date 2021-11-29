package me.HavocDev.Client.Client;

import java.util.ArrayList;

import me.HavocDev.Client.Auth.Auth;
import me.HavocDev.Client.Bypass.Bypasses;
import me.HavocDev.Client.Commands.CommandManager;
import me.HavocDev.Client.Events.EntityLivingEvent;
import me.HavocDev.Client.Mods.ModManager;
import me.HavocDev.Client.Setting.SettingManager;
import me.HavocDev.Client.Utilities.ChatUtils;
import me.HavocDev.Client.Variables.Variables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.network.Packet;
import net.wurstclient.font.Fonts;

public enum Client {
	
	INSTANCE;
	
	/* Modifications to minecraft files */
	/*
	 * Minecraft.java
	 * 596: Gui Hook
	 * 625: Client.startClient();
	 * 2017: Added ModManager check key
	 * 
	 * 
	 * EntityPlayerSP.java
	 * 356: Added chatHook
	 * 887: Added EntityLivingEvent fire
	 * 
	 * 
	 * EntityRenderer.java
	 * 1477: Added RenderEvent fire
	 * 1478: Added color clear
	 * 
	 * 
	 * Render.java
	 * 365: Added nick system.
	 * 
	 * NetworkManager.java
	 * 181-184: Fire packet event
	 * 
	 * 
	 * PlayerControllerMP.java
	 * 335: Added condition for fast mine.
	 * 342: Added condition for fast mine.
	 *
	 *
	 * VertexBuffer.java
	 * 236: Added condition for xray.
	 * 316: Added condition for xray.
	 *
	 *
	 * Block.java
	 * 201: Added conditions for xray.
	 * 483: Added conditons for xray.
	 * 789-792 Added conditions for xray.
	 * 
	 * 
	 * GuiMainMenu
	 * GuiInGame
	 * 
	 * 
	 */
	
	
	private String clientName = "Labyrinth";
	private String modifierName = "R";
	private double clientVersion = 1.0;
	public ModManager modManager;
	public CommandManager commandManager;
	//public ValueManager valueManager;
	public SettingManager settingsManager;
	public Minecraft mc;
	public EntityPlayerSP player;
	public WorldClient world;
	public Auth aa = new Auth("https://localhost/checkvalid.php?id=", "valid");
	public boolean checkAuth = true;
	public boolean auth = false;;
    public int compatibility = 0;

    public boolean isAuthenticated()
	{
		return auth;
	}
	
	public String getClientName()
	{
		return clientName + " "+modifierName+clientVersion;
	}
	public ArrayList<String> changelog = new ArrayList<String>();

	public void addChangelog()
	{
		changelog.add("+ Aimbot");
		changelog.add("- Invicibiltiy");
	}
	
	public void sendPacket(Packet p)
	{
		player.sendQueue.addToSendQueue(p);
	}
	
	public void sendPacketBypass(Packet p)
	{
		player.sendQueue.addToSendQueueBypass(p);
	}
	
	public void updateeVars()
	{
		player = mc.thePlayer;
		world = mc.theWorld;
	}

	public void startClient()
	{
		/*
		if(checkAuth)
		{
		try {
			auth = aa.CheckAuth();
		} catch (IOException e) {
			auth = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}*/
		auth = true;
		addChangelog();
		mc = Minecraft.getMinecraft();
		modManager = new ModManager();
		commandManager = new CommandManager();
		settingsManager = new SettingManager();
		//valueManager = new ValueManager();
		Fonts.loadFonts();
		//guiManager = new GuiManager();
		//guiManager.setTheme(new IosTheme());
		//guiManager.setup();
		//friendGUI = new FriendGUIManager();
		//friendGUI.setTheme(new IosTheme());
		//friendGUI.setup();
		Variables.cc();
		modManager.changeMods(Bypasses.getBypasses(Bypasses.Bypass.VANILLA));
		mc.guiHook.clickGUI.initFrames();

		System.out.println(getClientName() + " has started!");
		/* Managers setup */
	}
	
	
	
	public boolean onSendChatMessage(String s)
	{
		if(s.startsWith(".") && s.endsWith(";"))
		{
			String input = s.substring(1);
			input = input.replaceAll(";", "");
			
			if(input.equalsIgnoreCase("checkauth"))
			{
				if(player.getName().toLowerCase().contains("havocdev") || player.getName().equalsIgnoreCase("subject087") || player.getName().equalsIgnoreCase("jackson613"))
				{
		    	ChatUtils.addChatMessage("Access Granted!");
		    	Client.INSTANCE.checkAuth = false;
		    	Client.INSTANCE.auth = true;
		    	Client.INSTANCE.startClient();
		    	}
		    	return false;
			}
			if(isAuthenticated())
			{
			commandManager.callCommand(input);
			return false;
			}
		}
		return true;
	}

}
