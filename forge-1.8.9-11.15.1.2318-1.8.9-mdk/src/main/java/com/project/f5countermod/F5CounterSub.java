package com.project.f5countermod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class F5CounterSub extends GuiScreen {
    public void F5CounterGui() {

    }

    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 2 - 40, this.height / 2 + 20, 80, 20, "Chiudi"));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0) {
            this.mc.displayGuiScreen(null);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawCenteredString(this.fontRendererObj,
                "Hai premuto " + F5CounterMain.counter + " volte il tasto F5 ",
                this.width / 2, this.height / 2 - 20, 0xFFFFFF);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
