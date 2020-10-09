package at.htlkaindorf.levelup.items.magma;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class MagmaAxe extends ItemAxe {
    public MagmaAxe(ToolMaterial material, String name) {
        super(material, 10.0F, 1.0F);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
