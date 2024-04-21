package me.river.rawinput.utils

import me.river.rawinput.mouses
import me.river.rawinput.rescan
import net.minecraft.util.MouseHelper

class RawInputMouseHelper : MouseHelper() {
    override fun grabMouseCursor() {
        super.grabMouseCursor()
        rescan()
    }

    override fun ungrabMouseCursor() {
        super.ungrabMouseCursor()
        rescan()
    }

    override fun mouseXYChange() {
        deltaX = 0
        deltaY = 0

        if (mouses.isEmpty()) {
            rescan()
        } else {
            for (mouse in mouses) {
                if (!mouse.poll()) {
                    rescan()
                }
                deltaX += mouse.x.pollData.toInt()
                deltaY -= mouse.y.pollData.toInt()
            }
        }
    }
}