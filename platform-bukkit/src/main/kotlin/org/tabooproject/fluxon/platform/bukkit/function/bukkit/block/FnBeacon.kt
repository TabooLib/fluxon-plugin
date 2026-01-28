package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Beacon
import org.bukkit.potion.PotionEffectType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.Beacon"])
@PlatformSide(Platform.BUKKIT)
object FnBeacon {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Beacon::class.java)
                .function("entitiesInRange", returnsObject().noParams()) { it.target?.entitiesInRange }
                .function("tier", returnsObject().noParams()) { it.target?.tier }
                .function("primaryEffect", returnsObject().noParams()) { it.target?.primaryEffect }
                .function("setPrimaryEffect", returnsObject().params(Type.OBJECT)) { it.target?.setPrimaryEffect(it.getRef(0) as PotionEffectType) }
                .function("secondaryEffect", returnsObject().noParams()) { it.target?.secondaryEffect }
                .function("setSecondaryEffect", returnsObject().params(Type.OBJECT)) { it.target?.setSecondaryEffect(it.getRef(0) as PotionEffectType) }
        }
    }
}
