package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Leaves
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.Leaves"])
@PlatformSide(Platform.BUKKIT)
object FnLeaves {

    val TYPE = Type.fromClass(Leaves::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Leaves::class.java)
                .function("isPersistent", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPersistent ?: false) }
                .function("setPersistent", returnsVoid().params(Type.Z)) { it.target?.setPersistent(it.getBool(0)) }
                .function("distance", returns(Type.I).noParams()) { it.setReturnInt(it.target?.distance ?: 0) }
                .function("setDistance", returnsVoid().params(Type.I)) { it.target?.setDistance(it.getInt(0).toInt()) }
        }
    }
}
