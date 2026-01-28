package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.SculkShrieker
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.SculkShrieker"])
@PlatformSide(Platform.BUKKIT)
object FnSculkShrieker {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SculkShrieker::class.java)
                .function("isCanSummon", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCanSummon) }
                .function("setCanSummon", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCanSummon(it.getBool(0))) }
                .function("isShrieking", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isShrieking) }
                .function("setShrieking", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setShrieking(it.getBool(0))) }
        }
    }
}
