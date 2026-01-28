package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Skeleton
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Skeleton"])
@PlatformSide(Platform.BUKKIT)
object FnSkeleton {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Skeleton::class.java)
                .function("isConverting", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isConverting) }
                .function("conversionTime", returnsObject().noParams()) { it.setReturnRef(it.target?.conversionTime) }
                .function("setConversionTime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setConversionTime(it.getInt(0).toInt())) }
        }
    }
}
