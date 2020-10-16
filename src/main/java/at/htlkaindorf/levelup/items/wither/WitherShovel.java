package at.htlkaindorf.levelup.items.wither;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.item.ItemSpade;

public class WitherShovel extends ItemSpade {

    public static final String NAME = "wither_shovel";

    public WitherShovel() {
        super(Materials.WITHER_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
