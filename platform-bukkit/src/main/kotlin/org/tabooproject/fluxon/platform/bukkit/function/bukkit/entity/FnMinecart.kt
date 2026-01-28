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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Minecart"])
@PlatformSide(Platform.BUKKIT)
object FnMinecart {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Minecart::class.java)
                .function("setDamage", returnsObject().params(Type.OBJECT)) { it.target?.setDamage(it.getAsDouble(0)) }
                .function("damage", returnsObject().noParams()) { it.target?.damage }
                .function("maxSpeed", returnsObject().noParams()) { it.target?.maxSpeed }
                .function("setMaxSpeed", returnsObject().params(Type.OBJECT)) { it.target?.setMaxSpeed(it.getAsDouble(0)) }
                .function("isSlowWhenEmpty", returns(Type.Z).noParams()) { it.target?.isSlowWhenEmpty }
                .function("setSlowWhenEmpty", returnsObject().params(Type.OBJECT)) { it.target?.setSlowWhenEmpty(it.getBool(0)) }
                .function("flyingVelocityMod", returnsObject().noParams()) { it.target?.flyingVelocityMod }
                .function("setFlyingVelocityMod", returnsObject().params(Type.OBJECT)) { it.target?.setFlyingVelocityMod(it.getRef(0) as Vector) }
                .function("derailedVelocityMod", returnsObject().noParams()) { it.target?.derailedVelocityMod }
                .function("setDerailedVelocityMod", returnsObject().params(Type.OBJECT)) { it.target?.setDerailedVelocityMod(it.getRef(0) as Vector) }
                .function("setDisplayBlock", returnsObject().params(Type.OBJECT)) { it.target?.setDisplayBlock(it.getRef(0) as MaterialData) }
                .function("displayBlock", returnsObject().noParams()) { it.target?.displayBlock }
                .function("setDisplayBlockData", returnsObject().params(Type.OBJECT)) { it.target?.setDisplayBlockData(it.getRef(0) as BlockData) }
                .function("displayBlockData", returnsObject().noParams()) { it.target?.displayBlockData }
                .function("setDisplayBlockOffset", returnsObject().params(Type.OBJECT)) { it.target?.setDisplayBlockOffset(it.getInt(0).toInt()) }
                .function("displayBlockOffset", returnsObject().noParams()) { it.target?.displayBlockOffset }
        }
    }
}
