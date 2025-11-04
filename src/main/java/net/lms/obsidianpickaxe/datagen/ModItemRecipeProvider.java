package net.lms.obsidianpickaxe.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lms.obsidianpickaxe.item.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemRecipeProvider extends FabricRecipeProvider {
    public ModItemRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                createShaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_PICKAXE)
                        .pattern("OOO")
                        .pattern("GNG")
                        .pattern("GGG")
                        .input('O', Items.OBSIDIAN)
                        .input('G', Items.GOLD_INGOT)
                        .input('N', Items.NETHERITE_PICKAXE)
                        .group("multi_bench")
                        .criterion(hasItem(Items.NETHERITE_PICKAXE), conditionsFromItem(Items.NETHERITE_PICKAXE))
                        .offerTo((exporter));
            }
        };
    }

    @Override
    public String getName() {
        return "ModItemRecipeProvider";
    }
}
