package net.O_B_V_.rangefinder.event;

import net.O_B_V_.rangefinder.util.KeyBindingHelper;
import net.O_B_V_.rangefinder.Rangefinder;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import  net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    private static final Minecraft mc = Minecraft.getInstance();

    @Mod.EventBusSubscriber(modid = Rangefinder.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBindingHelper.rangeFinderKey.consumeClick()) {
                HitResult hit = mc.hitResult;

                if (mc.player != null && mc.screen == null) {
                    Entity cameraEntity = mc.getCameraEntity();
                    Camera camera = mc.gameRenderer.getMainCamera();
                    if (cameraEntity == null) return;

                    Vec3 start = camera.getPosition();
                    Vec3 direction = cameraEntity.getViewVector(1.0f).normalize();
                    Vec3 end = start.add(direction.scale(500));

                    BlockHitResult result = mc.level.clip(new ClipContext(start, end, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, mc.player));

                    if (result.getType() != HitResult.Type.MISS) {
                        BlockPos pos = result.getBlockPos();
                            mc.player.sendSystemMessage(Component.literal("Попал в блок: " + pos));
                        } else {
                            mc.player.sendSystemMessage(Component.literal("Не попал ни во что."));
                        }

                }

            }
        }
    }

    @Mod.EventBusSubscriber(modid = Rangefinder.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public  static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBindingHelper.rangeFinderKey);
        }
    }
}
