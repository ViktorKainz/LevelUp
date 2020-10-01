package at.htlkaindorf.levelup;

import at.htlkaindorf.levelup.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemBase ruby = new ItemBase("Ruby").setCreativeTab(CreativeTabs.MATERIALS);


    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                ruby
        );
    }

    public static void registerModels() {
        ruby.registerItemModel();
    }

}