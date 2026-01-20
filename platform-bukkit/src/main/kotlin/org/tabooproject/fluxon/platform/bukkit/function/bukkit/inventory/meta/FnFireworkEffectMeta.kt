package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.FireworkEffect
import org.bukkit.inventory.meta.FireworkEffectMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnFireworkEffectMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FireworkEffectMeta::class.java)
                .function("setEffect", 1) { it.target?.setEffect(it.getArgument(0) as FireworkEffect) }
                .function("hasEffect", 0) { it.target?.hasEffect() }
                .function("effect", 0) { it.target?.effect }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
