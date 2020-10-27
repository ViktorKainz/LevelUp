package at.htlkaindorf.levelup.items.emerald.tools;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.item.ItemSpade;

public class EmeraldShovel extends ItemSpade {

    public static final String NAME = "emerald_shovel";

    public EmeraldShovel() {
        super(Materials.EMERALD_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
