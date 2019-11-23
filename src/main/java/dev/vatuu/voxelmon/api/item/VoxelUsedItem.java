package dev.vatuu.voxelmon.api.item;

import dev.vatuu.voxelmon.api.species.Voxelmon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

//TODO: impl
public abstract class VoxelUsedItem extends Item {
	public VoxelUsedItem(Settings settings) {
		super(settings);
	}

	abstract boolean canUseOn(ItemStack stack, Voxelmon voxelmon);

	abstract void useOn(ItemStack stack, Voxelmon voxelmon);
}
