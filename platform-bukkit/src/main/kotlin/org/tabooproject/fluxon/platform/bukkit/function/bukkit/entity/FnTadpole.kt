package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Tadpole
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.Tadpole"])
@PlatformSide(Platform.BUKKIT)
object FnTadpole {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Tadpole::class.java)
                .function("age", 0) { it.target?.age }
                .function("setAge", 1) { it.target?.setAge(it.getNumber(0).toInt()) }
        }
    }
}
