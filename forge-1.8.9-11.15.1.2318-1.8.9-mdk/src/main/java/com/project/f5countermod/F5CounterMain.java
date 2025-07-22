package com.project.f5countermod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;//NEEDED FOR DEBUG (ROW 43)
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = F5CounterMain.MODID, version = F5CounterMain.VERSION)
public class F5CounterMain {
    public static final String MODID = "f5counter";
    public static final String VERSION = "1.0";

    private boolean wasPressed = false;
    public static int counter = -1;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        Minecraft mc = Minecraft.getMinecraft();

        if (mc.thePlayer == null || mc.theWorld == null) return;

        KeyBinding f5Key = mc.gameSettings.keyBindTogglePerspective;

        if (f5Key.isKeyDown()) {
            if (!wasPressed) {
                counter++;
                //debug chat message
                //mc.thePlayer.addChatMessage(new ChatComponentText("You pressed: " + Keyboard.getKeyName(f5Key.getKeyCode()) + " (" + counter + " times)"));
                wasPressed = true;
            }
        } else {
            wasPressed = false;
        }
    }

    //Bind a numeric value to a variable to use it as the button id
    final Integer btnF5 = 1234;
    @SubscribeEvent
    public void onGuiDraw(GuiScreenEvent.DrawScreenEvent.Post event) {
        if (event.gui instanceof GuiInventory) {
            int x = 10; // left distance
            int y = 10; // top distance

            String text = "F5 pressed: " + counter + " times";

            Minecraft mc = Minecraft.getMinecraft();
            mc.fontRendererObj.drawStringWithShadow(text, x, y, 0xFFFFFF); // white
        }
    }
}