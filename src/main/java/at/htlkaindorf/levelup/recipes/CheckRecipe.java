package at.htlkaindorf.levelup.recipes;

import at.htlkaindorf.levelup.config.Group;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;

public class CheckRecipe {

    private static final Field eventHandlerField = ObfuscationReflectionHelper.findField(InventoryCrafting.class, "field_70465_c");
    private static final Field containerPlayerPlayerField = ObfuscationReflectionHelper.findField(ContainerPlayer.class, "field_82862_h");
    private static final Field slotCraftingPlayerField = ObfuscationReflectionHelper.findField(SlotCrafting.class, "field_75238_b");

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
        if (player != null) {
            for (Group g : Group.groups.values()) {
                if (g.isUnlockedBy(player) && g.getItems().contains(r.getRegistryName())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static ItemStack getCraftingResult(IRecipe r, InventoryCrafting inv, ItemStack stack) {
        EntityPlayer player = CheckRecipe.findPlayer(inv);
        if (player != null && stack.isStackable()) {
            double amount = 1;
            for (Group g : Group.groups.values()) {
                if (g.isUnlockedBy(player) && g.getAmounts().containsKey(r.getRegistryName())) {
                    if(amount < g.getAmounts().get(r.getRegistryName())) {
                        amount = g.getAmounts().get(r.getRegistryName());
                    }
                }
            }
            stack.setCount((int)(stack.getCount() * amount));
        }
        return stack;
    }
}
