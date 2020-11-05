package at.htlkaindorf.levelup.items.magma;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.item.Item;

public class MagmaIngot extends Item {

    public static final String NAME = "magma_ingot";

    public MagmaIngot() {
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
