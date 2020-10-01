package at.htlkaindorf.levelup;

import at.htlkaindorf.levelup.proxy.CommonProxy;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(
        modid = LevelUp.MOD_ID,
        name = LevelUp.MOD_NAME,
        version = LevelUp.VERSION
)
public class LevelUp {

    public static final String MOD_ID = "levelup";
    public static final String MOD_NAME = "LevelUp";
    public static final String VERSION = "1.0";

    @SidedProxy(serverSide = "at.htlkaindorf.levelup.proxy.CommonProxy", clientSide = "at.htlkaindorf.levelup.proxy.ClientProxy")
    public static CommonProxy proxy;

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static LevelUp INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
