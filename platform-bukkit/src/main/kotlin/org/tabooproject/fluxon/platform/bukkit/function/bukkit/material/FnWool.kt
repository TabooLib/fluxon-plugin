package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.DyeColor
import org.bukkit.material.Wool
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnWool {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wool::class.java)
                .function("color", 0) { it.target?.color }
                .function("setColor", 1) { it.target?.setColor(it.getArgument(0) as DyeColor) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
