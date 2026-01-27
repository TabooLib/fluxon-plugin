package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Phantom
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.Phantom"])
@PlatformSide(Platform.BUKKIT)
object FnPhantom {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Phantom::class.java)
                .function("size", 0) { it.target?.size }
                .function("setSize", 1) { it.target?.setSize(it.getNumber(0).toInt()) }
        }
    }
}
