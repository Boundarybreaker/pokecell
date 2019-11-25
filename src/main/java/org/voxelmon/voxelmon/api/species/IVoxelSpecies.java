package org.voxelmon.voxelmon.api.species;

import org.voxelmon.voxelmon.api.combat.IVoxelAbility;
import org.voxelmon.voxelmon.api.data.*;
import org.voxelmon.voxelmon.api.combat.IVoxelMove;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.Set;

//TODO: javadocs
public interface IVoxelSpecies {
	//combat data
	//TODO: form
	IVoxelType getPrimaryType();
	Optional<IVoxelType> getSecondaryType();
	Object2IntMap<VoxelStat> getBaseStats();
	Object2IntMap<IVoxelMove> getLevelMoves();
	Set<IVoxelMove> getLearnableMoves();
	Set<IVoxelMove> getEggMoves();
	Optional<IVoxelMove> getEvolutionMove();
	Object2IntMap<VoxelStat> getEVYields();
	IVoxelAbility getPrimaryAbility();
	Optional<IVoxelAbility> getSecondaryAbility();
	Optional<IVoxelAbility> getHiddenAbility();

	//species data
	int getDexNumber(); //TODO: figure out a way to not have to manually specify?
	boolean hasGender();
	float getGenderRatio();
	byte getCatchRate();
	float getHeight();
	float getWeight();
	int getBaseFeidnship();
	LevelRate getLevelRate();
	VoxelBodyType getBodyType();
	VoxelEggGroup getEggGroup();
	Identifier getFootprint();
	SoundEvent getSound();
	Identifier getModel();
}
