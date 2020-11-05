package at.htlkaindorf.levelup.items.emerald.tools;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.item.ItemAxe;

public class EmeraldAxe extends ItemAxe {

    public static final String NAME = "emerald_axe";

    public EmeraldAxe() {
        super(Materials.EMERALD_TOOL_MATERIAL, 10.0F, 1.0F);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
