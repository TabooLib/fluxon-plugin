package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Dispenser
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.data.type.Dispenser"])
@PlatformSide(Platform.BUKKIT)
object FnDispenser {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Dispenser::class.java)
                .function("isTriggered", 0) { it.target?.isTriggered }
                .function("setTriggered", 1) { it.target?.setTriggered(it.getBoolean(0)) }
        }
    }
}
