package at.htlkaindorf.levelup.client.gui;

import at.htlkaindorf.levelup.client.gui.guiobject.RewardButton;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Gui extends GuiScreen {
    private GuiButton mButtonClose;
    private GuiButton mButtonFarming;
    private GuiButton mButtonCrafting;
    private GuiButton mButtonMining;
    private GuiButton mButtonWoodcutting;
    private GuiButton mButtonFighting;
    private GuiLabel mLabel;
    private List<RewardButton> buttons = new LinkedList<>();

    @Override
    public void initGui() {
        super.initGui();
        buttonList.add(mButtonFarming = new GuiButton(1,width/2-100,50, "Farming Skills"));
        buttonList.add(mButtonCrafting = new GuiButton(2,width/2-100, 150, "Crafting Skills"));
        buttonList.add(mButtonMining = new GuiButton(3,width/2-100, 250, "Mining Skills"));
        buttonList.add(mButtonWoodcutting = new GuiButton(4,width/2-100,350, "Woodcutting Skills"));
        buttonList.add(mButtonFighting = new GuiButton(5, width/2-100,450, "Fighting Skills"));
        buttonList.add(mButtonClose = new GuiButton(0,width/2-100,550, "Close"));
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
