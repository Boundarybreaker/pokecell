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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VoxelmonMain implements ModInitializer {

	public static final String MOD_ID = "voxelmon";

	public static final Logger LOGGER = LogManager.getLogger();

	public static EntityType<VoxelmonEntity> VOXELMON_TYPE;

	private DefaultedRegistry<IVoxelType> typeRegistry;
	private DefaultedRegistry<IVoxelSpecies> voxelmonRegistry;
	private DefaultedRegistry<IVoxelMove> moveRegistry;
	private DefaultedRegistry<IVoxelAbility> abilityRegistry;

	@Override
	public void onInitialize() {
		VOXELMON_TYPE = Registry.register(
				Registry.ENTITY_TYPE,
				new Identifier(MOD_ID, "default"),
				FabricEntityTypeBuilder.create(EntityCategory.CREATURE, VoxelmonEntity::new).size(EntityDimensions.fixed(1, 2)).build()
		);
	}
}
