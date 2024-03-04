package me.nyaaa.rawinput.hooks

import net.weavemc.loader.api.Hook
import net.weavemc.loader.api.util.asm
import org.objectweb.asm.Opcodes.RETURN
import org.objectweb.asm.tree.ClassNode

class MinecraftHook : Hook("net/minecraft/client/Minecraft") {
    override fun transform(cn: ClassNode, cfg: AssemblerConfig) {
        cn.methods.find { mn -> mn.name.equals("startGame") && mn.desc.equals("()V") }?.apply {
            instructions.insertBefore(instructions.findLast { it.opcode == RETURN },
                asm {
                    aload(0)
                    new("me/nyaaa/rawinput/utils/RawInputMouseHelper")
                    dup
                    invokespecial("me/nyaaa/rawinput/utils/RawInputMouseHelper", "<init>", "()V")
                    putfield(cn.name, "mouseHelper", "Lnet/minecraft/util/MouseHelper;")
                }
            )
        }
    }
}