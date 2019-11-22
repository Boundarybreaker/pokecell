package dev.vatuu.voxelmon.extensions;

import dev.vatuu.voxelmon.Voxelmon;
import io.github.prospector.modmenu.api.ModMenuApi;
import net.minecraft.client.gui.screen.Screen;

import java.util.function.Function;

public class ModMenuEntrypoint implements ModMenuApi {

    public String getModId(){
        return Voxelmon.MOD_ID;
    }

    @Override
    public Function<Screen, ? extends Screen> getConfigScreenFactory() {
        return (screen) -> {
            return null; //TODO Config Screen once we have one, you know the deal.
        };
    }
}
