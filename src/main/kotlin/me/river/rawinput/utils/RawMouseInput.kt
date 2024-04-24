package me.river.rawinput.utils

import me.river.rawinput.mouses
import me.river.rawinput.rescan
import net.minecraft.client.MouseInput

class RawMouseInput : MouseInput() {
    override fun lockMouse() {
        super.lockMouse()
        rescan()
    }

    // WHY IS THIS CALLED GRAB MOUSE?!?!?!? ITS LITERALLY **UN**GRABBING IT
    override fun grabMouse() {
        super.grabMouse()
        rescan()
    }

    override fun updateMouse() {
        x = 0
        y = 0

        if (mouses.isEmpty()) {
            rescan()
        } else {
            for (mouse in mouses) {
                if (!mouse.poll()) {
                    rescan()
                }
                x += mouse.x.pollData.toInt()
                y -= mouse.y.pollData.toInt()
            }
        }
    }
}