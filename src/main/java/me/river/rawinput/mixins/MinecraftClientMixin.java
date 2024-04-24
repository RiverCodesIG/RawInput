package me.river.rawinput.mixins;

import me.river.rawinput.utils.RawMouseInput;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MouseInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// TODO: Replace with @Redirect.
@Mixin(value = MinecraftClient.class)
public class MinecraftClientMixin {
    @Shadow
    public MouseInput mouse;

    @Inject(method = "initializeGame", at = @At("TAIL"))
    public void initializeGame(CallbackInfo ci) {
        mouse = new RawMouseInput();
    }
}