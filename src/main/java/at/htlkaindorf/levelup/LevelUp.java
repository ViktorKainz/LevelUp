package at.htlkaindorf.levelup;

import at.htlkaindorf.levelup.client.LevelUpTab;
import at.htlkaindorf.levelup.commands.LevelUpCommand;
import at.htlkaindorf.levelup.commands.UnlockAllCommand;
import at.htlkaindorf.levelup.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
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

    @SidedProxy(clientSide = "at.htlkaindorf.levelup.proxy.ClientProxy",
            serverSide = "at.htlkaindorf.levelup.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance()
    public static LevelUp INSTANCE;

    private static Logger logger;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        proxy.preinit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        proxy.postinit(event);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new LevelUpCommand());
        event.registerServerCommand(new UnlockAllCommand());
    }
}
