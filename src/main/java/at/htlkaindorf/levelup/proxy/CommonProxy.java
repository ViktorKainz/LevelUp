package at.htlkaindorf.levelup.proxy;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.blocks.RubyOre;
import at.htlkaindorf.levelup.capability.EventHandler;
import at.htlkaindorf.levelup.items.ender.*;
import at.htlkaindorf.levelup.items.magma.*;
import at.htlkaindorf.levelup.items.ruby.*;
import at.htlkaindorf.levelup.items.wither.*;
import at.htlkaindorf.levelup.world.ModWorldGen;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
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

        addBlock(new RubyOre());

        addItem(new Ruby());
        addItem(new RubySword());
        addItem(new RubyAxe());
        addItem(new RubyShovel());
        addItem(new RubyPickaxe());
        addItem(new RubyHoe());
        addItem(new RubyHelmet());
        addItem(new RubyChestplate());
        addItem(new RubyLeggings());
        addItem(new RubyBoots());

        addItem(new MagmaIngot());
        addItem(new MagmaSword());
        addItem(new MagmaAxe());
        addItem(new MagmaShovel());
        addItem(new MagmaPickaxe());
        addItem(new MagmaHoe());
        addItem(new MagmaHelmet());
        addItem(new MagmaChestplate());
        addItem(new MagmaLeggings());
        addItem(new MagmaBoots());

        addItem(new EnderDiamond());
        addItem(new EnderSword());
        addItem(new EnderAxe());
        addItem(new EnderShovel());
        addItem(new EnderPickaxe());
        addItem(new EnderHoe());
        addItem(new EnderHelmet());
        addItem(new EnderChestplate());
        addItem(new EnderLeggings());
        addItem(new EnderBoots());

        addItem(new WitherIngot());
        addItem(new WitherSword());
        addItem(new WitherAxe());
        addItem(new WitherShovel());
        addItem(new WitherPickaxe());
        addItem(new WitherHoe());
        addItem(new WitherHelmet());
        addItem(new WitherChestplate());
        addItem(new WitherLeggings());
        addItem(new WitherBoots());

        MinecraftForge.EVENT_BUS.register(new EventHandler());
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
