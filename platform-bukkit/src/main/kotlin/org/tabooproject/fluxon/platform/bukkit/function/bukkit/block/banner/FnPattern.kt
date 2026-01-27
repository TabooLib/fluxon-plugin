package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.banner

import org.bukkit.block.banner.Pattern
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.banner.Pattern"])
@PlatformSide(Platform.BUKKIT)
object FnPattern {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Pattern::class.java)
                .function("color", 0) { it.target?.color }
                .function("pattern", 0) { it.target?.pattern }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
        }
    }
}
