package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.TurtleEgg
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.data.type.TurtleEgg"])
@PlatformSide(Platform.BUKKIT)
object FnTurtleEgg {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TurtleEgg::class.java)
                .function("eggs", 0) { it.target?.eggs }
                .function("setEggs", 1) { it.target?.setEggs(it.getNumber(0).toInt()) }
                .function("minimumEggs", 0) { it.target?.minimumEggs }
                .function("maximumEggs", 0) { it.target?.maximumEggs }
        }
    }
}
