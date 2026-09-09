package net.jadeite.testingmod.item;

import net.jadeite.testingmod.TestingMod;
import net.jadeite.testingmod.tags.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;

public class ModArmorMaterials {

    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset> CHEESE_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, "cheese"));

    public static final ArmorMaterial CHEESE_ARMOR_MATERIAL = new ArmorMaterial(800, ArmorMaterials.makeDefense(2, 4, 6, 3, 9), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, 1, 0, ModTags.Items.CHEESE_REPAIR, CHEESE_KEY);
}
