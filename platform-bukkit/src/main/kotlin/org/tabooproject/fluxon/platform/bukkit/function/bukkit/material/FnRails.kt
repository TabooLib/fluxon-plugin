package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Rails
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Rails"])
@PlatformSide(Platform.BUKKIT)
object FnRails {

    val TYPE = Type.fromClass(Rails::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rails::class.java)
                .function("isOnSlope", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOnSlope ?: false) }
                .function("isCurve", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCurve ?: false) }
                .function("direction", returnsObject().noParams()) { it.setReturnRef(it.target?.direction) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("setDirection", returnsVoid().params(Type.OBJECT, Type.Z)) {
                    it.target?.setDirection(
                        it.getRef(0) as BlockFace,
                        it.getBool(1)
                    )
                }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
