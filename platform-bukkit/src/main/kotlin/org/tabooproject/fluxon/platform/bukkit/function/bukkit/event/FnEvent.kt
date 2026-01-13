package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event

import org.bukkit.event.Event
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Event::class.java)
                .function("eventName", 0) { it.target?.eventName }
                .function("isAsynchronous", 0) { it.target?.isAsynchronous }
        }
    }
}
