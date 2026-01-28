package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration

import org.bukkit.configuration.Configuration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.configuration.Configuration"])
@PlatformSide(Platform.BUKKIT)
object FnConfiguration {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Configuration::class.java)
                .function("addDefault", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.addDefault(it.getString(0)!!, it.getRef(1)) }
                .function("addDefaults", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is Map<*, *> -> it.target?.addDefaults(var1 as Map<String, Any>)
                        is Configuration -> it.target?.addDefaults(var1)
                        else -> throw IllegalArgumentException("参数必须是 Map<String, Object> 或 Configuration 类型")
                    }
                }
                .function("setDefaults", returnsObject().params(Type.OBJECT)) { it.target?.setDefaults(it.getRef(0) as Configuration) }
                .function("defaults", returnsObject().noParams()) { it.target?.defaults }
        }
    }
}
