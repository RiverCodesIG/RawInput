package me.river.rawinput.hooks

import me.river.rawinput.utils.RawInputMouseHelper
import net.weavemc.api.Hook
import net.weavemc.internals.asm
import net.weavemc.internals.internalNameOf
import org.objectweb.asm.Opcodes.RETURN
import org.objectweb.asm.tree.ClassNode

class MinecraftHook : Hook("net/minecraft/client/Minecraft") {
    override fun transform(node: ClassNode, cfg: AssemblerConfig) {
        node.methods.find { mn -> mn.name.equals("startGame") && mn.desc.equals("()V") }?.apply {
            instructions.insertBefore(instructions.findLast { it.opcode == RETURN },
                asm {
                    aload(0)
                    new(internalNameOf<RawInputMouseHelper>())
                    dup
                    invokespecial(
                        internalNameOf<RawInputMouseHelper>(),
                        "<init>",
                        "()V"
                    )
                    putfield(
                        node.name,
                        "mouseHelper",
                        "Lnet/minecraft/util/MouseHelper;"
                    )
                }
            )
        }
    }
}