package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.PufferFish
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.PufferFish"])
@PlatformSide(Platform.BUKKIT)
object FnPufferFish {

    val TYPE = Type.fromClass(PufferFish::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PufferFish::class.java)
                .function("puffState", returns(Type.I).noParams()) { it.setReturnInt(it.target?.puffState ?: 0) }
                .function("setPuffState", returnsVoid().params(Type.I)) { it.target?.setPuffState(it.getInt(0).toInt()) }
        }
    }
}
