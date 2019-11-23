package dev.vatuu.voxelmon.entities;

import dev.vatuu.voxelmon.VoxelmonMain;
import dev.vatuu.voxelmon.api.species.Voxelmon;
import net.minecraft.client.network.packet.EntitySpawnS2CPacket;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.world.World;

//TODO Like everything in here
public class VoxelmonEntity extends Entity {

    public VoxelmonEntity(World w){
        super(VoxelmonMain.VOXELMON_TYPE, w);
    }

    public void initDataTracker(){}

    public void readCustomDataFromTag(CompoundTag tag) {}
    public void writeCustomDataToTag(CompoundTag tag) {}

    public Packet<?> createSpawnPacket() {
        return null;
    }
}
