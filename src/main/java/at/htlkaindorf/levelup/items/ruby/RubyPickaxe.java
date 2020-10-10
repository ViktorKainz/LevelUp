package at.htlkaindorf.levelup.items.ruby;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class RubyPickaxe extends ItemPickaxe {

    public RubyPickaxe(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
