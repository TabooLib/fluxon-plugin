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

@Requires(classes = ["org.bukkit.entity.Chicken"])
@PlatformSide(Platform.BUKKIT)
object FnChicken {

    val TYPE = Type.fromClass(org.bukkit.entity.Chicken::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.entity.Chicken::class.java)
                // .function("getVariant", returns(Type.fromClass(org.bukkit.entity.Variant::class.java)).noParams()) { it.setReturnRef(it.target?.getVariant()) }
                // .function("setVariant", returnsVoid().params(Type.fromClass(org.bukkit.entity.Variant::class.java))) { it.target?.setVariant(it.getRef(0) as org.bukkit.entity.Variant) }
                // .function("isChickenJockey", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isChickenJockey() ?: false) }
                // .function("setIsChickenJockey", returnsVoid().params(Type.Z)) { it.target?.setIsChickenJockey(it.getBool(0)) }
                // .function("getEggLayTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.getEggLayTime() ?: 0) }
                // .function("setEggLayTime", returnsVoid().params(Type.I)) { it.target?.setEggLayTime(it.getInt(0).toInt()) }
        }
    }
}
