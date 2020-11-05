package at.htlkaindorf.levelup.items.ender.tools;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class EnderShovel extends ItemSpade {

    public static final String NAME = "ender_shovel";

    public EnderShovel() {
        super(Materials.ENDER_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
