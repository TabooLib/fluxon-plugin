package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.RespawnAnchor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.RespawnAnchor"])
@PlatformSide(Platform.BUKKIT)
object FnRespawnAnchor {

    val TYPE = Type.fromClass(RespawnAnchor::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RespawnAnchor::class.java)
                .function("charges", returns(Type.I).noParams()) { it.setReturnInt(it.target?.charges ?: 0) }
                .function("setCharges", returnsVoid().params(Type.I)) { it.target?.setCharges(it.getInt(0)) }
                .function("maximumCharges", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumCharges ?: 0) }
        }
    }
}
