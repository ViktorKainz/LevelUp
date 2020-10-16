package at.htlkaindorf.levelup.items.ruby;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.item.Item;

public class Ruby extends Item {

    public static final String NAME = "ruby";

    public Ruby() {
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
