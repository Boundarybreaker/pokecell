package org.voxelmon.voxelmon.api.data;

public class VoxelNature {
	private VoxelStat raised;
	private VoxelStat lowered;
	private boolean affectsStats = true;

	public VoxelNature() {
		affectsStats = false;
	}

	public VoxelNature(VoxelStat raised, VoxelStat lowered) {
		this.raised = raised;
		this.lowered = lowered;
	}

	boolean affectsStats() {
		return affectsStats;
	}

	VoxelStat getRaisedStat() {
		return raised;
	}

	VoxelStat getLoweredStat() {
		return lowered;
	}
}
