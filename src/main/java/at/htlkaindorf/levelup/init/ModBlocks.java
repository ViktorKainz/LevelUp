package at.htlkaindorf.levelup.init;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.blocks.RubyOre;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = LevelUp.MOD_ID)
public class ModBlocks
{
    public static Block rubyOre;

    public static void init()
    {
        rubyOre = new RubyOre("rubyOre");
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(rubyOre);
    }
}