package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Bogged"])
@PlatformSide(Platform.BUKKIT)
object FnBogged {

    val TYPE = Type.fromClass(org.bukkit.entity.Bogged::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.entity.Bogged::class.java)
                // .function("isSheared", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSheared() ?: false) }
                // .function("setSheared", returnsVoid().params(Type.Z)) { it.target?.setSheared(it.getBool(0)) }
        }
    }
}
