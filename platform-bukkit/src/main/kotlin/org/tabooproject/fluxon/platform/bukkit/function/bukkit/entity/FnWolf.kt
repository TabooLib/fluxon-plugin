package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.DyeColor
import org.bukkit.entity.Wolf
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Wolf"])
@PlatformSide(Platform.BUKKIT)
object FnWolf {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wolf::class.java)
                .function("isAngry", returns(Type.Z).noParams()) { it.target?.isAngry }
                .function("setAngry", returnsObject().params(Type.OBJECT)) { it.target?.setAngry(it.getBool(0)) }
                .function("collarColor", returnsObject().noParams()) { it.target?.collarColor }
                .function("setCollarColor", returnsObject().params(Type.OBJECT)) { it.target?.setCollarColor(it.getRef(0) as DyeColor) }
                .function("isWet", returns(Type.Z).noParams()) { it.target?.isWet }
                .function("tailAngle", returnsObject().noParams()) { it.target?.tailAngle }
                .function("isInterested", returns(Type.Z).noParams()) { it.target?.isInterested }
                .function("setInterested", returnsObject().params(Type.OBJECT)) { it.target?.setInterested(it.getBool(0)) }
                .function("variant", returnsObject().noParams()) { it.target?.variant }
                .function("setVariant", returnsObject().params(Type.OBJECT)) { it.target?.setVariant(it.getRef(0) as Wolf.Variant) }
        }
    }
}
