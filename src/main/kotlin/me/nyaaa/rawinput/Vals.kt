package me.nyaaa.rawinput

import net.java.games.input.ControllerEnvironment
import net.java.games.input.DirectAndRawInputEnvironmentPlugin
import net.java.games.input.Mouse

val environ: ControllerEnvironment = DirectAndRawInputEnvironmentPlugin()

val mouses: MutableList<Mouse> = environ.controllers.filterIsInstance<Mouse>().toMutableList()