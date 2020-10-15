package at.htlkaindorf.levelup.items.magma;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class MagmaLeggings extends ItemArmor {

    public MagmaLeggings(ArmorMaterial materialIn, String name) {
        super(materialIn, 2, EntityEquipmentSlot.LEGS);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
