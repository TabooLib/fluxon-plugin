package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator

import org.bukkit.generator.WorldInfo
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.generator.WorldInfo"])
@PlatformSide(Platform.BUKKIT)
object FnWorldInfo {

    val TYPE = Type.fromClass(WorldInfo::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WorldInfo::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("uID",returns(org.tabooproject.fluxon.util.StandardTypes.UUID).noParams()) { it.setReturnRef(it.target?.uid) }
                .function("seed",returns(Type.J).noParams()) { it.setReturnRef(it.target?.seed) }
                .function("minHeight",returns(Type.I).noParams()) { it.setReturnRef(it.target?.minHeight) }
                .function("maxHeight",returns(Type.I).noParams()) { it.setReturnRef(it.target?.maxHeight) }
                .function("environment", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldEnvironment.TYPE).noParams()) { it.setReturnRef(it.target?.environment) }
        }
    }
}
