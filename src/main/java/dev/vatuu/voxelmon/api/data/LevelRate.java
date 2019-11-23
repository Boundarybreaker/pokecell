package dev.vatuu.voxelmon.api.data;

public interface LevelRate {
	int getNextLevelXP(int currentLevel);
	int getLevelTotalXP(int level);
	int getLevelForXP(int xp);
}
