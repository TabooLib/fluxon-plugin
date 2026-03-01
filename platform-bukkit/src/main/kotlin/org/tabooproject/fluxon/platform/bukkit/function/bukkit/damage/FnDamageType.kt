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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.damage.DamageType"])
@PlatformSide(Platform.BUKKIT)
object FnDamageType {

    val TYPE = Type.fromClass(DamageType::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DamageType::class.java)
                .function("translationKey",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.translationKey) }
                .function("damageScaling", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.damage.FnDamageScaling.TYPE).noParams()) { it.setReturnRef(it.target?.damageScaling) }
                .function("damageEffect",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.damage.FnDamageEffect.TYPE).noParams()) { it.setReturnRef(it.target?.damageEffect) }
                .function("deathMessageType", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.damage.FnDeathMessageType.TYPE).noParams()) { it.setReturnRef(it.target?.deathMessageType) }
                .function("exhaustion",returns(Type.F).noParams()) { it.setReturnRef(it.target?.exhaustion) }
        }
    }
}
