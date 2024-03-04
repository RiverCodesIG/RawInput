package me.nyaaa.rawinput.listener

import me.nyaaa.rawinput.mouses
import net.java.games.input.ControllerEvent
import net.java.games.input.ControllerListener
import net.java.games.input.Mouse

class MouseListener : ControllerListener {
    override fun controllerAdded(event: ControllerEvent) {
        if (event.controller is Mouse) {
            mouses.add(event.controller as Mouse)
        }
    }

    override fun controllerRemoved(event: ControllerEvent) {
        if (event.controller is Mouse) {
            mouses.remove(event.controller)
        }
    }
}