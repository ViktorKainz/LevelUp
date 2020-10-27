package at.htlkaindorf.levelup.items.magma.armor;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class MagmaLeggings extends ItemArmor {

    public static final String NAME = "magma_leggings";

    public MagmaLeggings() {
        super(Materials.MAGMA_ARMOR_MATERIAL, 2, EntityEquipmentSlot.LEGS);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
