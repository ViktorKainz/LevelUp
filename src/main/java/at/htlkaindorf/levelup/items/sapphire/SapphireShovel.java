package at.htlkaindorf.levelup.items.sapphire;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.item.ItemSpade;

public class SapphireShovel extends ItemSpade {

    public static final String NAME = "sapphire_shovel";

    public SapphireShovel() {
        super(Materials.SAPPHIRE_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
