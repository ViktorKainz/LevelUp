package at.htlkaindorf.levelup.capability;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.capability.experience.ExperienceProvider;
import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import at.htlkaindorf.levelup.capability.experience.IExperience;
import at.htlkaindorf.levelup.capability.unlocked.IUnlocked;
import at.htlkaindorf.levelup.capability.unlocked.UnlockedProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;

@Mod.EventBusSubscriber(modid = LevelUp.MODID)
public class EventHandler
{
    @SubscribeEvent
    public void onPlayerLogsIn(PlayerLoggedInEvent event)
    {
        EntityPlayer player = event.player;
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        for(ExperienceType type : ExperienceType.values()) {
            player.sendMessage(new TextComponentString(
                    String.format("You have %d  %s experience.", experience.getExperience(type), type)));
        }
    }

    @SubscribeEvent
    public void onPlayerClone(Clone event)
    {
        EntityPlayer player = event.getEntityPlayer();
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        IExperience oldExperience = event.getOriginal().getCapability(ExperienceProvider.EXPERIENCE_CAP, null);

        for(ExperienceType type : ExperienceType.values()) {
            experience.set(type,oldExperience.getExperience(type));
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BreakEvent event) {
        EntityPlayer player = event.getPlayer();
        Block block = event.getState().getBlock();
        if(event.getState().getMaterial().equals(Material.ROCK)) {
            IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
            experience.add(ExperienceType.Mining, 1);
            player.sendMessage(new TextComponentString(
                    String.format("You have %d  %s experience.", experience.getExperience(ExperienceType.Mining), ExperienceType.Mining)));
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
