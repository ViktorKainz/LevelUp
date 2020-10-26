package at.htlkaindorf.levelup.items.sapphire;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.item.ItemHoe;

public class SapphireHoe extends ItemHoe {

    public static final String NAME = "sapphire_hoe";

    public SapphireHoe() {
        super(Materials.SAPPHIRE_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
