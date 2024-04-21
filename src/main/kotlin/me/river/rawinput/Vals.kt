package me.river.rawinput

import net.java.games.input.ControllerEnvironment
import net.java.games.input.DirectAndRawInputEnvironmentPlugin
import net.java.games.input.Mouse

var environ: ControllerEnvironment = DirectAndRawInputEnvironmentPlugin()

var mouses: MutableList<Mouse> = if (environ.isSupported) {
    environ.controllers.filterIsInstance<Mouse>().toMutableList()
} else {
    ControllerEnvironment.getDefaultEnvironment().controllers.filterIsInstance<Mouse>().toMutableList()
}

fun rescan() {
    environ = DirectAndRawInputEnvironmentPlugin()
    mouses = if (environ.isSupported) {
        environ.controllers.filterIsInstance<Mouse>().toMutableList()
    } else {
        ControllerEnvironment.getDefaultEnvironment().controllers.filterIsInstance<Mouse>().toMutableList()
    }
}