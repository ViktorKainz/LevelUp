package at.htlkaindorf.levelup.items.wither;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.item.Item;

public class WitherIngot extends Item {

    public static final String NAME = "wither_ingot";

    public WitherIngot() {
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
