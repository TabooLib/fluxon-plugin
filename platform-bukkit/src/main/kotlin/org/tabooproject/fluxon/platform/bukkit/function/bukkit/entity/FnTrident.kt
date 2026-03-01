package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Trident"])
@PlatformSide(Platform.BUKKIT)
object FnTrident {

    val TYPE = Type.fromClass(org.bukkit.entity.Trident::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.entity.Trident::class.java)
                // .function("hasGlint", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasGlint() ?: false) }
                // .function("setGlint", returnsVoid().params(Type.Z)) { it.target?.setGlint(it.getBool(0)) }
                // .function("getLoyaltyLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.getLoyaltyLevel() ?: 0) }
                // .function("setLoyaltyLevel", returnsVoid().params(Type.I)) { it.target?.setLoyaltyLevel(it.getInt(0).toInt()) }
                // .function("hasDealtDamage", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasDealtDamage() ?: false) }
                // .function("setHasDealtDamage", returnsVoid().params(Type.Z)) { it.target?.setHasDealtDamage(it.getBool(0)) }
                .function("setDamage", returnsVoid().params(Type.D)) { it.target?.setDamage(it.getDouble(0)) }
                .function("getDamage", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.getDamage() ?: 0.0) }
        }
    }
}
