package net.jadeite.testingmod.keybind;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.jadeite.testingmod.TestingMod;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class ModKeyMappings {

    public static final KeyMapping CHEESE_BLAST = KeyMappingHelper.registerKeyMapping(
            new KeyMapping("key.testingmod.cheese_blast", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, KeyMapping.Category.MISC));

    public static void registerKeys() {
        TestingMod.LOGGER.info("Registering Keys for " + TestingMod.MOD_ID);
    }
}