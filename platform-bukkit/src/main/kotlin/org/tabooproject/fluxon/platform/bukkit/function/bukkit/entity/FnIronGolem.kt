package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.IronGolem
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

@Requires(classes = ["org.bukkit.entity.IronGolem"])
@PlatformSide(Platform.BUKKIT)
object FnIronGolem {

    val TYPE = Type.fromClass(IronGolem::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(IronGolem::class.java)
                .function("isPlayerCreated", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPlayerCreated ?: false) }
                .function("setPlayerCreated", returnsVoid().params(Type.Z)) { it.target?.setPlayerCreated(it.getBool(0)) }
        }
    }
}
