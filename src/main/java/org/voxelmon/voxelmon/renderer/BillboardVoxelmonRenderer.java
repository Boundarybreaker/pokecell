package org.voxelmon.voxelmon.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import org.voxelmon.voxelmon.api.species.IVoxelSpecies;
import org.voxelmon.voxelmon.entities.VoxelmonEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;

public class BillboardVoxelmonRenderer extends AbstractVoxelmonRenderer{

    public BillboardVoxelmonRenderer(EntityRenderDispatcher renderer, IVoxelSpecies mon){
        super(renderer, mon);
    }

    public void render(VoxelmonEntity e, double x, double y, double z, float pitch, float yaw){
        RenderSystem.pushMatrix();

        EntityDimensions s = e.getDimensions(EntityPose.STANDING);
        RenderSystem.translatef((float)x, (float)y+s.height/4, (float)z);
        RenderSystem.enableRescaleNormal();
        RenderSystem.scalef(s.width, s.height, s.width);
        Tessellator t = Tessellator.getInstance();
        BufferBuilder buf = t.getBuffer();
        RenderSystem.rotatef(180.0F - this.renderManager.camera.getYaw(), 0.0F, 1.0F, 0.0F);
        RenderSystem.rotatef((float)(this.renderManager.gameOptions.perspective == 2 ? -1 : 1) * -this.renderManager.camera.getPitch(), 1.0F, 0.0F, 0.0F);

        buf.begin(7, VertexFormats.POSITION);
        buf.vertex(-0.5D, -0.25D, 0.0D).texture(0.0f, 1.0f).normal(0.0F, 1.0F, 0.0F).next();
        buf.vertex(0.5D, -0.25D, 0.0D).texture(1.0f, 1.0f).normal(0.0F, 1.0F, 0.0F).next();
        buf.vertex(0.5D, 0.75D, 0.0D).texture(1.0f, 0.0f).normal(0.0F, 1.0F, 0.0F).next();
        buf.vertex(-0.5D, 0.75D, 0.0D).texture(0.0f, 0.0f).normal(0.0F, 1.0F, 0.0F).next();
        t.draw();

        RenderSystem.disableRescaleNormal();
        RenderSystem.popMatrix();
    }
}
