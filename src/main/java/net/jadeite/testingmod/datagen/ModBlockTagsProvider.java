package net.jadeite.testingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.jadeite.testingmod.block.ModBlocks;
import net.jadeite.testingmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.CHEESE_ORE))
                .add(ModBlocks.getRK(ModBlocks.BOUNTIFUL_CHEESE_ORE))
                .add(ModBlocks.getRK(ModBlocks.RAW_CHEESE_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.MAGIC_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_SLAB))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_FENCE))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_FENCE_GATE))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_WALL))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_DOOR))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_TRAPDOOR));

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.getRK(ModBlocks.CHEESE_ORE))
                .add(ModBlocks.getRK(ModBlocks.BOUNTIFUL_CHEESE_ORE))
                .add(ModBlocks.getRK(ModBlocks.RAW_CHEESE_BLOCK));

        tag(ModTags.Blocks.NEEDS_CHEESE_TOOL)
                .add(ModBlocks.getRK(ModBlocks.CHEESE_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.MAGIC_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_SLAB))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_FENCE))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_FENCE_GATE))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_WALL))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_DOOR))
                .add(ModBlocks.getRK(ModBlocks.CHEESE_TRAPDOOR))
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        // Limits cheese to below diamond
        tag(ModTags.Blocks.INCORRECT_FOR_CHEESE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.getRK(ModBlocks.BOUNTIFUL_CHEESE_ORE));

        tag(BlockTags.STAIRS)
                .add(ModBlocks.getRK(ModBlocks.CHEESE_STAIRS));

        tag(BlockTags.SLABS)
                .add(ModBlocks.getRK(ModBlocks.CHEESE_SLAB));

        tag(BlockTags.BUTTONS)
                .add(ModBlocks.getRK(ModBlocks.CHEESE_BUTTON));

        tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.getRK(ModBlocks.CHEESE_PRESSURE_PLATE));

        tag(BlockTags.FENCES)
                .add(ModBlocks.getRK(ModBlocks.CHEESE_FENCE));

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.getRK(ModBlocks.CHEESE_FENCE_GATE));

        tag(BlockTags.WALLS)
                .add(ModBlocks.getRK(ModBlocks.CHEESE_WALL));

        tag(BlockTags.DOORS)
                .add(ModBlocks.getRK(ModBlocks.CHEESE_DOOR));

        tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.getRK(ModBlocks.CHEESE_TRAPDOOR));
    }
}
