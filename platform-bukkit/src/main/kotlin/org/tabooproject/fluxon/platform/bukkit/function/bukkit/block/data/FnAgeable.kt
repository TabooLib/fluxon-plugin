package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Ageable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.block.data.Ageable"])
@PlatformSide(Platform.BUKKIT)
object FnAgeable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ageable::class.java)
                .function("age", 0) { it.target?.age }
                .function("setAge", 1) { it.target?.setAge(it.getNumber(0).toInt()) }
                .function("maximumAge", 0) { it.target?.maximumAge }
        }
    }
}
