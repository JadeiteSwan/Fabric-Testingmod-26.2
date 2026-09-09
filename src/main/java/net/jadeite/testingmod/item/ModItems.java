package net.jadeite.testingmod.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.jadeite.testingmod.TestingMod;
import net.jadeite.testingmod.food.ModFoods;
import net.jadeite.testingmod.item.custom.ChiselItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {

    // ITEMS
    public static final Item CHEESE_ITEM = registerItem("cheese_item", Item::new /* properties -> new Item(properties.)*/);
    public static final Item RAW_CHEESE_ITEM = registerItem("raw_cheese_item", Item::new);
    public static final Item COAL_CHEESE = registerItem("coal_cheese", properties -> new Item(properties.stacksTo(8)));

    // COMPLEX ITEMS
    public static final Item CHISEL = registerItem("chisel", properties -> new ChiselItem(properties.durability(64)));

    // FOODS
    public static final Item MELTED_CHEESE = registerItem("melted_cheese", properties -> new Item(properties.food(ModFoods.MELTED_CHEESE, ModFoods.MELTED_CHEESE_CONSUMABLE)) {
        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            builder.accept(Component.translatable("tooltip.testingmod.melted_cheese"));
            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    });

    // TOOLS AND WEAPONS

    public static final Item CHEESE_SWORD = registerItem("cheese_sword", properties -> new Item(properties.sword(ModToolMaterials.CHEESE, 4, -3f)));
    public static final Item CHEESE_PICKAXE = registerItem("cheese_pickaxe", properties -> new Item(properties.pickaxe(ModToolMaterials.CHEESE, 1, -2.8f)));
    public static final Item CHEESE_AXE = registerItem("cheese_axe", properties -> new AxeItem(ModToolMaterials.CHEESE, 5, -3.4f, properties));
    public static final Item CHEESE_SHOVEL = registerItem("cheese_shovel", properties -> new ShovelItem(ModToolMaterials.CHEESE, 1, -2.8f, properties));
    public static final Item CHEESE_HOE = registerItem("cheese_hoe", properties -> new HoeItem(ModToolMaterials.CHEESE, 1, -2.8f, properties));
    public static final Item CHEESE_SPEAR = registerItem("cheese_spear", properties -> new Item(properties.spear(ModToolMaterials.CHEESE, 0.95f, -0.95f, 0.6f, 2.5f, 11.0f, 6.75f, 5.1f, 11.25f, 4.6f)));

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name), function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name)))));
    }

    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    public static void registerModItems() {
        TestingMod.LOGGER.info("Registering Mod Items for " + TestingMod.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(output -> {
            output.accept(CHEESE_ITEM);
            output.accept(RAW_CHEESE_ITEM);
        });
    }
}