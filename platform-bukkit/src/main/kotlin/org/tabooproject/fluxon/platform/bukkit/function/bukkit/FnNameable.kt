package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Nameable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnNameable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Nameable::class.java)
                .function("customName", 0) { it.target?.customName }
                .function("setCustomName", 1) { it.target?.setCustomName(it.getString(0)) }
        }
    }
}
