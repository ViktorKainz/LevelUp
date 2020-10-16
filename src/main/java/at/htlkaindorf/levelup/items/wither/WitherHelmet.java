package at.htlkaindorf.levelup.items.wither;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import javafx.scene.paint.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class WitherHelmet extends ItemArmor {

    public static final String NAME = "wither_helmet";

    public WitherHelmet() {
        super(Materials.WITHER_ARMOR_MATERIAL, 1, EntityEquipmentSlot.HEAD);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }
}
