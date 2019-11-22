package dev.vatuu.voxelmon.renderer;

import dev.vatuu.voxelmon.api.species.IVoxelSpecies;
import dev.vatuu.voxelmon.entities.VoxelmonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.util.Identifier;

public abstract class AbstractVoxelmonRenderer extends EntityRenderer<VoxelmonEntity> {

    private Identifier model;

    public AbstractVoxelmonRenderer(EntityRenderDispatcher dispatcher, IVoxelSpecies mon){
        super(dispatcher);
        this.model = mon.getModel();
    }

    public abstract void render(VoxelmonEntity e, double x, double y, double z, float yaw, float pitch);

    public Identifier getTexture(VoxelmonEntity e){
        return model;
    }
}