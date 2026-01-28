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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WorldInfo::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("uID", returnsObject().noParams()) { it.setReturnRef(it.target?.uid) }
                .function("seed", returnsObject().noParams()) { it.setReturnRef(it.target?.seed) }
                .function("minHeight", returnsObject().noParams()) { it.setReturnRef(it.target?.minHeight) }
                .function("maxHeight", returnsObject().noParams()) { it.setReturnRef(it.target?.maxHeight) }
                .function("environment", returnsObject().noParams()) { it.setReturnRef(it.target?.environment) }
        }
    }
}
