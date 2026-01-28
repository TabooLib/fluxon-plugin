package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.FallingBlock
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.FallingBlock"])
@PlatformSide(Platform.BUKKIT)
object FnFallingBlock {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FallingBlock::class.java)
                .function("material", returnsObject().noParams()) { it.setReturnRef(it.target?.material) }
                .function("blockData", returnsObject().noParams()) { it.setReturnRef(it.target?.blockData) }
                .function("dropItem", returnsObject().noParams()) { it.setReturnRef(it.target?.dropItem) }
                .function("setDropItem", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDropItem(it.getBool(0))) }
                .function("cancelDrop", returnsObject().noParams()) { it.setReturnRef(it.target?.cancelDrop) }
                .function("setCancelDrop", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCancelDrop(it.getBool(0))) }
                .function("canHurtEntities", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.canHurtEntities()) }
                .function("setHurtEntities", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setHurtEntities(it.getBool(0))) }
                .function("damagePerBlock", returnsObject().noParams()) { it.setReturnRef(it.target?.damagePerBlock) }
                .function("setDamagePerBlock", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDamagePerBlock(it.getFloat(0))) }
                .function("maxDamage", returnsObject().noParams()) { it.setReturnRef(it.target?.maxDamage) }
                .function("setMaxDamage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMaxDamage(it.getInt(0).toInt())) }
        }
    }
}
