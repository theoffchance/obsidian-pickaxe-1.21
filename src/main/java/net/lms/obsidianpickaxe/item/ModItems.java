package net.lms.obsidianpickaxe.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lms.obsidianpickaxe.ObsidianPickaxe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item OBSIDIAN_PICKAXE = register(
            "obsidian_pickaxe",
            new PickaxeItem(ObsidianMaterial.INSTANCE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ObsidianMaterial.INSTANCE, 1, -2.8f))));

    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ObsidianPickaxe.MOD_ID, id), item);
    }

    public static void initialize() {
        ObsidianPickaxe.LOGGER.info("Registering Mod Items for " + ObsidianPickaxe.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> {
            itemGroup.add(OBSIDIAN_PICKAXE);
        });
    }
}
