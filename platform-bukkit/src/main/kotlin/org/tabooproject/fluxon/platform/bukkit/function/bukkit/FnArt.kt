package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Art
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnArt {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Art::class.java)
                .function("blockWidth", 0) { it.target?.blockWidth }
                .function("blockHeight", 0) { it.target?.blockHeight }
                .function("id", 0) { it.target?.id }
                .function("key", 0) { it.target?.key }
                // static
                .function("getById", 1) { Art.getById(it.getNumber(0).toInt()) }
                // static
                .function("getByName", 1) { Art.getByName(it.getString(0)!!) }
        }
    }
}
