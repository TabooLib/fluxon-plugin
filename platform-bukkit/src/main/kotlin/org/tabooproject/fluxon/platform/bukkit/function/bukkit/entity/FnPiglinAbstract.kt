package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.PiglinAbstract
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.PiglinAbstract"])
@PlatformSide(Platform.BUKKIT)
object FnPiglinAbstract {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PiglinAbstract::class.java)
                .function("isImmuneToZombification", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isImmuneToZombification) }
                .function("setImmuneToZombification", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setImmuneToZombification(it.getBool(0))) }
                .function("conversionTime", returnsObject().noParams()) { it.setReturnRef(it.target?.conversionTime) }
                .function("setConversionTime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setConversionTime(it.getInt(0).toInt())) }
                .function("isConverting", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isConverting) }
                .function("isBaby", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isBaby) }
                .function("setBaby", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBaby(it.getBool(0))) }
        }
    }
}
