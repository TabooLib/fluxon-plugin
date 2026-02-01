package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Rail
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.Rail"])
@PlatformSide(Platform.BUKKIT)
object FnRail {

    val TYPE = Type.fromClass(Rail::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rail::class.java)
                .function("shape", returnsObject().noParams()) { it.setReturnRef(it.target?.shape) }
                .function("setShape", returnsVoid().params(Type.OBJECT)) { it.target?.setShape(it.getRef(0) as Rail.Shape) }
                .function("shapes", returnsObject().noParams()) { it.setReturnRef(it.target?.shapes) }
        }
    }
}
