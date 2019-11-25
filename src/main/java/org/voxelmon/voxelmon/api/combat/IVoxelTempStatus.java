package org.voxelmon.voxelmon.api.combat;

import org.voxelmon.voxelmon.api.species.Voxelmon;

//TODO: javadocs
public interface IVoxelTempStatus {
	//TODO: more places to do stuff?
	boolean attemptMove(Voxelmon voxelmon);
	void endTurn(Voxelmon voxelmon, int turnsHad);
}
