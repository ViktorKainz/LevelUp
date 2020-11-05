package at.htlkaindorf.levelup.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class Gui extends GuiScreen {
    private GuiButton mButtonClose;
    private GuiLabel mLabel;

    @Override
    public void initGui() {
        super.initGui();
        buttonList.add(mButtonClose = new GuiButton(0, width / 2 - 100,
                height - (height / 4) + 10, "Close"));
        labelList.add(mLabel = new GuiLabel(fontRenderer, 1,
                width / 2 - 20, height / 2 + 40, 300, 10, 0xFFFFFF));
        mLabel.addLine("Test Line");
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == mButtonClose) {
            mc.player.closeScreen();
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
