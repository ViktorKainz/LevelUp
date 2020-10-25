package at.htlkaindorf.levelup.recipes;

import at.htlkaindorf.levelup.capability.ExperienceProvider;
import at.htlkaindorf.levelup.capability.ExperienceType;
import at.htlkaindorf.levelup.capability.IExperience;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ShapelessUnlockable extends ShapelessRecipes {

    public ShapelessUnlockable(String group, ItemStack output, NonNullList<Ingredient> ingredients, String name) {
        super(group, output, ingredients);
        this.setRegistryName(name);
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        EntityPlayer player = CraftingHandler.findPlayer(inv);
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        return experience.getExperience(ExperienceType.Mining) > 10 ? super.matches(inv, worldIn) : false;
    }
}
