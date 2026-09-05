package net.jadeite.testingmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.jadeite.testingmod.datagen.ModBlockLootTableProvider;
import net.jadeite.testingmod.datagen.ModBlockTagsProvider;
import net.jadeite.testingmod.datagen.ModModelProvider;
import net.jadeite.testingmod.datagen.ModRecipeProvider;

public class TestingModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
