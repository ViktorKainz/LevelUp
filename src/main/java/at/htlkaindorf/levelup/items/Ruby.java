package at.htlkaindorf.levelup.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Ruby extends Item {
    public Ruby(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MISC);
    }
}
