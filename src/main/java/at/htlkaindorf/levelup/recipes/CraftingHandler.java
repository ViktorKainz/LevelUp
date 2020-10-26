package at.htlkaindorf.levelup.recipes;

import at.htlkaindorf.levelup.capability.Group;
import com.google.common.collect.Lists;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

import java.util.ArrayList;

public class CraftingHandler {

    public static void replaceRecipes() {
        ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES;
        ArrayList<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValuesCollection());

        for (IRecipe r : recipes) {
            boolean unlockable = false;
            groups:
            for (Group g : Group.groups) {
                for (ResourceLocation location : g.getItems()) {
                    if(r.getRegistryName().equals(location)) {
                        unlockable = true;
                        break groups;
                    }
                }
            }
            if(!unlockable) {
                continue;
            }
            if (r instanceof ShapedRecipes) {
                ShapedRecipes shaped = (ShapedRecipes) r;
                recipeRegistry.remove(r.getRegistryName());
                recipeRegistry.register(new ShapedUnlockable(shaped.getGroup(), shaped.getWidth(), shaped.getHeight(),
                        shaped.getIngredients(), shaped.getRecipeOutput(), shaped.getRegistryName().toString()));
            } else if (r instanceof ShapelessRecipes) {
                ShapelessRecipes shapeless = (ShapelessRecipes) r;
                recipeRegistry.remove(r.getRegistryName());
                recipeRegistry.register(new ShapelessUnlockable(shapeless.getGroup(), shapeless.getRecipeOutput(),
                        shapeless.getIngredients(), shapeless.getRegistryName().toString()));
            }
        }
    }
}
