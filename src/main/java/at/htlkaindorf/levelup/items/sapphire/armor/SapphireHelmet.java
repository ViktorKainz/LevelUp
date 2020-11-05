package at.htlkaindorf.levelup.items.sapphire.armor;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class SapphireHelmet extends ItemArmor {

    public static final String NAME = "sapphire_helmet";

    public SapphireHelmet() {
        super(Materials.SAPPHIRE_ARMOR_MATERIAL, 1, EntityEquipmentSlot.HEAD);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
