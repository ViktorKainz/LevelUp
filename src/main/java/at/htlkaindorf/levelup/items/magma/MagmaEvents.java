package at.htlkaindorf.levelup.items.magma;

import net.minecraft.client.Minecraft;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MagmaEvents {

    public static void onHarvestDrop(BlockEvent.HarvestDropsEvent event) {
        List<ItemStack> drops = new ArrayList<>(event.getDrops());
        event.getDrops().clear();
        drops.forEach(i -> {
            ItemStack smelted = FurnaceRecipes.instance().getSmeltingResult(i);
            if (smelted.getItem().getRegistryName().getResourcePath().equals("air")) {
                event.getDrops().add(i);
            } else {
                smelted.setCount(i.getCount());
                event.getDrops().add(smelted);
            }
        });
        effects(event.getPos());
    }

    public static void effects(BlockPos pos) {
        World world = Minecraft.getMinecraft().world;
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            world.spawnParticle(EnumParticleTypes.FLAME,
                    pos.getX() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                    pos.getY() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                    pos.getZ() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                    random.nextDouble() % (random.nextBoolean() ? -0.1 : 0.1),
                    random.nextDouble() % (random.nextBoolean() ? -0.1 : 0.1),
                    random.nextDouble() % (random.nextBoolean() ? -0.1 : 0.1));
        }
        world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.NEUTRAL, 1, 1, false);
    }

    public static void onFullArmorLivingAttack(LivingAttackEvent event) {
        DamageSource source = event.getSource();
        if (source.getImmediateSource() != null) {
            source.getImmediateSource().setFire(1);
        }
    }
}
