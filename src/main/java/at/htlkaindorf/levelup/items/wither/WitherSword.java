package at.htlkaindorf.levelup.items.wither;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.item.ItemSword;

public class WitherSword extends ItemSword {

    public static final String NAME = "wither_sword";

    public WitherSword() {
        super(Materials.WITHER_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
