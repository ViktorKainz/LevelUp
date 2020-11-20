package at.htlkaindorf.levelup.proxy;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.blocks.RubyBlock;
import at.htlkaindorf.levelup.blocks.RubyOre;
import at.htlkaindorf.levelup.blocks.SapphireBlock;
import at.htlkaindorf.levelup.blocks.SapphireOre;
import at.htlkaindorf.levelup.capability.CapabilityHandler;
import at.htlkaindorf.levelup.capability.experience.Experience;
import at.htlkaindorf.levelup.capability.experience.ExperienceStorage;
import at.htlkaindorf.levelup.capability.experience.IExperience;
import at.htlkaindorf.levelup.config.ModConfig;
import at.htlkaindorf.levelup.eventHandler.ExperienceHandler;
import at.htlkaindorf.levelup.eventHandler.ItemHandler;
import at.htlkaindorf.levelup.items.emerald.armor.EmeraldBoots;
import at.htlkaindorf.levelup.items.emerald.armor.EmeraldChestplate;
import at.htlkaindorf.levelup.items.emerald.armor.EmeraldHelmet;
import at.htlkaindorf.levelup.items.emerald.armor.EmeraldLeggings;
import at.htlkaindorf.levelup.items.emerald.tools.*;
import at.htlkaindorf.levelup.items.ender.EnderDiamond;
import at.htlkaindorf.levelup.items.ender.armor.EnderBoots;
import at.htlkaindorf.levelup.items.ender.armor.EnderChestplate;
import at.htlkaindorf.levelup.items.ender.armor.EnderHelmet;
import at.htlkaindorf.levelup.items.ender.armor.EnderLeggings;
import at.htlkaindorf.levelup.items.ender.tools.*;
import at.htlkaindorf.levelup.items.magma.MagmaIngot;
import at.htlkaindorf.levelup.items.magma.armor.MagmaBoots;
import at.htlkaindorf.levelup.items.magma.armor.MagmaChestplate;
import at.htlkaindorf.levelup.items.magma.armor.MagmaHelmet;
import at.htlkaindorf.levelup.items.magma.armor.MagmaLeggings;
import at.htlkaindorf.levelup.items.magma.tools.*;
import at.htlkaindorf.levelup.items.ruby.Ruby;
import at.htlkaindorf.levelup.items.ruby.armor.RubyBoots;
import at.htlkaindorf.levelup.items.ruby.armor.RubyChestplate;
import at.htlkaindorf.levelup.items.ruby.armor.RubyHelmet;
import at.htlkaindorf.levelup.items.ruby.armor.RubyLeggings;
import at.htlkaindorf.levelup.items.ruby.tools.*;
import at.htlkaindorf.levelup.items.sapphire.Sapphire;
import at.htlkaindorf.levelup.items.sapphire.armor.SapphireBoots;
import at.htlkaindorf.levelup.items.sapphire.armor.SapphireChestplate;
import at.htlkaindorf.levelup.items.sapphire.armor.SapphireHelmet;
import at.htlkaindorf.levelup.items.sapphire.armor.SapphireLeggings;
import at.htlkaindorf.levelup.items.sapphire.tools.*;
import at.htlkaindorf.levelup.items.wither.WitherIngot;
import at.htlkaindorf.levelup.items.wither.armor.WitherBoots;
import at.htlkaindorf.levelup.items.wither.armor.WitherChestplate;
import at.htlkaindorf.levelup.items.wither.armor.WitherHelmet;
import at.htlkaindorf.levelup.items.wither.armor.WitherLeggings;
import at.htlkaindorf.levelup.items.wither.tools.*;
import at.htlkaindorf.levelup.recipes.CraftingHandler;
import at.htlkaindorf.levelup.world.ModWorldGen;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
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
        addBlock(new RubyBlock());
        addBlock(new SapphireOre());
        addBlock(new SapphireBlock());

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

        addItem(new Sapphire());
        addItem(new SapphireSword());
        addItem(new SapphireAxe());
        addItem(new SapphireShovel());
        addItem(new SapphirePickaxe());
        addItem(new SapphireHoe());
        addItem(new SapphireHelmet());
        addItem(new SapphireChestplate());
        addItem(new SapphireLeggings());
        addItem(new SapphireBoots());

        addItem(new EmeraldSword());
        addItem(new EmeraldAxe());
        addItem(new EmeraldShovel());
        addItem(new EmeraldPickaxe());
        addItem(new EmeraldHoe());
        addItem(new EmeraldHelmet());
        addItem(new EmeraldChestplate());
        addItem(new EmeraldLeggings());
        addItem(new EmeraldBoots());

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

        CapabilityManager.INSTANCE.register(IExperience.class, new ExperienceStorage(), Experience::new);
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new ExperienceHandler());
        MinecraftForge.EVENT_BUS.register(new ItemHandler());

        ModConfig.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        CraftingHandler.replaceRecipes();
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
