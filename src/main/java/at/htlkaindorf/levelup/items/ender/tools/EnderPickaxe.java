package at.htlkaindorf.levelup.items.ender.tools;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.item.ItemPickaxe;

public class EnderPickaxe extends ItemPickaxe {

    public static final String NAME = "ender_pickaxe";

    public EnderPickaxe() {
        super(Materials.ENDER_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
