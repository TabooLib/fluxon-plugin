package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Openable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnOpenable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Openable::class.java)
                .function("isOpen", 0) { it.target?.isOpen }
                .function("setOpen", 1) { it.target?.setOpen(it.getBoolean(0)) }
        }
    }
}
