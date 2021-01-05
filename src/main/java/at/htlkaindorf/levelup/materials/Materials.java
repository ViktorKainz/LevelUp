package at.htlkaindorf.levelup.materials;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Materials {
    //ToolMaterial
    public static final ToolMaterial MAGMA_TOOL_MATERIAL = EnumHelper.addToolMaterial("MAGMA",
            1, 150, 18.0F, 1.0F, 27); //comparison to gold: GOLD(0, 32, 12.0F, 0.0F, 22)
    public static final ToolMaterial EMERALD_TOOL_MATERIAL = EnumHelper.addToolMaterial("EMERALD",
            3, 1000, 10F, 3.0F, 15); //comparison to diamond: DIAMOND(3, 1561, 8.0F, 3.0F, 10)
    public static final ToolMaterial ENDER_TOOL_MATERIAL = EnumHelper.addToolMaterial("ENDER",
            2, 600, 14.0F, 3.5F, 18); //comparison to iron: IRON(2, 250, 6.0F, 2.0F, 14)
    public static final ToolMaterial RUBY_TOOL_MATERIAL = EnumHelper.addToolMaterial("RUBY",
            3, 2000, 10F, 4.0F, 15); //comparison to diamond: DIAMOND(3, 1561, 8.0F, 3.0F, 10)
    public static final ToolMaterial SAPPHIRE_TOOL_MATERIAL = EnumHelper.addToolMaterial("SAPPHIRE",
            4, 2500, 12F, 4.0F, 20); //comparison to diamond: DIAMOND(3, 1561, 8.0F, 3.0F, 10)
    public static final ToolMaterial WITHER_TOOL_MATERIAL = EnumHelper.addToolMaterial("WITHER",
            4, 6000, 30.0F, 8.0F, 40);

    //ArmorMaterial
    public static final ArmorMaterial MAGMA_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("MAGMA",
            LevelUp.MODID + ":magma", 10, new int[]{2, 4, 6, 3}, 27,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.75f); //comparison to gold: GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F)
    public static final ArmorMaterial EMERALD_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("EMERALD",
            LevelUp.MODID + ":emerald", 25, new int[]{3, 5, 8, 2}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.75f);
    public static final ArmorMaterial ENDER_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("ENDER",
            LevelUp.MODID + ":ender", 18, new int[]{3, 6, 6, 2}, 18,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1f); //comparison to iron: IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F)
    public static final ArmorMaterial RUBY_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("RUBY",
            LevelUp.MODID + ":ruby", 40, new int[]{4, 7, 9, 4}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5f); //comparison to diamond: DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F)
    public static final ArmorMaterial SAPPHIRE_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("SAPPHIRE",
            LevelUp.MODID + ":sapphire", 50, new int[]{5,8, 9, 4}, 20,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3f);
    public static final ArmorMaterial WITHER_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("WITHER",
            LevelUp.MODID + ":wither", 100, new int[]{8, 11, 13, 8}, 40,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 8f); //comparison to iron: IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F)
}
