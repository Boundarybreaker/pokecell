package dev.vatuu.voxelmon.api.combat;

import dev.vatuu.voxelmon.VoxelmonMain;
import dev.vatuu.voxelmon.api.data.IVoxelType;

public interface IVoxelMove {
	int getPower();
	int getAccuracy();
	IVoxelType getType();
	void doAttackEffects(VoxelmonMain attacker, VoxelmonMain defender);
	int getPriority();
	int getPP();
	boolean makesContact();
	boolean protectBlocks();
	boolean magicCoatReflects();
	boolean snatchSteals();
	boolean mirrorMoveReflects();
	boolean kingsRockAffects();
	boolean[][] getPossibleTargets();
	boolean targetsMultiple();

	//TODO: animation stuff? contest stuff?
}
