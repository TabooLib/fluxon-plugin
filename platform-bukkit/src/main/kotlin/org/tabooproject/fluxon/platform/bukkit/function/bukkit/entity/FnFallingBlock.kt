package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.FallingBlock
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

@Requires(classes = ["org.bukkit.entity.FallingBlock"])
@PlatformSide(Platform.BUKKIT)
object FnFallingBlock {

    val TYPE = Type.fromClass(FallingBlock::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FallingBlock::class.java)
                .function("material", returnsObject().noParams()) { it.setReturnRef(it.target?.material) }
                .function("blockData", returnsObject().noParams()) { it.setReturnRef(it.target?.blockData) }
                .function("dropItem", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.dropItem ?: false) }
                .function("setDropItem", returnsVoid().params(Type.Z)) { it.target?.setDropItem(it.getBool(0)) }
                .function("cancelDrop", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.cancelDrop ?: false) }
                .function("setCancelDrop", returnsVoid().params(Type.Z)) { it.target?.setCancelDrop(it.getBool(0)) }
                .function("canHurtEntities", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.canHurtEntities() ?: false) }
                .function("setHurtEntities", returnsVoid().params(Type.Z)) { it.target?.setHurtEntities(it.getBool(0)) }
                .function("damagePerBlock", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.damagePerBlock ?: 0f) }
                .function("setDamagePerBlock", returnsVoid().params(Type.F)) { it.target?.setDamagePerBlock(it.getFloat(0)) }
                .function("maxDamage", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxDamage ?: 0) }
                .function("setMaxDamage", returnsVoid().params(Type.I)) { it.target?.setMaxDamage(it.getInt(0).toInt()) }
        }
    }
}
