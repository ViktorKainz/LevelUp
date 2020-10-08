package at.htlkaindorf.levelup.init;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.items.Ruby;
import at.htlkaindorf.levelup.items.RubyAxe;
import at.htlkaindorf.levelup.items.RubySword;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = LevelUp.MOD_ID)
public class ModItems {
    public static Item ruby;
    public static Item rubySword;
    public static Item rubyAxe;

    public static void init() {
        ruby = new Ruby("ruby");
        rubySword = new RubySword(Materials.rubyToolMatMATERIAL, "ruby_sword");
        rubyAxe = new RubyAxe(Materials.rubyToolMatMATERIAL, "ruby_axe");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ruby,
                rubySword,
                rubyAxe
        );
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(ruby);
        registerRender(rubySword);
        registerRender(rubyAxe);
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}