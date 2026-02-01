package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.ExtendedRails
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.material.ExtendedRails"])
@PlatformSide(Platform.BUKKIT)
object FnExtendedRails {

    val TYPE = Type.fromClass(ExtendedRails::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExtendedRails::class.java)
                .function("isCurve", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCurve ?: false) }
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
