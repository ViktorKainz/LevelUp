package at.htlkaindorf.levelup.proxy;

import at.htlkaindorf.levelup.eventHandler.ClientEventHandler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.input.Keyboard;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    public static KeyBinding[] keyBindings;

    @Override
    public void preinit(FMLPreInitializationEvent event) {
        super.preinit(event);
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        keyBindings = new KeyBinding[3];

        keyBindings[0] = new KeyBinding("Skill 1", Keyboard.KEY_Z, "LevelUP");
        keyBindings[1] = new KeyBinding("Skill 2", Keyboard.KEY_H, "LevelUP");
        keyBindings[2] = new KeyBinding("Skill 3", Keyboard.KEY_N, "LevelUP");

        for (KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
    }

}
