package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import org.bukkit.metadata.MetadataValueAdapter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMetadataValueAdapter {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MetadataValueAdapter::class.java)
                .function("owningPlugin", 0) { it.target?.getOwningPlugin() }
                .function("asInt", 0) { it.target?.asInt() }
                .function("asFloat", 0) { it.target?.asFloat() }
                .function("asDouble", 0) { it.target?.asDouble() }
                .function("asLong", 0) { it.target?.asLong() }
                .function("asShort", 0) { it.target?.asShort() }
                .function("asByte", 0) { it.target?.asByte() }
                .function("asBoolean", 0) { it.target?.asBoolean() }
                .function("asString", 0) { it.target?.asString() }
        }
    }
}
