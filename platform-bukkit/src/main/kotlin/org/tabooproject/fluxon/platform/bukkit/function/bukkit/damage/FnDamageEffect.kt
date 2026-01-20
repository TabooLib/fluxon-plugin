package org.tabooproject.fluxon.platform.bukkit.function.bukkit.damage

import org.bukkit.damage.DamageEffect
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnDamageEffect {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DamageEffect::class.java)
                .function("sound", 0) { it.target?.sound }
        }
    }
}
