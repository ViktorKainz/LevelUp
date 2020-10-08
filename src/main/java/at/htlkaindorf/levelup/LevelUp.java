package at.htlkaindorf.levelup;

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


    @Mod.Instance(MOD_ID)
    public static LevelUp INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
