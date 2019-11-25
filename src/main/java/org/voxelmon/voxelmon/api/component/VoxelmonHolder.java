package org.voxelmon.voxelmon.api.component;

import org.voxelmon.voxelmon.api.species.Voxelmon;
import nerdhub.cardinal.components.api.component.Component;
import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;

import java.util.ArrayList;
import java.util.List;

public class VoxelmonHolder implements Component {
	private int size;
	private List<Voxelmon> voxelmon = new ArrayList<>();

	public VoxelmonHolder(int size) {
		this.size = size;
	}

	@Override
	public void fromTag(CompoundTag tag) {
		size = tag.getInt("Size");
		ListTag mons = tag.getList("Voxelmon", NbtType.COMPOUND);
		List<Voxelmon> voxelmon = new ArrayList<>();
		for (Tag monTag : mons) {
			CompoundTag monCompound = (CompoundTag)monTag;
			voxelmon.add(Voxelmon.readVoxelmon(monCompound));
		}
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		tag.putInt("Size", size);
		ListTag mons = new ListTag();
		for (Voxelmon mon : voxelmon) {
			mons.add(mon.toTag(new CompoundTag()));
		}
		tag.put("Voxelmon", mons);
		return tag;
	}

	public int getSize() {
		return size;
	}

	public boolean addVoxelmon(Voxelmon mon) {
		if (voxelmon.size() >= size) return false;
		else {
			voxelmon.add(mon);
			return true;
		}
	}

	public void setVoxelmon(int slot, Voxelmon mon) {
		if (slot >= size) throw new IllegalArgumentException("Voxelmon Holder cannot hold that many voxelmon!");
		else voxelmon.set(slot, mon);
	}

	public Voxelmon getVoxelmon(int slot) {
		if (slot >= size) throw new IllegalArgumentException("Voxelmon Holder cannot hold that many voxelmon!");
		else return voxelmon.get(slot);
	}
}
