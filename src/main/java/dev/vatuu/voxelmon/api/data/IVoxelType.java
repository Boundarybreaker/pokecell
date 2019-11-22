package dev.vatuu.voxelmon.api.data;

import java.util.Map;

public interface IVoxelType {
	Map<IVoxelType, Effectiveness> getTypeMatchups();
}
