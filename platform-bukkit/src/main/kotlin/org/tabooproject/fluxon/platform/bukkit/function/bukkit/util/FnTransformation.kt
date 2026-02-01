package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.Transformation
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.Transformation"])
@PlatformSide(Platform.BUKKIT)
object FnTransformation {

    val TYPE = Type.fromClass(Transformation::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Transformation::class.java)
//                .function("translation", returnsObject().noParams()) { it.setReturnRef(it.target?.translation) }
//                .function("leftRotation", returnsObject().noParams()) { it.setReturnRef(it.target?.leftRotation) }
//                .function("scale", returnsObject().noParams()) { it.setReturnRef(it.target?.scale) }
//                .function("rightRotation", returnsObject().noParams()) { it.setReturnRef(it.target?.rightRotation) }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnInt(it.target?.hashCode() ?: 0) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.equals(it.getRef(0)) ?: false)
                }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
