package at.htlkaindorf.levelup.items.sapphire;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class SapphireChestplate extends ItemArmor {

    public static final String NAME = "sapphire_chestplate";

    public SapphireChestplate() {
        super(Materials.SAPPHIRE_ARMOR_MATERIAL, 1, EntityEquipmentSlot.CHEST);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
