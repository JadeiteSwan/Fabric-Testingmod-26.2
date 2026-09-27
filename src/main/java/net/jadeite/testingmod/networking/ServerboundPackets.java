package net.jadeite.testingmod.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.jadeite.testingmod.networking.packet.TestPayloadC2S;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityTypes;

public class ServerboundPackets {

    public static void handleTestPayload(TestPayloadC2S payload, ServerPlayNetworking.Context context) {
        EntityTypes.COW.spawn(context.player().level(), context.player().getOnPos(), EntitySpawnReason.TRIGGERED);
        context.player().sendSystemMessage(Component.literal("A " + payload.name() + " has been granted by The Cheese."), true);
    }
}