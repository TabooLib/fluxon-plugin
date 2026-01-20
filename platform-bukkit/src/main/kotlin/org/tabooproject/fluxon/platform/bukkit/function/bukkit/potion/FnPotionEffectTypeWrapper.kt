package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.bukkit.potion.PotionEffectTypeWrapper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPotionEffectTypeWrapper {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionEffectTypeWrapper::class.java)
                .function("type", 0) { it.target?.type }
        }
    }
}
