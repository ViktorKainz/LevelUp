package at.htlkaindorf.levelup.capability;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.capability.experience.ExperienceProvider;
import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import at.htlkaindorf.levelup.capability.experience.IExperience;
import at.htlkaindorf.levelup.capability.unlocked.IUnlocked;
import at.htlkaindorf.levelup.capability.unlocked.UnlockedProvider;
import at.htlkaindorf.levelup.items.magma.MagmaBoots;
import at.htlkaindorf.levelup.items.magma.MagmaChestplate;
import at.htlkaindorf.levelup.items.magma.MagmaHelmet;
import at.htlkaindorf.levelup.items.magma.MagmaLeggings;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;

import java.util.ArrayList;
import java.util.List;

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
            if (tool.getToolMaterialName().equals(Materials.MAGMA_TOOL_MATERIAL.name())) {
                List<ItemStack> drops = new ArrayList<>(event.getDrops());
                event.getDrops().clear();
                drops.forEach(i -> {
                    ItemStack smelted = FurnaceRecipes.instance().getSmeltingResult(i);
                    if (smelted.getItem().getRegistryName().getResourcePath().equals("air")) {
                        event.getDrops().add(i);
                    } else {
                        event.getDrops().add(smelted);
                    }
                });
            }
        }
    }

    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event) {
        EntityLivingBase target = event.getEntityLiving();
        DamageSource source = event.getSource();
        if (target instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) target;
            if (MagmaHelmet.fullArmor(player)) {
                if(source.getImmediateSource() != null) {
                    source.getImmediateSource().setFire(1);
                }
            }
        }
    }

    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {
        EntityPlayer player = event.getEntityPlayer();
        IUnlocked unlocked = player.getCapability(UnlockedProvider.UNLOCKED_CAP, null);
        unlocked.add(event.getItem().getItem().getItem().getRegistryName());
        player.sendMessage(new TextComponentString(event.getItem().getItem().getItem().getRegistryName().getResourcePath() + " unlocked"));
    }
}
