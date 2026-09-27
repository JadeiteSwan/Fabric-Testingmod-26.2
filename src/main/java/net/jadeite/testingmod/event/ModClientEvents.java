package net.jadeite.testingmod.event;

import net.jadeite.testingmod.keybind.ModKeyMappings;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class ModClientEvents {

    public static void onEndTick(Minecraft client) {
        while(ModKeyMappings.CHEESE_BLAST.consumeClick()) {
            client.player.sendSystemMessage(Component.literal("CHEESE BLAST!"));
        }
    }
}