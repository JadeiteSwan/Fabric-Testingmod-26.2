package net.jadeite.testingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.jadeite.testingmod.item.ModItems;
import net.jadeite.testingmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.getRK(ModItems.CHEESE_ITEM))
                .add(ModItems.getRK(ModItems.RAW_CHEESE_ITEM));

        tag(ItemTags.SWORDS)
                .add(ModItems.getRK(ModItems.CHEESE_SWORD));

        tag(ItemTags.PICKAXES)
                .add(ModItems.getRK(ModItems.CHEESE_PICKAXE));

        tag(ItemTags.AXES)
                .add(ModItems.getRK(ModItems.CHEESE_AXE));

        tag(ItemTags.SHOVELS)
                .add(ModItems.getRK(ModItems.CHEESE_SHOVEL));

        tag(ItemTags.HOES)
                .add(ModItems.getRK(ModItems.CHEESE_HOE));

        tag(ItemTags.SPEARS)
                .add(ModItems.getRK(ModItems.CHEESE_SPEAR));

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.getRK(ModItems.CHEESE_HELMET));

        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.getRK(ModItems.CHEESE_CHESTPLATE));

        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.getRK(ModItems.CHEESE_LEGGINGS));

        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.getRK(ModItems.CHEESE_BOOTS));
    }
}