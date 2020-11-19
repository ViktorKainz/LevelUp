package at.htlkaindorf.levelup.eventHandler;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.capability.experience.ExperienceProvider;
import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import at.htlkaindorf.levelup.capability.experience.IExperience;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber(modid = LevelUp.MODID)
public class ExperienceHandler {

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
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        experience.add(ExperienceType.Crafting, 1);
        player.sendMessage(new TextComponentString(
                String.format("You have %d %s experience.", experience.getExperience(ExperienceType.Crafting), ExperienceType.Crafting)));
    }

    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event) {
        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
            experience.add(ExperienceType.Fighting, 1);
            player.sendMessage(new TextComponentString(
                    String.format("You have %d %s experience.", experience.getExperience(ExperienceType.Fighting), ExperienceType.Fighting)));
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.PlaceEvent event) {
        EntityPlayer player = event.getPlayer();
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        experience.add(ExperienceType.Building, 1);
        player.sendMessage(new TextComponentString(
                String.format("You have %d %s experience.", experience.getExperience(ExperienceType.Building), ExperienceType.Building)));
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        EntityPlayer player = event.getPlayer();
        if (event.getState().getMaterial().equals(Material.ROCK)) {
            IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
            experience.add(ExperienceType.Mining, 1);
            player.sendMessage(new TextComponentString(
                    String.format("You have %d %s experience.", experience.getExperience(ExperienceType.Mining), ExperienceType.Mining)));
        }
    }

    @SubscribeEvent
    public void onUseHoe(UseHoeEvent event) {
        EntityPlayer player = event.getEntityPlayer();
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        experience.add(ExperienceType.Farming, 1);
        player.sendMessage(new TextComponentString(
                String.format("You have %d %s experience.", experience.getExperience(ExperienceType.Farming), ExperienceType.Farming)));
    }
}
