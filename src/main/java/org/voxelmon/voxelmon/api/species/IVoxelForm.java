package org.voxelmon.voxelmon.api.species;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.voxelmon.voxelmon.api.combat.IVoxelAbility;
import org.voxelmon.voxelmon.api.combat.IVoxelMove;
import org.voxelmon.voxelmon.api.data.IVoxelType;
import org.voxelmon.voxelmon.api.data.VoxelBodyType;
import org.voxelmon.voxelmon.api.data.VoxelStat;

import java.util.Optional;
import java.util.Set;

//TODO: this seems kinda messy and might be redundant in a lot of cases. Is there any way to improve this without basically making a duplicate of IVoxelSpecies? Maybe move most of the IVoxelSpecies stuff to forms and have all species provide a default form?
public interface IVoxelForm {
	// options for what should be applied from form
	boolean changesType();
	boolean changesStats();
	boolean changesMoves();
	boolean changesAbility();
	boolean changesSpeciesData();

	//combat data
	IVoxelType getPrimaryType();
	Optional<IVoxelType> getSecondaryType();
	Object2IntMap<VoxelStat> getBaseStats();
	Object2IntMap<IVoxelMove> getLevelMoves();
	Set<IVoxelMove> getLearnableMoves();
	Set<IVoxelMove> getEggMoves();
	Optional<IVoxelMove> getEvolutionMove();
	IVoxelAbility getPrimaryAbility();
	Optional<IVoxelAbility> getSecondaryAbility();
	Optional<IVoxelAbility> getHiddenAbility();

	//species data
	float getHeight();
	float getWeight();
	VoxelBodyType getBodyType();
	Identifier getFootprint();

	//model data
	SoundEvent getSound();
	Identifier getModel();
}
