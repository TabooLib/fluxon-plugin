package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Damageable
import org.bukkit.entity.Entity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type


@Requires(classes = ["org.bukkit.entity.Damageable"])
@PlatformSide(Platform.BUKKIT)
object FnDamageable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Damageable::class.java)
                .function("damage", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.damage(it.getAsDouble(0))
                    } else {
                        it.target?.damage(it.getAsDouble(0), it.getRef(1) as Entity)
                    })
                }
                .function("damage", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.damage(it.getAsDouble(0))
                    } else {
                        it.target?.damage(it.getAsDouble(0), it.getRef(1) as Entity)
                    })
                }
                .function("health", returnsObject().noParams()) { it.setReturnRef(it.target?.health) }
                .function("setHealth", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setHealth(it.getAsDouble(0))) }
                .function("absorptionAmount", returnsObject().noParams()) { it.setReturnRef(it.target?.absorptionAmount) }
                .function("setAbsorptionAmount", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAbsorptionAmount(it.getAsDouble(0))) }
                .function("maxHealth", returnsObject().noParams()) { it.setReturnRef(it.target?.maxHealth) }
                .function("setMaxHealth", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMaxHealth(it.getAsDouble(0))) }
                .function("resetMaxHealth", returnsObject().noParams()) { it.setReturnRef(it.target?.resetMaxHealth()) }
        }
    }
}
