package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Hoglin
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

@Requires(classes = ["org.bukkit.entity.Hoglin"])
@PlatformSide(Platform.BUKKIT)
object FnHoglin {

    val TYPE = Type.fromClass(Hoglin::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Hoglin::class.java)
                .function("isImmuneToZombification", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isImmuneToZombification ?: false) }
                .function("setImmuneToZombification", returnsVoid().params(Type.Z)) { it.target?.setImmuneToZombification(it.getBool(0)) }
                .function("isAbleToBeHunted", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAbleToBeHunted ?: false) }
                .function("setIsAbleToBeHunted", returnsVoid().params(Type.Z)) { it.target?.setIsAbleToBeHunted(it.getBool(0)) }
                .function("conversionTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.conversionTime ?: 0) }
                .function("setConversionTime", returnsVoid().params(Type.I)) { it.target?.setConversionTime(it.getInt(0).toInt()) }
                .function("isConverting", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isConverting ?: false) }
        }
    }
}
