package at.htlkaindorf.levelup.items.ruby;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class RubyLeggings extends ItemArmor {

    public static final String NAME = "ruby_leggings";

    public RubyLeggings() {
        super(Materials.RUBY_ARMOR_MATERIAL, 2, EntityEquipmentSlot.LEGS);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
