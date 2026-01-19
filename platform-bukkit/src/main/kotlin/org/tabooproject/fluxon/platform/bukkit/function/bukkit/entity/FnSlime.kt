package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Slime
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnSlime {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Slime::class.java)
                .function("size", 0) { it.target?.size }
                .function("setSize", 1) { it.target?.setSize(it.getNumber(0).toInt()) }
        }
    }
}
