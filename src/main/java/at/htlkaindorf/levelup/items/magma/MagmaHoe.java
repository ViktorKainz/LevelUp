package at.htlkaindorf.levelup.items.magma;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class MagmaHoe extends ItemHoe {
    public MagmaHoe(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}