package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.Damageable
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
                .function("hasDamage", 0) { it.target?.hasDamage() }
                .function("damage", 0) { it.target?.damage }
                .function("setDamage", 1) { it.target?.setDamage(it.getNumber(0).toInt()) }
                .function("hasMaxDamage", 0) { it.target?.hasMaxDamage() }
                .function("maxDamage", 0) { it.target?.maxDamage }
                .function("setMaxDamage", 1) { it.target?.setMaxDamage(it.getNumber(0).toInt()) }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
