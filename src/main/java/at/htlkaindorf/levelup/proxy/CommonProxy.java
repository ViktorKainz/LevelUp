package at.htlkaindorf.levelup.proxy;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.blocks.RubyOre;
import at.htlkaindorf.levelup.items.ender.*;
import at.htlkaindorf.levelup.items.magma.*;
import at.htlkaindorf.levelup.items.ruby.*;
import at.htlkaindorf.levelup.materials.Materials;
import at.htlkaindorf.levelup.world.ModWorldGen;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Map;
import java.util.TreeMap;

@Mod.EventBusSubscriber(modid = LevelUp.MODID)
public class CommonProxy {

    public static Map<String, Block> blocks = new TreeMap<>();
    public static Map<String, Item> items = new TreeMap<>();

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);

        blocks.put("ruby_ore", new RubyOre("ruby_ore"));
        items.put("ruby_ore", new ItemBlock(blocks.get("ruby_ore")).setRegistryName("ruby_ore"));

        items.put("ruby", new Ruby("ruby"));
        items.put("ruby_sword", new RubySword(Materials.RUBY_TOOL_MATERIAL, "ruby_sword"));
        items.put("ruby_axe", new RubyAxe(Materials.RUBY_TOOL_MATERIAL, "ruby_axe"));
        items.put("ruby_shovel", new RubyShovel(Materials.RUBY_TOOL_MATERIAL, "ruby_shovel"));
        items.put("ruby_pickaxe", new RubyPickaxe(Materials.RUBY_TOOL_MATERIAL, "ruby_pickaxe"));
        items.put("ruby_hoe", new RubyHoe(Materials.RUBY_TOOL_MATERIAL, "ruby_hoe"));
        items.put("ruby_helmet", new RubyHelmet(Materials.RUBY_ARMOR_MATERIAL, "ruby_helmet"));
        items.put("ruby_chestplate", new RubyChestplate(Materials.RUBY_ARMOR_MATERIAL, "ruby_chestplate"));
        items.put("ruby_leggings", new RubyLeggings(Materials.RUBY_ARMOR_MATERIAL, "ruby_leggings"));
        items.put("ruby_boots", new RubyBoots(Materials.RUBY_ARMOR_MATERIAL, "ruby_boots"));

        items.put("magma_ingot", new MagmaIngot("magma_ingot"));
        items.put("magma_sword", new MagmaSword(Materials.MAGMA_TOOL_MATERIAL, "magma_sword"));
        items.put("magma_axe", new MagmaAxe(Materials.MAGMA_TOOL_MATERIAL, "magma_axe"));
        items.put("magma_shovel", new MagmaShovel(Materials.MAGMA_TOOL_MATERIAL, "magma_shovel"));
        items.put("magma_pickaxe", new MagmaPickaxe(Materials.MAGMA_TOOL_MATERIAL, "magma_pickaxe"));
        items.put("magma_hoe", new MagmaHoe(Materials.MAGMA_TOOL_MATERIAL, "magma_hoe"));
        items.put("magma_helmet", new RubyHelmet(Materials.MAGMA_ARMOR_MATERIAL, "magma_helmet"));
        items.put("magma_chestplate", new RubyChestplate(Materials.MAGMA_ARMOR_MATERIAL, "magma_chestplate"));
        items.put("magma_leggings", new RubyLeggings(Materials.MAGMA_ARMOR_MATERIAL, "magma_leggings"));
        items.put("magma_boots", new RubyBoots(Materials.MAGMA_ARMOR_MATERIAL, "magma_boots"));

        items.put("ender_diamond", new EnderDiamond("ender_diamond"));
        items.put("ender_sword", new EnderSword(Materials.ENDER_TOOL_MATERIAL, "ender_sword"));
        items.put("ender_axe", new EnderAxe(Materials.ENDER_TOOL_MATERIAL, "ender_axe"));
        items.put("ender_shovel", new EnderShovel(Materials.ENDER_TOOL_MATERIAL, "ender_shovel"));
        items.put("ender_pickaxe", new EnderPickaxe(Materials.ENDER_TOOL_MATERIAL, "ender_pickaxe"));
        items.put("ender_hoe", new EnderHoe(Materials.ENDER_TOOL_MATERIAL, "ender_hoe"));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        for (Block b : blocks.values()) {
            event.getRegistry().register(b);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (Item i : items.values()) {
            event.getRegistry().register(i);
        }
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        for (Item i : items.values()) {
            registerRender(i);
        }
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    private static void registerRender(ItemBlock itemblock) {
        ModelLoader.setCustomModelResourceLocation(itemblock, 0, new ModelResourceLocation(itemblock.getRegistryName(), "inventory"));
    }
}
