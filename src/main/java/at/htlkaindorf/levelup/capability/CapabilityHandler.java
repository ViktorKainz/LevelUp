package at.htlkaindorf.levelup.capability;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.capability.experience.ExperienceProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {

    public static final ResourceLocation EXPERIENCE_CAP = new ResourceLocation(LevelUp.MODID, "experience");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(EXPERIENCE_CAP, new ExperienceProvider());
        }
        if (event.getObject() instanceof ItemStack) {
            Item i = ((ItemStack) event.getObject()).getItem();
            if ( i instanceof ItemTool || i instanceof ItemHoe || i instanceof ItemSword || i instanceof ItemBow) {
                event.addCapability(EXPERIENCE_CAP, new ExperienceProvider());
            }
        }
    }
}
