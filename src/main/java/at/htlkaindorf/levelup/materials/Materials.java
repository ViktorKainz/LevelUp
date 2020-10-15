package at.htlkaindorf.levelup.materials;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Materials {
    //ToolMaterial
    public static final ToolMaterial RUBY_TOOL_MATERIAL = EnumHelper.addToolMaterial("RUBY",
            3, 2000, 10F, 4.0F, 15); //comparison to diamond: DIAMOND(3, 1561, 8.0F, 3.0F, 10);
    public static final ToolMaterial MAGMA_TOOL_MATERIAL = EnumHelper.addToolMaterial("MAGMA",
            1, 100, 15.0F, 1.0F, 25);
    public static final ToolMaterial ENDER_TOOL_MATERIAL = EnumHelper.addToolMaterial("ENDER",
            2, 400, 8.0F, 3.0F, 16); //comparison to iron: IRON(2, 250, 6.0F, 2.0F, 14),

    //ArmorMaterial
    public static final ArmorMaterial RUBY_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("RUBY",
            LevelUp.MODID + ":ruby", 40, new int[]{4, 7, 9, 4}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5f); //comparison to diamond: DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F)
    public static final ArmorMaterial MAGMA_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("MAGMA",
            LevelUp.MODID + ":magma", 10, new int[]{2, 4, 6, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0f); //comparison to gold: GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F)
}
