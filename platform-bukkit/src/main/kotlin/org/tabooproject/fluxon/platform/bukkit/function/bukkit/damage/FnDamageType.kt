package org.tabooproject.fluxon.platform.bukkit.function.bukkit.damage

import org.bukkit.damage.DamageType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnDamageType {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DamageType::class.java)
                .function("translationKey", 0) { it.target?.translationKey }
                .function("damageScaling", 0) { it.target?.damageScaling }
                .function("damageEffect", 0) { it.target?.damageEffect }
                .function("deathMessageType", 0) { it.target?.deathMessageType }
                .function("exhaustion", 0) { it.target?.exhaustion }
        }
    }
}
