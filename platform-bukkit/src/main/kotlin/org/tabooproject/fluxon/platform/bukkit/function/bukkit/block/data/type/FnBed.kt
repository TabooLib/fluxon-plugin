package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Bed
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBed {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bed::class.java)
                .function("part", 0) { it.target?.part }
                .function("setPart", 1) { it.target?.setPart(it.getArgument(0) as Bed.Part) }
                .function("isOccupied", 0) { it.target?.isOccupied }
        }
    }
}
