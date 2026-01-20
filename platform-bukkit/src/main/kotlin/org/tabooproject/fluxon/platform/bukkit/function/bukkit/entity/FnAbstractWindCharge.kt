package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AbstractWindCharge
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAbstractWindCharge {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractWindCharge::class.java)
                .function("explode", 0) { it.target?.explode() }
        }
    }
}
