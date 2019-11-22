package dev.vatuu.voxelmon.api.data;

//TODO: string forms
public enum VoxelEggGroup {
	MONSTER("monster"),
	AMPHIBIOUS("amphibious"),
	BUG("bug"),
	FLYING("flying"),
	FIELD("field"),
	FAIRY("fairy"),
	GRASS("grass"),
	HUMAN_LIKE("human_like"),
	AQUATIC_INVERTEBRATE("aquatic_invertebrate"),
	MINERAL("mineral"),
	AMORPHOUS("amorphous"),
	PISCINE("piscine"),
	DITTO("ditto"),
	DRACONIC("draconic"),
	UNDISCOVERED("undiscovered");

	private final String name;

	VoxelEggGroup(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static VoxelEggGroup forName(String name) {
		for (VoxelEggGroup group : VoxelEggGroup.values()) {
			if (group.getName().equals(name)) {
				return group;
			}
		}
		return UNDISCOVERED;
	}
}
