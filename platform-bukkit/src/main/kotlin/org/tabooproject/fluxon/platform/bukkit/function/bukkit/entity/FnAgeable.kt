package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Ageable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAgeable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ageable::class.java)
                .function("age", 0) { it.target?.age }
                .function("setAge", 1) { it.target?.setAge(it.getNumber(0).toInt()) }
                .function("setAgeLock", 1) { it.target?.setAgeLock(it.getBoolean(0)) }
                .function("ageLock", 0) { it.target?.ageLock }
                .function("setBaby", 0) { it.target?.setBaby() }
                .function("setAdult", 0) { it.target?.setAdult() }
                .function("isAdult", 0) { it.target?.isAdult }
                .function("canBreed", 0) { it.target?.canBreed() }
                .function("setBreed", 1) { it.target?.setBreed(it.getBoolean(0)) }
        }
    }
}
