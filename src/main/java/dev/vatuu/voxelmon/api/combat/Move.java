package dev.vatuu.voxelmon.api.combat;

import dev.vatuu.voxelmon.Voxelmon;
import dev.vatuu.voxelmon.api.data.Type;

public interface Move {
	int getPower();
	int getAccuracy();
	Type getType();
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
