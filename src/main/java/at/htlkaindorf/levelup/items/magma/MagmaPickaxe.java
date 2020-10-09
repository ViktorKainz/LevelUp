package at.htlkaindorf.levelup.items.magma;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class MagmaPickaxe extends ItemPickaxe {
    public MagmaPickaxe(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
