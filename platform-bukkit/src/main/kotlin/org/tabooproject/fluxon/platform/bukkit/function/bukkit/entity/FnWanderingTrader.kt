package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.WanderingTrader
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.WanderingTrader"])
@PlatformSide(Platform.BUKKIT)
object FnWanderingTrader {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WanderingTrader::class.java)
                .function("despawnDelay", returnsObject().noParams()) { it.setReturnRef(it.target?.despawnDelay) }
                .function("setDespawnDelay", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDespawnDelay(it.getInt(0).toInt())) }
        }
    }
}
