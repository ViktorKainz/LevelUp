package at.htlkaindorf.levelup.items.ruby.armor;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class RubyHelmet extends ItemArmor {

    public static final String NAME = "ruby_helmet";

    public RubyHelmet() {
        super(Materials.RUBY_ARMOR_MATERIAL, 1, EntityEquipmentSlot.HEAD);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
