package at.htlkaindorf.levelup.items.wither;

import net.minecraft.entity.EntityLiving;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class WitherEvents {

    public static void onFullArmorLivingAttack(LivingAttackEvent event) {
        DamageSource source = event.getSource();
        if (source.getImmediateSource() instanceof EntityLiving) {
            ((EntityLiving) source.getImmediateSource()).addPotionEffect(new PotionEffect(MobEffects.WITHER, 20, 1));
        }
    }
}
