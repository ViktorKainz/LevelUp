package at.htlkaindorf.levelup.items.sapphire.armor;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class SapphireBoots extends ItemArmor {

    public static final String NAME = "sapphire_boots";

    public SapphireBoots() {
        super(Materials.SAPPHIRE_ARMOR_MATERIAL, 1, EntityEquipmentSlot.FEET);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
