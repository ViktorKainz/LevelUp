package at.htlkaindorf.levelup.items.wither.armor;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class WitherLeggings extends ItemArmor {

    public static final String NAME = "wither_leggings";

    public WitherLeggings() {
        super(Materials.WITHER_ARMOR_MATERIAL, 2, EntityEquipmentSlot.LEGS);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
