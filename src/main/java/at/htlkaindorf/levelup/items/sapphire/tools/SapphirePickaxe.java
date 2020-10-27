package at.htlkaindorf.levelup.items.sapphire.tools;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.item.ItemPickaxe;

public class SapphirePickaxe extends ItemPickaxe {

    public static final String NAME = "sapphire_pickaxe";

    public SapphirePickaxe() {
        super(Materials.SAPPHIRE_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
