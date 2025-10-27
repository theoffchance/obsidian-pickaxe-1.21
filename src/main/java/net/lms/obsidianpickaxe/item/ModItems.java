package net.lms.obsidianpickaxe.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lms.obsidianpickaxe.ObsidianPickaxe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item OBSIDIAN_PICKAXE = registerItem(
            "obsidian_pickaxe",
            new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ObsidianPickaxe.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ObsidianPickaxe.LOGGER.info("Registering Mod Items for " + ObsidianPickaxe.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(OBSIDIAN_PICKAXE);
        });
    }
}
