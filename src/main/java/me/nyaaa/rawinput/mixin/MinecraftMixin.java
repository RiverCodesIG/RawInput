package me.nyaaa.rawinput.mixin;

import me.nyaaa.rawinput.event.StartGameEvent;
import me.nyaaa.rawinput.utils.RawInputMouseHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MouseHelper;
import net.weavemc.api.event.EventBus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Shadow
    public MouseHelper mouseHelper;

    @Inject(method = "startGame", at = @At("RETURN"))
    public void onGameStart(CallbackInfo ci) {
        EventBus.postEvent(new StartGameEvent());
        mouseHelper = new RawInputMouseHelper();
    }
}
