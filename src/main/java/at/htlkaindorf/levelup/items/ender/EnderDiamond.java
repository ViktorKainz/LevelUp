package at.htlkaindorf.levelup.items.ender;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.item.Item;

public class EnderDiamond extends Item {

    public static final String NAME = "ender_diamond";

    public EnderDiamond() {
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
