package net.lms.obsidianpickaxe.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lms.obsidianpickaxe.ObsidianPickaxe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final ToolMaterial OBSIDIAN_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            3500,
            39.0f,
            6.0f,
            18,
            ItemTags.REPAIRS_NETHERITE_ARMOR
    );

    public static final Item OBSIDIAN_PICKAXE = register(
            "obsidian_pickaxe",
            settings -> new PickaxeItem(OBSIDIAN_TOOL_MATERIAL, 1f, -2.8f, ),
            new Item.Settings()
    );

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
