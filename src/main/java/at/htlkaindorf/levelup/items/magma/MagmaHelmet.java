package at.htlkaindorf.levelup.items.magma;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class MagmaHelmet extends ItemArmor {

    public static final String NAME = "magma_helmet";

    public MagmaHelmet() {
        super(Materials.MAGMA_ARMOR_MATERIAL, 1, EntityEquipmentSlot.HEAD);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack item) {
        if (fullArmor(player)) {
            player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 1, 3, false, false));
        }
    }

    public static boolean fullArmor(EntityPlayer player) {
        return player.inventory.armorItemInSlot(0).getItem().getRegistryName().getResourcePath().equals(MagmaBoots.NAME) &&
               player.inventory.armorItemInSlot(1).getItem().getRegistryName().getResourcePath().equals(MagmaLeggings.NAME) &&
               player.inventory.armorItemInSlot(2).getItem().getRegistryName().getResourcePath().equals(MagmaChestplate.NAME) &&
               player.inventory.armorItemInSlot(3).getItem().getRegistryName().getResourcePath().equals(MagmaHelmet.NAME);
    }
}

