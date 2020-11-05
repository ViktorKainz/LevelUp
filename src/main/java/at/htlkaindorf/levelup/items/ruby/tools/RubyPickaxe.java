package at.htlkaindorf.levelup.items.ruby.tools;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class RubyPickaxe extends ItemPickaxe {

    public static final String NAME = "ruby_pickaxe";

    public RubyPickaxe() {
        super(Materials.RUBY_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
