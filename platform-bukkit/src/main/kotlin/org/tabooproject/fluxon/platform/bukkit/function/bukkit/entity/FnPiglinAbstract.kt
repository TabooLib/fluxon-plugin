package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.PiglinAbstract
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

@Requires(classes = ["org.bukkit.entity.PiglinAbstract"])
@PlatformSide(Platform.BUKKIT)
object FnPiglinAbstract {

    val TYPE = Type.fromClass(PiglinAbstract::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PiglinAbstract::class.java)
                .function("isImmuneToZombification", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isImmuneToZombification ?: false) }
                .function("setImmuneToZombification", returnsVoid().params(Type.Z)) { it.target?.setImmuneToZombification(it.getBool(0)) }
                .function("conversionTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.conversionTime ?: 0) }
                .function("setConversionTime", returnsVoid().params(Type.I)) { it.target?.setConversionTime(it.getInt(0)) }
                .function("isConverting", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isConverting ?: false) }
                .function("isBaby", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBaby ?: false) }
                .function("setBaby", returnsVoid().params(Type.Z)) { it.target?.setBaby(it.getBool(0)) }
        }
    }
}
