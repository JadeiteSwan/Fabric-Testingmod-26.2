package net.jadeite.testingmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.jadeite.testingmod.event.ModClientEvents;
import net.jadeite.testingmod.keybind.ModKeyMappings;

public class TestingModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModKeyMappings.registerKeys();

        ClientTickEvents.END_CLIENT_TICK.register(ModClientEvents::onEndTick);
    }
}