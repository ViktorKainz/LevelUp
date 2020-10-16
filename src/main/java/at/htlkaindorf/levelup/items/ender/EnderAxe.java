package at.htlkaindorf.levelup.items.ender;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class EnderAxe extends ItemAxe {

    public static final String NAME = "ender_axe";
    public EnderAxe() {
        super(Materials.ENDER_TOOL_MATERIAL, 10.0F, 1.0F);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
