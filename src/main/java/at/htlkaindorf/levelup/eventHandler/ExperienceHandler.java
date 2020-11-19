package at.htlkaindorf.levelup.eventHandler;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.capability.experience.ExperienceProvider;
import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import at.htlkaindorf.levelup.capability.experience.IExperience;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber(modid = LevelUp.MODID)
public class ExperienceHandler {

    public void addExperience(EntityPlayer player, ExperienceType type, int amount) {
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        experience.add(type, amount);
        player.sendMessage(new TextComponentString(
                String.format("You have %d %s experience.", experience.getExperience(type), type)));
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
    public void onLivingAttack(LivingAttackEvent event) {
        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            addExperience(player, ExperienceType.Fighting, 1);
        }
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
    public void onHarvestDrop(BlockEvent.HarvestDropsEvent event) {
        EntityPlayer player = event.getHarvester();
        Item main = player != null ? player.getHeldItemMainhand() != null ? player.getHeldItemMainhand().getItem() : null : null;
        if (main instanceof ItemTool) {
            IExperience experience = player.getHeldItemMainhand().getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
            if (experience != null) {
                experience.add(ExperienceType.Tool, 1);
                player.sendMessage(new TextComponentString(
                        String.format("%s has %d %s experience.", main.getUnlocalizedName(), experience.getExperience(ExperienceType.Tool), ExperienceType.Tool)));
            }
        }
    }
}
