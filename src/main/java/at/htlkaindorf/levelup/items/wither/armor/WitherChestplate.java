package at.htlkaindorf.levelup.items.wither.armor;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class WitherChestplate extends ItemArmor {

    public static final String NAME = "wither_chestplate";

    public WitherChestplate() {
        super(Materials.WITHER_ARMOR_MATERIAL, 1, EntityEquipmentSlot.CHEST);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
