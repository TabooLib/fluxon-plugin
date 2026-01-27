package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.GameRule
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.GameRule"])
@PlatformSide(Platform.BUKKIT)
object FnGameRule {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GameRule::class.java)
                .function("name", 0) { it.target?.name }
                .function("type", 0) { it.target?.getType() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
