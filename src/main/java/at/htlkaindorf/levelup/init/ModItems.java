package at.htlkaindorf.levelup.init;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.items.*;
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
    public static Item rubyShovel;
    public static Item rubyPickaxe;
    public static Item rubyHoe;

    public static void init() {
        ruby = new Ruby("ruby");
        rubySword = new RubySword(Materials.rubyToolMatMATERIAL, "ruby_sword");
        rubyAxe = new RubyAxe(Materials.rubyToolMatMATERIAL, "ruby_axe");
        rubyShovel = new RubyShovel(Materials.rubyToolMatMATERIAL, "ruby_shovel");
        rubyPickaxe = new RubyPickaxe(Materials.rubyToolMatMATERIAL, "ruby_pickaxe");
        rubyHoe = new RubyHoe(Materials.rubyToolMatMATERIAL, "ruby_hoe");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ruby,
                rubySword,
                rubyAxe,
                rubyShovel,
                rubyPickaxe,
                rubyHoe
        );
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(ruby);
        registerRender(rubySword);
        registerRender(rubyAxe);
        registerRender(rubyShovel);
        registerRender(rubyPickaxe);
        registerRender(rubyHoe);
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}