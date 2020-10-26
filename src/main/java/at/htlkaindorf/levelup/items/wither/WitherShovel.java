package at.htlkaindorf.levelup.items.wither;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.items.HitEffects;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class WitherShovel extends ItemSpade {

    public static final String NAME = "wither_shovel";

    public WitherShovel() {
        super(Materials.WITHER_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        HitEffects.onHitWither(stack, target, attacker);
        return super.hitEntity(stack, target, attacker);
    }
}
