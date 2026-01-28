package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.block.BlockFace
import org.bukkit.entity.Hanging
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Hanging"])
@PlatformSide(Platform.BUKKIT)
object FnHanging {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Hanging::class.java)
                .function("setFacingDirection", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setFacingDirection(
                        it.getRef(0) as BlockFace,
                        it.getBool(1)
                    ))
                }
        }
    }
}
