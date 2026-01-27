package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.PiglinAbstract
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.PiglinAbstract"])
@PlatformSide(Platform.BUKKIT)
object FnPiglinAbstract {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PiglinAbstract::class.java)
                .function("isImmuneToZombification", 0) { it.target?.isImmuneToZombification }
                .function("setImmuneToZombification", 1) { it.target?.setImmuneToZombification(it.getBoolean(0)) }
                .function("conversionTime", 0) { it.target?.conversionTime }
                .function("setConversionTime", 1) { it.target?.setConversionTime(it.getNumber(0).toInt()) }
                .function("isConverting", 0) { it.target?.isConverting }
                .function("isBaby", 0) { it.target?.isBaby }
                .function("setBaby", 1) { it.target?.setBaby(it.getBoolean(0)) }
        }
    }
}
