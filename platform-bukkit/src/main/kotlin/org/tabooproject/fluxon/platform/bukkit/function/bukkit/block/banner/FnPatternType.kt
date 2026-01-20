package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.banner

import org.bukkit.block.banner.PatternType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPatternType {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PatternType::class.java)
                .function("key", 0) { it.target?.key }
                .function("identifier", 0) { it.target?.identifier }
        }
    }
}
