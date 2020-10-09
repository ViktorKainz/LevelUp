package at.htlkaindorf.levelup.items.magma;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MagmaIngot extends Item {
    public MagmaIngot(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);
    }
}
