package at.htlkaindorf.levelup.items.ruby.armor;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class RubyBoots extends ItemArmor {

    public static final String NAME = "ruby_boots";

    public RubyBoots() {
        super(Materials.RUBY_ARMOR_MATERIAL, 1, EntityEquipmentSlot.FEET);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
