package dev.vatuu.voxelmon.api.combat;

import dev.vatuu.voxelmon.Voxelmon;
import dev.vatuu.voxelmon.api.data.Type;

public interface Move {
	int getPower();
	int getAccuracy();
	Type getType();
	void doAttackEffects(Voxelmon attacker, Voxelmon defender);
}
