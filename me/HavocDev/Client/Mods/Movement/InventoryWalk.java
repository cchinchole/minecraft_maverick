package me.HavocDev.Client.Mods.Movement;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Variables.Category;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

import java.util.Objects;

public class InventoryWalk extends Mod {

    public InventoryWalk()
    {
        super("iwalk", "Inventory Walk", "Walk while in inventory", Category.Movement, -99);
    }

    public void onUpdate()
    {

    	KeyBinding[] moveKeys = { Client.INSTANCE.mc.gameSettings.keyBindRight, Client.INSTANCE.mc.gameSettings.keyBindLeft,
    			Client.INSTANCE.mc.gameSettings.keyBindBack, Client.INSTANCE.mc.gameSettings.keyBindForward, Client.INSTANCE.mc.gameSettings.keyBindJump,
    			Client.INSTANCE.mc.gameSettings.keyBindSprint };
		if ((Client.INSTANCE.mc.currentScreen instanceof GuiContainer)) {
			KeyBinding[] array;
			int length = (array = moveKeys).length;
			for (int i = 0; i < length; i++) {
				KeyBinding key = array[i];
				key.pressed = Keyboard.isKeyDown(key.getKeyCode());
			}
		} else if (Objects.isNull(Client.INSTANCE.mc.currentScreen)) {
			KeyBinding[] array2;
			int length2 = (array2 = moveKeys).length;
			for (int j = 0; j < length2; j++) {
				KeyBinding bind = array2[j];
				if (!Keyboard.isKeyDown(bind.getKeyCode())) {
					KeyBinding.setKeyBindState(bind.getKeyCode(), false);
				}
			}
		}
    }

}
