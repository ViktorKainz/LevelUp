package at.htlkaindorf.levelup.init;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.items.ender.*;
import at.htlkaindorf.levelup.items.magma.*;
import at.htlkaindorf.levelup.items.ruby.*;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = LevelUp.MODID)
public class ModItems {
    public static Item ruby;
    public static Item rubySword;
    public static Item rubyAxe;
    public static Item rubyShovel;
    public static Item rubyPickaxe;
    public static Item rubyHoe;
    public static Item magmaIngot;
    public static Item magmaSword;
    public static Item magmaAxe;
    public static Item magmaShovel;
    public static Item magmaPickaxe;
    public static Item magmaHoe;
    public static Item enderIngot;
    public static Item enderSword;
    public static Item enderAxe;
    public static Item enderShovel;
    public static Item enderPickaxe;
    public static Item enderHoe;

    public static void init() {
        ruby = new Ruby("ruby");
        rubySword = new RubySword(Materials.rubyToolMatMATERIAL, "ruby_sword");
        rubyAxe = new RubyAxe(Materials.rubyToolMatMATERIAL, "ruby_axe");
        rubyShovel = new RubyShovel(Materials.rubyToolMatMATERIAL, "ruby_shovel");
        rubyPickaxe = new RubyPickaxe(Materials.rubyToolMatMATERIAL, "ruby_pickaxe");
        rubyHoe = new RubyHoe(Materials.rubyToolMatMATERIAL, "ruby_hoe");
        magmaIngot = new MagmaIngot("magma_ingot");
        magmaSword = new MagmaSword(Materials.magmaToolMatMATERIAL, "magma_sword");
        magmaAxe = new MagmaAxe(Materials.magmaToolMatMATERIAL, "magma_axe");
        magmaShovel = new MagmaShovel(Materials.magmaToolMatMATERIAL, "magma_shovel");
        magmaPickaxe = new MagmaPickaxe(Materials.magmaToolMatMATERIAL, "magma_pickaxe");
        magmaHoe = new MagmaHoe(Materials.magmaToolMatMATERIAL, "magma_hoe");
        enderIngot = new EnderDiamond("ender_diamond");
        enderSword = new EnderSword(Materials.enderToolMatMATERIAL, "ender_sword");
        enderAxe = new EnderAxe(Materials.enderToolMatMATERIAL, "ender_axe");
        enderShovel = new EnderShovel(Materials.enderToolMatMATERIAL, "ender_shovel");
        enderPickaxe = new EnderPickaxe(Materials.enderToolMatMATERIAL, "ender_pickaxe");
        enderHoe = new EnderHoe(Materials.enderToolMatMATERIAL, "ender_hoe");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ruby,
                rubySword,
                rubyAxe,
                rubyShovel,
                rubyPickaxe,
                rubyHoe,
                magmaIngot,
                magmaSword,
                magmaAxe,
                magmaShovel,
                magmaPickaxe,
                magmaHoe,
                enderIngot,
                enderSword,
                enderAxe,
                enderShovel,
                enderPickaxe,
                enderHoe
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
        registerRender(magmaIngot);
        registerRender(magmaSword);
        registerRender(magmaAxe);
        registerRender(magmaShovel);
        registerRender(magmaPickaxe);
        registerRender(magmaHoe);
        registerRender(enderIngot);
        registerRender(enderSword);
        registerRender(enderAxe);
        registerRender(enderShovel);
        registerRender(enderPickaxe);
        registerRender(enderHoe);
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}