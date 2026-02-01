package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Beacon
import org.bukkit.potion.PotionEffectType
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffect
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffectType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.util.StandardTypes

@Requires(classes = ["org.bukkit.block.Beacon"])
@PlatformSide(Platform.BUKKIT)
object FnBeacon {

    val TYPE = Type.fromClass(Beacon::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Beacon::class.java)
                .function("entitiesInRange", returns(StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.entitiesInRange) }
                .function("tier", returns(Type.I).noParams()) { it.setReturnInt(it.target?.tier ?: 0) }
                .function("primaryEffect", returns(FnPotionEffect.TYPE).noParams()) { it.setReturnRef(it.target?.primaryEffect) }
                .function("setPrimaryEffect", returnsVoid().params(FnPotionEffectType.TYPE)) { it.target?.setPrimaryEffect(it.getRef(0) as PotionEffectType) }
                .function("secondaryEffect", returns(FnPotionEffect.TYPE).noParams()) { it.setReturnRef(it.target?.secondaryEffect) }
                .function("setSecondaryEffect", returnsVoid().params(FnPotionEffectType.TYPE)) { it.target?.setSecondaryEffect(it.getRef(0) as PotionEffectType) }
        }
    }
}
