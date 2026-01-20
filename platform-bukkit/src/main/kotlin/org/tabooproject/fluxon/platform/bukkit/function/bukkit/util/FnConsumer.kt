package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.Consumer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnConsumer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Consumer::class.java)
                .function("accept", 1) { (it.target as? Consumer<Any>)?.accept(it.getArgument(0)!!) }
        }
    }
}
