package at.htlkaindorf.levelup.items.emerald.tools;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.item.ItemHoe;

public class EmeraldHoe extends ItemHoe {

    public static final String NAME = "emerald_hoe";

    public EmeraldHoe() {
        super(Materials.EMERALD_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
