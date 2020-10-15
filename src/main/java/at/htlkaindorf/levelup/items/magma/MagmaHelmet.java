package at.htlkaindorf.levelup.items.magma;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class MagmaHelmet extends ItemArmor {

    public MagmaHelmet(ArmorMaterial materialIn, String name) {
        super(materialIn, 1, EntityEquipmentSlot.HEAD);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
