package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Art
import org.bukkit.entity.Painting
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPainting {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Painting::class.java)
                .function("art", 0) { it.target?.art }
                .function("setArt", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setArt(it.getArgument(0) as Art)
                    } else {
                        it.target?.setArt(it.getArgument(0) as Art, it.getBoolean(1))
                    }
                }
        }
    }
}
