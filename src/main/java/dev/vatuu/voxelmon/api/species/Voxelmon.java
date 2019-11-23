package dev.vatuu.voxelmon.api.species;

import dev.vatuu.voxelmon.api.combat.IVoxelAbility;
import dev.vatuu.voxelmon.api.combat.IVoxelMove;
import dev.vatuu.voxelmon.api.combat.IVoxelStatus;
import dev.vatuu.voxelmon.api.combat.IVoxelTempStatus;
import dev.vatuu.voxelmon.api.data.VoxelNature;
import dev.vatuu.voxelmon.api.data.VoxelStat;
import dev.vatuu.voxelmon.api.item.VoxelHeldItem;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.nbt.CompoundTag;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

//TODO: component?
public class Voxelmon {
	//primary info
	IVoxelSpecies species;
	IVoxelAbility ability;
	int level;
	int totalXP;
	Object2IntMap<VoxelStat> individualValues;
	Object2IntMap<VoxelStat> effortValues = new Object2IntOpenHashMap<>();
	VoxelNature nature;

	//live combat info
	int currentHP;
	IVoxelMove[] moves = new IVoxelMove[4];
	Optional<IVoxelStatus> status = Optional.empty();
	List<IVoxelTempStatus> minorStatuses = new ArrayList<>();
	Object2IntMap<VoxelStat> statMods = new Object2IntOpenHashMap<>();
	VoxelHeldItem heldItem;

	//other info
	int friendliness;
	boolean shiny = false;
	int personality = new Random().nextInt(); //TODO: better personality system?
	//TODO: form

	public Voxelmon(IVoxelSpecies species) {
		this.species = species;
		//TODO: everything
	}

	public CompoundTag toTag(CompoundTag tag) {
		//TODO
		return new CompoundTag();
	}

	public void fromTag(CompoundTag tag) {
		//TODO
	}
}
