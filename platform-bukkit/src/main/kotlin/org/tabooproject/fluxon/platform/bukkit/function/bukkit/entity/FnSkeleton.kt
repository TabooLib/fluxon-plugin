package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Skeleton
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

@Requires(classes = ["org.bukkit.entity.Skeleton"])
@PlatformSide(Platform.BUKKIT)
object FnSkeleton {

    val TYPE = Type.fromClass(Skeleton::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Skeleton::class.java)
                .function("isConverting", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isConverting ?: false) }
                .function("conversionTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.conversionTime ?: 0) }
                .function("setConversionTime", returnsVoid().params(Type.I)) { it.target?.setConversionTime(it.getInt(0).toInt()) }
        }
    }
}
