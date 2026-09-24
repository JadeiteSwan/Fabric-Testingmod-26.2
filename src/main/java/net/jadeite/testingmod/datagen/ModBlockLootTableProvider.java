package net.jadeite.testingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.jadeite.testingmod.block.ModBlocks;
import net.jadeite.testingmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {

    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {

        // BLOCKS
        dropSelf(ModBlocks.CHEESE_BLOCK);
        dropSelf(ModBlocks.RAW_CHEESE_BLOCK);
        dropSelf(ModBlocks.MAGIC_BLOCK);
        dropSelf(ModBlocks.CHEESE_LAMP);

        // ORES
        add(ModBlocks.CHEESE_ORE, createOreDrop(ModBlocks.CHEESE_ORE, ModItems.RAW_CHEESE_ITEM));
        add(ModBlocks.BOUNTIFUL_CHEESE_ORE, createMultipleOreDrops(ModBlocks.BOUNTIFUL_CHEESE_ORE, ModItems.RAW_CHEESE_ITEM, 3, 5));
        add(ModBlocks.TIN_ORE, createOreDrop(ModBlocks.TIN_ORE, ModItems.RAW_CHEESE_ITEM));
        add(ModBlocks.LEAD_ORE, createOreDrop(ModBlocks.LEAD_ORE, ModItems.RAW_CHEESE_ITEM));
        add(ModBlocks.BAUXITE_ORE, createOreDrop(ModBlocks.BAUXITE_ORE, ModItems.RAW_CHEESE_ITEM));
        add(ModBlocks.ZINC_ORE, createOreDrop(ModBlocks.ZINC_ORE, ModItems.RAW_CHEESE_ITEM));
        add(ModBlocks.NICKEL_ORE, createOreDrop(ModBlocks.NICKEL_ORE, ModItems.RAW_CHEESE_ITEM));
        add(ModBlocks.SILVER_ORE, createOreDrop(ModBlocks.SILVER_ORE, ModItems.RAW_CHEESE_ITEM));
        add(ModBlocks.PLATINUM_ORE, createOreDrop(ModBlocks.PLATINUM_ORE, ModItems.RAW_CHEESE_ITEM));
        add(ModBlocks.LITHIUM_ORE, createOreDrop(ModBlocks.LITHIUM_ORE, ModItems.RAW_CHEESE_ITEM));
        add(ModBlocks.CHROMIUM_ORE, createOreDrop(ModBlocks.CHROMIUM_ORE, ModItems.RAW_CHEESE_ITEM));

        // STAIRS AND SLABS
        dropSelf(ModBlocks.CHEESE_STAIRS);
        add(ModBlocks.CHEESE_SLAB, this::createSlabItemTable);

        // FENCES AND WALLS
        dropSelf(ModBlocks.CHEESE_FENCE);
        dropSelf(ModBlocks.CHEESE_FENCE_GATE);
        dropSelf(ModBlocks.CHEESE_WALL);

        // DOORS AND TRAPDOORS
        add(ModBlocks.CHEESE_DOOR, this::createDoorTable);
        dropSelf(ModBlocks.CHEESE_TRAPDOOR);

        // REDSTONE BLOCKS
        dropSelf(ModBlocks.CHEESE_BUTTON);
        dropSelf(ModBlocks.CHEESE_PRESSURE_PLATE);

    }

    // Multiple block drops with range
    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
                        block, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}