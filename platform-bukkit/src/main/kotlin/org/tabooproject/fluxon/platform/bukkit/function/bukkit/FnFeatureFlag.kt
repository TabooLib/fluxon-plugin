package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.FeatureFlag
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnFeatureFlag {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FeatureFlag::class.java)
        }
    }
}
