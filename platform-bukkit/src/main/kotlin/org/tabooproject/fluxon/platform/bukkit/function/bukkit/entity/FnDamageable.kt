package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Damageable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnDamageable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Damageable::class.java)
                // 生命值
                .function("health", 0) { it.target?.health }
                .syncFunction("setHealth", 1) { it.target?.apply { health = it.getNumber(0).toDouble() } }

                // 伤害吸收
                .function("absorptionAmount", 0) { it.target?.absorptionAmount }
                .syncFunction("setAbsorptionAmount", 1) { it.target?.apply { absorptionAmount = it.getNumber(0).toDouble() } }
        }
    }
}
