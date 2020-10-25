package at.htlkaindorf.levelup.recipes;

import at.htlkaindorf.levelup.capability.ExperienceProvider;
import at.htlkaindorf.levelup.capability.ExperienceType;
import at.htlkaindorf.levelup.capability.IExperience;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;


public class ShapedUnlockable extends ShapedRecipes {

    public ShapedUnlockable(String group, int width, int height, NonNullList<Ingredient> ingredients, ItemStack result, String name) {
        super(group, width, height, ingredients, result);
        this.setRegistryName(name);
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        EntityPlayer player = CraftingHandler.findPlayer(inv);
        IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
        return experience.getExperience(ExperienceType.Mining) > 10 ? super.matches(inv, worldIn) : false;
    }
}
