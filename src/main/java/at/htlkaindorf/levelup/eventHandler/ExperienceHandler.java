package at.htlkaindorf.levelup.eventHandler;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.capability.experience.ExperienceProvider;
import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import at.htlkaindorf.levelup.capability.experience.IExperience;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Mod.EventBusSubscriber(modid = LevelUp.MODID)
public class ExperienceHandler {

    public void addExperience(EntityPlayer player, ExperienceType type, int amount) {
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        experience.add(type, amount);
        player.sendMessage(new TextComponentString(
                String.format("You have %d %s experience.", experience.getExperience(type), type)));
    }

    public void addExperience(ItemStack item, int amount) {
        IExperience experience = item.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        int oldLevel = experience.getLevel(ExperienceType.Tool);
        experience.add(ExperienceType.Tool, 10);
        if (experience.getLevel(ExperienceType.Tool) > oldLevel && experience.getLevel(ExperienceType.Tool) % 5 == 0) {
            EnchantmentHelper.addRandomEnchantment(new Random(), item, experience.getLevel(ExperienceType.Tool), true);
        }
        NBTTagList l = item.getEnchantmentTagList();
        Map<Integer, Integer[]> m = new HashMap<>();
        for (int i = 0; i < l.tagCount(); i++) {
            if(m.get(l.getCompoundTagAt(i).getInteger("id")) == null ||
               m.get(l.getCompoundTagAt(i).getInteger("id"))[0] >
               l.getCompoundTagAt(i).getInteger("lvl"))
            m.put(l.getCompoundTagAt(i).getInteger("id"),
                  new Integer[]{l.getCompoundTagAt(i).getInteger("lvl"), i});
        }
        for (int i = 0; i < l.tagCount(); i++) {
            boolean t = false;
            for(int j : m.keySet()) {
                t = m.get(j)[1] == i;
                if(t) {
                    break;
                }
            }
            if(!t) {
                l.removeTag(i);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerLogsIn(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        for (ExperienceType type : ExperienceType.values()) {
            player.sendMessage(new TextComponentString(
                    String.format("You have %d %s experience.", experience.getExperience(type), type)));
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
        addExperience(player, ExperienceType.Crafting, 1);
    }

    @SubscribeEvent
    public void onBlockPlace(BlockEvent.PlaceEvent event) {
        EntityPlayer player = event.getPlayer();
        addExperience(player, ExperienceType.Building, 1);
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        EntityPlayer player = event.getPlayer();
        if (event.getState().getMaterial().equals(Material.ROCK)) {
            addExperience(player, ExperienceType.Mining, 1);
        }
    }

    @SubscribeEvent
    public void onUseHoe(UseHoeEvent event) {
        EntityPlayer player = event.getEntityPlayer();
        addExperience(player, ExperienceType.Farming, 1);
    }

    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event) {
        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            addExperience(player, ExperienceType.Fighting, 1);
            Item main = player != null ? player.getHeldItemMainhand() != null ? player.getHeldItemMainhand().getItem() : null : null;
            if (main instanceof ItemSword) {
                addExperience(player.getHeldItemMainhand(), 10);
            }
        }
    }

    @SubscribeEvent
    public void onHarvestDrop(BlockEvent.HarvestDropsEvent event) {
        EntityPlayer player = event.getHarvester();
        Item main = player != null ? player.getHeldItemMainhand() != null ? player.getHeldItemMainhand().getItem() : null : null;
        if (main instanceof ItemTool) {
            addExperience(player.getHeldItemMainhand(), 100);
        }
    }

    @SubscribeEvent
    void onToolTip(ItemTooltipEvent event) {
        IExperience experience = event.getItemStack().getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        if (experience != null) {
            List<String> toolTip = event.getToolTip();
            int level = experience.getLevel(ExperienceType.Tool);
            toolTip.add(1,"Level " + level);
            toolTip.add(2,(experience.getExperience(ExperienceType.Tool) - experience.getExperienceOfLevel(level-1)) + "/"
                    + (experience.getExperienceOfLevel(level) - experience.getExperienceOfLevel(level-1)));
        }
    }
}
