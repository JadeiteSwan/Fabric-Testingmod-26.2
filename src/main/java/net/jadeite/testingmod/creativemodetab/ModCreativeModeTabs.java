package net.jadeite.testingmod.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.jadeite.testingmod.TestingMod;
import net.jadeite.testingmod.block.ModBlocks;
import net.jadeite.testingmod.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {

    public static final CreativeModeTab CHEESE_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, "cheese_items"), FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.CHEESE_ITEM))
            .title(Component.translatable("creativemodetab.testingmod.cheese_items"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.RAW_CHEESE_ITEM);
                output.accept(ModItems.CHEESE_ITEM);
                output.accept(ModItems.MELTED_CHEESE);
                output.accept(ModItems.COAL_CHEESE);
            }).build());

    public static final CreativeModeTab CHEESE_BLOCK_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, "cheese_blocks"), FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.CHEESE_BLOCK))
            .title(Component.translatable("creativemodetab.testingmod.cheese_blocks"))
            .displayItems((parameters, output) -> {

                // BLOCKS
                output.accept(ModBlocks.CHEESE_BLOCK);
                output.accept(ModBlocks.RAW_CHEESE_BLOCK);
                output.accept(ModBlocks.CHEESE_ORE);
                output.accept(ModBlocks.BOUNTIFUL_CHEESE_ORE);
                output.accept(ModBlocks.MAGIC_BLOCK);

                // STAIRS AND SLABS
                output.accept(ModBlocks.CHEESE_STAIRS);
                output.accept(ModBlocks.CHEESE_SLAB);

                // FENCES AND WALLS
                output.accept(ModBlocks.CHEESE_FENCE);
                output.accept(ModBlocks.CHEESE_FENCE_GATE);
                output.accept(ModBlocks.CHEESE_WALL);

                // DOORS AND TRAPDOORS
                output.accept(ModBlocks.CHEESE_DOOR);
                output.accept(ModBlocks.CHEESE_TRAPDOOR);

                // REDSTONE BLOCKS
                output.accept(ModBlocks.CHEESE_BUTTON);
                output.accept(ModBlocks.CHEESE_PRESSURE_PLATE);

            }).build());

    public static final CreativeModeTab CHEESE_TOOL_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, "cheese_tools"), FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.CHISEL))
            .title(Component.translatable("creativemodetab.testingmod.cheese_tools"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.CHEESE_SWORD);
                output.accept(ModItems.CHEESE_PICKAXE);
                output.accept(ModItems.CHEESE_AXE);
                output.accept(ModItems.CHEESE_SHOVEL);
                output.accept(ModItems.CHEESE_HOE);
                output.accept(ModItems.CHEESE_SPEAR);
                output.accept(ModItems.CHISEL);
            }).build());

    public static void registerModCreativeModeTabs() {
        TestingMod.LOGGER.info("Registering Creative Mode Tabs for " + TestingMod.MOD_ID);
    }
}