package net.jadeite.testingmod.tags;

import net.jadeite.testingmod.TestingMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> NEEDS_CHEESE_TOOL = createTag("needs_cheese_tool");
        public static final TagKey<Block> INCORRECT_FOR_CHEESE_TOOL = createTag("incorrect_for_cheese_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        public static final TagKey<Item> CHEESE_REPAIR = createTag("cheese_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name));
        }
    }




}
