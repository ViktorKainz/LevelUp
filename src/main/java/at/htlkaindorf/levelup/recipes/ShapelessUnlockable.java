package at.htlkaindorf.levelup.recipes;

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
        return CheckRecipe.isUnlocked(this, inv) ? super.matches(inv, worldIn) : false;
    }
}
