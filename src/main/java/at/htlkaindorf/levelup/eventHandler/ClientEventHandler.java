package at.htlkaindorf.levelup.eventHandler;

import at.htlkaindorf.levelup.capability.experience.ExperienceProvider;
import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import at.htlkaindorf.levelup.capability.experience.IExperience;
import net.minecraft.advancements.AdvancementList;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientEventHandler {

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
    public void onToolTip(ItemTooltipEvent event) {
        IExperience experience = event.getItemStack().getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        if (experience != null) {
            List<String> toolTip = event.getToolTip();
            int level = experience.getLevel(ExperienceType.tool);
            toolTip.add(1, "Level " + level);
            if(level == 0) {
                toolTip.add(2, (100 + experience.getExperience(ExperienceType.tool) - experience.getExperienceOfLevel(level - 1)) + "/"
                        + (100 + experience.getExperienceOfLevel(level) - experience.getExperienceOfLevel(level - 1)));
            } else if(level == 1) {
                toolTip.add(2, (experience.getExperience(ExperienceType.tool) - experience.getExperienceOfLevel(level - 1)) + "/"
                        + (100 + experience.getExperienceOfLevel(level) - experience.getExperienceOfLevel(level - 1)));
            } else {
                toolTip.add(2, (experience.getExperience(ExperienceType.tool) - experience.getExperienceOfLevel(level - 1) - 100) + "/"
                        + (experience.getExperienceOfLevel(level) - experience.getExperienceOfLevel(level - 1)));
            }
        }
    }
}
