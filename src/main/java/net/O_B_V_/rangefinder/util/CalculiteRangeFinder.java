package net.O_B_V_.rangefinder.util;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class CalculiteRangeFinder {
    private static final Minecraft mc = Minecraft.getInstance();
    public static KeyMapping keyMapping;

    public static void getLookCords() {
        HitResult hit = mc.hitResult;
        if (hit != null && hit.getType() == HitResult.Type.BLOCK) {
            BlockPos pos = ((BlockHitResult) hit).getBlockPos();
            mc.player.sendSystemMessage(net.minecraft.network.chat.Component.literal(
                    pos.getX() + " " + pos.getY() + " " + pos.getZ()
            ));
        } else {
            mc.player.sendSystemMessage(net.minecraft.network.chat.Component.literal(
                    "Вы не смотрите на блок"
            ));
        }
    }
}