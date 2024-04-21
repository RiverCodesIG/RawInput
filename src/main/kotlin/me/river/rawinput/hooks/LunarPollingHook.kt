package me.river.rawinput.hooks

import net.weavemc.api.Hook
import net.weavemc.internals.asm
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.LdcInsnNode

class LunarPollingHook : Hook() {
    override fun transform(node: ClassNode, cfg: AssemblerConfig) {
        if (node.name.startsWith("com/moonsworth/lunar/client")) {
            node.methods.find { mn -> mn.instructions
                .filterIsInstance<LdcInsnNode>()
                .map { it.cst }.containsAll(listOf(
                    "PollingRateDetectionThread",
                    "Unable to start polling detection thread in headless client!"
                )) }?.apply {
                instructions.clear()
                instructions.add(asm { _return })
            }
        }
    }
}
