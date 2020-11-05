package at.htlkaindorf.levelup.capability;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.capability.experience.ExperienceProvider;
import at.htlkaindorf.levelup.capability.skillpoint.SkillPointProvider;
import at.htlkaindorf.levelup.capability.unlocked.UnlockedProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {

    public static final ResourceLocation EXPERIENCE_CAP = new ResourceLocation(LevelUp.MODID, "experience");
    public static final ResourceLocation UNLOCKED_CAP = new ResourceLocation(LevelUp.MODID, "unlocked");
    public static final ResourceLocation SKILLPOINT_CAP = new ResourceLocation(LevelUp.MODID, "skillpoint");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(EXPERIENCE_CAP, new ExperienceProvider());
            event.addCapability(UNLOCKED_CAP, new UnlockedProvider());
            event.addCapability(SKILLPOINT_CAP, new SkillPointProvider());
        }
    }
}
