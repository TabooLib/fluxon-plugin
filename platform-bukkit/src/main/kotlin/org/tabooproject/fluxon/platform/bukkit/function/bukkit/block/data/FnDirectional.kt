package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.BlockFace
import org.bukkit.block.data.Directional
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.Directional"])
@PlatformSide(Platform.BUKKIT)
object FnDirectional {

    val TYPE = Type.fromClass(Directional::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Directional::class.java)
                .function("facing", returnsObject().noParams()) { it.setReturnRef(it.target?.facing) }
                .function("setFacing", returnsVoid().params(Type.OBJECT)) { it.target?.setFacing(it.getRef(0) as BlockFace) }
                .function("faces", returnsObject().noParams()) { it.setReturnRef(it.target?.faces) }
        }
    }
}
