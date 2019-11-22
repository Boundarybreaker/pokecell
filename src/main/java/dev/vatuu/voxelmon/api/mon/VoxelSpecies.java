package dev.vatuu.voxelmon.api.mon;

import dev.vatuu.voxelmon.api.data.Stat;
import dev.vatuu.voxelmon.api.data.Type;
import dev.vatuu.voxelmon.api.move.Move;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.Set;

public interface VoxelSpecies {
	//combat data
	Type getPrimaryType();
	Optional<Type> getSecondaryType();
	Object2IntMap<Stat> getBaseStats();
	Int2ObjectMap<Move> getLevelMoves();
	Set<Move> getLearnableMoves();
	Object2IntMap<Stat> getEVYields();

	//species data
	int getDexNumber(); //TODO: figure out a way to not have to manually specify?
	boolean hasGender();
	float getGenderRatio();
	byte getCatchRate();
	float getHeight();
	float getWeight();
	//TODO: body type
	Identifier getFootprint();
	SoundEvent getSound();
	Identifier getModel();
}
