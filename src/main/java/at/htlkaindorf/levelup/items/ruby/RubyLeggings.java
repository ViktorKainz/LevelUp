package at.htlkaindorf.levelup.items.ruby;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class RubyLeggings extends ItemArmor {

    public RubyLeggings(ArmorMaterial materialIn, String name) {
        super(materialIn, 2, EntityEquipmentSlot.LEGS);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
