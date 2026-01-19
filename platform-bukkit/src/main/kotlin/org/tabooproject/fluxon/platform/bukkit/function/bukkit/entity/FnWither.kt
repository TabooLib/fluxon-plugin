package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Wither
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnWither {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wither::class.java)
                .function("setTarget", 1) { it.target?.setTarget(it.getArgument(0) as LivingEntity) }
                .function("setTarget", 2) {
                    it.target?.setTarget(
                        it.getArgument(0) as Wither.Head,
                        it.getArgument(1) as LivingEntity
                    )
                }
                .function("target", 1) { it.target?.getTarget(it.getArgument(0) as Wither.Head) }
                .function("invulnerabilityTicks", 0) { it.target?.invulnerabilityTicks }
                .function("setInvulnerabilityTicks", 1) { it.target?.setInvulnerabilityTicks(it.getNumber(0).toInt()) }
        }
    }
}
