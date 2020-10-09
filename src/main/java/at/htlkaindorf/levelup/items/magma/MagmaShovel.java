package at.htlkaindorf.levelup.items.magma;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class MagmaShovel extends ItemSpade {

    public MagmaShovel(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
