package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Damageable
import org.bukkit.entity.Entity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnDamageable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Damageable::class.java)
                .function("damage", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.damage(it.getNumber(0).toDouble())
                    } else {
                        it.target?.damage(it.getNumber(0).toDouble(), it.getArgument(1) as Entity)
                    }
                }
                .function("health", 0) { it.target?.health }
                .function("setHealth", 1) { it.target?.setHealth(it.getNumber(0).toDouble()) }
                .function("absorptionAmount", 0) { it.target?.absorptionAmount }
                .function("setAbsorptionAmount", 1) { it.target?.setAbsorptionAmount(it.getNumber(0).toDouble()) }
                .function("maxHealth", 0) { it.target?.maxHealth }
                .function("setMaxHealth", 1) { it.target?.setMaxHealth(it.getNumber(0).toDouble()) }
                .function("resetMaxHealth", 0) { it.target?.resetMaxHealth() }
        }
    }
}
