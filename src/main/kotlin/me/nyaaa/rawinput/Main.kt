package me.nyaaa.rawinput

import me.nyaaa.rawinput.listener.MouseListener
import net.weavemc.loader.api.ModInitializer
import net.weavemc.loader.api.event.EventBus
import net.weavemc.loader.api.event.StartGameEvent


class Main : ModInitializer {
    override fun preInit() {
        EventBus.subscribe(StartGameEvent.Post::class.java) { environ.addControllerListener(MouseListener()) }
    }
}