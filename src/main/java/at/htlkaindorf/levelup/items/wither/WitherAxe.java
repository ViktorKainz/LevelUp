package at.htlkaindorf.levelup.items.wither;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.item.ItemAxe;

public class WitherAxe extends ItemAxe {

    public WitherAxe(ToolMaterial material, String name) {
        super(material, 10.0F, 1.0F);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
