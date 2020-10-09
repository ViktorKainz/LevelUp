package at.htlkaindorf.levelup.items.ender;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class EnderAxe extends ItemAxe {
    public EnderAxe(ToolMaterial material, String name) {
        super(material, 10.0F, 1.0F);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
