package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Stairs
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Stairs"])
@PlatformSide(Platform.BUKKIT)
object FnStairs {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Stairs::class.java)
                .function("shape", returnsObject().noParams()) { it.target?.shape }
                .function("setShape", returnsObject().params(Type.OBJECT)) { it.target?.setShape(it.getRef(0) as Stairs.Shape) }
        }
    }
}
