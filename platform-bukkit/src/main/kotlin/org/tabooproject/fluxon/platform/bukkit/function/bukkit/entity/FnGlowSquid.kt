package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.GlowSquid
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.GlowSquid"])
@PlatformSide(Platform.BUKKIT)
object FnGlowSquid {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GlowSquid::class.java)
                .function("darkTicksRemaining", 0) { it.target?.darkTicksRemaining }
                .function("setDarkTicksRemaining", 1) { it.target?.setDarkTicksRemaining(it.getNumber(0).toInt()) }
        }
    }
}
