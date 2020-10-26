package at.htlkaindorf.levelup.items.sapphire;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class SapphireLeggings extends ItemArmor {

    public static final String NAME = "sapphire_leggings";

    public SapphireLeggings() {
        super(Materials.SAPPHIRE_ARMOR_MATERIAL, 2, EntityEquipmentSlot.LEGS);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
