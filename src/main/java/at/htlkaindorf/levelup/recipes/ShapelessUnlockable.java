package at.htlkaindorf.levelup.recipes;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ShapelessUnlockable extends ShapelessRecipes {

    private final boolean unlocked;

    public ShapelessUnlockable(String group, ItemStack output, NonNullList<Ingredient> ingredients, String name, boolean unlocked) {
        super(group, output, ingredients);
        this.setRegistryName(name);
        this.unlocked = unlocked;
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        return (unlocked || CheckRecipe.isUnlocked(this, inv)) && super.matches(inv, worldIn);
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return CheckRecipe.getCraftingResult(this, inv, super.getCraftingResult(inv));
    }
}
