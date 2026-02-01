package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Gate
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.block.data.type.Gate"])
@PlatformSide(Platform.BUKKIT)
object FnGate {

    val TYPE = Type.fromClass(Gate::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Gate::class.java)
                .function("isInWall", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInWall ?: false) }
                .function("setInWall", returnsVoid().params(Type.Z)) { it.target?.setInWall(it.getBool(0)) }
        }
    }
}
