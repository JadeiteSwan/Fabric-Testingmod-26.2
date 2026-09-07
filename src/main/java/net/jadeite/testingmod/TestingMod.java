package net.jadeite.testingmod;

import net.fabricmc.api.ModInitializer;

import net.jadeite.testingmod.block.ModBlocks;
import net.jadeite.testingmod.creativemodetab.ModCreativeModeTabs;
import net.jadeite.testingmod.item.ModItems;
import net.jadeite.testingmod.registries.ModFuels;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestingMod implements ModInitializer {
	public static final String MOD_ID = "testingmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModFuels.registerFuels();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
