package dev.vatuu.voxelmon.api.data;

import java.util.Map;

public interface Type {
	Map<Type, Effectiveness> getTypeMatchups();
}
