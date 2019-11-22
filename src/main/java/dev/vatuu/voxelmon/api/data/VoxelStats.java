package dev.vatuu.voxelmon.api.data;

//TODO: string forms
public enum VoxelStats {
	HP("hp"),
	ATTACK("attack"),
	DEFENSE("defense"),
	SPECIAL_ATTACK("special_attack"),
	SPECIAL_DEFENSE("special_defense"),
	SPEED("speed");

	private final String name;

	VoxelStats(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static VoxelStats forName(String name) {
		for (VoxelStats stat : VoxelStats.values()) {
			if (stat.getName().equals(name)) {
				return stat;
			}
		}
		return HP;
	}
}
