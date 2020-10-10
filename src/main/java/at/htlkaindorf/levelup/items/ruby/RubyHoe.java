package at.htlkaindorf.levelup.items.ruby;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class RubyHoe extends ItemHoe {

    public RubyHoe(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
