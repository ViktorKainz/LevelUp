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
        this.buttonList.add(mButtonClose = new GuiButton(0, this.width / 2 - 100,
                this.height - (this.height / 4) + 10, "Close"));
        this.labelList.add(mLabel = new GuiLabel(fontRenderer, 1,
                this.width / 2 - 20, this.height / 2 + 40, 300, 10, 0xFFFFFF));
        mLabel.addLine("Test Line");
        this.drawWorldBackground(0x000000);

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
}