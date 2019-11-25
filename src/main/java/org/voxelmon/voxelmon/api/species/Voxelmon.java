package org.voxelmon.voxelmon.api.species;

import org.voxelmon.voxelmon.VoxelmonMain;
import org.voxelmon.voxelmon.api.combat.*;
import org.voxelmon.voxelmon.api.data.VoxelNature;
import org.voxelmon.voxelmon.api.data.VoxelStat;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import nerdhub.cardinal.components.api.component.Component;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Voxelmon implements Component {
	IVoxelSpecies species;

	//summary info
	IVoxelAbility ability;
	int level = 1;
	int totalXP = 0;
	Object2IntMap<VoxelStat> individualValues = new Object2IntOpenHashMap<>();
	Object2IntMap<VoxelStat> effortValues = new Object2IntOpenHashMap<>();
	Object2IntMap<VoxelStat> totalStats = new Object2IntOpenHashMap<>();
	VoxelNature nature;
	int friendliness;
	boolean shiny = false;
	int personality = new Random().nextInt(); //TODO: better personality system?
	IVoxelForm currentForm;
	//TODO: form, ribbons

	//live combat info
	int currentHP;
	VoxelMoveInstance[] moves = new VoxelMoveInstance[4];
	Optional<IVoxelStatus> status = Optional.empty();
	List<IVoxelTempStatus> minorStatuses = new ArrayList<>();
	Object2IntMap<VoxelStat> statMods = new Object2IntOpenHashMap<>();
	ItemStack heldItem = ItemStack.EMPTY;

	public Voxelmon() { }

	public static Voxelmon create(IVoxelSpecies species) {
		Voxelmon voxelmon = new Voxelmon();
		voxelmon.species = species;

		return voxelmon;
	}

	public CompoundTag toTag(CompoundTag tag) {
		tag.putString("Species", VoxelmonMain.SPECIES.getId(species).toString());

		CompoundTag summaryTag = new CompoundTag();
		//TODO: ability
		summaryTag.putInt("Level", level);
		summaryTag.putInt("Experience", totalXP);
		CompoundTag ivs = new CompoundTag();
		CompoundTag evs = new CompoundTag();
		CompoundTag stats = new CompoundTag();
		for (VoxelStat stat : VoxelStat.values()) {
			ivs.putInt(stat.getName(), individualValues.getInt(stat));
			evs.putInt(stat.getName(), effortValues.getInt(stat));
			stats.putInt(stat.getName(), totalStats.getInt(stat));
		}
		summaryTag.put("IVs", ivs);
		summaryTag.put("EVs", evs);
		summaryTag.put("Stats", stats);
		//TODO: nature
		summaryTag.putInt("Friendliness", friendliness);
		summaryTag.putBoolean("Shiny", shiny);
		summaryTag.putInt("Personality", personality);
		tag.put("Summary", summaryTag);

		CompoundTag combatTag = new CompoundTag();
		combatTag.putInt("CurrentHP", currentHP);
		//TODO: moves
		//TODO: major status
		//TODO: minor statuses
		//TODO: stat changes
		combatTag.put("HeldItem", heldItem.toTag(new CompoundTag()));
		tag.put("Combat", combatTag);

		return tag;
	}

	public void fromTag(CompoundTag tag) {
		this.species = VoxelmonMain.SPECIES.get(new Identifier(tag.getString("Species")));

		CompoundTag summaryTag = tag.getCompound("Summary");
		this.level = summaryTag.getInt("Level");
		this.totalXP = summaryTag.getInt("Experience");
		Object2IntMap<VoxelStat> ivs = new Object2IntOpenHashMap<>();
		Object2IntMap<VoxelStat> evs = new Object2IntOpenHashMap<>();
		Object2IntMap<VoxelStat> stats = new Object2IntOpenHashMap<>();
		CompoundTag ivTag = summaryTag.getCompound("IVs");
		CompoundTag evTag = summaryTag.getCompound("EVs");
		CompoundTag statTag = summaryTag.getCompound("Stats");
		for (VoxelStat stat : VoxelStat.values()) {
			ivs.put(stat, ivTag.getInt(stat.getName()));
			evs.put(stat, evTag.getInt(stat.getName()));
			stats.put(stat, statTag.getInt(stat.getName()));
		}
		//TODO: nature
		this.friendliness = summaryTag.getInt("Friendliness");
		this.shiny = summaryTag.getBoolean("Shiny");
		this.personality = summaryTag.getInt("Personality");

		CompoundTag combatTag = tag.getCompound("Combat");
		this.currentHP = combatTag.getInt("CurrentHP");
		//TODO: moves
		//TODO: major status
		//TODO: minor statuses
		//TODO: stat changes
		this.heldItem = ItemStack.fromTag(combatTag.getCompound("HeldItem"));
	}

	public static Voxelmon readVoxelmon(CompoundTag tag) {
		Voxelmon voxelmon = new Voxelmon();
		voxelmon.fromTag(tag);
		return voxelmon;
	}
}
