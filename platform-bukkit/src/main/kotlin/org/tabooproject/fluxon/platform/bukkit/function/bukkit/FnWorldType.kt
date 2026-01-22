package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.WorldType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnWorldType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WorldType::class.java)
                .function("name", 0) { it.target?.getName() }
                // static
                .function("getByName", 1) { WorldType.getByName(it.getString(0)!!) }
        }
    }
}
