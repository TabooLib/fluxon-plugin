package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Effect
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Effect"])
@PlatformSide(Platform.BUKKIT)
object FnEffect {

    val TYPE = Type.fromClass(Effect::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Effect::class.java)
                .function("id", returns(Type.I).noParams()) { it.setReturnInt(it.target?.id ?: 0) }
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
                .function("data", returnsObject().noParams()) { it.setReturnRef(it.target?.data) }
                // static
                .function("getById", returnsObject().params(Type.I)) { it.setReturnRef(Effect.getById(it.getInt(0).toInt())) }
        }
    }
}
