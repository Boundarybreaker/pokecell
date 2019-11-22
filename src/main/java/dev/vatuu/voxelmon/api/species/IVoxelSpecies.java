package dev.vatuu.voxelmon.api.species;

import dev.vatuu.voxelmon.api.combat.IVoxelAbility;
import dev.vatuu.voxelmon.api.data.VoxelBodyType;
import dev.vatuu.voxelmon.api.data.VoxelEggGroup;
import dev.vatuu.voxelmon.api.data.VoxelStats;
import dev.vatuu.voxelmon.api.data.IVoxelType;
import dev.vatuu.voxelmon.api.combat.IVoxelAttack;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.Set;

public interface IVoxelSpecies {
	//combat data
	IVoxelType getPrimaryType();
	Optional<IVoxelType> getSecondaryType();
	Object2IntMap<VoxelStats> getBaseStats();
	Int2ObjectMap<IVoxelAttack> getLevelMoves();
	Set<IVoxelAttack> getLearnableMoves();
	Set<IVoxelAttack> getEggMoves();
	Optional<IVoxelAttack> getEvolutionMove();
	Object2IntMap<VoxelStats> getEVYields();
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
	VoxelBodyType getBodyType();
	VoxelEggGroup getEggGroup();
	Identifier getFootprint();
	SoundEvent getSound();
	Identifier getModel();
}
