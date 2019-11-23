package dev.vatuu.voxelmon;

import dev.vatuu.voxelmon.api.combat.IVoxelAbility;
import dev.vatuu.voxelmon.api.combat.IVoxelMove;
import dev.vatuu.voxelmon.api.data.IVoxelType;
import dev.vatuu.voxelmon.api.species.IVoxelSpecies;
import dev.vatuu.voxelmon.entities.VoxelmonEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;

public class VoxelmonMain implements ModInitializer {

	public static final String MOD_ID = "voxelmon";

	public static final Logger LOGGER = LogManager.getLogger();

	public static EntityType<VoxelmonEntity> VOXELMON_TYPE;

	public static final DefaultedRegistry<IVoxelType> TYPES = new DefaultedRegistry<>("voxelmon:normal");
	public static final DefaultedRegistry<IVoxelSpecies> SPECIES = new DefaultedRegistry<>("voxelmon:missingno");
	public static final DefaultedRegistry<IVoxelMove> MOVES = new DefaultedRegistry<>("voxelmon:struggle");
	public static final DefaultedRegistry<IVoxelAbility> ABILITIES = new DefaultedRegistry<>("voxelmon:none");

	@Override
	public void onInitialize() {
		VOXELMON_TYPE = Registry.register(
				Registry.ENTITY_TYPE,
				new Identifier(MOD_ID, "default"),
				FabricEntityTypeBuilder.create(EntityCategory.CREATURE, (Function<World, VoxelmonEntity>) VoxelmonEntity::new).size(EntityDimensions.fixed(1, 2)).build()
		);
	}
}
