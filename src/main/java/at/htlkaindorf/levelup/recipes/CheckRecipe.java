package at.htlkaindorf.levelup.recipes;

import at.htlkaindorf.levelup.capability.IUnlocked;
import at.htlkaindorf.levelup.capability.UnlockedProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;

public class CheckRecipe {

    private static final Field eventHandlerField = ObfuscationReflectionHelper.findField(InventoryCrafting.class, "eventHandler");
    private static final Field containerPlayerPlayerField = ObfuscationReflectionHelper.findField(ContainerPlayer.class, "player");
    private static final Field slotCraftingPlayerField = ObfuscationReflectionHelper.findField(SlotCrafting.class, "player");

    private static EntityPlayer findPlayer(InventoryCrafting inv) {
        try {
            Container container = (Container) eventHandlerField.get(inv);
            if (container instanceof ContainerPlayer) {
                return (EntityPlayer) containerPlayerPlayerField.get(container);
            } else if (container instanceof ContainerWorkbench) {
                return (EntityPlayer) slotCraftingPlayerField.get(container.getSlot(0));
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static boolean isUnlocked(IRecipe r, InventoryCrafting inv) {
        EntityPlayer player = CheckRecipe.findPlayer(inv);
        if(player != null) {
            IUnlocked unlocked = player.getCapability(UnlockedProvider.UNLOCKED_CAP, null);
            return unlocked.isUnlocked(r.getRecipeOutput().getItem().getRegistryName());
        }
        return true;
    }
}
