package net.jadeite.testingmod.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.jadeite.testingmod.keybind.ModKeyMappings;
import net.jadeite.testingmod.networking.packet.TestPayloadC2S;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class ModClientEvents {

    public static void onEndTick(Minecraft client) {
        while(ModKeyMappings.CHEESE_BLAST.consumeClick()) {
            client.player.sendSystemMessage(Component.literal("CHEESE BLAST!"));
            ClientPlayNetworking.send(new TestPayloadC2S("Magic cow", 1));
        }
    }
}