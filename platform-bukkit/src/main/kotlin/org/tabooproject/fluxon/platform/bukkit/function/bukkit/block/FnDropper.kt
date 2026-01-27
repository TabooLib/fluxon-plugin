package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Dropper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.Dropper"])
@PlatformSide(Platform.BUKKIT)
object FnDropper {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Dropper::class.java)
                .function("drop", 0) { it.target?.drop() }
        }
    }
}
