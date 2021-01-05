package at.htlkaindorf.levelup.eventHandler;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.capability.experience.ExperienceProvider;
import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import at.htlkaindorf.levelup.capability.experience.IExperience;
import at.htlkaindorf.levelup.config.Group;
import com.google.common.collect.Lists;
import net.minecraft.advancements.AdvancementList;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

import java.lang.reflect.Field;
import java.util.*;

@Mod.EventBusSubscriber(modid = LevelUp.MODID)
public class ExperienceHandler {

    public void addExperience(EntityPlayer player, ExperienceType type, int amount) {
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        int old = experience.getLevel(type);
        experience.add(type, amount);
        int newL = experience.getLevel(type);
        if (old < newL) {
            ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES;
            List<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValuesCollection());
            List<ResourceLocation> items = Group.getUnlockedAtLevel(type, newL);
            List<IRecipe> unlocked = new ArrayList<>();
            for (IRecipe r : recipes) {
                if (items.contains(r.getRegistryName())) {
                    unlocked.add(r);
                }
            }
            player.unlockRecipes(unlocked);
            player.sendMessage(new TextComponentString(
                    String.format("You are now Level %d in %s.", experience.getLevel(type), type)));
        }
    }

    public void addExperience(ItemStack item, int amount) {
        IExperience experience = item.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        int oldLevel = experience.getLevel(ExperienceType.tool);
        experience.add(ExperienceType.tool, amount);
        if (experience.getLevel(ExperienceType.tool) > oldLevel && experience.getLevel(ExperienceType.tool) % 5 == 0) {
            EnchantmentHelper.addRandomEnchantment(new Random(), item, experience.getLevel(ExperienceType.tool), true);
        }
        NBTTagList l = item.getEnchantmentTagList();
        Map<Integer, Integer[]> m = new HashMap<>();
        for (int i = 0; i < l.tagCount(); i++) {
            if (m.get(l.getCompoundTagAt(i).getInteger("id")) == null ||
                    m.get(l.getCompoundTagAt(i).getInteger("id"))[0] >
                            l.getCompoundTagAt(i).getInteger("lvl"))
                m.put(l.getCompoundTagAt(i).getInteger("id"),
                        new Integer[]{l.getCompoundTagAt(i).getInteger("lvl"), i});
        }
        for (int i = 0; i < l.tagCount(); i++) {
            boolean t = false;
            for (int j : m.keySet()) {
                t = m.get(j)[1] == i;
                if (t) {
                    break;
                }
            }
            if (!t) {
                l.removeTag(i);
            }
        }
    }

    @SubscribeEvent
    public void onWorldload(WorldEvent.Load event) {
        try {
            Field field = ObfuscationReflectionHelper.findField(AdvancementManager.class, "field_192784_c");
            AdvancementList l = (AdvancementList) field.get(null);
            Set<ResourceLocation> r = new HashSet<>();
            r.add(new ResourceLocation("minecraft:recipes/root"));
            l.removeAll(r);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @SubscribeEvent
    public void onPlayerClone(net.minecraftforge.event.entity.player.PlayerEvent.Clone event) {
        EntityPlayer player = event.getEntityPlayer();
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        IExperience oldExperience = event.getOriginal().getCapability(ExperienceProvider.EXPERIENCE_CAP, null);

        for (ExperienceType type : ExperienceType.values()) {
            experience.set(type, oldExperience.getExperience(type));
        }
    }

    @SubscribeEvent
    public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        EntityPlayer player = event.player;
        addExperience(player, ExperienceType.crafting, 1);
    }

    @SubscribeEvent
    public void onBlockPlace(BlockEvent.PlaceEvent event) {
        EntityPlayer player = event.getPlayer();
        addExperience(player, ExperienceType.building, 1);
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        EntityPlayer player = event.getPlayer();
        addExperience(player, ExperienceType.mining, ExperienceDistributor.amountFromBlock(event.getState(), ExperienceType.mining));
        addExperience(player, ExperienceType.farming, ExperienceDistributor.amountFromBlock(event.getState(), ExperienceType.farming));
    }

    @SubscribeEvent
    public void onUseHoe(UseHoeEvent event) {
        EntityPlayer player = event.getEntityPlayer();
        addExperience(player, ExperienceType.farming, 1);
    }

    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event) {
        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            addExperience(player, ExperienceType.fighting, (int) event.getAmount());
        }
    }

    @SubscribeEvent
    public void onHarvestDrop(BlockEvent.HarvestDropsEvent event) {
        EntityPlayer player = event.getHarvester();
        Item main = player != null ? player.getHeldItemMainhand() != null ? player.getHeldItemMainhand().getItem() : null : null;
        if (main instanceof ItemTool) {
            addExperience(player.getHeldItemMainhand(), 5);
        }
    }

    @SubscribeEvent
    public void onToolTip(ItemTooltipEvent event) {
        IExperience experience = event.getItemStack().getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        if (experience != null) {
            List<String> toolTip = event.getToolTip();
            int level = experience.getLevel(ExperienceType.tool);
            toolTip.add(1, "Level " + level);
            toolTip.add(2, (experience.getExperience(ExperienceType.tool) - experience.getExperienceOfLevel(level - 1)) + "/"
                    + (experience.getExperienceOfLevel(level) - experience.getExperienceOfLevel(level - 1)));
        }
    }
}
