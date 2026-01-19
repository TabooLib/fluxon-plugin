package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Breedable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBreedable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Breedable::class.java)
                .function("setAgeLock", 1) { it.target?.setAgeLock(it.getBoolean(0)) }
                .function("ageLock", 0) { it.target?.ageLock }
                .function("canBreed", 0) { it.target?.canBreed() }
                .function("setBreed", 1) { it.target?.setBreed(it.getBoolean(0)) }
        }
    }
}
