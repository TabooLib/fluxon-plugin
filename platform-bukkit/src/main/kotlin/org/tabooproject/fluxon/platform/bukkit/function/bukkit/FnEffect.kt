package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Effect
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Effect"])
@PlatformSide(Platform.BUKKIT)
object FnEffect {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Effect::class.java)
                .function("id", returnsObject().noParams()) { it.target?.id }
                .function("type", returnsObject().noParams()) { it.target?.type }
                .function("data", returnsObject().noParams()) { it.target?.data }
                // static
                .function("getById", returnsObject().params(Type.OBJECT)) { Effect.getById(it.getInt(0).toInt()) }
        }
    }
}
