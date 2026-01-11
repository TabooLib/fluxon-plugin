package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Nameable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnNameable {

    @Awake(LifeCycle.LOAD)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Nameable::class.java)
                .function("customName", 0) { it.target?.customName }
                .syncFunction("setCustomName", 1) { it.target?.apply { customName = it.getString(0) } }
        }
    }
}