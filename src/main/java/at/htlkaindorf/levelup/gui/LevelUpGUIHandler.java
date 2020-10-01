package at.htlkaindorf.levelup.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class LevelUpGUIHandler implements IGuiHandler
{

    public static final int LEVELUP_GUI = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }


    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == LEVELUP_GUI)
        {
            return new GuiLevelUp();
        }
        return null;
    }
}
