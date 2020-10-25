package at.htlkaindorf.levelup.capability;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {

    public static final ResourceLocation EXPERIENCE_CAP = new ResourceLocation(LevelUp.MODID, "experience");
    public static final ResourceLocation UNLOCKED_CAP = new ResourceLocation(LevelUp.MODID, "unlocked");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(EXPERIENCE_CAP, new ExperienceProvider());
            event.addCapability(UNLOCKED_CAP, new UnlockedProvider());
        }
    }
}
