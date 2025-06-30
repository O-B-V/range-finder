package net.O_B_V_.rangefinder.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
public class KeyBindingHelper {
    public static final String CATEGORY_RANGEFINDER = "key.categories.rangeFinder";
    public static final String KEY_RANGEFINDER = "key.rangefinder.rangeFinderKey";

    public static final KeyMapping rangeFinderKey = new KeyMapping(
            KEY_RANGEFINDER,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_K,
            CATEGORY_RANGEFINDER
    );
}
