package at.htlkaindorf.levelup.items.magma.tools;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.items.HitEffects;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class MagmaAxe extends ItemAxe {

    public static final String NAME = "magma_axe";

    public MagmaAxe() {
        super(Materials.MAGMA_TOOL_MATERIAL, 10.0F, 1.0F);
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
