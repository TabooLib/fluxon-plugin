package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.PigZombie
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.PigZombie"])
@PlatformSide(Platform.BUKKIT)
object FnPigZombie {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PigZombie::class.java)
                .function("anger", returnsObject().noParams()) { it.target?.anger }
                .function("setAnger", returnsObject().params(Type.OBJECT)) { it.target?.setAnger(it.getInt(0).toInt()) }
                .function("setAngry", returnsObject().params(Type.OBJECT)) { it.target?.setAngry(it.getBool(0)) }
                .function("isAngry", returns(Type.Z).noParams()) { it.target?.isAngry }
                .function("isConverting", returns(Type.Z).noParams()) { it.target?.isConverting }
                .function("conversionTime", returnsObject().noParams()) { it.target?.conversionTime }
                .function("setConversionTime", returnsObject().params(Type.OBJECT)) { it.target?.setConversionTime(it.getInt(0).toInt()) }
        }
    }
}
