package net.jadeite.testingmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.jadeite.testingmod.block.ModBlocks;
import net.jadeite.testingmod.block.custom.CheeseLampBlock;
import net.jadeite.testingmod.data.ModDataComponents;
import net.jadeite.testingmod.item.ModArmorMaterials;
import net.jadeite.testingmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ConditionalItemModel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.HasComponent;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.Optional;

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
        blockModelGenerators.createTrivialCube(ModBlocks.TIN_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.LEAD_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.BAUXITE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.ZINC_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.NICKEL_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.SILVER_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.PLATINUM_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.LITHIUM_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.CHROMIUM_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.MAGIC_BLOCK);

        MultiVariant off = blockModelGenerators.plainVariant(TexturedModel.CUBE.create(ModBlocks.CHEESE_LAMP, blockModelGenerators.modelOutput));
        MultiVariant on = BlockModelGenerators.plainVariant(blockModelGenerators.createSuffixedVariant(ModBlocks.CHEESE_LAMP, "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube));
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(ModBlocks.CHEESE_LAMP)
                .with(BlockModelGenerators.createBooleanModelDispatch(CheeseLampBlock.CLICKED, on, off)));

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
        ItemModel.Unbaked unbakedChisel = ItemModelUtils.plainModel(itemModelGenerators.createFlatItemModel(ModItems.CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM));
        ItemModel.Unbaked unbakedUsedChisel = ItemModelUtils.plainModel(itemModelGenerators.createFlatItemModel(ModItems.CHISEL, "_used", ModelTemplates.FLAT_HANDHELD_ITEM));
        itemModelGenerators.itemModelOutput.accept(ModItems.CHISEL,
                new ClientItem(new ConditionalItemModel.Unbaked(Optional.empty(), new HasComponent(ModDataComponents.COORDINATES, false),
                        unbakedUsedChisel, unbakedChisel), new ClientItem.Properties(false, false, 1f)).model());

        // FOODS
        itemModelGenerators.generateFlatItem(ModItems.MELTED_CHEESE, ModelTemplates.FLAT_ITEM);

        // TOOLS AND WEAPONS
        itemModelGenerators.generateFlatItem(ModItems.CHEESE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHEESE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHEESE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHEESE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHEESE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModItems.CHEESE_SPEAR);
        itemModelGenerators.generateFlatItem(ModItems.CHEESE_PAXEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHEESE_HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);

        // EQUIPMENT
        itemModelGenerators.generateTrimmableItem(ModItems.CHEESE_HELMET, ModArmorMaterials.CHEESE_KEY, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.CHEESE_CHESTPLATE, ModArmorMaterials.CHEESE_KEY, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.CHEESE_LEGGINGS, ModArmorMaterials.CHEESE_KEY, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.CHEESE_BOOTS, ModArmorMaterials.CHEESE_KEY, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        itemModelGenerators.generateFlatItem(ModItems.CHEESE_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
    }
}