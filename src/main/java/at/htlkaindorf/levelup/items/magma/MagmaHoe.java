package at.htlkaindorf.levelup.items.magma;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class MagmaHoe extends ItemHoe {
    public MagmaHoe(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
