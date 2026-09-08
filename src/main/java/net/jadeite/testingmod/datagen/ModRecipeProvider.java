package net.jadeite.testingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jadeite.testingmod.block.ModBlocks;
import net.jadeite.testingmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> CHEESE_SMELTABLES = List.of(ModItems.RAW_CHEESE_ITEM, ModBlocks.CHEESE_ORE, ModBlocks.BOUNTIFUL_CHEESE_ORE, ModBlocks.RAW_CHEESE_BLOCK);

                oreSmelting(CHEESE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.CHEESE_ITEM, 0.3f, 180, "cheese");
                oreBlasting(CHEESE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.CHEESE_ITEM, 0.3f, 90, "cheese");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.CHEESE_ITEM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHEESE_BLOCK);

                shaped(RecipeCategory.MISC, ModBlocks.RAW_CHEESE_BLOCK)
                        .pattern("RR")
                        .pattern("RR")
                        .define('R', ModItems.RAW_CHEESE_ITEM)
                        .unlockedBy(getHasName(ModItems.RAW_CHEESE_ITEM), has(ModItems.RAW_CHEESE_ITEM))
                        .group("cheese")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RAW_CHEESE_ITEM, 4)
                        .requires(ModBlocks.RAW_CHEESE_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.RAW_CHEESE_BLOCK), has(ModBlocks.RAW_CHEESE_BLOCK))
                        .group("cheese")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RAW_CHEESE_ITEM, 4)
                        .requires(ModBlocks.RAW_CHEESE_BLOCK)
                        .requires(Items.STICK)
                        .unlockedBy(getHasName(ModBlocks.RAW_CHEESE_BLOCK), has(ModBlocks.RAW_CHEESE_BLOCK))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("cheese")
                        .save(output, "raw_cheese_item_from_cheese_and_stick");

                stairBuilder(ModBlocks.CHEESE_STAIRS, Ingredient.of(ModBlocks.CHEESE_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.CHEESE_BLOCK), has(ModBlocks.CHEESE_BLOCK))
                        .group("cheese")
                        .save(output);

                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHEESE_SLAB, ModBlocks.CHEESE_BLOCK);

                buttonBuilder(ModBlocks.CHEESE_BUTTON, Ingredient.of(ModItems.CHEESE_ITEM))
                        .unlockedBy(getHasName(ModItems.CHEESE_ITEM), has(ModItems.CHEESE_ITEM))
                        .group("cheese")
                        .save(output);

                pressurePlate(ModBlocks.CHEESE_PRESSURE_PLATE, ModItems.CHEESE_ITEM);

                fenceBuilder(ModBlocks.CHEESE_FENCE, Ingredient.of(ModBlocks.CHEESE_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.CHEESE_BLOCK), has(ModBlocks.CHEESE_BLOCK))
                        .group("cheese")
                        .save(output);

                fenceGateBuilder(ModBlocks.CHEESE_FENCE_GATE, Ingredient.of(ModBlocks.CHEESE_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.CHEESE_BLOCK), has(ModBlocks.CHEESE_BLOCK))
                        .group("cheese")
                        .save(output);

                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHEESE_WALL, ModBlocks.CHEESE_BLOCK);

                doorBuilder(ModBlocks.CHEESE_DOOR, Ingredient.of(ModBlocks.CHEESE_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.CHEESE_BLOCK), has(ModBlocks.CHEESE_BLOCK))
                        .group("cheese")
                        .save(output);

                trapdoorBuilder(ModBlocks.CHEESE_TRAPDOOR, Ingredient.of(ModItems.CHEESE_ITEM))
                        .unlockedBy(getHasName(ModItems.CHEESE_ITEM), has(ModItems.CHEESE_ITEM))
                        .group("cheese")
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "TestingMod Recipes";
    }
}