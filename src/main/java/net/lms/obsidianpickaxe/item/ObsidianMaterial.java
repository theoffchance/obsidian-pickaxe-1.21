package net.lms.obsidianpickaxe.item;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class ObsidianMaterial implements ToolMaterial {

    @Override
    public int getDurability() {
        return 3500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 39.0f;
    }

    @Override
    public float getAttackDamage() {
        return 6.0f;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }

    public static final ObsidianMaterial INSTANCE = new ObsidianMaterial();
}
