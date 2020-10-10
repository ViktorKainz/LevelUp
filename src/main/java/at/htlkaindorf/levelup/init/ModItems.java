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
    public static Item rubyHelmet;
    public static Item rubyChestplate;
    public static Item rubyLeggings;
    public static Item rubyBoots;

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
        rubySword = new RubySword(Materials.RUBY_TOOL_MATERIAL, "ruby_sword");
        rubyAxe = new RubyAxe(Materials.RUBY_TOOL_MATERIAL, "ruby_axe");
        rubyShovel = new RubyShovel(Materials.RUBY_TOOL_MATERIAL, "ruby_shovel");
        rubyPickaxe = new RubyPickaxe(Materials.RUBY_TOOL_MATERIAL, "ruby_pickaxe");
        rubyHoe = new RubyHoe(Materials.RUBY_TOOL_MATERIAL, "ruby_hoe");
        rubyHelmet = new RubyHelmet(Materials.RUBY_ARMOR_MATERIAL, "ruby_helmet");
        rubyChestplate = new RubyChestplate(Materials.RUBY_ARMOR_MATERIAL, "ruby_chestplate");
        rubyLeggings = new RubyLeggings(Materials.RUBY_ARMOR_MATERIAL, "ruby_leggings");
        rubyBoots = new RubyBoots(Materials.RUBY_ARMOR_MATERIAL, "ruby_boots");

        magmaIngot = new MagmaIngot("magma_ingot");
        magmaSword = new MagmaSword(Materials.MAGMA_TOOL_MATERIAL, "magma_sword");
        magmaAxe = new MagmaAxe(Materials.MAGMA_TOOL_MATERIAL, "magma_axe");
        magmaShovel = new MagmaShovel(Materials.MAGMA_TOOL_MATERIAL, "magma_shovel");
        magmaPickaxe = new MagmaPickaxe(Materials.MAGMA_TOOL_MATERIAL, "magma_pickaxe");
        magmaHoe = new MagmaHoe(Materials.MAGMA_TOOL_MATERIAL, "magma_hoe");

        enderIngot = new EnderDiamond("ender_diamond");
        enderSword = new EnderSword(Materials.ENDER_TOOL_MATERIAL, "ender_sword");
        enderAxe = new EnderAxe(Materials.ENDER_TOOL_MATERIAL, "ender_axe");
        enderShovel = new EnderShovel(Materials.ENDER_TOOL_MATERIAL, "ender_shovel");
        enderPickaxe = new EnderPickaxe(Materials.ENDER_TOOL_MATERIAL, "ender_pickaxe");
        enderHoe = new EnderHoe(Materials.ENDER_TOOL_MATERIAL, "ender_hoe");
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
                rubyHelmet,
                rubyChestplate,
                rubyLeggings,
                rubyBoots,
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
        registerRender(rubyHelmet);
        registerRender(rubyChestplate);
        registerRender(rubyLeggings);
        registerRender(rubyBoots);
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