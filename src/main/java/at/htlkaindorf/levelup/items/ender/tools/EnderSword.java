package at.htlkaindorf.levelup.items.ender.tools;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.item.ItemSword;

public class EnderSword extends ItemSword {

    public static final String NAME = "ender_sword";

    public EnderSword() {
        super(Materials.ENDER_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }

}
