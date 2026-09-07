package net.jadeite.testingmod.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
    public static final FoodProperties MELTED_CHEESE = new FoodProperties.Builder().nutrition(3).saturationModifier(2f).build();

    public static final Consumable MELTED_CHEESE_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(3f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE, 30, 2))).build();

}
