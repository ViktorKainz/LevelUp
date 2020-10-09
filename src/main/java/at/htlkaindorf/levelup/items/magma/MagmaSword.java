package at.htlkaindorf.levelup.items.magma;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class MagmaSword extends ItemSword {

    public MagmaSword(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.COMBAT);
    }

}
