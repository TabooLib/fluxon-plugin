package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event

import org.bukkit.event.EventException
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEventException {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EventException::class.java)
                .function("cause", 0) { it.target?.cause }
        }
    }
}
