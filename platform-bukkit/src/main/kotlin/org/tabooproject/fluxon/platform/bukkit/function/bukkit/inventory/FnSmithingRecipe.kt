package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.SmithingRecipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSmithingRecipe {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SmithingRecipe::class.java)
                .function("base", 0) { it.target?.base }
                .function("addition", 0) { it.target?.addition }
                .function("result", 0) { it.target?.result }
                .function("key", 0) { it.target?.key }
        }
    }
}
