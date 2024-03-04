package me.nyaaa.rawinput.utils

import me.nyaaa.rawinput.mouses
import net.minecraft.util.MouseHelper

class RawInputMouseHelper : MouseHelper() {
    override fun mouseXYChange() {
        deltaX = 0
        deltaY = 0

        for (mouse in mouses) {
            mouse.poll()
            deltaX += mouse.x.pollData.toInt()
            deltaY -= mouse.y.pollData.toInt()
        }
    }
}