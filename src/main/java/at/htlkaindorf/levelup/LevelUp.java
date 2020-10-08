package at.htlkaindorf.levelup;

import at.htlkaindorf.levelup.client.LevelUpTab;
import at.htlkaindorf.levelup.init.ModBlocks;
import at.htlkaindorf.levelup.init.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = LevelUp.MODID,
        name = LevelUp.NAME,
        version = LevelUp.VERSION
)
public class LevelUp {

    public static final String MODID = "levelup";
    public static final String NAME = "LevelUp";
    public static final String VERSION = "1.0";

    public static final LevelUpTab LEVEL_UP_TAB = new LevelUpTab();


    @Mod.Instance()
    public static LevelUp INSTANCE;

    private static Logger logger;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        ModItems.init();
        ModBlocks.init();
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
