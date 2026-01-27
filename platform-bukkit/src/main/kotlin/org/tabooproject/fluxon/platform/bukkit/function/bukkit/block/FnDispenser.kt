package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Dispenser
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.Dispenser"])
@PlatformSide(Platform.BUKKIT)
object FnDispenser {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Dispenser::class.java)
                .function("blockProjectileSource", 0) { it.target?.blockProjectileSource }
                .function("dispense", 0) { it.target?.dispense() }
        }
    }
}
