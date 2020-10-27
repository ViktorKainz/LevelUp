package at.htlkaindorf.levelup.items.wither.armor;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class WitherBoots extends ItemArmor {

    public static final String NAME = "wither_boots";

    public WitherBoots() {
        super(Materials.WITHER_ARMOR_MATERIAL, 1, EntityEquipmentSlot.FEET);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
