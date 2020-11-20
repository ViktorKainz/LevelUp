package at.htlkaindorf.levelup.items.ender;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnderEvents {

    public static void onHarvestDrop(BlockEvent.HarvestDropsEvent event) {
        EntityPlayer player = event.getHarvester();
        List<ItemStack> drops = new ArrayList<>(event.getDrops());
        drops.forEach(i -> {
            if (player.inventory.addItemStackToInventory(i)) {
                event.getDrops().remove(i);
            }
        });
        effects(event.getPos());
    }

    public static void onLivingDrops(LivingDropsEvent event) {
        EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
        List<EntityItem> drops = new ArrayList<>(event.getDrops());
        drops.forEach(i -> {
            if (player.inventory.addItemStackToInventory(i.getItem())) {
                event.getDrops().remove(i);
            }
        });
        effects(event.getEntity().getPosition());
    }

    public static void effects(BlockPos pos) {
        World world = Minecraft.getMinecraft().world;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            world.spawnParticle(EnumParticleTypes.PORTAL,
                    pos.getX() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                    pos.getY() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                    pos.getZ() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                    random.nextDouble() % (random.nextBoolean() ? -1 : 1),
                    random.nextDouble() % (random.nextBoolean() ? -1 : 1),
                    random.nextDouble() % (random.nextBoolean() ? -1 : 1));
        }
        world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.NEUTRAL, 1, 1, false);
    }
}
