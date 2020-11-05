package at.htlkaindorf.levelup.items.emerald.armor;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class EmeraldBoots extends ItemArmor {

    public static final String NAME = "emerald_boots";

    public EmeraldBoots() {
        super(Materials.EMERALD_ARMOR_MATERIAL, 1, EntityEquipmentSlot.FEET);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
