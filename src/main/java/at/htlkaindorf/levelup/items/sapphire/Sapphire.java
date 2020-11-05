package at.htlkaindorf.levelup.items.sapphire;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.item.Item;

public class Sapphire extends Item {

    public static final String NAME = "sapphire";

    public Sapphire() {
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
