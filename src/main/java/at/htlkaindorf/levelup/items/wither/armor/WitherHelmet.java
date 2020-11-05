package at.htlkaindorf.levelup.items.wither.armor;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class WitherHelmet extends ItemArmor {

    public static final String NAME = "wither_helmet";

    public WitherHelmet() {
        super(Materials.WITHER_ARMOR_MATERIAL, 1, EntityEquipmentSlot.HEAD);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack item) {
        if (fullArmor(player)) {
            player.removePotionEffect(Potion.getPotionById(20));
        }
    }

    public static boolean fullArmor(EntityPlayer player) {
        return player.inventory.armorItemInSlot(0).getItem().getRegistryName().getResourcePath().equals(WitherBoots.NAME) &&
                player.inventory.armorItemInSlot(1).getItem().getRegistryName().getResourcePath().equals(WitherLeggings.NAME) &&
                player.inventory.armorItemInSlot(2).getItem().getRegistryName().getResourcePath().equals(WitherChestplate.NAME) &&
                player.inventory.armorItemInSlot(3).getItem().getRegistryName().getResourcePath().equals(WitherHelmet.NAME);
    }
}
