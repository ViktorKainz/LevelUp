package at.htlkaindorf.levelup.capability;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.capability.experience.ExperienceProvider;
import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import at.htlkaindorf.levelup.capability.experience.IExperience;
import at.htlkaindorf.levelup.capability.unlocked.IUnlocked;
import at.htlkaindorf.levelup.capability.unlocked.UnlockedProvider;
import at.htlkaindorf.levelup.items.magma.MagmaHelmet;
import at.htlkaindorf.levelup.items.wither.WitherHelmet;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = LevelUp.MODID)
public class EventHandler {
    @SubscribeEvent
    public void onPlayerLogsIn(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        for (ExperienceType type : ExperienceType.values()) {
            player.sendMessage(new TextComponentString(
                    String.format("You have %d  %s experience.", experience.getExperience(type), type)));
        }
        IUnlocked unlocked = player.getCapability(UnlockedProvider.UNLOCKED_CAP,null);
        unlocked.add("Stone Tools");
    }

    @SubscribeEvent
    public void onPlayerClone(Clone event) {
        EntityPlayer player = event.getEntityPlayer();
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        IExperience oldExperience = event.getOriginal().getCapability(ExperienceProvider.EXPERIENCE_CAP, null);

        for (ExperienceType type : ExperienceType.values()) {
            experience.set(type, oldExperience.getExperience(type));
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        EntityPlayer player = event.getPlayer();
        Block block = event.getState().getBlock();
        if (event.getState().getMaterial().equals(Material.ROCK)) {
            IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
            experience.add(ExperienceType.Mining, 1);
            player.sendMessage(new TextComponentString(
                    String.format("You have %d  %s experience.", experience.getExperience(ExperienceType.Mining), ExperienceType.Mining)));
        }
    }

    @SubscribeEvent
    public void onHarvestDrop(BlockEvent.HarvestDropsEvent event) {
        EntityPlayer player = event.getHarvester();
        Item main = player != null ? player.getHeldItemMainhand() != null ? player.getHeldItemMainhand().getItem() : null : null;
        if (main instanceof ItemTool) {
            ItemTool tool = (ItemTool) main;
            List<ItemStack> drops = new ArrayList<>(event.getDrops());
            World world = Minecraft.getMinecraft().world;
            BlockPos pos = event.getPos();
            Random random = new Random();
            if (tool.getToolMaterialName().equals(Materials.MAGMA_TOOL_MATERIAL.name())) {
                event.getDrops().clear();
                drops.forEach(i -> {
                    ItemStack smelted = FurnaceRecipes.instance().getSmeltingResult(i);
                    if (smelted.getItem().getRegistryName().getResourcePath().equals("air")) {
                        event.getDrops().add(i);
                    } else {
                        event.getDrops().add(smelted);
                    }
                });

                for(int i = 0; i < 4; i++) {
                    world.spawnParticle(EnumParticleTypes.FLAME,
                            pos.getX() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                            pos.getY() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                            pos.getZ() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                            random.nextDouble() % (random.nextBoolean() ? -0.1 : 0.1),
                            random.nextDouble() % (random.nextBoolean() ? -0.1 : 0.1),
                            random.nextDouble() % (random.nextBoolean() ? -0.1 : 0.1));
                }
                world.playSound(pos.getX(),pos.getY(),pos.getZ(),SoundEvents.BLOCK_FIRE_EXTINGUISH,SoundCategory.NEUTRAL,1,1,false);
            } else if (tool.getToolMaterialName().equals(Materials.ENDER_TOOL_MATERIAL.name())) {
                drops.forEach(i -> {
                    if(player.inventory.addItemStackToInventory(i)) {
                        event.getDrops().remove(i);
                    }
                });

                for(int i = 0; i < 10; i++) {
                    world.spawnParticle(EnumParticleTypes.PORTAL,
                            pos.getX() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                            pos.getY() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                            pos.getZ() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                            random.nextDouble() % (random.nextBoolean() ? -1 : 1),
                            random.nextDouble() % (random.nextBoolean() ? -1 : 1),
                            random.nextDouble() % (random.nextBoolean() ? -1 : 1));
                }
                world.playSound(pos.getX(),pos.getY(),pos.getZ(),SoundEvents.ENTITY_ENDERMEN_TELEPORT,SoundCategory.NEUTRAL,1,1,false);
            }
        }
    }

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {
        DamageSource source = event.getSource();
        if(source.getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)source.getTrueSource();
            Item main = player != null ? player.getHeldItemMainhand() != null ? player.getHeldItemMainhand().getItem() : null : null;
            if (main instanceof ItemSword) {
                ItemSword tool = (ItemSword) main;
                if (tool.getToolMaterialName().equals(Materials.ENDER_TOOL_MATERIAL.name())) {
                    List<EntityItem> drops = new ArrayList<>(event.getDrops());
                    drops.forEach(i -> {
                        if(player.inventory.addItemStackToInventory(i.getItem())) {
                            event.getDrops().remove(i);
                        }
                    });
                    World world = Minecraft.getMinecraft().world;
                    BlockPos pos = event.getEntity().getPosition();
                    Random random = new Random();
                    for(int i = 0; i < 10; i++) {
                        world.spawnParticle(EnumParticleTypes.PORTAL,
                                pos.getX() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                                pos.getY() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                                pos.getZ() + random.nextDouble() % (random.nextBoolean() ? -10 : 10),
                                0.1,0.1,0.1);
                    }
                    event.getEntity().playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT,1,1);
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event) {
        EntityLivingBase target = event.getEntityLiving();
        DamageSource source = event.getSource();
        if (target instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) target;
            if (MagmaHelmet.fullArmor(player) && source.getImmediateSource() != null) {
                source.getImmediateSource().setFire(1);
            } else if (WitherHelmet.fullArmor(player) && source.getImmediateSource() instanceof EntityLiving) {
                ((EntityLiving) source.getImmediateSource()).addPotionEffect(new PotionEffect(MobEffects.WITHER, 20, 1));
            }
        }
    }
}
