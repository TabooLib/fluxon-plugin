package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.GrassSpecies
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.GrassSpecies"])
@PlatformSide(Platform.BUKKIT)
object FnGrassSpecies {

    val TYPE = Type.fromClass(GrassSpecies::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GrassSpecies::class.java)
                .function("data", returns(Type.I).noParams()) { it.setReturnInt(it.target?.data?.toInt() ?: 0) }
                // static
                .function("getByData", returnsObject().params(Type.I)) { it.setReturnRef(GrassSpecies.getByData(it.getInt(0).toByte())) }
        }
    }
}
