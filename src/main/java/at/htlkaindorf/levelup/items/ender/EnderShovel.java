package at.htlkaindorf.levelup.items.ender;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class EnderShovel extends ItemSpade {

    public EnderShovel(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
