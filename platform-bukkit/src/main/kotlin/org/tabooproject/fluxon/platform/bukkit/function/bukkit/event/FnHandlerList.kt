package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event

import org.bukkit.event.HandlerList
import org.bukkit.plugin.RegisteredListener
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnHandlerList {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HandlerList::class.java)
                .function(
                    "registerAll",
                    1
                ) { it.target?.registerAll(it.getArgument(0) as Collection<RegisteredListener>) }
                .function("registeredListeners", 0) { it.target?.registeredListeners }
        }
    }
}
