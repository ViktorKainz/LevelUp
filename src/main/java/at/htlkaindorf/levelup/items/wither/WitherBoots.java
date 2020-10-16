package at.htlkaindorf.levelup.items.wither;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class WitherBoots extends ItemArmor {

    public WitherBoots(ArmorMaterial materialIn, String name) {
        super(materialIn, 1, EntityEquipmentSlot.FEET);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
