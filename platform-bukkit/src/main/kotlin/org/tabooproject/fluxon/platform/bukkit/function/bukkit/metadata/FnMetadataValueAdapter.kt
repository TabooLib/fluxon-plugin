package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import org.bukkit.metadata.MetadataValueAdapter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.metadata.MetadataValueAdapter"])
@PlatformSide(Platform.BUKKIT)
object FnMetadataValueAdapter {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MetadataValueAdapter::class.java)
                .function("owningPlugin", returnsObject().noParams()) { it.target?.getOwningPlugin() }
                .function("asInt", returnsObject().noParams()) { it.target?.asInt() }
                .function("asFloat", returnsObject().noParams()) { it.target?.asFloat() }
                .function("asDouble", returnsObject().noParams()) { it.target?.asDouble() }
                .function("asLong", returnsObject().noParams()) { it.target?.asLong() }
                .function("asShort", returnsObject().noParams()) { it.target?.asShort() }
                .function("asByte", returnsObject().noParams()) { it.target?.asByte() }
                .function("asBoolean", returnsObject().noParams()) { it.target?.asBoolean() }
                .function("asString", returnsObject().noParams()) { it.target?.asString() }
        }
    }
}
