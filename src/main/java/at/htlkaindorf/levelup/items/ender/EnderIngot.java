package at.htlkaindorf.levelup.items.ender;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EnderIngot extends Item {
    public EnderIngot(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);
    }
}
