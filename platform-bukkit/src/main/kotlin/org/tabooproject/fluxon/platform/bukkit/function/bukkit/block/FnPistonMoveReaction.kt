package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.PistonMoveReaction
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPistonMoveReaction {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PistonMoveReaction::class.java)
                .function("id", 0) { it.target?.id }
                // static
                .function("getById", 1) { PistonMoveReaction.getById(it.getNumber(0).toInt()) }
        }
    }
}
