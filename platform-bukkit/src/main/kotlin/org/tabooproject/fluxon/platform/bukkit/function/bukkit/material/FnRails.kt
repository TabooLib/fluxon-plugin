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
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Rails"])
@PlatformSide(Platform.BUKKIT)
object FnRails {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rails::class.java)
                .function("isOnSlope", returns(Type.Z).noParams()) { it.target?.isOnSlope }
                .function("isCurve", returns(Type.Z).noParams()) { it.target?.isCurve }
                .function("direction", returnsObject().noParams()) { it.target?.direction }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
                .function("setDirection", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setDirection(
                        it.getRef(0) as BlockFace,
                        it.getBool(1)
                    )
                }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
