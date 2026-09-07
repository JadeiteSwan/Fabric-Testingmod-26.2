package net.jadeite.testingmod.registries;

import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.jadeite.testingmod.item.ModItems;

public class ModFuels {
    public static void registerFuels() {
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.COAL_CHEESE, 2400);
        });
    }
}
