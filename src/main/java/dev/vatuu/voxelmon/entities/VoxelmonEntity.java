package dev.vatuu.voxelmon.entities;

import dev.vatuu.voxelmon.VoxelmonMain;

import net.minecraft.client.network.packet.EntitySpawnS2CPacket;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.util.Arm;
import net.minecraft.world.World;

import java.util.ArrayList;

//TODO Like everything in here
public class VoxelmonEntity extends LivingEntity {

    public VoxelmonEntity(World w) {
        super(VoxelmonMain.VOXELMON_TYPE, w);
    }

    public void initDataTracker(){}

    public void readCustomDataFromTag(CompoundTag tag) {
    }

    public void writeCustomDataToTag(CompoundTag tag) {
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return new ArrayList<>();
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {

    }

    @Override
    public Arm getMainArm() {
        return Arm.RIGHT;
    }

    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }
}
