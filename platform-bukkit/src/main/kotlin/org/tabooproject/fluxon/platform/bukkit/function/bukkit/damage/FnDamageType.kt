package org.tabooproject.fluxon.platform.bukkit.function.bukkit.damage

import org.bukkit.damage.DamageType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.damage.DamageType"])
@PlatformSide(Platform.BUKKIT)
object FnDamageType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DamageType::class.java)
                .function("translationKey", returnsObject().noParams()) { it.target?.translationKey }
                .function("damageScaling", returnsObject().noParams()) { it.target?.damageScaling }
                .function("damageEffect", returnsObject().noParams()) { it.target?.damageEffect }
                .function("deathMessageType", returnsObject().noParams()) { it.target?.deathMessageType }
                .function("exhaustion", returnsObject().noParams()) { it.target?.exhaustion }
        }
    }
}
