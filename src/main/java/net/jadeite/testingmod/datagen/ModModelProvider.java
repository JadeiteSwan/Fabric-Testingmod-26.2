package net.jadeite.testingmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.jadeite.testingmod.block.ModBlocks;
import net.jadeite.testingmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        // BLOCKS
        blockModelGenerators.createTrivialCube(ModBlocks.RAW_CHEESE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.CHEESE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.BOUNTIFUL_CHEESE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.MAGIC_BLOCK);

        // STAIRS, SLABS, FENCES, AND WALLS
        blockModelGenerators.family(ModBlocks.CHEESE_BLOCK)
                .stairs(ModBlocks.CHEESE_STAIRS)
                .slab(ModBlocks.CHEESE_SLAB)
                .button(ModBlocks.CHEESE_BUTTON)
                .pressurePlate(ModBlocks.CHEESE_PRESSURE_PLATE)
                .fence(ModBlocks.CHEESE_FENCE)
                .fenceGate(ModBlocks.CHEESE_FENCE_GATE)
                .wall(ModBlocks.CHEESE_WALL);

        // DOORS AND TRAPDOORS
        blockModelGenerators.createDoor(ModBlocks.CHEESE_DOOR);
        blockModelGenerators.createTrapdoor(ModBlocks.CHEESE_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        // ITEMS
        itemModelGenerators.generateFlatItem(ModItems.CHEESE_ITEM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_CHEESE_ITEM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COAL_CHEESE, ModelTemplates.FLAT_ITEM);

        // COMPLEX ITEMS
        itemModelGenerators.generateFlatItem(ModItems.CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);

        // FOODS
        itemModelGenerators.generateFlatItem(ModItems.MELTED_CHEESE, ModelTemplates.FLAT_ITEM);

        // TOOLS AND WEAPONS
        itemModelGenerators.generateFlatItem(ModItems.CHEESE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHEESE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHEESE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHEESE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHEESE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModItems.CHEESE_SPEAR);
    }
}
