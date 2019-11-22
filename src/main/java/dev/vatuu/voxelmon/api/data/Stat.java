package dev.vatuu.voxelmon.api.data;

//TODO: string forms
public enum Stat {
	HP("hp"),
	ATTACK("attack"),
	DEFENSE("defense"),
	SPECIAL_ATTACK("special_attack"),
	SPECIAL_DEFENSE("special_defense"),
	SPEED("speed");

	private final String name;

	Stat(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Stat forName(String name) {
		for (Stat stat : Stat.values()) {
			if (stat.getName().equals(name)) {
				return stat;
			}
		}
		return HP;
	}
}
