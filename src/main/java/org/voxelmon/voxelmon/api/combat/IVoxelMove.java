package org.voxelmon.voxelmon.api.combat;

import org.voxelmon.voxelmon.VoxelmonMain;
import org.voxelmon.voxelmon.api.data.IVoxelType;

//TODO: javadocs
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
