package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.DyeColor
import org.bukkit.entity.Wolf
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

@Requires(classes = ["org.bukkit.entity.Wolf"])
@PlatformSide(Platform.BUKKIT)
object FnWolf {

    val TYPE = Type.fromClass(Wolf::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wolf::class.java)
                .function("isAngry", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAngry ?: false) }
                .function("setAngry", returnsVoid().params(Type.Z)) { it.target?.setAngry(it.getBool(0)) }
                .function("collarColor", returnsObject().noParams()) { it.setReturnRef(it.target?.collarColor) }
                .function("setCollarColor", returnsVoid().params(Type.OBJECT)) { it.target?.setCollarColor(it.getRef(0) as DyeColor) }
                .function("isWet", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isWet ?: false) }
                .function("tailAngle", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.tailAngle ?: 0f) }
                .function("isInterested", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInterested ?: false) }
                .function("setInterested", returnsVoid().params(Type.Z)) { it.target?.setInterested(it.getBool(0)) }
                .function("variant", returnsObject().noParams()) { it.setReturnRef(it.target?.variant) }
                .function("setVariant", returnsVoid().params(Type.OBJECT)) { it.target?.setVariant(it.getRef(0) as Wolf.Variant) }
        }
    }
}
