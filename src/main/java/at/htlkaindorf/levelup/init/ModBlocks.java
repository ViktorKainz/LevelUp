package at.htlkaindorf.levelup.init;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.blocks.RubyOre;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = LevelUp.MODID)
public class ModBlocks
{
    @GameRegistry.ObjectHolder("levelup:rubyOre")
    public static RubyOre rubyOre;

    public static ItemBlock rubyOreItem;


    public static void init()
    {
        rubyOre = new RubyOre("ruby_ore");
        rubyOreItem = new ItemBlock(ModBlocks.rubyOre);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(rubyOre);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(rubyOreItem.setRegistryName(ModBlocks.rubyOre.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event)
    {
        registerRender(rubyOre);
        registerRender(rubyOreItem);
    }

    private static void registerRender(Block Block)
    {

    }

    private static void registerRender(ItemBlock itemblock)
    {
        ModelLoader.setCustomModelResourceLocation(itemblock,0,new ModelResourceLocation(itemblock.getRegistryName(), "inventory"));
    }

}