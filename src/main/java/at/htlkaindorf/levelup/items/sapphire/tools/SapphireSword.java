package at.htlkaindorf.levelup.items.sapphire.tools;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.item.ItemSword;

public class SapphireSword extends ItemSword {

    public static final String NAME = "sapphire_sword";

    public SapphireSword() {
        super(Materials.SAPPHIRE_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
