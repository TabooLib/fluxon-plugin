package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import org.bukkit.metadata.LazyMetadataValue
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLazyMetadataValue {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LazyMetadataValue::class.java)
                .function("value", 0) { it.target?.value() }
        }
    }
}
