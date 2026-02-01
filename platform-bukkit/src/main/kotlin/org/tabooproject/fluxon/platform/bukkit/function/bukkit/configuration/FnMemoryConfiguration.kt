package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration

import org.bukkit.configuration.Configuration
import org.bukkit.configuration.MemoryConfiguration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.configuration.MemoryConfiguration"])
@PlatformSide(Platform.BUKKIT)
object FnMemoryConfiguration {

    val TYPE = Type.fromClass(MemoryConfiguration::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MemoryConfiguration::class.java)
                .function("addDefault", returnsVoid().params(Type.STRING, Type.OBJECT)) { it.target?.addDefault(it.getString(0)!!, it.getRef(1)) }
                .function("addDefaults", returnsVoid().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is Map<*, *> -> it.target?.addDefaults(var1 as Map<String, Any>)
                        is Configuration -> it.target?.addDefaults(var1)
                        else -> throw IllegalArgumentException("参数必须是 Map<String, Object> 或 Configuration 类型")
                    }
                }
                .function("setDefaults", returnsVoid().params(Type.OBJECT)) { it.target?.setDefaults(it.getRef(0) as Configuration) }
                .function("defaults", returnsObject().noParams()) { it.setReturnRef(it.target?.getDefaults()) }
                .function("parent", returnsObject().noParams()) { it.setReturnRef(it.target?.parent) }
        }
    }
}
