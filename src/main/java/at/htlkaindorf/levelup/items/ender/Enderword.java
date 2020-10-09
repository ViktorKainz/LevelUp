package at.htlkaindorf.levelup.items.ender;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class Enderword extends ItemSword {

    public Enderword(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.COMBAT);
    }

}
