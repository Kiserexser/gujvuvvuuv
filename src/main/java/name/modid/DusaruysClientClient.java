package name.modid;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class DusaruysClientClient implements ClientModInitializer {
    public static ClickGUI clickGUI = new ClickGUI();

    @Override
    public void onInitializeClient() {
        KeyBinding openMenu = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.dusaruysclient.open",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "category.dusaruysclient"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (openMenu.wasPressed()) {
                clickGUI.toggle();
            }
        });
    }
}
