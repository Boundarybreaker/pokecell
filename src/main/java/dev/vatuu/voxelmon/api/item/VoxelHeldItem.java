package dev.vatuu.voxelmon.api.item;

import dev.vatuu.voxelmon.api.combat.VoxelMoveInstance;
import dev.vatuu.voxelmon.api.species.Voxelmon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

//TODO: javadocs
public abstract class VoxelHeldItem extends Item {
	public VoxelHeldItem(Settings settings) {
		super(settings);
	}

	abstract void onTurnStart(ItemStack stack, Voxelmon holder);

	abstract void onMoveUse(ItemStack stack, VoxelMoveInstance move);

	abstract void onAttack(ItemStack stack, VoxelMoveInstance move);

	abstract void onDefend(ItemStack stack, VoxelMoveInstance move);

	abstract void onTurnEnd(ItemStack stack, Voxelmon holder);
}
