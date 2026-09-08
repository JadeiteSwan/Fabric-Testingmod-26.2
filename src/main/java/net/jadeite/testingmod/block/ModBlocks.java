package net.jadeite.testingmod.block;

import net.jadeite.testingmod.TestingMod;
import net.jadeite.testingmod.block.custom.MagicBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlocks {

    // BLOCKS
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
                    .sound(SoundType.GLASS)), Component.translatable("tooltip.testingmod.magic_block"));

    // STAIRS AND SLABS
    public static final Block CHEESE_STAIRS = registerBlock("cheese_stairs",
            properties -> new StairBlock(ModBlocks.CHEESE_BLOCK.defaultBlockState(),
                    properties.strength(2f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.CACTUS_FLOWER)));

    public static final Block CHEESE_SLAB = registerBlock("cheese_slab",
            properties -> new SlabBlock(
                    properties.strength(2f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.CACTUS_FLOWER)));

    // REDSTONE BLOCKS
    public static final Block CHEESE_BUTTON = registerBlock("cheese_button",
            properties -> new ButtonBlock(
                    BlockSetType.IRON,
                    40,
                    properties.strength(2f)
                            .noCollision()));

    public static final Block CHEESE_PRESSURE_PLATE = registerBlock("cheese_pressure_plate",
            properties -> new PressurePlateBlock(
                    BlockSetType.IRON,
                    properties.mapColor(MapColor.COLOR_YELLOW)
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1f)
                            .pushReaction(PushReaction.DESTROY)));

    // BLOCK TOOLTIPS
    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, Component... tooltips) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name))));
        registerBlockItem(name, toRegister, tooltips);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block, Component... tooltips) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name)))) {
                    @Override
                    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                        for(var component : tooltips) {
                            builder.accept(component);
                        }
                        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                    }
                });
    }

    // REGISTERING BLOCKS
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