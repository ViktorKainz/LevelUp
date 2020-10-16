package at.htlkaindorf.levelup.items.wither;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.item.ItemHoe;

public class WitherHoe extends ItemHoe {

    public static final String NAME = "wither_hoe";

    public WitherHoe() {
        super(Materials.WITHER_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
