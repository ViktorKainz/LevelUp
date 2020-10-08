package at.htlkaindorf.levelup.init;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = LevelUp.MOD_ID)
public class ModItems {
    public static Item RubyOre;

    public static void init()
    {

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll();
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event)
    {
        registerRender(RubyOre);
    }

    private static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item,0,new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}