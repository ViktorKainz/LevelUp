package at.htlkaindorf.levelup.items.ender;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class EnderBoots extends ItemArmor {

    public static final String NAME = "ender_boots";

    public EnderBoots() {
        super(Materials.ENDER_ARMOR_MATERIAL, 1, EntityEquipmentSlot.FEET);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
