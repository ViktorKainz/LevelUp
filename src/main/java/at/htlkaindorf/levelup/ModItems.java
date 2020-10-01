package at.htlkaindorf.levelup;

import at.htlkaindorf.levelup.items.Ruby;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                Ruby.ruby
        );
    }

    public static void registerModels() {
        Ruby.ruby.registerItemModel();
    }

}