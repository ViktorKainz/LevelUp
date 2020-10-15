package at.htlkaindorf.levelup.items.wither;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.item.ItemSword;

public class WitherSword extends ItemSword {

    public WitherSword(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
