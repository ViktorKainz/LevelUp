package at.htlkaindorf.levelup.items.sapphire.tools;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.item.ItemAxe;

public class SapphireAxe extends ItemAxe {

    public static final String NAME = "sapphire_axe";

    public SapphireAxe() {
        super(Materials.SAPPHIRE_TOOL_MATERIAL, 10.0F, 1.0F);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
