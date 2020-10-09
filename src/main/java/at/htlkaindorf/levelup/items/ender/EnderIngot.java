package at.htlkaindorf.levelup.items.ender;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EnderIngot extends Item {
    public EnderIngot(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}