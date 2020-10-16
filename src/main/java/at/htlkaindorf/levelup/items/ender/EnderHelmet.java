package at.htlkaindorf.levelup.items.ender;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class EnderHelmet extends ItemArmor {

    public EnderHelmet(ArmorMaterial materialIn, String name) {
        super(materialIn, 1, EntityEquipmentSlot.HEAD);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
