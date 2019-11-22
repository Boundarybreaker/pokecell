package dev.vatuu.voxelmon.api.combat;

import dev.vatuu.voxelmon.Voxelmon;
import dev.vatuu.voxelmon.api.data.IVoxelType;

public interface IVoxelAttack {
	int getPower();
	int getAccuracy();
	IVoxelType getType();
	void doAttackEffects(Voxelmon attacker, Voxelmon defender);
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
