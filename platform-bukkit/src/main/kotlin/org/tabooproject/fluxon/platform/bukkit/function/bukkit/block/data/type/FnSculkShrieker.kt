package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.SculkShrieker
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.block.data.type.SculkShrieker"])
@PlatformSide(Platform.BUKKIT)
object FnSculkShrieker {

    val TYPE = Type.fromClass(SculkShrieker::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SculkShrieker::class.java)
                .function("isCanSummon", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCanSummon ?: false) }
                .function("setCanSummon", returnsVoid().params(Type.Z)) { it.target?.setCanSummon(it.getBool(0)) }
                .function("isShrieking", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isShrieking ?: false) }
                .function("setShrieking", returnsVoid().params(Type.Z)) { it.target?.setShrieking(it.getBool(0)) }
        }
    }
}
