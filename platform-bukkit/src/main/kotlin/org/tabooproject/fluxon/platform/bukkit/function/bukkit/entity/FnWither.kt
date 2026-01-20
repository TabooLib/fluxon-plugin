package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Wither
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnWither {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wither::class.java)
                .function("setTarget", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setTarget(it.getArgument(0) as LivingEntity)
                    } else {
                        it.target?.setTarget(
                            it.getArgument(0) as Wither.Head,
                            it.getArgument(1) as LivingEntity
                        )
                    }
                }
                .function("target", 1) { it.target?.getTarget(it.getArgument(0) as Wither.Head) }
                .function("invulnerabilityTicks", 0) { it.target?.invulnerabilityTicks }
                .function("setInvulnerabilityTicks", 1) { it.target?.setInvulnerabilityTicks(it.getNumber(0).toInt()) }
        }
    }
}
