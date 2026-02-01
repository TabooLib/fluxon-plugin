package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Farmland
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Farmland"])
@PlatformSide(Platform.BUKKIT)
object FnFarmland {

    val TYPE = Type.fromClass(Farmland::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Farmland::class.java)
                .function("moisture", returns(Type.I).noParams()) { it.setReturnInt(it.target?.moisture ?: 0) }
                .function("setMoisture", returnsVoid().params(Type.I)) { it.target?.setMoisture(it.getInt(0)) }
                .function("maximumMoisture", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumMoisture ?: 0) }
        }
    }
}
