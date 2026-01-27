package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Sheep
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.Sheep"])
@PlatformSide(Platform.BUKKIT)
object FnSheep {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sheep::class.java)
                .function("isSheared", 0) { it.target?.isSheared }
                .function("setSheared", 1) { it.target?.setSheared(it.getBoolean(0)) }
        }
    }
}
