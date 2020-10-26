package at.htlkaindorf.levelup.items.magma;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.items.HitEffects;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class MagmaShovel extends ItemSpade {

    public static final String NAME = "magma_shovel";

    public MagmaShovel() {
        super(Materials.MAGMA_TOOL_MATERIAL);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        HitEffects.onHitMagma(stack, target, attacker);
        return super.hitEntity(stack, target, attacker);
    }
}
