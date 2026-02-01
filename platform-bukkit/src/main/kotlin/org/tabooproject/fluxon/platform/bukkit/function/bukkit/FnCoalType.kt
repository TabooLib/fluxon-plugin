package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.CoalType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.CoalType"])
@PlatformSide(Platform.BUKKIT)
object FnCoalType {

    val TYPE = Type.fromClass(CoalType::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CoalType::class.java)
                .function("data", returns(Type.I).noParams()) { it.setReturnInt(it.target?.data?.toInt() ?: 0) }
                // static
                .function("getByData", returnsObject().params(Type.I)) { it.setReturnRef(CoalType.getByData(it.getInt(0).toByte())) }
        }
    }
}
