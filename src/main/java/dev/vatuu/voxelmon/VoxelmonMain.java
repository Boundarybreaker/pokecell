package dev.vatuu.voxelmon;

import dev.vatuu.voxelmon.api.combat.IVoxelAbility;
import dev.vatuu.voxelmon.api.combat.IVoxelMove;
import dev.vatuu.voxelmon.api.component.VoxelmonHolder;
import dev.vatuu.voxelmon.api.data.IVoxelType;
import dev.vatuu.voxelmon.api.species.IVoxelSpecies;
import dev.vatuu.voxelmon.api.species.Voxelmon;
import dev.vatuu.voxelmon.entities.VoxelmonEntity;
import nerdhub.cardinal.components.api.ComponentRegistry;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.event.EntityComponentCallback;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
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
	public static final ComponentType<Voxelmon> VOXELMON_COMPONENT = ComponentRegistry.INSTANCE.registerIfAbsent(new Identifier(MOD_ID, "voxelmon"), Voxelmon.class);
	public static final ComponentType<VoxelmonHolder> VOXELMON_HOLDER_COMPONENT = ComponentRegistry.INSTANCE.registerIfAbsent(new Identifier(MOD_ID, "voxelmon_holder"), VoxelmonHolder.class);

	public static final DefaultedRegistry<IVoxelType> TYPES = new DefaultedRegistry<>("voxelmon:normal");
	public static final DefaultedRegistry<IVoxelSpecies> SPECIES = new DefaultedRegistry<>("voxelmon:missingno");
	public static final DefaultedRegistry<IVoxelMove> MOVES = new DefaultedRegistry<>("voxelmon:struggle");
	public static final DefaultedRegistry<IVoxelAbility> ABILITIES = new DefaultedRegistry<>("voxelmon:adaptability"); //TODO: better default ability?

	@Override
	public void onInitialize() {
		VOXELMON_TYPE = Registry.register(
				Registry.ENTITY_TYPE,
				new Identifier(MOD_ID, "default"),
				FabricEntityTypeBuilder.create(EntityCategory.CREATURE, VoxelmonEntity::new).size(EntityDimensions.fixed(1, 2)).build()
		);
		EntityComponentCallback.event(VoxelmonEntity.class).register((entity, components) -> components.put(VOXELMON_COMPONENT, new Voxelmon()));
		EntityComponentCallback.event(PlayerEntity.class).register((player, components) -> components.put(VOXELMON_HOLDER_COMPONENT, new VoxelmonHolder(6)));
	}
}
