package at.htlkaindorf.levelup.items.ruby;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class RubyAxe extends ItemAxe {
    public RubyAxe(ToolMaterial material, String name) {
        super(material, 10.0F, 1.0F);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
