package org.voxelmon.voxelmon.api.data;

import java.util.Map;

public interface IVoxelType {
	Map<IVoxelType, VoxelTypeEffectiveness> getTypeMatchups();
}
