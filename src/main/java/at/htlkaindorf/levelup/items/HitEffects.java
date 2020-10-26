package at.htlkaindorf.levelup.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class HitEffects {

    public static void onHitMagma(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        target.setFire(4);
    }

    public static void onHitWither(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        target.addPotionEffect(new PotionEffect(MobEffects.WITHER, 20, 1));
    }
}
