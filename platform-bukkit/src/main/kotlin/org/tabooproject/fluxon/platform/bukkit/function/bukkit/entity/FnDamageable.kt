package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Damageable
import org.bukkit.entity.Entity
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


@Requires(classes = ["org.bukkit.entity.Damageable"])
@PlatformSide(Platform.BUKKIT)
object FnDamageable {

    val TYPE = Type.fromClass(Damageable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Damageable::class.java)
                .function("damage", returnsVoid().params(Type.D)) { it.target?.damage(it.getDouble(0)) }
                .function("damage",returnsVoid().params(Type.D, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) {
                    it.target?.damage(it.getDouble(0), it.getRef(1) as Entity)
                }
                .function("health", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.health ?: 0.0) }
                .function("setHealth", returnsVoid().params(Type.D)) { it.target?.setHealth(it.getDouble(0)) }
                .function("absorptionAmount", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.absorptionAmount ?: 0.0) }
                .function("setAbsorptionAmount", returnsVoid().params(Type.D)) { it.target?.setAbsorptionAmount(it.getDouble(0)) }
                .function("maxHealth", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.maxHealth ?: 0.0) }
                .function("setMaxHealth", returnsVoid().params(Type.D)) { it.target?.setMaxHealth(it.getDouble(0)) }
                .function("resetMaxHealth", returnsVoid().noParams()) { it.target?.resetMaxHealth() }
        }
    }
}
