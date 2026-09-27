package net.jadeite.testingmod.networking;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.jadeite.testingmod.networking.packet.TestPayloadC2S;
import net.minecraft.network.RegistryFriendlyByteBuf;

public class ModPackets {

    private static void registerClientbound(PayloadTypeRegistry<RegistryFriendlyByteBuf> registry) {

    }

    private static void registerServerbound(PayloadTypeRegistry<RegistryFriendlyByteBuf> registry) {
        registry.register(TestPayloadC2S.TYPE, TestPayloadC2S.STREAM_CODEC);

        ServerPlayNetworking.registerGlobalReceiver(TestPayloadC2S.TYPE, ServerboundPackets::handleTestPayload);
    }

    public static void registerPackets() {
        registerClientbound(PayloadTypeRegistry.clientboundPlay());
        registerServerbound(PayloadTypeRegistry.serverboundPlay());
    }
}