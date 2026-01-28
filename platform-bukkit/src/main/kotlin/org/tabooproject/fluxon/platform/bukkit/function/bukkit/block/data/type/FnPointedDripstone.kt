package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.BlockFace
import org.bukkit.block.data.type.PointedDripstone
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.PointedDripstone"])
@PlatformSide(Platform.BUKKIT)
object FnPointedDripstone {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PointedDripstone::class.java)
                .function("verticalDirection", returnsObject().noParams()) { it.target?.verticalDirection }
                .function("setVerticalDirection", returnsObject().params(Type.OBJECT)) { it.target?.setVerticalDirection(it.getRef(0) as BlockFace) }
                .function("verticalDirections", returnsObject().noParams()) { it.target?.verticalDirections }
                .function("thickness", returnsObject().noParams()) { it.target?.thickness }
                .function("setThickness", returnsObject().params(Type.OBJECT)) { it.target?.setThickness(it.getRef(0) as PointedDripstone.Thickness) }
        }
    }
}
