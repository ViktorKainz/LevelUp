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

        addBlock(new RubyOre("ruby_ore"));

        addItem(new Ruby("ruby"));
        addItem(new RubySword(Materials.RUBY_TOOL_MATERIAL, "ruby_sword"));
        addItem(new RubyAxe(Materials.RUBY_TOOL_MATERIAL, "ruby_axe"));
        addItem(new RubyShovel(Materials.RUBY_TOOL_MATERIAL, "ruby_shovel"));
        addItem(new RubyPickaxe(Materials.RUBY_TOOL_MATERIAL, "ruby_pickaxe"));
        addItem(new RubyHoe(Materials.RUBY_TOOL_MATERIAL, "ruby_hoe"));
        addItem(new RubyHelmet(Materials.RUBY_ARMOR_MATERIAL, "ruby_helmet"));
        addItem(new RubyChestplate(Materials.RUBY_ARMOR_MATERIAL, "ruby_chestplate"));
        addItem(new RubyLeggings(Materials.RUBY_ARMOR_MATERIAL, "ruby_leggings"));
        addItem(new RubyBoots(Materials.RUBY_ARMOR_MATERIAL, "ruby_boots"));

        addItem(new MagmaIngot("magma_ingot"));
        addItem(new MagmaSword(Materials.MAGMA_TOOL_MATERIAL, "magma_sword"));
        addItem(new MagmaAxe(Materials.MAGMA_TOOL_MATERIAL, "magma_axe"));
        addItem(new MagmaShovel(Materials.MAGMA_TOOL_MATERIAL, "magma_shovel"));
        addItem(new MagmaPickaxe(Materials.MAGMA_TOOL_MATERIAL, "magma_pickaxe"));
        addItem(new MagmaHoe(Materials.MAGMA_TOOL_MATERIAL, "magma_hoe"));

        addItem(new EnderDiamond("ender_diamond"));
        addItem(new EnderSword(Materials.ENDER_TOOL_MATERIAL, "ender_sword"));
        addItem(new EnderAxe(Materials.ENDER_TOOL_MATERIAL, "ender_axe"));
        addItem(new EnderShovel(Materials.ENDER_TOOL_MATERIAL, "ender_shovel"));
        addItem(new EnderPickaxe(Materials.ENDER_TOOL_MATERIAL, "ender_pickaxe"));
        addItem(new EnderHoe(Materials.ENDER_TOOL_MATERIAL, "ender_hoe"));
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

    private void addBlock(Block b) {
        blocks.put(b.getRegistryName().toString(), b);
        addItemBlockOf(b);
    }

    private void addItem(Item i) {
        items.put(i.getRegistryName().toString(), i);
    }

    private void addItemBlockOf(Block b) {
        ItemBlock i = new ItemBlock(b);
        i.setRegistryName(b.getRegistryName());
        i.setUnlocalizedName(b.getUnlocalizedName());
        items.put(i.getRegistryName().toString(), i);
    }
}
