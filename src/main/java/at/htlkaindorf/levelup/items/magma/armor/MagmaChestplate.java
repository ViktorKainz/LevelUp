package at.htlkaindorf.levelup.items.magma.armor;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class MagmaChestplate extends ItemArmor {

    public static final String NAME = "magma_chestplate";

    public MagmaChestplate() {
        super(Materials.MAGMA_ARMOR_MATERIAL, 1, EntityEquipmentSlot.CHEST);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
