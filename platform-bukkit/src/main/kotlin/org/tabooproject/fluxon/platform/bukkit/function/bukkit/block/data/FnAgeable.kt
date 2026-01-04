package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Ageable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnAgeable {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ageable::class.java)
                .function("age", 0) { it.target?.age }
                .syncFunction("setAge", 1) { it.target?.apply { age = it.getNumber(0).toInt() } }
                .function("maximumAge", 0) { it.target?.maximumAge }
        }
    }
}
