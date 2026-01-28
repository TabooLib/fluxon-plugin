package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.BlockFace
import org.bukkit.block.data.Rotatable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.Rotatable"])
@PlatformSide(Platform.BUKKIT)
object FnRotatable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rotatable::class.java)
                .function("rotation", returnsObject().noParams()) { it.target?.rotation }
                .function("setRotation", returnsObject().params(Type.OBJECT)) { it.target?.setRotation(it.getRef(0) as BlockFace) }
        }
    }
}
