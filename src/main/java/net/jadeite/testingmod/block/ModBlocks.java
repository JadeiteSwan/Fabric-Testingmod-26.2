package net.jadeite.testingmod.block;

import net.jadeite.testingmod.TestingMod;
import net.jadeite.testingmod.block.custom.MagicBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {

    public static final Block CHEESE_BLOCK = registerBlock("cheese_block",
            properties -> new Block(properties
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.CACTUS_FLOWER)));

    public static final Block RAW_CHEESE_BLOCK = registerBlock("raw_cheese_block",
            properties -> new Block(properties
                    .strength(8f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GILDED_BLACKSTONE)));

    public static final Block CHEESE_ORE = registerBlock("cheese_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 5), properties
                    .strength(8f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GILDED_BLACKSTONE)));

    public static final Block BOUNTIFUL_CHEESE_ORE = registerBlock("bountiful_cheese_ore",
            properties -> new DropExperienceBlock(UniformInt.of(5, 10), properties
                    .strength(8f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GILDED_BLACKSTONE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            properties -> new MagicBlock(properties
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GLASS)));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name)))));
    }

    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

    public static void registerModBlocks() {
        TestingMod.LOGGER.info("Registering Mod Blocks for " + TestingMod.MOD_ID);
    }
}
