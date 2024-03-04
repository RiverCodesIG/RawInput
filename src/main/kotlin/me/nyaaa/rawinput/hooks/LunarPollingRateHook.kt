package me.nyaaa.rawinput.hooks

import net.weavemc.loader.api.Hook
import net.weavemc.loader.api.util.asm
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.LdcInsnNode

class LunarPollingRateHook : Hook() {
    override fun transform(cn: ClassNode, cfg: AssemblerConfig) {
        if (cn.name.startsWith("com/moonsworth/lunar/client")) {
            cn.methods.find { mn -> mn.instructions
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