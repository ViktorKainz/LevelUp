package at.htlkaindorf.levelup.items.ender;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class EnderHoe extends ItemHoe {
    public EnderHoe(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
