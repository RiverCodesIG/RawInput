package me.nyaaa.rawinput

import me.nyaaa.rawinput.event.StartGameEvent
import me.nyaaa.rawinput.listener.MouseListener
import net.weavemc.api.ModInitializer
import net.weavemc.api.event.EventBus
import java.lang.instrument.Instrumentation


class Main : ModInitializer {
    override fun preInit(inst: Instrumentation) {
        EventBus.subscribe(StartGameEvent::class.java) { environ.addControllerListener(MouseListener()) }
    }
}