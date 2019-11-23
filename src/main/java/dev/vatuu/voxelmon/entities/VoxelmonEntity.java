package dev.vatuu.voxelmon.entities;

import dev.vatuu.voxelmon.VoxelmonMain;
import dev.vatuu.voxelmon.api.species.IVoxelSpecies;
import dev.vatuu.voxelmon.api.species.Voxelmon;
import net.minecraft.client.network.packet.EntitySpawnS2CPacket;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.Random;

//TODO Like everything in here
public class VoxelmonEntity extends Entity {
    private Voxelmon voxelmon;

    public VoxelmonEntity(World w) {
        super(VoxelmonMain.VOXELMON_TYPE, w);
    }

    public VoxelmonEntity(World w, IVoxelSpecies species) {
        this(w, new Voxelmon(species));
    }

    public VoxelmonEntity(World w, Voxelmon voxelmon){
        this(w);
        this.voxelmon = voxelmon;
    }

    public void initDataTracker(){}

    public void readCustomDataFromTag(CompoundTag tag) {
        CompoundTag voxelTag = tag.getCompound("Voxelmon");
        Identifier id = new Identifier(voxelTag.getString("species"));
        this.voxelmon = new Voxelmon(VoxelmonMain.SPECIES.get(id));
    }
    
    public void writeCustomDataToTag(CompoundTag tag) {
        tag.put("Voxelmon", voxelmon.toTag(new CompoundTag()));
    }

    public Packet<?> createSpawnPacket() {
        return null;
    }

    public Voxelmon getVoxelmon() {
        return voxelmon;
    }
}
