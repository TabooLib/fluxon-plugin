package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.SkeletonHorse
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

@Requires(classes = ["org.bukkit.entity.SkeletonHorse"])
@PlatformSide(Platform.BUKKIT)
object FnSkeletonHorse {

    val TYPE = Type.fromClass(SkeletonHorse::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SkeletonHorse::class.java)
                .function("isTrapped", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isTrapped ?: false) }
                .function("setTrapped", returnsVoid().params(Type.Z)) { it.target?.setTrapped(it.getBool(0)) }
                .function("trapTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.trapTime ?: 0) }
                .function("setTrapTime", returnsVoid().params(Type.I)) { it.target?.setTrapTime(it.getInt(0).toInt()) }
        }
    }
}
