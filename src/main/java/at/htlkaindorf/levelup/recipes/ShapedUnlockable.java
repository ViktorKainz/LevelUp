package at.htlkaindorf.levelup.recipes;

import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;


public class ShapedUnlockable extends ShapedRecipes {

    private boolean unlocked;

    public ShapedUnlockable(String group, int width, int height, NonNullList<Ingredient> ingredients, ItemStack result, String name, boolean unlocked) {
        super(group, width, height, ingredients, result);
        this.setRegistryName(name);
        this.unlocked = unlocked;
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        return unlocked || CheckRecipe.isUnlocked(this, inv) ? super.matches(inv, worldIn) : false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return CheckRecipe.getCraftingResult(this, inv, super.getCraftingResult(inv));
    }
}
