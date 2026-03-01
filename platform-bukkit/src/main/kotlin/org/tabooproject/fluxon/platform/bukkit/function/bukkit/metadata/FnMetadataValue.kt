package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import org.bukkit.metadata.MetadataValue
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.metadata.MetadataValue"])
@PlatformSide(Platform.BUKKIT)
object FnMetadataValue {

    val TYPE = Type.fromClass(MetadataValue::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MetadataValue::class.java)
                .function("value", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.value()) }
                .function("asInt",returns(Type.I).noParams()) { it.setReturnRef(it.target?.asInt()) }
                .function("asFloat",returns(Type.F).noParams()) { it.setReturnRef(it.target?.asFloat()) }
                .function("asDouble",returns(Type.D).noParams()) { it.setReturnRef(it.target?.asDouble()) }
                .function("asLong",returns(Type.J).noParams()) { it.setReturnRef(it.target?.asLong()) }
                .function("asShort",returns(Type.I).noParams()) { it.setReturnRef(it.target?.asShort()) }
                .function("asByte",returns(Type.I).noParams()) { it.setReturnRef(it.target?.asByte()) }
                .function("asBoolean",returns(Type.Z).noParams()) { it.setReturnRef(it.target?.asBoolean()) }
                .function("asString",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.asString()) }
                .function("owningPlugin",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE).noParams()) { it.setReturnRef(it.target?.owningPlugin) }
                .function("invalidate", returnsVoid().noParams()) { it.target?.invalidate() }
        }
    }
}
