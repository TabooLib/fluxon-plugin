package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.SkeletonHorse
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.SkeletonHorse"])
@PlatformSide(Platform.BUKKIT)
object FnSkeletonHorse {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SkeletonHorse::class.java)
                .function("isTrapped", returns(Type.Z).noParams()) { it.target?.isTrapped }
                .function("setTrapped", returnsObject().params(Type.OBJECT)) { it.target?.setTrapped(it.getBool(0)) }
                .function("trapTime", returnsObject().noParams()) { it.target?.trapTime }
                .function("setTrapTime", returnsObject().params(Type.OBJECT)) { it.target?.setTrapTime(it.getInt(0).toInt()) }
        }
    }
}
