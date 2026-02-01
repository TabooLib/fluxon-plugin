package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.PigZombie
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

@Requires(classes = ["org.bukkit.entity.PigZombie"])
@PlatformSide(Platform.BUKKIT)
object FnPigZombie {

    val TYPE = Type.fromClass(PigZombie::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PigZombie::class.java)
                .function("anger", returns(Type.I).noParams()) { it.setReturnInt(it.target?.anger ?: 0) }
                .function("setAnger", returnsVoid().params(Type.I)) { it.target?.setAnger(it.getInt(0)) }
                .function("setAngry", returnsVoid().params(Type.Z)) { it.target?.setAngry(it.getBool(0)) }
                .function("isAngry", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAngry ?: false) }
                .function("isConverting", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isConverting ?: false) }
                .function("conversionTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.conversionTime ?: 0) }
                .function("setConversionTime", returnsVoid().params(Type.I)) { it.target?.setConversionTime(it.getInt(0)) }
        }
    }
}
