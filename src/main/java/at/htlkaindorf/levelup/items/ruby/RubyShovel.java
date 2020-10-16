package at.htlkaindorf.levelup.items.ruby;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class RubyShovel extends ItemSpade {

    public static final String NAME = "ruby_shovel";

    public RubyShovel() {
        super(Materials.RUBY_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
