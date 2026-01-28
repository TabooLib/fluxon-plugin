package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Hoglin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Hoglin"])
@PlatformSide(Platform.BUKKIT)
object FnHoglin {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Hoglin::class.java)
                .function("isImmuneToZombification", returns(Type.Z).noParams()) { it.target?.isImmuneToZombification }
                .function("setImmuneToZombification", returnsObject().params(Type.OBJECT)) { it.target?.setImmuneToZombification(it.getBool(0)) }
                .function("isAbleToBeHunted", returns(Type.Z).noParams()) { it.target?.isAbleToBeHunted }
                .function("setIsAbleToBeHunted", returnsObject().params(Type.OBJECT)) { it.target?.setIsAbleToBeHunted(it.getBool(0)) }
                .function("conversionTime", returnsObject().noParams()) { it.target?.conversionTime }
                .function("setConversionTime", returnsObject().params(Type.OBJECT)) { it.target?.setConversionTime(it.getInt(0).toInt()) }
                .function("isConverting", returns(Type.Z).noParams()) { it.target?.isConverting }
        }
    }
}
