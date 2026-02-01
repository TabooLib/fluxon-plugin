package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.block.data.BlockData
import org.bukkit.entity.Minecart
import org.bukkit.material.MaterialData
import org.bukkit.util.Vector
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

@Requires(classes = ["org.bukkit.entity.Minecart"])
@PlatformSide(Platform.BUKKIT)
object FnMinecart {

    val TYPE = Type.fromClass(Minecart::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Minecart::class.java)
                .function("setDamage", returnsVoid().params(Type.D)) { it.target?.setDamage(it.getDouble(0)) }
                .function("damage", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.damage ?: 0.0) }
                .function("maxSpeed", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.maxSpeed ?: 0.0) }
                .function("setMaxSpeed", returnsVoid().params(Type.D)) { it.target?.setMaxSpeed(it.getDouble(0)) }
                .function("isSlowWhenEmpty", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSlowWhenEmpty ?: false) }
                .function("setSlowWhenEmpty", returnsVoid().params(Type.Z)) { it.target?.setSlowWhenEmpty(it.getBool(0)) }
                .function("flyingVelocityMod", returnsObject().noParams()) { it.setReturnRef(it.target?.flyingVelocityMod) }
                .function("setFlyingVelocityMod", returnsVoid().params(Type.OBJECT)) { it.target?.setFlyingVelocityMod(it.getRef(0) as Vector) }
                .function("derailedVelocityMod", returnsObject().noParams()) { it.setReturnRef(it.target?.derailedVelocityMod) }
                .function("setDerailedVelocityMod", returnsVoid().params(Type.OBJECT)) { it.target?.setDerailedVelocityMod(it.getRef(0) as Vector) }
                .function("setDisplayBlock", returnsVoid().params(Type.OBJECT)) { it.target?.setDisplayBlock(it.getRef(0) as MaterialData) }
                .function("displayBlock", returnsObject().noParams()) { it.setReturnRef(it.target?.displayBlock) }
                .function("setDisplayBlockData", returnsVoid().params(Type.OBJECT)) { it.target?.setDisplayBlockData(it.getRef(0) as BlockData) }
                .function("displayBlockData", returnsObject().noParams()) { it.setReturnRef(it.target?.displayBlockData) }
                .function("setDisplayBlockOffset", returnsVoid().params(Type.I)) { it.target?.setDisplayBlockOffset(it.getInt(0).toInt()) }
                .function("displayBlockOffset", returns(Type.I).noParams()) { it.setReturnInt(it.target?.displayBlockOffset ?: 0) }
        }
    }
}
