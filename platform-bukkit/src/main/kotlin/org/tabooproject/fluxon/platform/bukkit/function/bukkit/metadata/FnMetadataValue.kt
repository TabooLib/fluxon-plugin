package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import org.bukkit.metadata.MetadataValue
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.metadata.MetadataValue"])
@PlatformSide(Platform.BUKKIT)
object FnMetadataValue {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MetadataValue::class.java)
                .function("value", returnsObject().noParams()) { it.setReturnRef(it.target?.value()) }
                .function("asInt", returnsObject().noParams()) { it.setReturnRef(it.target?.asInt()) }
                .function("asFloat", returnsObject().noParams()) { it.setReturnRef(it.target?.asFloat()) }
                .function("asDouble", returnsObject().noParams()) { it.setReturnRef(it.target?.asDouble()) }
                .function("asLong", returnsObject().noParams()) { it.setReturnRef(it.target?.asLong()) }
                .function("asShort", returnsObject().noParams()) { it.setReturnRef(it.target?.asShort()) }
                .function("asByte", returnsObject().noParams()) { it.setReturnRef(it.target?.asByte()) }
                .function("asBoolean", returnsObject().noParams()) { it.setReturnRef(it.target?.asBoolean()) }
                .function("asString", returnsObject().noParams()) { it.setReturnRef(it.target?.asString()) }
                .function("owningPlugin", returnsObject().noParams()) { it.setReturnRef(it.target?.owningPlugin) }
                .function("invalidate", returnsObject().noParams()) { it.setReturnRef(it.target?.invalidate()) }
        }
    }
}
