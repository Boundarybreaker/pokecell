package org.voxelmon.voxelmon.api.data;

//TODO: string forms
public enum VoxelStat {
	HP("hp"),
	ATTACK("attack"),
	DEFENSE("defense"),
	SPECIAL_ATTACK("special_attack"),
	SPECIAL_DEFENSE("special_defense"),
	SPEED("speed");

	private final String name;

	VoxelStat(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static VoxelStat forName(String name) {
		for (VoxelStat stat : VoxelStat.values()) {
			if (stat.getName().equals(name)) {
				return stat;
			}
		}
		return HP;
	}
}
